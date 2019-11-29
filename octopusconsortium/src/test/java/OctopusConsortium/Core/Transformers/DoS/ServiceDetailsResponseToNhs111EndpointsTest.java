package OctopusConsortium.Core.Transformers.DoS;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.xml.bind.JAXBException;

import org.junit.Test;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.types.DataTypeFactory;

import OctopusConsortium.DosService1_5.ArrayOfServiceEndpoints;
import OctopusConsortium.DosService1_5.Endpoint;
import OctopusConsortium.DosService1_5.ObjectFactory;
import OctopusConsortium.DosService1_5.ServiceDetail;
import OctopusConsortium.DosService1_5.ServiceDetailsByIdResponse;
import OctopusConsortium.Models.Nhs111Endpoint;
import OctopusConsortium.Models.Nhs111Endpoints;


/**
 * @author stuart.yeates
 *
 */
public class ServiceDetailsResponseToNhs111EndpointsTest {

	/**
	 * Test method for {@link OctopusConsortium.Core.Transformers.RCS.ToRepeatCallerCDA#IdentifyPatientResponseToRepeatCallerCDA()}.
	 */
	@Test
	public void testDataTypeSupport() {
		ServiceDetailsResponseToNhs111Endpoints target = new ServiceDetailsResponseToNhs111Endpoints();

		assertTrue("input of ServiceDetailsByIdResponse not supported",target.isSourceDataTypeSupported(DataTypeFactory.create(OctopusConsortium.DosService1_5.ServiceDetailsByIdResponse.class)));
		assertTrue("output of POCDMT000002UK01ClinicalDocument not supported",target.getReturnDataType().equals(DataTypeFactory.create(Nhs111Endpoints.class)));
	}

	
	/**
	 * Test method for {@link OctopusConsortium.Core.Transformers.RCS.ToRepeatCallerCDA#IdentifyPatientResponseToRepeatCallerCDA()}.
	 * @throws JAXBException 
	 */
	@Test
	public void testDoTransform() {
		//Arrange
		//########
		ServiceDetailsResponseToNhs111Endpoints target = new ServiceDetailsResponseToNhs111Endpoints();		
		ObjectFactory modelFactory = new ObjectFactory();
		ServiceDetailsByIdResponse payload = modelFactory.createServiceDetailsByIdResponse();

		payload.setServices(modelFactory.createArrayOfServices());
		ServiceDetail serviceDetail = modelFactory.createServiceDetail();
		payload.getServices().getService().add(serviceDetail);
		ArrayOfServiceEndpoints arrayOfServiceEndpoints = modelFactory.createArrayOfServiceEndpoints();
		serviceDetail.setServiceEndpoints(arrayOfServiceEndpoints);
		
		Nhs111Endpoints results = null;
		
		//Add a end point with no transport type
		Endpoint endpoint1 = modelFactory.createEndpoint();
		endpoint1.setEndpointOrder(0);
		endpoint1.setTransport("");
		endpoint1.setAddress("https://a.url.com/test/NHS111v2.svc");
		endpoint1.setBusinessScenario("Primary");
		endpoint1.setFormat("CDA");
		endpoint1.setInteraction("urn:nhs-itk:interaction:primaryOutofHourRecipientNHS111CDADocument-v2-0");
		arrayOfServiceEndpoints.getEndpoint().add(endpoint1);
		
		//Add valid primary end point (should be returned)
		Endpoint endpoint2 = modelFactory.createEndpoint();
		endpoint2.setEndpointOrder(0);
		endpoint2.setTransport("ITK");
		endpoint2.setAddress("https://test.nhsdirect.nhs.uk:81/test/NHS111v2.svc");
		endpoint2.setBusinessScenario("Primary");
		endpoint2.setFormat("CDA");
		endpoint2.setInteraction("urn:nhs-itk:interaction:primaryOutofHourRecipientNHS111CDADocument-v2-0");
		arrayOfServiceEndpoints.getEndpoint().add(endpoint2);

		//Add valid other end point 		
		Endpoint endpoint3 = modelFactory.createEndpoint();
		endpoint3.setEndpointOrder(1);
		endpoint3.setTransport("ITK");
		endpoint3.setAddress("https://a.different.url/test/NHS111v2.svc");
		endpoint3.setBusinessScenario("Primary");
		endpoint3.setFormat("CDA");
		endpoint3.setInteraction("urn:nhs-itk:interaction:primaryOutofHourRecipientNHS111CDADocument-v2-0");
		arrayOfServiceEndpoints.getEndpoint().add(endpoint3);
		
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
		
	}
	
	
}
