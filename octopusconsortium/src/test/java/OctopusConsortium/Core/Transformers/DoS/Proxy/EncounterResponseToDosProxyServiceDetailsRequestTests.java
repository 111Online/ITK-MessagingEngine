package OctopusConsortium.Core.Transformers.DoS.Proxy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.xml.bind.JAXBException;

import org.junit.Test;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.types.DataTypeFactory;

import OctopusConsortium.Models.DOS.Proxy.Request.Services;
import OctopusConsortium.Service.Models.GPPractice;
import OctopusConsortium.Service.Models.IdentifyPatientResponse;
import OctopusConsortium.Service.Models.Patient;
import OctopusConsortium.Service.Models.SubmitEncounterToServiceRequest;
import OctopusConsortium.Service.Models.SubmitToServiceDetails;


/**
 * @author tom.axworthy
 *
 */
public class EncounterResponseToDosProxyServiceDetailsRequestTests  {

	/**
	 * Test method for {@link OctopusConsortium.Core.Transformers.Dos.Proxy.EncounterResponseToDosProxyServiceDetailsRequest()}.
	 */
	@Test
	public void testDataTypeSupport() {
		EncounterResponseToDosProxyServiceDetailsRequest target = new EncounterResponseToDosProxyServiceDetailsRequest();
		assertTrue("input of SubmitEncounterToServiceRequest not supported",target.isSourceDataTypeSupported(DataTypeFactory.create(OctopusConsortium.Service.Models.SubmitEncounterToServiceRequest.class)));
		assertTrue("input of IdentifyPatientResponse not supported",target.isSourceDataTypeSupported(DataTypeFactory.create(OctopusConsortium.Service.Models.IdentifyPatientResponse.class)));
		assertTrue("output of Services not supported",target.getReturnDataType().equals(DataTypeFactory.create(OctopusConsortium.Models.DOS.Proxy.Request.Services.class)));
	}

	String _username = "testusername";
	String _password = "testpassword";
	String _serviceVersion = "1.3";
	Integer _serviceId = 123;
	String _odsCode = "1234ODS";
	
	/**
	 * Test method for {@link OctopusConsortium.Core.Transformers.Dos.Proxy.EncounterResponseToDosProxyServiceDetailsRequest#doTransform(Object,String)()}
	 * @throws JAXBException
	 */
	@Test
	public void testDoTransformSubmitEncounterToServiceRequest() {
		//Arrange
		//########
		EncounterResponseToDosProxyServiceDetailsRequest target = new EncounterResponseToDosProxyServiceDetailsRequest();
		target._username = _username;
		target._password = _password;
		target._serviceVersion = _serviceVersion;
		
		SubmitEncounterToServiceRequest payload = new SubmitEncounterToServiceRequest();
		SubmitToServiceDetails sd = new SubmitToServiceDetails();
		sd.setId(_serviceId);
		sd.setOdsCode(_odsCode);
		payload.setServiceDetails(sd);
		
		//Act
		//########
		Services results = null;
		try {
			results = (Services) target.doTransform(payload, "");
		} catch (TransformerException e) {
			e.printStackTrace();
			assertTrue("Error", false);
		}
		//Assert
		//########
		assertNotNull("Transform returned null", results);
		
		assertEquals(_serviceId.toString() ,results.getServiceId());
		assertEquals(_serviceVersion ,results.getServiceVersion());
		assertEquals(_username ,results.getUserInfo().getUsername());
		assertEquals(_password ,results.getUserInfo().getPassword());	
	}
	
	/**
	 * Test method for {@link OctopusConsortium.Core.Transformers.Dos.Proxy.EncounterResponseToDosProxyServiceDetailsRequest#doTransform(Object,String)()}
	 * @throws JAXBException
	 */
	@Test
	public void testDoTransformSubmitEncounterToServiceRequest_OnlyODSCode() {
		//Arrange
		//########
				
		EncounterResponseToDosProxyServiceDetailsRequest target = new EncounterResponseToDosProxyServiceDetailsRequest();
		target._username = _username;
		target._password = _password;
		target._serviceVersion = _serviceVersion;
		
		SubmitEncounterToServiceRequest payload = new SubmitEncounterToServiceRequest();
		SubmitToServiceDetails sd = new SubmitToServiceDetails();
		sd.setOdsCode(_serviceId.toString());
		payload.setServiceDetails(sd);
		
		//Act
		//########
		Services results = null;
		try {
			results = (Services) target.doTransform(payload, "");
		} catch (TransformerException e) {
			e.printStackTrace();
			assertTrue("Error", false);
		}
		//Assert
		//########
		assertNotNull("Transform returned null", results);
		
		assertEquals(_serviceId.toString() ,results.getServiceId());
		assertEquals(_serviceVersion ,results.getServiceVersion());
		assertEquals(_username ,results.getUserInfo().getUsername());
		assertEquals(_password ,results.getUserInfo().getPassword());	
	}
	
	/**
	 * Test method for {@link OctopusConsortium.Core.Transformers.Dos.Proxy.EncounterResponseToDosProxyServiceDetailsRequest#doTransform(Object,String)()}
	 * @throws JAXBException
	 */
	@Test
	public void testDoTransformIdentifyPatientResponse() {
		//Arrange
		//########
				
		EncounterResponseToDosProxyServiceDetailsRequest target = new EncounterResponseToDosProxyServiceDetailsRequest();
		target._username = _username;
		target._password = _password;
		target._serviceVersion = _serviceVersion;
		
		IdentifyPatientResponse payload = new IdentifyPatientResponse();
		
		GPPractice gp = new GPPractice();
		gp.setODS(_serviceId.toString());//this ODS should actually be a DOS ID, for the Dos 'ServiceById' call to work...
		Patient p = new Patient();
		p.setGPPractice(gp);
		payload.setPatient(p);
		
		//Act
		//########
		Services results = null;
		try {
			results = (Services) target.doTransform(payload, "");
		} catch (TransformerException e) {
			e.printStackTrace();
			assertTrue("Error", false);
		}
		//Assert
		//########
		assertNotNull("Transform returned null", results);
		
		assertEquals(_serviceId.toString() ,results.getServiceId());
		assertEquals(_serviceVersion ,results.getServiceVersion());
		assertEquals(_username ,results.getUserInfo().getUsername());
		assertEquals(_password ,results.getUserInfo().getPassword());	
	}
}
