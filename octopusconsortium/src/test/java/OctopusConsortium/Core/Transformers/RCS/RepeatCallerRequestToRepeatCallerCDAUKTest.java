/**
 * 
 */
package OctopusConsortium.Core.Transformers.RCS;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.junit.Test;
import org.mule.DefaultMuleMessage;
import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.tck.junit4.AbstractMuleContextTestCase;
import org.mule.transformer.types.DataTypeFactory;

import OctopusConsortium.Models.RCS.POCDMT000002UK01ClinicalDocument;
import OctopusConsortium.RepeatCallerServiceV1.DistributionEnvelopeType;
import OctopusConsortium.Service.Models.DispositionDetails;
import OctopusConsortium.Service.Models.GPPractice;
import OctopusConsortium.Service.Models.Gender;
import OctopusConsortium.Service.Models.HaSC;
import OctopusConsortium.Service.Models.IdentifyPatientResponse;
import OctopusConsortium.Service.Models.Patient;
import OctopusConsortium.Service.Models.SubmitEncounterResponse;

/**
 * @author stuart.yeates
 *
 */
public class RepeatCallerRequestToRepeatCallerCDAUKTest extends AbstractMuleContextTestCase 
{

	
	/**
	 * Test method for {@link OctopusConsortium.Core.Transformers.RCS.ToRepeatCallerCDA#IdentifyPatientResponseToRepeatCallerCDA()}.
	 */
	@Test
	public void testIdentifyPatientResponseToRepeatCallerCDA() {
		ToRepeatCallerCDA_UK target = new ToRepeatCallerCDA_UK();
		assertTrue("input of RepeatCallerRequest not supported",target.isSourceDataTypeSupported(DataTypeFactory.create(SubmitEncounterResponse.class)));
		assertTrue("output of POCDMT000002UK01ClinicalDocument not supported",target.getReturnDataType().equals(DataTypeFactory.create(POCDMT000002UK01ClinicalDocument.class)));
	}

	
	/**
	 * Test method for {@link OctopusConsortium.Core.Transformers.RCS.ToRepeatCallerCDA#transformMessage(org.mule.api.MuleMessage, java.lang.String)}.
	 * @throws DatatypeConfigurationException 
	 */
	@Test
	public void testMessageSchemaValidation() throws DatatypeConfigurationException {
		//Arrange
		//########
		SubmitEncounterResponse requestFailTest = getRepeatCallerRequestData();
		SubmitEncounterResponse request = getRepeatCallerRequestData();
		
		//set the Hasc details
		request.getHaSC().setDispositionDetails(new DispositionDetails());
		request.getHaSC().getDispositionDetails().setDispositionCode(1);
		request.getHaSC().getDispositionDetails().setDispositionName("test");
		request.getHaSC().getDispositionDetails().setSymptomDiscriminatorList(new ArrayList<Integer>());
		request.getHaSC().getDispositionDetails().setSymptomGroup(4005);
				
		ToRepeatCallerCDA_UK target = new ToRepeatCallerCDA_UK();
		target.setOds("ODS123");
		target.setOrgName("Test Org");

		//Act
		//########
		POCDMT000002UK01ClinicalDocument result = null;
		//try failed as missing setDispositionCode
		boolean caught = false;
		try {
			Object returnValue = target.doTransform(requestFailTest, "");
			result = (POCDMT000002UK01ClinicalDocument)returnValue;
		} catch (TransformerException e) {			
			caught = true;
		}
		finally{
			assertTrue("missing hasc data error not thrown",caught);
		}
		
		//try failed as missing Hasc
		requestFailTest.getHaSC().setDispositionDetails(new DispositionDetails());
		requestFailTest.getHaSC().getDispositionDetails().setDispositionCode(1);
		requestFailTest.getHaSC().getDispositionDetails().setDispositionName("test");
		requestFailTest.getHaSC().getDispositionDetails().setSymptomDiscriminatorList(new ArrayList<Integer>());
		requestFailTest.getHaSC().getDispositionDetails().setSymptomGroup(4005);
		requestFailTest.getHaSC().setValue("");
		caught = false;
		try {
			Object returnValue = target.doTransform(requestFailTest, "");
			result = (POCDMT000002UK01ClinicalDocument)returnValue;
		} catch (TransformerException e) {			
			caught = true;
		}
		finally{
			assertTrue("missing hasc error not thrown",caught);
		}
		request.getHaSC().setValue(getHascValue());
		try {
			Object returnValue = target.doTransform(request, "");
			result = (POCDMT000002UK01ClinicalDocument)returnValue;
		} catch (TransformerException e) {			
			assertTrue("error: \n" + e.getSummaryMessage(),false);
		}
		//Assert
		//########
		assertNotNull(result);
		if(result!=null)
		{
			URL file = getClass().getResource("/schemas/RPC/Schemas/POCD_MT000002UK01.xsd"); 
			
			try {
				JAXBContext jaxbContext = JAXBContext.newInstance(POCDMT000002UK01ClinicalDocument.class);
				OctopusConsortium.Models.RCS.ObjectFactory rcsfactory = new OctopusConsortium.Models.RCS.ObjectFactory();
				JAXBElement<POCDMT000002UK01ClinicalDocument> jax_message = rcsfactory.createClinicalDocument(result);
				//String xml =  test();
				String xml =  getXML(jax_message,jaxbContext);				
				SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
				//LSResourceResolver resolver = new ResourceResolver(factory.getResourceResolver(),file);			
				//factory.setResourceResolver(resolver);
				Schema schema = factory.newSchema(file);	
				
				
				Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
				unmarshaller.setSchema(schema);	
				Object unm = unmarshaller.unmarshal(new ByteArrayInputStream (xml.getBytes()));
				//Assert
				assertTrue("unmarshalled null",unm!=null);
			} catch (Exception e) {
				//Assert
				e.printStackTrace();			
				assertTrue("Generated xml message failed to validate " + e.getMessage() ,false);
			}
		}
		
		System.out.print("Complete");

		
	}

	
	/**
	 * Test method for {@link OctopusConsortium.Core.Transformers.RCS.ToRepeatCallerCDA#IdentifyPatientResponseToRepeatCallerCDA()}.
	 * @throws JAXBException 
	 */
	@Test
	public void testRepeatCallerCDAToDistributionEnvelope() throws JAXBException {
		ToDistributionEnvelope target = new ToDistributionEnvelope();
		assertTrue("input of POCDMT000002UK01ClinicalDocument not supported",target.isSourceDataTypeSupported(DataTypeFactory.create(POCDMT000002UK01ClinicalDocument.class)));
		assertTrue("output of DistributionEnvelopeType not supported",target.getReturnDataType().equals(DataTypeFactory.create(DistributionEnvelopeType.class)));
	}
	/**
	 * Test method for {@link OctopusConsortium.Core.Transformers.RCS.ToRepeatCallerCDA#transformMessage(org.mule.api.MuleMessage, java.lang.String)}.
	 * @throws DatatypeConfigurationException 
	 */
	@Test
	public void testDistributionEnvelopeMessageSchemaValidation() throws DatatypeConfigurationException ,JAXBException{
		
		SubmitEncounterResponse request = getRepeatCallerRequestData();
		//set the Hasc details
		request.getHaSC().setDispositionDetails(new DispositionDetails());
		request.getHaSC().getDispositionDetails().setDispositionCode(1);
		request.getHaSC().getDispositionDetails().setDispositionName("test");
		request.getHaSC().getDispositionDetails().setSymptomDiscriminatorList(new ArrayList<Integer>());
		request.getHaSC().getDispositionDetails().setSymptomGroup(4005);
		request.getHaSC().setValue(getHascValue());
		
		ToRepeatCallerCDA_UK requestToCDA = new ToRepeatCallerCDA_UK();
		requestToCDA.setOds("ODS123");
		requestToCDA.setOrgName("Test Org");
		
		ToDistributionEnvelope target = new ToDistributionEnvelope();
		target.setOds("ODS123");
		target.setOrgName("Test Org");

		OctopusConsortium.RepeatCallerServiceV1.DistributionEnvelopeType result = null;
		try {
			OctopusConsortium.Models.RCS.POCDMT000002UK01ClinicalDocument returnValue = (OctopusConsortium.Models.RCS.POCDMT000002UK01ClinicalDocument)requestToCDA.doTransform(request, "");
			
			MuleMessage message = new DefaultMuleMessage(returnValue,muleContext);
			result = (OctopusConsortium.RepeatCallerServiceV1.DistributionEnvelopeType)target.transformMessage(message,"");
		} catch (TransformerException e) {
			assertTrue("error: \n" + e.getSummaryMessage(),false);
		}
		
		assertNotNull(result);
		if(result!=null)
		{
			URL file = getClass().getResource("/schemas/RPC/Schemas/distributionEnvelope-v2-0.xsd"); 
			
			try {
				JAXBContext jaxbContext = JAXBContext.newInstance(DistributionEnvelopeType.class,OctopusConsortium.Models.RCS.POCDMT000002UK01ClinicalDocument.class);
				JAXBElement<?>jax_result = new OctopusConsortium.RepeatCallerServiceV1.ObjectFactory().createDistributionEnvelope(result);
				
				String xml =  getXML(jax_result,jaxbContext);
				//String xml  = test();
				
				SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
				Schema schema = factory.newSchema(file);	
				Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
				unmarshaller.setSchema(schema);	
				Object unm = unmarshaller.unmarshal(new ByteArrayInputStream (xml.getBytes()));
				//Assert
				assertTrue("unmarshalled null",unm!=null);
			}
			catch (Exception e) {
				//Assert
				e.printStackTrace();			
				assertTrue("Generated xml message failed to validate " + e.getMessage() ,false);
			}
		}
	}

