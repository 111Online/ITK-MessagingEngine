package OctopusConsortium.Core.Transformers.RCS;

import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.net.URL;
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
import org.mule.DefaultTestMuleMessage;
import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.tck.junit4.AbstractMuleContextTestCase;
import org.mule.transformer.types.DataTypeFactory;

import OctopusConsortium.Core.CommonValues;
import OctopusConsortium.Models.RCS.II;
import OctopusConsortium.Models.RCS.ObjectFactory;
import OctopusConsortium.Models.RCS.POCDMT000002UK01ClinicalDocument;
import OctopusConsortium.Models.RCS.POCDMT000002UK01InformationRecipient;
import OctopusConsortium.Models.RCS.POCDMT000002UK01IntendedRecipient;
import OctopusConsortium.Models.RCS.POCDMT000002UK01Organization;
import OctopusConsortium.Models.RCS.QUPAMT000001GB01RepeatCallerQuery;
import OctopusConsortium.RepeatCallerServiceV1.DistributionEnvelopeType;
import OctopusConsortium.Service.Models.Gender;
import OctopusConsortium.Service.Models.HaSC;
import OctopusConsortium.Service.Models.IdentifyPatientResponse;
import OctopusConsortium.Service.Models.Patient;
import OctopusConsortium.Service.Models.SubmitEncounterResponse;


public class IdentifyPatientResponseToRepeatCallerQueryTests extends AbstractMuleContextTestCase {

	/**
	 * Test method for {@link OctopusConsortium.Core.Transformers.RCS.IdentifyPatientResponseToRepeatCallerQuery#IdentifyPatientResponseToRepeatCallerCDA()}.
	 */
	@Test
	public void testIdentifyPatientResponseToRepeatCallerQuery() {
		IdentifyPatientResponseToRepeatCallerQuery target = new IdentifyPatientResponseToRepeatCallerQuery();
		assertTrue("input of RepeatCallerRequest not supported",target.isSourceDataTypeSupported(DataTypeFactory.create(SubmitEncounterResponse.class)));
		assertTrue("input of IdentifyPatientResponseV1 not supported",target.isSourceDataTypeSupported(DataTypeFactory.create(IdentifyPatientResponse.class)));
		assertTrue("output of POCDMT200001GB02ClinicalDocument not supported",target.getReturnDataType().equals(DataTypeFactory.create(QUPAMT000001GB01RepeatCallerQuery.class)));
	}
	
