package OctopusConsortium.Core.Transformers.DoS.Proxy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import org.junit.Test;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.types.DataTypeFactory;

import OctopusConsortium.DosService1_3.ContactType;
import OctopusConsortium.DosService1_5.EndpointTransportType;
import OctopusConsortium.Models.Nhs111Endpoint;
import OctopusConsortium.Models.Nhs111Endpoints;
import OctopusConsortium.Models.DOS.Proxy.Response.ContactDetailsField;
import OctopusConsortium.Models.DOS.Proxy.Response.Service;
import OctopusConsortium.Models.DOS.Proxy.Response.Services;


/**
 * @author tom.axworthy
 *
 */
public class ProxyServiceDetailsResponseToNhs111EndpointsTests {

	/**
	 * Test method for {@link OctopusConsortium.Core.Transformers.DoS.Proxy.ProxyServiceDetailsResponseToNhs111Endpoints()}.
	 */
	@Test
	public void testDataTypeSupport() {
		ProxyServiceDetailsResponseToNhs111Endpoints target = new ProxyServiceDetailsResponseToNhs111Endpoints();
		assertTrue("input of Services not supported",target.isSourceDataTypeSupported(DataTypeFactory.create(Services.class)));
		assertTrue("output of NHS 111 endpoints not supported",target.getReturnDataType().equals(DataTypeFactory.create(OctopusConsortium.Models.Nhs111Endpoints.class)));

	}

	
	/**
	 * Test method for {@link OctopusConsortium.Core.Transformers.DoS.Proxy.ProxyServiceDetailsResponseToNhs111Endpoints#doTransform(Object, String)()}.
	 * @throws JAXBException 
	 */
	@Test
	public void testDoTransform() {	 
		//Arrange
		//########
		ProxyServiceDetailsResponseToNhs111Endpoints target = new ProxyServiceDetailsResponseToNhs111Endpoints();		
	
		Services payload = new Services();
		
		Service service = new Service();
		ArrayList<Service> serviceList = new ArrayList<Service>();
		serviceList.add(service);
		
		ArrayList<ContactDetailsField> contactdetailsList = new ArrayList<ContactDetailsField>(); 
		service.setContactDetailsField(contactdetailsList);
		
		payload.setServices(serviceList);
		
		Nhs111Endpoints results = null;
		
		//Add a end point with invalid name
		ContactDetailsField contactDetail1 = new ContactDetailsField();
		contactDetail1.setNameField("");
		contactDetail1.setOrderField(0);
		contactDetail1.setTagField(ContactType.ITK);
		contactDetail1.setValueField("");
		contactdetailsList.add(contactDetail1);
		//Add valid primary end point (should be returned)		
		ContactDetailsField contactDetail2 = new ContactDetailsField();
		contactDetail2.setNameField("111 Routing Details");
		contactDetail2.setOrderField(0);
		contactDetail2.setTagField(ContactType.ITK);
		contactDetail2.setValueField("https://test.nhsdirect.nhs.uk:81/test/NHS111v2.svc\\|urn:nhs-itk:interaction:primaryOutofHourRecipientNHS111CDADocument-v2-0\\|CDA\\|Primary\\|");
		contactdetailsList.add(contactDetail2);
		//Add valid other end point 		
		ContactDetailsField contactDetail3 = new ContactDetailsField();
		contactDetail3.setNameField("111 Routing Details");
		contactDetail3.setOrderField(0);
		contactDetail3.setTagField(ContactType.ITK);
		contactDetail3.setValueField("https://test.nhsdirect.nhs.uk/NHS111v2other.svc\\|urn:nhs-itk:interaction:primaryOutofHourRecipientNHS111CDADocument-v2-0\\|CDA\\|Other\\|");
		contactdetailsList.add(contactDetail3);
		
		
		//Act
		//########
		try {
			results = (Nhs111Endpoints) target.doTransform(payload, "");
		} catch (TransformerException e) {
			e.printStackTrace();
			assertTrue("Error", false);
		}
		//Assert
		//########
		assertNotNull("Transform returned null", results);
		//this transformer should only return one 'Primary' end point
		assertTrue("incorrect number of endpoints",results.getEndpoints().size()==1);
		
		Nhs111Endpoint endpoint = results.getEndpoints().get(0);
		//check its not null
		assertNotNull("Missing endpoint",endpoint);
		//check the Primary end point was returned
		assertEquals("invalid url","https://test.nhsdirect.nhs.uk:81/test/NHS111v2.svc",endpoint.getUrl());
		//check the correct interaction was returned
		assertEquals("invalid interaction","urn:nhs-itk:interaction:primaryOutofHourRecipientNHS111CDADocument-v2-0",endpoint.getInteraction());
		//check url components are correct
		assertEquals("invalid type","https",endpoint.getUrlProtocol());
		assertEquals("invalid host","test.nhsdirect.nhs.uk",endpoint.getUrlHost());
		assertEquals("invalid port","81",endpoint.getUrlPort());
		assertEquals("invalid path","test/NHS111v2.svc",endpoint.getUrlPath());
		assertEquals(EndpointTransportType.ITK, endpoint.getTransport());
	}
	
