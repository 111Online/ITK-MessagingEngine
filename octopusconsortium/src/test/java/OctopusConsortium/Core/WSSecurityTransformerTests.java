package OctopusConsortium.Core;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.StringReader;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.mule.tck.junit4.AbstractMuleContextTestCase;
import org.mule.transport.http.HttpsConnector;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

public class WSSecurityTransformerTests extends AbstractMuleContextTestCase  {

	
	
	@Test(timeout=240000)
	public void doTransform_WithCorrectData_CreatesSecurityElement()
			throws IOException {
		
		//Arrange	
		String payload = getPatientDetailsResponse();		
		WSSecurityTransformer target = new WSSecurityTransformer();
		
		String  theResponse = null;
		
		//Act
		try {
			HttpsConnector connector = new HttpsConnector(AbstractMuleContextTestCase.muleContext);
			connector.setClientKeyStore("orqestra-nhs_direct.jks");
			connector.setKeyStore("orqestra-nhs_direct.jks");
			connector.setTrustStore("orqestra-nhs_direct.jks");
			connector.setClientKeyStorePassword("raTru2Em");
			connector.setKeyPassword("raTru2Em");
			connector.setTrustStorePassword("raTru2Em");					
			target.setHTTPS(connector);			
			target.setAlias("orqestrakey");
			target.setUsername("CN=194.176.105.128");
			
			theResponse  = ( String ) target.doTransform(payload, null);
			
			Document doc = stringToDom(theResponse);
			
			NodeList nodes = doc.getElementsByTagNameNS("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd", "Security");
			
			//Asserts
			assertNotNull(nodes.item(0));
			assertEquals(nodes.item(0).getLocalName(), "Security");
			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void doTransform_WithCorrectData_CreatesTimestampElement()
			throws IOException {
		
		//Arrange	
		String payload = getPatientDetailsResponse();		
		WSSecurityTransformer target = new WSSecurityTransformer();
		
		String  theResponse = null;
		
		//Act
		try {
			HttpsConnector connector = new HttpsConnector(AbstractMuleContextTestCase.muleContext);
			connector.setClientKeyStore("orqestra-nhs_direct.jks");
			connector.setKeyStore("orqestra-nhs_direct.jks");
			connector.setTrustStore("orqestra-nhs_direct.jks");
			connector.setClientKeyStorePassword("raTru2Em");
			connector.setKeyPassword("raTru2Em");
			connector.setTrustStorePassword("raTru2Em");					
			target.setHTTPS(connector);			
			target.setAlias("orqestrakey");
			target.setUsername("CN=194.176.105.128");
			
			theResponse  = ( String ) target.doTransform(payload, null);
			
			Document doc = stringToDom(theResponse);
			
			NodeList nodes = doc.getElementsByTagNameNS("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd", "Timestamp");
			
			//Asserts
			assertNotNull(nodes.item(0));
			assertEquals(nodes.item(0).getLocalName(), "Timestamp");
			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}				
	}
	
	@Test
	public void doTransform_WithCorrectData_SignsTimestamp()
			throws IOException {
		
		//Arrange	
		String payload = getPatientDetailsResponse();		
		WSSecurityTransformer target = new WSSecurityTransformer();
		
		String  theResponse = null;
		
		//Act
		try {
			HttpsConnector connector = new HttpsConnector(AbstractMuleContextTestCase.muleContext);
			connector.setClientKeyStore("orqestra-nhs_direct.jks");
			connector.setKeyStore("orqestra-nhs_direct.jks");
			connector.setTrustStore("orqestra-nhs_direct.jks");
			connector.setClientKeyStorePassword("raTru2Em");
			connector.setKeyPassword("raTru2Em");
			connector.setTrustStorePassword("raTru2Em");					
			target.setHTTPS(connector);			
			target.setAlias("orqestrakey");
			target.setUsername("CN=194.176.105.128");
			
			theResponse  = ( String ) target.doTransform(payload, null);
			
			Document doc = stringToDom(theResponse);
			
			NodeList sigRef = doc.getElementsByTagNameNS("http://www.w3.org/2000/09/xmldsig#", "Reference");
			NodeList timestampNodes = doc.getElementsByTagNameNS("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd", "Timestamp");
			
			//Asserts
			assertNotNull(sigRef.item(0));
			assertNotNull(timestampNodes.item(0));
			String signedElement = sigRef.item(0).getAttributes().getNamedItem("URI").getNodeValue();
			
			assertEquals(signedElement, "#" + timestampNodes.item(0).getAttributes().getNamedItemNS("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd", "Id").getNodeValue());
			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}				
	}
		
	private String getPatientDetailsResponse() throws IOException {
		URL file = getClass().getResource("/messages/pds/getPatientDetailsResponse.xml");
		return Resources.toString(file, Charsets.UTF_8);
	}
		
	private static Document stringToDom(String xmlSource) 
            throws SAXException, ParserConfigurationException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(new InputSource(new StringReader(xmlSource)));
    }
}
