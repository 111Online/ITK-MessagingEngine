package OctopusConsortium.Core.Transformers.PDS;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.io.StringWriter;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.JAXBIntrospector;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.namespace.QName;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.junit.Assert;
import org.junit.Test;
import org.mule.api.transformer.TransformerException;
import org.mule.tck.junit4.AbstractMuleTestCase;
import org.mule.transformer.types.DataTypeFactory;
import org.xml.sax.SAXException;

import OctopusConsortium.Models.PDS.AD;
import OctopusConsortium.Models.PDS.AD.PostalCode;
import OctopusConsortium.Models.PDS.AD.StreetAddressLine;
import OctopusConsortium.Models.PDS.ADNHSAddressType2;
import OctopusConsortium.Models.PDS.COMTMT000016GB01GPPractice;
import OctopusConsortium.Models.PDS.COMTMT000016GB01GetPatientDetailsResponseV10;
import OctopusConsortium.Models.PDS.COMTMT000016GB01Patient;
import OctopusConsortium.Models.PDS.COMTMT000016GB01Person;
import OctopusConsortium.Models.PDS.COMTMT000016GB01Person.AdministrativeGenderCode;
import OctopusConsortium.Models.PDS.COMTMT000016GB01Subject;
import OctopusConsortium.Models.PDS.CsPostalAddressUse;
import OctopusConsortium.Models.PDS.CsTelecommunicationAddressUse;
import OctopusConsortium.Models.PDS.EnGiven;
import OctopusConsortium.Models.PDS.EnPrefix;
import OctopusConsortium.Models.PDS.II;
import OctopusConsortium.Models.PDS.ObjectFactory;
import OctopusConsortium.Models.PDS.PNNHSPersonNameType2;
import OctopusConsortium.Models.PDS.QUPAMT000005GB01GetPatientDetailsV10;
import OctopusConsortium.Models.PDS.ST;

import OctopusConsortium.PDSMiniServicesV1.DistributionEnvelopeType;
import OctopusConsortium.PDSMiniServicesV1.PayloadType;
import OctopusConsortium.Service.Models.Gender;
import OctopusConsortium.Service.Models.IdentifyPatientRequest;
import OctopusConsortium.Service.Models.IdentifyPatientResponse;
import OctopusConsortium.Service.Models.IdentifyPatientResponseOverallStatus;

public class PDSTransformerTests extends AbstractMuleTestCase {

	
	@Override
    protected int getTimeoutSystemProperty()
    {       
        return 120;
    }
	
	/**
	 * Tests the supported types
	 */
	@Test
	public void patientDetailsToGetPatientDetailsRequestV1_supportedTypesTest() {
		PatientDetailsToGetPatientDetailsRequestV1 target = new PatientDetailsToGetPatientDetailsRequestV1();
		assertTrue("input of PatientDetails not supported",target.isSourceDataTypeSupported(DataTypeFactory.create(IdentifyPatientRequest.class)));
		assertTrue("output of QUPAMT000005GB01GetPatientDetailsV10 not supported",target.getReturnDataType().equals(DataTypeFactory.create(QUPAMT000005GB01GetPatientDetailsV10.class)));
		//fail("Not yet implemented");
	}