	protected String getXML(JAXBElement<?>jax_message,JAXBContext jaxbContext) throws JAXBException {
		
		//OctopusConsortium.Models.RCS.ObjectFactory factory = new OctopusConsortium.Models.RCS.ObjectFactory();
		//JAXBElement<POCDMT200001GB02ClinicalDocument> jax_message = factory.createClinicalDocument(result);

		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		//to disable the default XML declaration un-comment the following line  
		//jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
		StringWriter sw = new StringWriter();
		jaxbMarshaller.marshal(jax_message, sw);
		String re = sw.toString();
		System.out.print(re + "\n");						
		return re;
	}
	protected SubmitEncounterResponse getRepeatCallerRequestData() throws DatatypeConfigurationException
	{
		IdentifyPatientResponse patientResponse = new IdentifyPatientResponse();
		patientResponse.setPatient(new Patient());
		patientResponse.getPatient().setForename("forename");
		patientResponse.getPatient().setSurname("surename");
		patientResponse.getPatient().setGender(Gender.MALE);
		patientResponse.getPatient().setTitle("Mr");
		
		GregorianCalendar c = new GregorianCalendar();
		c.set(1980, 01, 01);
		XMLGregorianCalendar dob;		
		dob = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		patientResponse.getPatient().setDOB(dob);
		
		//SubmitEncounterMessage hascMessage = new SubmitEncounterMessage();
			
		
		SubmitEncounterResponse request = new SubmitEncounterResponse();
		request.setPatient(patientResponse.getPatient());
		request.setHaSC(new HaSC());
		
		request.getPatient().setGPPractice(new GPPractice());
		request.getPatient().setNhsNumber("123");
		
		return request;
	}
	
