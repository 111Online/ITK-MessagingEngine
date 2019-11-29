package OctopusConsortium.Core.Transformers.PDS;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.UUID;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;

import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
import org.w3c.dom.Document;

import OctopusConsortium.Core.SoapUtil;

public class ITKDigitalSignatureTransformer extends AbstractTransformer {

	public int getTtlMinutes() {
		return _ttlMinutes;
	}

	public void setTtlMinutes(int ttlMinutes) {
		this._ttlMinutes = ttlMinutes;
	}
	
	public String getUsername() {
		return _username;
	}

	public void setUsername(String username) {
		this._username = username;
	}
	
	@Override
	protected Object doTransform(Object src, String enc)
			throws TransformerException {

		try {	
			if (!(src instanceof String))
				throw new TransformerException(this, new Exception("Expected a string payload, recieved " + src.getClass().getName()));
			
			String payload = (String)src;
			
			//initialise the xml-security library.
			org.apache.xml.security.Init.init();
			
			Document doc = SoapUtil.toSOAPPart(payload);
			SOAPMessage message = SoapUtil.toSOAPMessage(doc);
			SOAPHeader header = message.getSOAPHeader();
			SOAPHeaderElement securityHeader = header.addHeaderElement(new QName("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd", "Security"));		
			securityHeader.addNamespaceDeclaration("wsse", WSSE);
			
			//timestamp
			String timestampId = UUID.randomUUID().toString().toUpperCase();
			SOAPElement ts = securityHeader.addChildElement(new QName(WSU, "Timestamp"));
			ts.addAttribute(new QName(WSU, "Id", "wsu"), timestampId);
			
			// confirmed by Nigel Watts in email 03/04/2018 
			// "All header timestamps MUST be in GMT/UTC"
			TimeZone UTC = TimeZone.getTimeZone("UTC");
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
			dateFormat.setTimeZone(UTC);			
			
			Calendar cal = Calendar.getInstance();
			SOAPElement created = ts.addChildElement(new QName(WSU, "Created"));
			created.setValue(dateFormat.format(cal.getTime()));
			SOAPElement expires = ts.addChildElement(new QName(WSU, "Expires"));
			cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) + _ttlMinutes);
			expires.setValue(dateFormat.format(cal.getTime()));

			//username
			SOAPElement usernameToken = securityHeader.addChildElement(new QName(WSSE, "UsernameToken"));
			SOAPElement username = usernameToken.addChildElement(new QName(WSSE, "Username"));
			username.setValue(_username);
						
			return SoapUtil.toString(message);
		} catch (Exception e) {
			throw new TransformerException(this, e);
		}
	}

	private final String WSU = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd";
	private final String WSSE = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd";
	
	private int _ttlMinutes = 5;
	private String _username;
}