	/**
	 * Tests the PatientDetailsToGetPatientDetailsRequestV1 transformer using the CustomSchemaResolver 
	 *  It creates a JAXB Element, serialises the object and validates the resulting xml against the schema file
	 * 
	 * @throws TransformerException
	 * @throws JAXBException
	 * @throws DatatypeConfigurationException
	 */	
	@SuppressWarnings("unchecked")
	@Test
	public void PatientDetailsToGetPatientDetailsRequestV1_DoTransformTest() throws TransformerException, DatatypeConfigurationException {
		//Arrange
		IdentifyPatientRequest patientDetails  = new IdentifyPatientRequestBuilder().build();
		URL file = getClass().getResource("/schemas/PDS/PDSMiniServices/QUPA_MT000005GB01.xsd");
		PatientDetailsToGetPatientDetailsRequestV1 target = new PatientDetailsToGetPatientDetailsRequestV1();
		target.setOds("ODS123");
		target.setOrgName("Test Org");
		
		//Act
		QUPAMT000005GB01GetPatientDetailsV10 resultValue = (QUPAMT000005GB01GetPatientDetailsV10)target.doTransform(patientDetails, "");
		
		//Assert
		DateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");		
		assertTrue("Invalid DOB", resultValue.getQueryEvent().getPersonDateOfBirth().getValue().getValue().equals(
				yyyyMMdd.format(patientDetails.getDateOfBirth().toGregorianCalendar().getTime()).trim()
				));
		assertTrue("Invalid Gender", resultValue.getQueryEvent().getPersonGender().getValue().getValue().getCode().equals(patientDetails.getGender().value()));
		assertTrue("Invalid NHS Number", resultValue.getQueryEvent().getPersonNHSNumber().getValue().getValue().getExtension().equals(patientDetails.getNhsNumber()));		
		assertTrue("Invalid Forename", findName(resultValue.getQueryEvent().getPersonName().getValue().getValue().getContent(),patientDetails.getForename()));
		assertTrue("Invalid Surname", findName(resultValue.getQueryEvent().getPersonName().getValue().getValue().getContent(),patientDetails.getSurname()));
		assertTrue("Invalid Postcode", findName(resultValue.getQueryEvent().getPersonPostcode().getValue().getValue().getContent(),patientDetails.getPostcode()));
		
		//validate generated schema
		JAXBElement<QUPAMT000005GB01GetPatientDetailsV10> result = null;
		try {
			//Marshall the object
			String xml =  testGetPatientDetailsV10XML(resultValue);
			JAXBContext jaxbContext = JAXBContext.newInstance(OctopusConsortium.Models.PDS.QUPAMT000005GB01GetPatientDetailsV10.class);
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = factory.newSchema(file);	
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			unmarshaller.setSchema(schema);	
			
			result = (JAXBElement<QUPAMT000005GB01GetPatientDetailsV10>)unmarshaller.unmarshal(new ByteArrayInputStream (xml.getBytes()));
			//Assert
			assertTrue("unmarshalled null",result != null);
		} catch (Exception e) {
			//Assert
			e.printStackTrace();			
			assertTrue("Generated xml message failed to validate " + e.getMessage() ,false);
		}	
	}
	
	private boolean findName(List<Serializable> list, String value){
		for (Serializable item : list) {
			if(item instanceof JAXBElement<?>){
				if(((JAXBElement<?>)item).getValue() instanceof ST){
					if(	((ST)((JAXBElement<?>)item).getValue()).getContent().contains(value) ){
						return true;
					}
				}
			}
			else if( ((ST)(item)).getContent().contains(value) ){
				return true;
			}
		}
		return false;
	}
	