	/**
	 * Test method for {@link OctopusConsortium.Core.Transformers.DoS.Proxy.ProxyServiceDetailsResponseToNhs111Endpoints#doTransform(Object, String)()}.
	 * @throws JAXBException 
	 */
	@Test
	public void testDoTransform_EmailService() {	 
		//Arrange
		//########
		ProxyServiceDetailsResponseToNhs111Endpoints target = new ProxyServiceDetailsResponseToNhs111Endpoints();		
	
		Services payload = new Services();
		
		Service service = new Service();
		ArrayList<Service> serviceList = new ArrayList<Service>();
		serviceList.add(service);
		
		ArrayList<ContactDetailsField> contactdetailsList = new ArrayList<ContactDetailsField>(); 
		service.setContactDetailsField(contactdetailsList);
		
		payload.setServices(serviceList);
		
		Nhs111Endpoints results = null;
		
		//Add a end point with invalid name
		ContactDetailsField contactDetail1 = new ContactDetailsField();
		contactDetail1.setNameField("");
		contactDetail1.setOrderField(0);
		contactDetail1.setTagField(ContactType.ITK);
		contactDetail1.setValueField("");
		contactdetailsList.add(contactDetail1);
		//Add valid primary end point (should be returned)
		ContactDetailsField contactDetail2 = new ContactDetailsField();
		contactDetail2.setNameField("111 Routing Details");
		contactDetail2.setOrderField(0);
		contactDetail2.setTagField(ContactType.EMAIL);
		contactDetail2.setValueField("https://test.nhsdirect.nhs.uk:81/test/NHS111v2.svc\\|urn:nhs-itk:interaction:primaryOutofHourRecipientNHS111CDADocument-v2-0\\|CDA\\|Primary\\|");
		contactdetailsList.add(contactDetail2);
		//Add valid other end point
		ContactDetailsField contactDetail3 = new ContactDetailsField();
		contactDetail3.setNameField("111 Routing Details");
		contactDetail3.setOrderField(0);
		contactDetail3.setTagField(ContactType.ITK);
		contactDetail3.setValueField("https://test.nhsdirect.nhs.uk/NHS111v2other.svc\\|urn:nhs-itk:interaction:primaryOutofHourRecipientNHS111CDADocument-v2-0\\|CDA\\|Other\\|");
		contactdetailsList.add(contactDetail3);
		
		
		//Act
		//########
		try {
			results = (Nhs111Endpoints) target.doTransform(payload, "");
		} catch (TransformerException e) {
			e.printStackTrace();
			assertTrue("Error", false);
		}
		//Assert
		//########
		assertNotNull("Transform returned null", results);
		//this transformer should only return one 'Primary' end point
		assertTrue("incorrect number of endpoints",results.getEndpoints().size()==1);
		
		Nhs111Endpoint endpoint = results.getEndpoints().get(0);
		//check its not null
		assertNotNull("Missing endpoint",endpoint);
		//check the Primary end point was returned
		assertEquals("invalid url","https://test.nhsdirect.nhs.uk:81/test/NHS111v2.svc",endpoint.getUrl());
		//check the correct interaction was returned
		assertEquals("invalid interaction","urn:nhs-itk:interaction:primaryOutofHourRecipientNHS111CDADocument-v2-0",endpoint.getInteraction());
		//check url components are correct
		assertEquals("invalid type","https",endpoint.getUrlProtocol());
		assertEquals("invalid host","test.nhsdirect.nhs.uk",endpoint.getUrlHost());
		assertEquals("invalid port","81",endpoint.getUrlPort());
		assertEquals("invalid path","test/NHS111v2.svc",endpoint.getUrlPath());
		assertEquals(EndpointTransportType.EMAIL, endpoint.getTransport());
	}
}