	/**
	 * Test method for {@link OctopusConsortium.Core.Transformers.RCS.IdentifyPatientResponseToRepeatCallerQuery#doTransform(java.Object, java.lang.String)}.
	 * @throws DatatypeConfigurationException 
	 * @throws TransformerException 
	 */
	@Test
	public void testMessageSchemaValidation() throws DatatypeConfigurationException  {
	
		SubmitEncounterResponse request = getRepeatCallerRequestData();
		IdentifyPatientResponseToRepeatCallerQuery target = new IdentifyPatientResponseToRepeatCallerQuery();
		target.setOds("ODS123");
		target.setOrgName("Test Org");

		QUPAMT000001GB01RepeatCallerQuery result = null;
		try {
			result = (QUPAMT000001GB01RepeatCallerQuery) target.doTransform(request,"");
		} catch (TransformerException e) {			
			assertTrue("error: \n" + e.getSummaryMessage(),false);
		}
		
		assertNotNull(result);
		if(result!=null)
		{
			URL file = getClass().getResource("/schemas/RPC/Schemas/QUPA_MT000001GB01.xsd"); 
			
			try {
				JAXBContext jaxbContext = JAXBContext.newInstance(QUPAMT000001GB01RepeatCallerQuery.class);
				ObjectFactory rcsfactory = new ObjectFactory();
				JAXBElement<QUPAMT000001GB01RepeatCallerQuery> jax_message = rcsfactory.createRepeatCallerQuery(result);
				String xml = null; 
				//xml = test();
				xml =  getXML(jax_message,jaxbContext);	
				System.out.print(xml + "\n");	
				SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);		
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
	
	
	@Test
	public void testToDistributionEnvelopeV2() throws JAXBException {
		ToDistributionEnvelope target = new ToDistributionEnvelope();
		assertTrue("input of POCDMT000002UK01ClinicalDocument not supported",target.isSourceDataTypeSupported(DataTypeFactory.create(POCDMT000002UK01ClinicalDocument.class)));
		assertTrue("input of QUPAMT000001GB01RepeatCallerQuery not supported",target.isSourceDataTypeSupported(DataTypeFactory.create(QUPAMT000001GB01RepeatCallerQuery.class)));
		assertTrue("output of DistributionEnvelopeType not supported",target.getReturnDataType().equals(DataTypeFactory.create(DistributionEnvelopeType.class)));
		
	}
	
	@Test
	public void testToDistributionEnvelopeV2POCDMT000002UK01ClinicalDocument() throws JAXBException, TransformerException {
		//arrange
		ToDistributionEnvelope target = new ToDistributionEnvelope();
		target.setOds("ODS123");
		target.setOrgName("Test Org");

		POCDMT000002UK01ClinicalDocument cda = new POCDMT000002UK01ClinicalDocument();
		POCDMT000002UK01InformationRecipient informationRecipient = new POCDMT000002UK01InformationRecipient();
		CommonValues commonValues = new CommonValues("ODS123","Test Org");
		//populate cda payload
		cda.getInformationRecipient().add(informationRecipient);
		POCDMT000002UK01IntendedRecipient intendedRecipient = new POCDMT000002UK01IntendedRecipient();
		informationRecipient.setIntendedRecipient(intendedRecipient);
		POCDMT000002UK01Organization organisation = new POCDMT000002UK01Organization();
		intendedRecipient.setReceivedOrganization(organisation);
		II id = new II();
		organisation.getId().add(id);
		id.setExtension("ODSC56");
		
		//set up test mule message
		final MuleMessage msg = new DefaultTestMuleMessage(cda, muleContext);
		
		//act
		OctopusConsortium.RepeatCallerServiceV1.DistributionEnvelopeType result = (OctopusConsortium.RepeatCallerServiceV1.DistributionEnvelopeType)target.transformMessage(msg, "");

		//assert
		assertTrue(result.getHeader().getAddresslist().getAddress().get(0).getUri().equals(CommonValues.ODS_ADDRESS_BLANK + "ODSC56"));
		assertTrue(result.getHeader().getService().equals(CommonValues.REPEATCALLER_REPORT_SERVICE));
		assertTrue(result.getHeader().getAuditIdentity().getId().get(0).getUri().equals(commonValues.ODS_URI));
	}

	@Test
	public void testToDistributionEnvelopeV2POCDMT000002UK01ClinicalDocumentNoInformationRecipient() throws JAXBException, TransformerException {
		//arrange
		ToDistributionEnvelope target = new ToDistributionEnvelope();
		target.setOds("ODS123");
		target.setOrgName("Test Org");

		POCDMT000002UK01ClinicalDocument cda = new POCDMT000002UK01ClinicalDocument();
		
		//set up test mule message
		final MuleMessage msg = new DefaultTestMuleMessage(cda, muleContext);
		
		//act
		OctopusConsortium.RepeatCallerServiceV1.DistributionEnvelopeType result = (OctopusConsortium.RepeatCallerServiceV1.DistributionEnvelopeType)target.transformMessage(msg, "");

		//assert
		assertEquals(null, result.getHeader().getAddresslist());		
	}
	
	@Test
	public void testToDistributionEnvelopeV2POCDMT000002UK01ClinicalDocumentNoOrganisation() throws JAXBException, TransformerException {
		//arrange
		ToDistributionEnvelope target = new ToDistributionEnvelope();
		target.setOds("ODS123");
		target.setOrgName("Test Org");

		POCDMT000002UK01ClinicalDocument cda = new POCDMT000002UK01ClinicalDocument();
		POCDMT000002UK01InformationRecipient informationRecipient = new POCDMT000002UK01InformationRecipient();
		//populate cda payload
		cda.getInformationRecipient().add(informationRecipient);
		POCDMT000002UK01IntendedRecipient intendedRecipient = new POCDMT000002UK01IntendedRecipient();
		informationRecipient.setIntendedRecipient(intendedRecipient);
				
		//set up test mule message
		final MuleMessage msg = new DefaultTestMuleMessage(cda, muleContext);
		
		//act
		OctopusConsortium.RepeatCallerServiceV1.DistributionEnvelopeType result = (OctopusConsortium.RepeatCallerServiceV1.DistributionEnvelopeType)target.transformMessage(msg, "");

		//assert
		assertEquals(null, result.getHeader().getAddresslist());
	}
	
	@Test
	public void testToDistributionEnvelopeV2POCDMT000002UK01ClinicalDocumentNoIntendedRecipient() throws JAXBException, TransformerException {
		//arrange
		ToDistributionEnvelope target = new ToDistributionEnvelope();
		target.setOds("ODS123");
		target.setOrgName("Test Org");

		POCDMT000002UK01ClinicalDocument cda = new POCDMT000002UK01ClinicalDocument();
		POCDMT000002UK01InformationRecipient informationRecipient = new POCDMT000002UK01InformationRecipient();
		//populate cda payload
		cda.getInformationRecipient().add(informationRecipient);
		
		//set up test mule message
		final MuleMessage msg = new DefaultTestMuleMessage(cda, muleContext);
		
		//act
		OctopusConsortium.RepeatCallerServiceV1.DistributionEnvelopeType result = (OctopusConsortium.RepeatCallerServiceV1.DistributionEnvelopeType)target.transformMessage(msg, "");

		//assert
		assertEquals(null, result.getHeader().getAddresslist());
	}
	
	
	@Test
	public void testToDistributionEnvelopeV2POCDMT000002UK01ClinicalDocumentNoId() throws JAXBException, TransformerException {
		//arrange
		ToDistributionEnvelope target = new ToDistributionEnvelope();
		target.setOds("ODS123");
		target.setOrgName("Test Org");

		POCDMT000002UK01ClinicalDocument cda = new POCDMT000002UK01ClinicalDocument();
		POCDMT000002UK01InformationRecipient informationRecipient = new POCDMT000002UK01InformationRecipient();
		//populate cda payload
		cda.getInformationRecipient().add(informationRecipient);
		POCDMT000002UK01IntendedRecipient intendedRecipient = new POCDMT000002UK01IntendedRecipient();
		informationRecipient.setIntendedRecipient(intendedRecipient);
		POCDMT000002UK01Organization organisation = new POCDMT000002UK01Organization();
		intendedRecipient.setReceivedOrganization(organisation);
		
		//set up test mule message
		final MuleMessage msg = new DefaultTestMuleMessage(cda, muleContext);
		
		//act
		OctopusConsortium.RepeatCallerServiceV1.DistributionEnvelopeType result = (OctopusConsortium.RepeatCallerServiceV1.DistributionEnvelopeType)target.transformMessage(msg, "");

		//assert
		assertEquals(null, result.getHeader().getAddresslist());
	}
	
	@Test
	public void testToDistributionEnvelopeV2POCDMT000002UK01ClinicalDocumentNoExtension() throws JAXBException, TransformerException {
		//arrange
		ToDistributionEnvelope target = new ToDistributionEnvelope();
		target.setOds("ODS123");
		target.setOrgName("Test Org");

		POCDMT000002UK01ClinicalDocument cda = new POCDMT000002UK01ClinicalDocument();
		POCDMT000002UK01InformationRecipient informationRecipient = new POCDMT000002UK01InformationRecipient();
		//populate cda payload
		cda.getInformationRecipient().add(informationRecipient);
		POCDMT000002UK01IntendedRecipient intendedRecipient = new POCDMT000002UK01IntendedRecipient();
		informationRecipient.setIntendedRecipient(intendedRecipient);
		POCDMT000002UK01Organization organisation = new POCDMT000002UK01Organization();
		intendedRecipient.setReceivedOrganization(organisation);
		II id = new II();
		organisation.getId().add(id);
		
		//set up test mule message
		final MuleMessage msg = new DefaultTestMuleMessage(cda, muleContext);
		
		//act
		OctopusConsortium.RepeatCallerServiceV1.DistributionEnvelopeType result = (OctopusConsortium.RepeatCallerServiceV1.DistributionEnvelopeType)target.transformMessage(msg, "");

		//assert
		assertEquals(null, result.getHeader().getAddresslist());
	}
	
	@Test
	public void testTransformMessageMuleMessageString() throws DatatypeConfigurationException, JAXBException {
		SubmitEncounterResponse request = getRepeatCallerRequestData();
		
		IdentifyPatientResponseToRepeatCallerQuery requestToQuery = new IdentifyPatientResponseToRepeatCallerQuery();
		requestToQuery.setOds("ODS123");
		requestToQuery.setOrgName("Test Org");
				
		ToDistributionEnvelope target = new ToDistributionEnvelope();
		target.setOds("ODS123");
		target.setOrgName("Test Org");

		OctopusConsortium.RepeatCallerServiceV1.DistributionEnvelopeType result = null;
		try {
			OctopusConsortium.Models.RCS.QUPAMT000001GB01RepeatCallerQuery returnValue = (OctopusConsortium.Models.RCS.QUPAMT000001GB01RepeatCallerQuery)requestToQuery.doTransform(request, "");
			
			MuleMessage message = new DefaultMuleMessage(returnValue, muleContext);
			result = (OctopusConsortium.RepeatCallerServiceV1.DistributionEnvelopeType)target.transformMessage(message,"");
		} catch (TransformerException e) {
			assertTrue("error: \n" + e.getSummaryMessage(),false);
		}
		
		assertNotNull(result);
		if(result!=null)
		{
			URL file = getClass().getResource("/schemas/RPC/Schemas/distributionEnvelope-v2-0.xsd"); 
			
			try {
				JAXBContext jaxbContext = JAXBContext.newInstance(DistributionEnvelopeType.class,OctopusConsortium.Models.RCS.QUPAMT000001GB01Query.class);
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
					
		SubmitEncounterResponse request = new SubmitEncounterResponse();
		request.setPatient(patientResponse.getPatient());
		
		request.setHaSC(new HaSC());
		return request;
	}
	protected String getXML(JAXBElement<?>jax_message,JAXBContext jaxbContext) throws JAXBException {
		
		//ObjectFactory factory = new ObjectFactory();
		//JAXBElement<POCDMT200001GB02ClinicalDocument> jax_message = factory.createClinicalDocument(result);

		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		//to disable the default XML declaration un-comment the following line  
		//jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
		StringWriter sw = new StringWriter();
		jaxbMarshaller.marshal(jax_message, sw);
		String re = sw.toString();
							
		return re;
	}
	
	@SuppressWarnings("unused")
	private String test()
	{
		return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<RepeatCallerQuery classCode=\"CACT\" moodCode=\"EVN\" xmlns:ns2=\"NPFIT:HL7:Localisation\" xmlns=\"urn:hl7-org:v3\" xmlns:ns3=\"xhtml:NPfIT:PresentationText\">\n  <code code=\"01\" codeSystem=\"2.16.840.1.113883.2.1.3.2.4.17.420\"/>\n  <effectiveTime value=\"20124425154406\"/>\n  <id root=\"CD6A1DC4-EF1E-48D8-987F-4295EC48362E\"/>\n  <author typeCode=\"AUT\" contextControlCode=\"OP\">\n    <ns2:contentId root=\"2.16.840.1.113883.2.1.3.2.4.18.16\" extension=\"COCD_TP145200GB01#AssignedAuthor\"/>\n    <COCD_TP145200GB01.AssignedAuthor classCode=\"ASSIGNED\">\n      <code nullFlavor=\"NI\"/>\n      <id nullFlavor=\"NI\"/>\n      <templateId root=\"2.16.840.1.113883.2.1.3.2.4.18.2\" extension=\"COCD_TP145200GB01#AssignedAuthor\"/>\n      <assignedPerson classCode=\"PSN\" determinerCode=\"INSTANCE\">\n        <name use=\"L\">\n          <given></given>\n        </name>\n        <templateId root=\"2.16.840.1.113883.2.1.3.2.4.18.2\" extension=\"COCD_TP145200GB01#assignedPerson\"/>\n      </assignedPerson>\n      <representedOrganization classCode=\"ORG\" determinerCode=\"INSTANCE\">\n        <id root=\"2.16.840.1.113883.2.1.3.2.4.19.1\" extension=\"RYH\"/>\n        <name>NHS Digital Message Engine</name>\n        <templateId root=\"2.16.840.1.113883.2.1.3.2.4.18.2\" extension=\"COCD_TP145200GB01#representedOrganization\"/>\n      </representedOrganization>\n    </COCD_TP145200GB01.AssignedAuthor>\n  </author>\n  <query>\n    <person.birthTime>\n      <value value=\"1980-02-01T15:44:06.469Z\"/>\n    </person.birthTime>\n    <person.familyName>\n      <value>surename</value>\n    </person.familyName>\n    <person.givenName>\n      <value>forename</value>\n    </person.givenName>\n  </query>\n</RepeatCallerQuery>\n";
	}
}