	@Test
	public void GetPatientDetailsRequestV1ToDistributionEnvelope_SupportedTypesTest()
	{
		GetPatientDetailsV1ToDistributionEnvelopeV2 target = new GetPatientDetailsV1ToDistributionEnvelopeV2();
		assertTrue("input of QUPAMT000005GB01GetPatientDetailsV10 not supported",target.isSourceDataTypeSupported(DataTypeFactory.create(QUPAMT000005GB01GetPatientDetailsV10.class)));
		assertTrue("output of DistributionEnvelopeType not supported",target.getReturnDataType().equals(DataTypeFactory.create(DistributionEnvelopeType.class)));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void GetPatientDetailsRequestV1ToDistributionEnvelope_DoTransformTest() throws TransformerException, DatatypeConfigurationException, JAXBException, SAXException 
	{
		//Arrange
		GetPatientDetailsV1ToDistributionEnvelopeV2 target = new GetPatientDetailsV1ToDistributionEnvelopeV2();
		target.setOds("ODS123");
		target.setOrgName("Test Org");

		QUPAMT000005GB01GetPatientDetailsV10 getPatientDetailsV10 =  getPatientDetails();	
		URL file = getClass().getResource("/schemas/PDS/PDSMiniServices/distributionEnvelope-v2-0.xsd");
		
		//Act
		DistributionEnvelopeType result = (DistributionEnvelopeType) target.doTransform(getPatientDetailsV10, "");
		OctopusConsortium.PDSMiniServicesV1.ObjectFactory pdsFactory = new OctopusConsortium.PDSMiniServicesV1.ObjectFactory();
		JAXBElement<DistributionEnvelopeType> jax_result= pdsFactory.createDistributionEnvelope(result);
		
		//Serialise object 
		JAXBContext jaxbContext;
		String soapBody;
		Unmarshaller unmarshaller;
		jaxbContext = JAXBContext.newInstance(new Class[]{DistributionEnvelopeType.class,OctopusConsortium.Models.PDS.QUPAMT000005GB01GetPatientDetailsV10.class});
		try {
			
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();			
			
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE );
			//jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			//NamespacePrefixMapper mapper = new MyNamespacePrefixMapper();  
			//jaxbMarshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", mapper);
			//IDResolver
			StringWriter sw = new StringWriter();
			jaxbMarshaller.marshal(jax_result, sw);
			soapBody = sw.toString();
			System.out.print("\n"+soapBody+"\n");
			//UnSerialise object
			unmarshaller = jaxbContext.createUnmarshaller();
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = factory.newSchema(file);
			unmarshaller.setSchema(schema);
			
			jax_result = (JAXBElement<DistributionEnvelopeType>)unmarshaller.unmarshal(new ByteArrayInputStream (soapBody.getBytes())); 
			
		} catch (JAXBException e1) {
			e1.printStackTrace();			
			assertTrue("DistributionEnvelopeType failed to serialise: " + e1.getMessage() ,false);
		}			
		ValidateQUPAMT000005GB01GetPatientDetailsV10(jax_result);				
	}
	/**
	 * returns a populated QUPAMT000005GB01GetPatientDetailsV10 
	 * @return
	 * @throws DatatypeConfigurationException
	 * @throws TransformerException
	 */
	private QUPAMT000005GB01GetPatientDetailsV10 getPatientDetails() throws DatatypeConfigurationException, TransformerException
	{		
		IdentifyPatientRequest patientDetails  = new IdentifyPatientRequestBuilder().build();
		
		PatientDetailsToGetPatientDetailsRequestV1 patient2getPatient = new PatientDetailsToGetPatientDetailsRequestV1();
		patient2getPatient.setOds("ODS123");
		patient2getPatient.setOrgName("Test Org");
		
		QUPAMT000005GB01GetPatientDetailsV10 getPatientDetailsV10 = (QUPAMT000005GB01GetPatientDetailsV10)patient2getPatient.doTransform(patientDetails, "");
		return getPatientDetailsV10;	
	}
	
