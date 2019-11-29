package OctopusConsortium.Core;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.IOUtils;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import OctopusConsortium.Service.Models.DateOfBirth;

public class SubmitToCallQueueDobValidationInterceptor extends AbstractSoapInterceptor  {

	public static final String ALLOWED_DATE_PATTERN_DATETIME = "yyyy-MM-dd'T'HH:mm:ss";
	public static final String ALLOWED_DATE_PATTERN_DATE = "yyyy-MM-dd";
	
	public SubmitToCallQueueDobValidationInterceptor() throws NoSuchFieldException {
		super(Phase.RECEIVE);
		
		reflectXmlAnnotations();
	}

	@Override
	public void handleMessage(SoapMessage message) throws Fault {
		if (message.get("SOAPAction") == null || !(message.get("SOAPAction").toString().equals("SubmitToCallQueueEnquiry")
				 || message.get("SOAPAction").toString().equals("SubmitToCallQueueCallback")))
			return;
		
		_originalValue = null; //reset
        try {
	        String soapMessage = readContent(message);
	        
            Document document = loadXmlDocument(soapMessage);  
            
            findAndParseDob(document);
            
        } catch (Exception e) {
        	if (e instanceof ParseException || 
        		e instanceof DOMException ||
        		e instanceof DatatypeConfigurationException ||
        		e instanceof IllegalArgumentException         		
        		) {
        		throw new Fault(new InvalidMessageException(String.format("Invalid date of birth '%s'. Expected pattern '%s' or '%s.'", _originalValue, DateAdapterOoHTimeString.ALLOWED_DATE_PATTERN_DATETIME, DateAdapterOoHTimeString.ALLOWED_DATE_PATTERN_DATETIME)));
        	}
        	else {
        		throw new Fault(e);
        	}
        }
	}

	private String _dobElementName = null;
	private String _dobChoiceName = null;
	private String _originalValue = null;
	
	private void reflectXmlAnnotations() throws NoSuchFieldException {
		reflectElementName();
		reflectChoiceName();
	}

	private void reflectChoiceName() throws NoSuchFieldException {
		Field dobField = DateOfBirth.class.getDeclaredField("dob");
		XmlElements elements = dobField.getAnnotation(XmlElements.class);
		for (XmlElement element : elements.value())
		{
			if (element.type() == XMLGregorianCalendar.class)
				_dobChoiceName = element.name();
		}
		if (_dobChoiceName == null)
			throw new NoSuchFieldException(String.format("Cannot initialise %s because the DateOfBirth class doesn't contain an XmlElements annotation with a child XmlElement of type %s.", this.getClass().getSimpleName(), XMLGregorianCalendar.class.getSimpleName()));
	}

	private void reflectElementName() throws NoSuchFieldException {
		XmlType type = DateOfBirth.class.getAnnotation(XmlType.class);
		if (type == null)
			throw new NoSuchFieldException(String.format("Cannot initialise %s because the DateOfBirth class doesn't contain an XmlType annotation.", this.getClass().getSimpleName()));
		_dobElementName = type.name();
	}

	private String readContent(SoapMessage message) throws IOException {
		InputStream inStream = message.getContent(InputStream.class);
		if (inStream == null) return null;
		
	    CachedOutputStream outStream = new CachedOutputStream();
	    IOUtils.copy(inStream, outStream);

	    outStream.flush();
	    inStream.close();
	    
	    message.setContent(InputStream.class, outStream.getInputStream());
	    outStream.close();
	    
	    return new String(outStream.getBytes());
	}
	
	private Document loadXmlDocument(String soapMessage)
			throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
		DocumentBuilder builder = factory.newDocumentBuilder();
		return builder.parse( new InputSource( new StringReader( soapMessage ) ) );
	}

	private void findAndParseDob(Document document)
			throws ParseException, DOMException, DatatypeConfigurationException {

		NodeList dobElements = document.getElementsByTagName(_dobElementName);
		
		for (int i = 0; i < dobElements.getLength(); ++i) {
			NodeList dobChoices = dobElements.item(i).getChildNodes();
			
			findAndParseDobChoice(dobChoices);
		}
	}

	private void findAndParseDobChoice(NodeList dobChoices)
			throws ParseException, DOMException, DatatypeConfigurationException {
		
		for (int j = 0; j < dobChoices.getLength(); ++j) {
			Node dobNode = dobChoices.item(j);
			if (!dobNode.getNodeName().equals(_dobChoiceName))
				continue;
			
			tryParseDate(_originalValue = dobNode.getTextContent());
			return;
		}
		//no dob specified, ignore
	}

	private void tryParseDate(String value) throws ParseException, DatatypeConfigurationException {	
		SimpleDateFormat format = (SimpleDateFormat)DateFormat.getDateInstance();
		try{
			format.applyPattern(ALLOWED_DATE_PATTERN_DATETIME);
			format.parse(value);
		}catch (ParseException e) {
			format.applyPattern(ALLOWED_DATE_PATTERN_DATE);
			format.parse(value);
		}
    	format.parse(value);
	}
}