	protected String getHascValue(){
		return "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n   <soap:Body>\n      <ShowDataResponse xmlns=\"http://www.infermed.com/AzWebService\">\n         <ShowDataResult>\n            <WebInstances>\n               <DataInstance>\n                  <Id>70000</Id>\n                  <Name>job</Name>\n                  <Caption>job</Caption>\n                  <Type>setOfText</Type>\n                  <Requested>false</Requested>\n                  <DefaultValues>\n                     <DefaultValue>guarding</DefaultValue>\n                  </DefaultValues>\n                  <Scope>always_ask</Scope>\n                  <Owners>\n                     <Owner>job_e</Owner>\n                  </Owners>\n                  <StartTime>2012-11-15T15:58:38.013</StartTime>\n                  <EndTime>2012-11-15T16:04:51.703</EndTime>\n                  <Ranges>\n                     <Range>\n                        <Caption>guarding</Caption>\n                        <Value>guarding</Value>\n                     </Range>\n                     <Range>\n                        <Caption>searching</Caption>\n                        <Value>searching</Value>\n                     </Range>\n                     <Range>\n                        <Caption>racing</Caption>\n                        <Value>racing</Value>\n                     </Range>\n                     <Range>\n                        <Caption>ratting</Caption>\n                        <Value>ratting</Value>\n                     </Range>\n                     <Range>\n                        <Caption>pet</Caption>\n                        <Value>pet</Value>\n                     </Range>\n                     <Range>\n                        <Caption>herding</Caption>\n                        <Value>herding</Value>\n                     </Range>\n                     <Range>\n                        <Caption>gun dog</Caption>\n                        <Value>gun dog</Value>\n                     </Range>\n                  </Ranges>\n                  <Values>\n                     <Value>racing</Value>\n                  </Values>\n               </DataInstance>\n               <DataInstance>\n                  <Id>70001</Id>\n                  <Name>colour</Name>\n                  <Caption>colour</Caption>\n                  <Type>setOfText</Type>\n                  <Requested>false</Requested>\n                  <DefaultValues>\n                     <DefaultValue>black</DefaultValue>\n                  </DefaultValues>\n                  <Scope>always_ask</Scope>\n                  <Owners>\n                     <Owner>colour_e</Owner>\n                  </Owners>\n                  <StartTime>2012-11-15T15:58:38.023</StartTime>\n                  <EndTime>2012-11-15T16:04:51.733</EndTime>\n                  <Ranges>\n                     <Range>\n                        <Caption>black</Caption>\n                        <Value>black</Value>\n                     </Range>\n                     <Range>\n                        <Caption>tan</Caption>\n                        <Value>tan</Value>\n                     </Range>\n                     <Range>\n                        <Caption>grey</Caption>\n                        <Value>grey</Value>\n                     </Range>\n                     <Range>\n                        <Caption>golden</Caption>\n                        <Value>golden</Value>\n                     </Range>\n                     <Range>\n                        <Caption>white</Caption>\n                        <Value>white</Value>\n                     </Range>\n                     <Range>\n                        <Caption>any</Caption>\n                        <Value>any</Value>\n                     </Range>\n                  </Ranges>\n                  <Values>\n                     <Value>black</Value>\n                  </Values>\n               </DataInstance>\n               <DataInstance>\n                  <Id>70002</Id>\n                  <Name>size</Name>\n                  <Caption>size</Caption>\n                  <Type>text</Type>\n                  <Requested>false</Requested>\n                  <DefaultValues>\n                     <DefaultValue>large</DefaultValue>\n                  </DefaultValues>\n                  <Scope>always_ask</Scope>\n                  <Owners>\n                     <Owner>size_e</Owner>\n                  </Owners>\n                  <StartTime>2012-11-15T15:58:38.023</StartTime>\n                  <EndTime>2012-11-15T16:04:51.793</EndTime>\n                  <Ranges>\n                     <Range>\n                        <Caption>small</Caption>\n                        <Value>small</Value>\n                     </Range>\n                     <Range>\n                        <Caption>average</Caption>\n                        <Value>average</Value>\n                     </Range>\n                     <Range>\n                        <Caption>large</Caption>\n                        <Value>large</Value>\n                     </Range>\n                  </Ranges>\n                  <Values>\n                     <Value>large</Value>\n                  </Values>\n               </DataInstance>\n            </WebInstances>\n         </ShowDataResult>\n      </ShowDataResponse>\n   </soap:Body>\n</soap:Envelope>";
	}
}