	/**
	 * Test the for unmarshall from ElementNSImpl elements
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void unmarshallElementNSImpl_Test()
	{	
		URL file = getClass().getResource("/schemas/PDS/PDSMiniServices/distributionEnvelope-v2-0.xsd");
		
		//Act
		JAXBElement<DistributionEnvelopeType> distResult=null;
		//JAXBElement<QUPAMT000005GB01GetPatientDetailsV10> result=null;
		try {			
			JAXBContext jaxbContext = JAXBContext.newInstance(OctopusConsortium.PDSMiniServicesV1.DistributionEnvelopeType.class);
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = factory.newSchema(file);	
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			unmarshaller.setSchema(schema);	
			distResult = (JAXBElement<DistributionEnvelopeType>)unmarshaller.unmarshal(new ByteArrayInputStream (getTestString().getBytes()));
			
			assertNotNull("unmarshalled null",distResult);
			
			ValidateQUPAMT000005GB01GetPatientDetailsV10(distResult);
			
		} catch (Exception e) {
			//Assert
			e.printStackTrace();			
			assertTrue("Generated xml message failed to validate " + e.getMessage() ,false);
		}
	}
	
	
	@Test
	public void GetPatientResponseV1ToIdentifyPatientResponseTest(){
		
		//Arrange
		GetPatientResponseV1ToIdentifyPatientResponse target = new GetPatientResponseV1ToIdentifyPatientResponse();
		
		OctopusConsortium.Models.PDS.COMTMT000016GB01GetPatientDetailsResponseV10 pdr = new COMTMT000016GB01GetPatientDetailsResponseV10();
		ObjectFactory of = new ObjectFactory();
		COMTMT000016GB01Subject subject = new COMTMT000016GB01Subject();
		COMTMT000016GB01Patient patient = new COMTMT000016GB01Patient();
		COMTMT000016GB01Person person = new COMTMT000016GB01Person();
		AdministrativeGenderCode adg = new AdministrativeGenderCode();
		adg.setCode("0");
		person.setAdministrativeGenderCode(adg);
		person.setBirthTime(of.createTSNHSTimestampType3());
		person.getBirthTime().setValue("19800101");
		COMTMT000016GB01GPPractice gp = of.createCOMTMT000016GB01GPPractice();
		
		ADNHSAddressType2 addr = of.createADNHSAddressType2();
		addr.getContent().addAll(getAddress().getContent());
		gp.setAddr(addr);
		person.setGPPractice(of.createCOMTMT000016GB01PersonGPPractice(gp));
	
		
		JAXBElement<COMTMT000016GB01Person> jPerson = new JAXBElement<COMTMT000016GB01Person>(new QName("COMT_MT000016GB01.Person"), COMTMT000016GB01Person.class, null, person);
				
		patient.setPatientPerson(jPerson);
		II iiPatientId = new II();
		iiPatientId.setExtension("123555");
		patient.getId().add(iiPatientId);
		PNNHSPersonNameType2 name = of.createPNNHSPersonNameType2();
		EnGiven gn = of.createEnGiven();
		gn.setContent("testGivenName");
		name.getContent().add(of.createENGiven(gn));
		OctopusConsortium.Models.PDS.EnFamily fn = of.createEnFamily();
		fn.setContent("testFamilyName");
		name.getContent().add(of.createENFamily(fn));
		EnPrefix pn = of.createEnPrefix();
		pn.setContent("Mr");
		name.getContent().add(of.createENPrefix(pn));
		patient.setName(name);
		//set gender
		AdministrativeGenderCode gender = of.createCOMTMT000016GB01PersonAdministrativeGenderCode();
		gender.setCode("1");
		patient.getPatientPerson().getValue().setAdministrativeGenderCode(gender);		
		
		//add address		
		addr = of.createADNHSAddressType2();
		addr.getContent().addAll(getAddress().getContent());
		patient.getAddr().add(addr);
						
		
		// add telephone details
		OctopusConsortium.Models.PDS.TEL tel = null;		
		tel = of.createTEL();
		tel.getUse().add(CsTelecommunicationAddressUse.HP);
		tel.setValue("tel:123456789");		
		patient.getTelecom().add(tel);
		
		subject.setPatient(patient);
		
		JAXBElement<COMTMT000016GB01Subject> jSubject = new JAXBElement<COMTMT000016GB01Subject>(new QName("COMT_MT000016GB01.Subject"), COMTMT000016GB01Subject.class, null, subject);
		
		pdr.setSubject(jSubject);
		
		//Act
		try {
			IdentifyPatientResponse result = (IdentifyPatientResponse)target.doTransform(pdr, new String());
			
			Assert.assertEquals(0, IdentifyPatientResponseOverallStatus.PATIENT_IDENTIFIED.compareTo(result.getOverallStatus()));
			
			Assert.assertEquals("Streetaddressline1", result.getPatient().getGPPractice().getAddress().getStreetAddressLine1());
			Assert.assertEquals("Streetaddressline2", result.getPatient().getGPPractice().getAddress().getStreetAddressLine2());
			Assert.assertEquals("Streetaddressline3", result.getPatient().getGPPractice().getAddress().getStreetAddressLine3());
			Assert.assertEquals("Streetaddressline4", result.getPatient().getGPPractice().getAddress().getStreetAddressLine4());
			Assert.assertEquals("Streetaddressline5", result.getPatient().getGPPractice().getAddress().getStreetAddressLine5());
			Assert.assertEquals("Streetaddressline5", result.getPatient().getGPPractice().getAddress().getStreetAddressLine5());
			Assert.assertEquals("123555", result.getPatient().getNhsNumber());
			
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail();
		}	
	}
	
	private AD getAddress(){
		ObjectFactory of = new ObjectFactory();
		AD addr = of.createAD();
		addr.getUse().add(CsPostalAddressUse.H);//Set as home address / current address / etc 
		
		StreetAddressLine addValue = of.createADStreetAddressLine();
		addValue.setContent("StreetAddressLine1");
		addr.getContent().add(of.createADStreetAddressLine(addValue));
		
		addValue = of.createADStreetAddressLine();
		addValue.setContent("StreetAddressLine2");
		addr.getContent().add((of.createADStreetAddressLine(addValue)));
		
		addValue = of.createADStreetAddressLine();
		addValue.setContent("StreetAddressLine3");
		addr.getContent().add(of.createADStreetAddressLine(addValue));
		
		addValue = of.createADStreetAddressLine();
		addValue.setContent("StreetAddressLine4");
		addr.getContent().add(of.createADStreetAddressLine(addValue));
		
		addValue = of.createADStreetAddressLine();
		addValue.setContent("StreetAddressLine5");
		addr.getContent().add(of.createADStreetAddressLine(addValue));

		PostalCode adPostalCode = of.createADPostalCode();
		adPostalCode.setContent("StreetAddressPostcode");
		addr.getContent().add(of.createADPostalCode( adPostalCode));
		return addr;
	}
	
	@Test
	public void GetPatientResponseV1ToIdentifyPatientResponseTestNoPatient(){
		GetPatientResponseV1ToIdentifyPatientResponse gprtipr = new GetPatientResponseV1ToIdentifyPatientResponse();
		
		OctopusConsortium.Models.PDS.COMTMT000016GB01GetPatientDetailsResponseV10 pdr = new COMTMT000016GB01GetPatientDetailsResponseV10();
				
		try {
			IdentifyPatientResponse result = (IdentifyPatientResponse)gprtipr.doTransform(pdr, new String());
						
			Assert.assertEquals(0, IdentifyPatientResponseOverallStatus.UNABLE_TO_IDENTIFY_PATIENT.compareTo(result.getOverallStatus()));
			Assert.assertEquals(null, result.getPatient());
			
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail();
		}	
	}
	
	/**
	 * Un-marshals @link QUPAMT000005GB01GetPatientDetailsV10 from a @link DistributionEnvelopeType
	 * @param envelope
	 */
	private void ValidateQUPAMT000005GB01GetPatientDetailsV10(JAXBElement<DistributionEnvelopeType> envelope)
	{
		assertNotNull("Failed to unmarshal distribution envelope", envelope);
		
		boolean found = false;
		URL file; 
		JAXBContext jaxbContext;
		Unmarshaller unmarshaller;
		try {
			for (Iterator<PayloadType> iterator = envelope.getValue().getPayloads().getPayload().iterator(); iterator.hasNext();) {
				PayloadType payloadType = (PayloadType) iterator.next();
				List<Object> content = payloadType.getContent();	
				
				assertTrue("missing payload", content.size()>1);
				
				for (Object object : content) {					
					
					if(object instanceof JAXBElement)
					{
						JAXBElement<?> elm = (JAXBElement<?>)object;					
						if(!(elm.getValue() instanceof QUPAMT000005GB01GetPatientDetailsV10))
						{
							//TODO check content of the object
							assertTrue("Incorrect type in payload",false);
						}
						else						
							found = true;						
					}
					else if(object instanceof org.apache.xerces.dom.ElementNSImpl)
					{
						org.apache.xerces.dom.ElementNSImpl elm = (org.apache.xerces.dom.ElementNSImpl)object;
					
						SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
						file = getClass().getResource("/schemas/PDS/PDSMiniServices/QUPA_MT000005GB01.xsd");
						Schema schema = factory.newSchema(file);
						jaxbContext = JAXBContext.newInstance(OctopusConsortium.Models.PDS.QUPAMT000005GB01GetPatientDetailsV10.class);
						unmarshaller = jaxbContext.createUnmarshaller();							
						unmarshaller.setSchema(schema);
						QUPAMT000005GB01GetPatientDetailsV10 jax_target = (QUPAMT000005GB01GetPatientDetailsV10) JAXBIntrospector.getValue(unmarshaller.unmarshal(elm));
						assertTrue("unmarshalled null",jax_target!=null);
						found = true;
					}
				}	
			}
		} catch (Exception e) {
			//Assert
			e.printStackTrace();			
			assertTrue("Generated xml message failed to validate:\n " + e.getCause().getMessage() ,false);
		}		
		assertTrue("Missing payload",found);
	}
	
	
	
	
	public class IdentifyPatientRequestBuilder{
		private IdentifyPatientRequest _identifyPatientRequest;
						
		public IdentifyPatientRequestBuilder(){
			_identifyPatientRequest = getDefaults();			
		}
		
		private IdentifyPatientRequest getDefaults(){
			_identifyPatientRequest = new IdentifyPatientRequest();				
			Calendar cal = Calendar.getInstance();
			cal.set(1980, 05, 01);
			GregorianCalendar c = new GregorianCalendar();
			c.setTime(cal.getTime());
			try {
				_identifyPatientRequest.setDateOfBirth(DatatypeFactory.newInstance().newXMLGregorianCalendar(c));
			} catch (DatatypeConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			_identifyPatientRequest.setForename("forename");
			_identifyPatientRequest.setSurname("surename");
			_identifyPatientRequest.setGender(Gender.MALE);
			_identifyPatientRequest.setPostcode("POSTCODE");
			_identifyPatientRequest.setNhsNumber("nhsNumber");
			return _identifyPatientRequest;
		}
		
		public IdentifyPatientRequestBuilder withForename(String value){
			_identifyPatientRequest.setForename(value);
			return this;
		}
		
		public IdentifyPatientRequestBuilder withSurname(String value){
			_identifyPatientRequest.setSurname(value);
			return this;
		}
		
		public IdentifyPatientRequestBuilder withGender(Gender value){
			_identifyPatientRequest.setGender(value);
			return this;
		}
		
		public IdentifyPatientRequestBuilder withPostcode(String value){
			_identifyPatientRequest.setPostcode(value);
			return this;
		}
		
		public IdentifyPatientRequestBuilder withNhsNumber(String value){
			_identifyPatientRequest.setNhsNumber(value);
			return this;
		}
		
		public IdentifyPatientRequest build(){
			return _identifyPatientRequest;
		}
	}
	
	private String testGetPatientDetailsV10XML(QUPAMT000005GB01GetPatientDetailsV10 value) throws JAXBException, ParserConfigurationException
	{
		OctopusConsortium.Models.PDS.ObjectFactory factory = new ObjectFactory();		
		
		JAXBElement<QUPAMT000005GB01GetPatientDetailsV10> jax_message = factory.createGetPatientDetailsV10(value);

		JAXBContext jaxbContext = JAXBContext.newInstance(QUPAMT000005GB01GetPatientDetailsV10.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		//to disable the default XML declaration un-comment the following line  
		//jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
		StringWriter sw = new StringWriter();
		jaxbMarshaller.marshal(jax_message, sw);
		String re = sw.toString();
		System.out.print(re + "\n");						
		return re;
	}
		
	private String getTestString()
	{
		//produced xml
		return "<DistributionEnvelope xmlns=\"urn:nhs-itk:ns:201005\" xmlns:ns2=\"urn:hl7-org:v3\" xmlns:ns3=\"xhtml:NPfIT:PresentationText\">\n\t<header service=\"urn:nhs-itk:interaction:getPatientDetailsRequest-v1-0\" trackingid=\"45A780AB-16D0-11E2-AC3C-91A65D8613FF\">\n\t\t<auditIdentity><id uri=\"urn:nhs-uk:identity:ods:RYH\"/></auditIdentity>\n\t\t<manifest count=\"1\">\n\t\t\t<manifestitem profileid=\"urn:nhs-en:profile:getPatientDetailsRequest-v1-0\" mimetype=\"text/xml\" id=\"uuid_45A780AA-16D0-11E2-AC3C-91A65D8613FF\"/>\n\t\t</manifest>\n\t</header>\n\t<payloads count=\"1\">\n\t\t<payload id=\"uuid_45A780AA-16D0-11E2-AC3C-91A65D8613FF\">\n\t\t\t<ns2:getPatientDetails-v1-0 moodCode=\"EVN\" classCode=\"CACT\"><ns2:id root=\"43E29F29-16D0-11E2-AC3C-91A65D8613FF\"/>\n\t\t\t\t<ns2:code codeSystem=\"2.16.840.1.113883.2.1.3.2.4.17.284\" code=\"getPatientDetailsRequest-v1-0\"/>\n\t\t\t\t<ns2:queryEvent>\n\t\t\t\t\t<ns2:Person.DateOfBirth>\n\t\t\t\t\t\t<ns2:value value=\"197200190101\"/>\n\t\t\t\t\t\t<ns2:semanticsText>Person.DateOfBirth</ns2:semanticsText>\n\t\t\t\t\t</ns2:Person.DateOfBirth>\n\t\t\t\t\t<ns2:Person.Gender>\n\t\t\t\t\t\t<ns2:value codeSystem=\"2.16.840.1.113883.2.1.3.2.4.16.25\" code=\"2\"/>\n\t\t\t\t\t\t<ns2:semanticsText>Person.Gender</ns2:semanticsText>\n\t\t\t\t\t</ns2:Person.Gender>\n\t\t\t\t\t<ns2:Person.Name>\n\t\t\t\t\t\t<ns2:value>\n\t\t\t\t\t\t\t<ns2:given>Poppy</ns2:given>\n\t\t\t\t\t\t\t<ns2:family>Roberts</ns2:family>\n\t\t\t\t\t\t</ns2:value>\n\t\t\t\t\t\t<ns2:semanticsText>Person.Name</ns2:semanticsText>\n\t\t\t\t\t</ns2:Person.Name>\n\t\t\t\t</ns2:queryEvent>\n\t\t\t</ns2:getPatientDetails-v1-0>\n\t\t</payload>\n\t</payloads>\n</DistributionEnvelope>";
		
		//valid example
		//return "<itk:DistributionEnvelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:itk=\"urn:nhs-itk:ns:201005\">\n\t\t\t<itk:header service=\"urn:nhs-itk:services:201005:getPatientDetails-v1-0\" trackingid=\"2D37D9CA-5223-41C7-A159-F33D5A914EB5\">\n\t\t\t\t<itk:auditIdentity>\n\t\t\t\t\t<itk:id  uri=\"urn:nhs-uk:addressing:ods:rhm:team1:C\"/>\n\t\t\t\t</itk:auditIdentity>\n\t\t\t\t<itk:manifest count=\"1\">\n\t\t\t\t\t<itk:manifestitem id=\"uuid_808A967-49B2-498B-AD75-1D7A0F1262D7\" mimetype=\"text/xml\" profileid=\"urn:nhs-en:profile:getPatientDetailsRequest-v1-0\" base64=\"false\" compressed=\"false\" encrypted=\"false\"/>\n\t\t\t\t</itk:manifest>\n\t\t\t\t<itk:senderAddress uri=\"urn:nhs-uk:addressing:ods:rhm:team1:C\"/>\n\t\t\t</itk:header>\n\t\t\t<itk:payloads count=\"1\">\n\t\t\t\t<itk:payload id=\"uuid_808A967-49B2-498B-AD75-1D7A0F1262D7\">\n\t\t\t\t\t<getPatientDetails-v1-0 xmlns=\"urn:hl7-org:v3\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" moodCode=\"EVN\" classCode=\"CACT\">\n\t\t\t\t\t\t<id root=\"4E25ACE2-23F8-4A37-B446-6A37F31CF76C\"/>\n\t\t\t\t\t\t<code codeSystem=\"2.16.840.1.113883.2.1.3.2.4.17.284\" code=\"getPatientDetailsRequest-v1-0\"/>\n\t\t\t\t\t\t<queryEvent>\n\t\t\t\t\t\t\t<Person.DateOfBirth>\n\t\t\t\t\t\t\t\t<value value=\"19890101\"/>\n\t\t\t\t\t\t\t\t<semanticsText>Person.DateOfBirth</semanticsText>\n\t\t\t\t\t\t\t</Person.DateOfBirth>\n\t\t\t\t\t\t\t<Person.Gender>\n\t\t\t\t\t\t\t\t<value code=\"1\" codeSystem=\"2.16.840.1.113883.2.1.3.2.4.16.25\"/>\n\t\t\t\t\t\t\t\t<semanticsText>Person.Gender</semanticsText>\n\t\t\t\t\t\t\t</Person.Gender>\n\t\t\t\t\t\t\t<Person.Name>\n\t\t\t\t\t\t\t\t<value>\n\t\t\t\t\t\t\t\t\t<given>John</given>\n\t\t\t\t\t\t\t\t\t<family>Smith</family>\n\t\t\t\t\t\t\t\t</value>\n\t\t\t\t\t\t\t\t<semanticsText>Person.Name</semanticsText>\n\t\t\t\t\t\t\t</Person.Name>\n\t\t\t\t\t\t</queryEvent>\n\t\t\t\t\t</getPatientDetails-v1-0>\n\t\t\t\t</itk:payload>\n\t\t\t</itk:payloads>\n\t\t</itk:DistributionEnvelope>";
	}

	@SuppressWarnings("unused")
	private String getPatientDetailsToGetPatientDetailsRequestV1Value()
	{
		return "<getPatientDetails-v1-0 moodCode=\"EVN\" classCode=\"CACT\" xmlns:ns2=\"xhtml:NPfIT:PresentationText\" xmlns=\"urn:hl7-org:v3\"><id root=\"4E25ACE2-23F8-4A37-B446-6A37F31CF76C\"/><code codeSystem=\"2.16.840.1.113883.2.1.3.2.4.17.284\" code=\"getPatientDetailsRequest-v1-0\"/><queryEvent><Person.Name><value><given/><family/></value></Person.Name></queryEvent></getPatientDetails-v1-0>";
		//return "<getPatientDetails-v1-0 moodCode=\"EVN\" classCode=\"CACT\" xmlns=\"urn:hl7-org:v3\"><id root=\"4E25ACE2-23F8-4A37-B446-6A37F31CF76C\"/><code codeSystem=\"2.16.840.1.113883.2.1.3.2.4.17.284\" code=\"getPatientDetailsRequest-v1-0\"/><queryEvent><Person.DateOfBirth><value value=\"19890101\"/><semanticsText>Person.DateOfBirth</semanticsText></Person.DateOfBirth><Person.Gender><value code=\"1\" codeSystem=\"2.16.840.1.113883.2.1.3.2.4.16.25\"/><semanticsText>Person.Gender</semanticsText></Person.Gender><Person.Name><value><given>John</given><family>Smith</family></value><semanticsText>Person.Name</semanticsText></Person.Name></queryEvent></getPatientDetails-v1-0>";
	}
	
}
