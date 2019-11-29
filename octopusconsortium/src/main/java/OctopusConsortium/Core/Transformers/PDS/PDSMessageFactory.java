package OctopusConsortium.Core.Transformers.PDS;


import java.io.StringWriter;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.UUID;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.mule.api.annotations.ContainsTransformerMethods;
import org.mule.api.annotations.Transformer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import OctopusConsortium.Core.CommonValues;
import OctopusConsortium.Models.PDS.AD;
import OctopusConsortium.Models.PDS.EnFamily;
import OctopusConsortium.Models.PDS.EnGiven;
import OctopusConsortium.Models.PDS.IINHSIdentifierType2;
import OctopusConsortium.Models.PDS.ObjectFactory;
import OctopusConsortium.Models.PDS.PNNHSPersonNameType1;
import OctopusConsortium.Models.PDS.QUPAMT000005GB01GetPatientDetailsRequestV10Grouper;
import OctopusConsortium.Models.PDS.QUPAMT000005GB01GetPatientDetailsV10;
import OctopusConsortium.Models.PDS.QUPAMT000005GB01PersonDateOfBirth;
import OctopusConsortium.Models.PDS.QUPAMT000005GB01PersonGender;
import OctopusConsortium.Models.PDS.QUPAMT000005GB01PersonNHSNumber;
import OctopusConsortium.Models.PDS.QUPAMT000005GB01PersonName;
import OctopusConsortium.Models.PDS.QUPAMT000005GB01PersonPostcode;
import OctopusConsortium.Models.PDS.TSNHSTimestampType1;
import OctopusConsortium.PDSMiniServicesV1.AddressType;
import OctopusConsortium.PDSMiniServicesV1.AuditIdentityType;
import OctopusConsortium.PDSMiniServicesV1.DistributionEnvelopeType;
import OctopusConsortium.PDSMiniServicesV1.DistributionHeaderType;
import OctopusConsortium.PDSMiniServicesV1.IdentityType;
import OctopusConsortium.PDSMiniServicesV1.ManifestItemType;
import OctopusConsortium.PDSMiniServicesV1.ManifestType;
import OctopusConsortium.PDSMiniServicesV1.PayloadType;
import OctopusConsortium.PDSMiniServicesV1.PayloadsType;
import OctopusConsortium.Service.Models.IdentifyPatientRequest;


@ContainsTransformerMethods
public class PDSMessageFactory {
		
	CommonValues _commonValues;
	
	public PDSMessageFactory(CommonValues commonValues) {
		_commonValues = commonValues;
	}
	
	@Transformer(sourceTypes = {OctopusConsortium.PDSMiniServicesV1.DistributionEnvelopeType.class})
	public String envelopeToString(OctopusConsortium.PDSMiniServicesV1.DistributionEnvelopeType doc, JAXBContext context) throws JAXBException
  	{
		
		String s = "";
		s = context.toString();
		return s;
  	}
	@Transformer(sourceTypes = {OctopusConsortium.PDSMiniServicesV1.DistributionEnvelopeType.class})
	public String envelopeToString(OctopusConsortium.PDSMiniServicesV1.DistributionEnvelopeType doc) throws JAXBException
  	{
		
		String s = "";
		s = doc.toString();
		return s;
  	}
	
	public QUPAMT000005GB01GetPatientDetailsV10 createGetPatientDetailsV10(IdentifyPatientRequest patientDetails) throws OctopusConsortium.Core.InvalidMessageException {
		ObjectFactory oFactory = new ObjectFactory();
		
		QUPAMT000005GB01GetPatientDetailsV10 message = oFactory.createQUPAMT000005GB01GetPatientDetailsV10();
		message.setClassCode("CACT");
		message.setMoodCode("EVN");
		
		IINHSIdentifierType2 idValue = oFactory.createIINHSIdentifierType2();
		idValue.setRoot(UUID.randomUUID().toString().toUpperCase());
		message.setId(idValue);
		
		QUPAMT000005GB01GetPatientDetailsV10.Code codeValue = oFactory.createQUPAMT000005GB01GetPatientDetailsV10Code();
		codeValue.setCode("getPatientDetailsRequest-v1-0");
		codeValue.setCodeSystem(CommonValues.PATIENTDETAILS_REQUEST_OID);
		message.setCode(codeValue);
		
		QUPAMT000005GB01GetPatientDetailsRequestV10Grouper queryEvent = oFactory.createQUPAMT000005GB01GetPatientDetailsRequestV10Grouper();
		
		if(patientDetails.getForename()!=null && !patientDetails.getForename().isEmpty())
		{
			EnGiven g = new EnGiven();		
			g.setContent(patientDetails.getForename());
			
			EnFamily f = new EnFamily();
			f.setContent(patientDetails.getSurname());		
			PNNHSPersonNameType1 pn = oFactory.createPNNHSPersonNameType1();
			pn.getContent().add(oFactory.createENGiven(g));	
			pn.getContent().add(oFactory.createENFamily(f));
			QUPAMT000005GB01PersonName personName = oFactory.createQUPAMT000005GB01PersonName();
			personName.setValue(pn);
			personName.setSemanticsText(oFactory.createST());
			personName.getSemanticsText().setContent("Person.Name");
			JAXBElement<QUPAMT000005GB01PersonName> jax_personName = oFactory.createQUPAMT000005GB01GetPatientDetailsRequestV10GrouperPersonName(personName);
			
			queryEvent.setPersonName(jax_personName);
		}
		if(patientDetails.getDateOfBirth()==null || patientDetails.getDateOfBirth()==null)
			throw new  OctopusConsortium.Core.InvalidMessageException("Missing Patient DOB");
		
		QUPAMT000005GB01PersonDateOfBirth dob = oFactory.createQUPAMT000005GB01PersonDateOfBirth();
		TSNHSTimestampType1 ts = oFactory.createTSNHSTimestampType1();
		DateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
		//ts.setValue(yyyyMMdd.format(patientDetails.getDateOfBirth()));
		ts.setValue(yyyyMMdd.format(patientDetails.getDateOfBirth().toGregorianCalendar().getTime()).trim());
		
		
		dob.setValue(ts);
		dob.setSemanticsText(oFactory.createST());
		dob.getSemanticsText().setContent("Person.DateOfBirth");
		queryEvent.setPersonDateOfBirth(dob);
		
		if(patientDetails.getGender()!=null)
		{
			QUPAMT000005GB01PersonGender gender = oFactory.createQUPAMT000005GB01PersonGender();
			gender.setSemanticsText(oFactory.createST());
			gender.getSemanticsText().setContent("Person.Gender");
			gender.setValue(oFactory.createQUPAMT000005GB01PersonGenderValue());
			gender.getValue().setCode(patientDetails.getGender().value());
			gender.getValue().setCodeSystem("2.16.840.1.113883.2.1.3.2.4.16.25");
			//gender.getValue().setDisplayName(patientDetails.getGender().toString());
			queryEvent.setPersonGender(oFactory.createQUPAMT000005GB01GetPatientDetailsRequestV10GrouperPersonGender(gender));
		}
		/*
		 * Not Required 
		QUPAMT000005GB01PersonLocalIdentifier local = oFactory.createQUPAMT000005GB01PersonLocalIdentifier();
		local.setSemanticsText(oFactory.createST());
		local.getSemanticsText().setContent("Person.LocalIdentifier");
		local.setValue(oFactory.createIINHSIdentifierType3());
		local.getValue().setRoot("2.16.840.1.113883.2.1.3.2.4.18.24");
		queryEvent.setPersonLocalIdentifier(oFactory.createQUPAMT000005GB01GetPatientDetailsRequestV10GrouperPersonLocalIdentifier(local));
		*/
		if(patientDetails.getNhsNumber()!=null && !patientDetails.getNhsNumber().isEmpty())
		{
			QUPAMT000005GB01PersonNHSNumber nhsNumber = oFactory.createQUPAMT000005GB01PersonNHSNumber();
			nhsNumber.setSemanticsText(oFactory.createST());
			nhsNumber.getSemanticsText().setContent("Person.NHSNumber");
			nhsNumber.setValue(oFactory.createIINHSIdentifierType1());
			nhsNumber.getValue().setRoot("2.16.840.1.113883.2.1.4.1");
			nhsNumber.getValue().setExtension(patientDetails.getNhsNumber());
			queryEvent.setPersonNHSNumber(oFactory.createQUPAMT000005GB01GetPatientDetailsRequestV10GrouperPersonNHSNumber(nhsNumber));
		}
		
		if(patientDetails.getPostcode()!=null && !patientDetails.getPostcode().isEmpty())
		{
			AD.PostalCode pcode = oFactory.createADPostalCode();
			pcode.setContent(patientDetails.getPostcode());
	
			QUPAMT000005GB01PersonPostcode postcode = oFactory.createQUPAMT000005GB01PersonPostcode();
			postcode.setSemanticsText(oFactory.createST());
			postcode.getSemanticsText().setContent("Person.Postcode");
			postcode.setValue(oFactory.createADNHSAddressType1());
			postcode.getValue().getContent().add(oFactory.createADPostalCode(pcode));
			
			queryEvent.setPersonPostcode(oFactory.createQUPAMT000005GB01GetPatientDetailsRequestV10GrouperPersonPostcode(postcode));
		}
				
		message.setQueryEvent(queryEvent);		
		
		//JAXBElement<QUPAMT000005GB01GetPatientDetailsV10> jax_message = oFactory.createGetPatientDetailsV10(message);
		
		return message;
    }
	
	public Object GetPatientDetailsV10XML(JAXBElement<QUPAMT000005GB01GetPatientDetailsV10> message) throws JAXBException, ParserConfigurationException 
	{		
		JAXBContext jaxbContext = JAXBContext.newInstance(QUPAMT000005GB01GetPatientDetailsV10.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		//to disable the default XML declaration un-comment the following line  
		//jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
		//StringWriter sw = new StringWriter();
		//jaxbMarshaller.marshal(message, sw);
		//String re = sw.toString();
		//System.out.print(re);						
		//return re;
		
		/*
		SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		java.net.URL file = getClass().getResource("/schemas/PDSMiniServices/QUPA_MT000005GB01.xsd");
		try {
			Schema schema = factory.newSchema(file);
			jaxbMarshaller.setSchema(schema);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		//dbf.setNamespaceAware(false);		
		
		Document doc = dbf.newDocumentBuilder().newDocument();	
		
		jaxbMarshaller.marshal(message, doc);
		
		Element elm = doc.getDocumentElement();		
		
		return elm;
		
	}	

	public DistributionEnvelopeType createGetDistributionEnvelopeGetPatientDetailsV10(QUPAMT000005GB01GetPatientDetailsV10 payload) //throws JAXBException, ParserConfigurationException
	{
		OctopusConsortium.Models.PDS.ObjectFactory oFactory = new OctopusConsortium.Models.PDS.ObjectFactory();
		
		JAXBElement<QUPAMT000005GB01GetPatientDetailsV10> jax_message = oFactory.createGetPatientDetailsV10(payload);
		
		DistributionEnvelopeType envelope =  createGetDistributionEnvelopeV2Xml(jax_message);
		//return GetDistributionEnvelopeV2XML(oFactory.createDistributionEnvelope(envelope));
		return envelope;
	}
	
	
	private DistributionEnvelopeType createGetDistributionEnvelopeV2Xml(Object payload)
	{
		
		OctopusConsortium.PDSMiniServicesV1.ObjectFactory oFactory = new OctopusConsortium.PDSMiniServicesV1.ObjectFactory();
		
		PayloadType payloadType = oFactory.createPayloadType();
		payloadType.setId("uuid_" + UUID.randomUUID().toString().toUpperCase());
		payloadType.getContent().add(payload);
		
		PayloadsType payloads = oFactory.createPayloadsType();	
		payloads.getPayload().add(payloadType);
		
		return buildEnvelope(oFactory, payloads);
		
	}
	
	
	private DistributionEnvelopeType buildEnvelope(OctopusConsortium.PDSMiniServicesV1.ObjectFactory oFactory,
			PayloadsType payloads)
	{
		DistributionEnvelopeType envelope = oFactory.createDistributionEnvelopeType();
		payloads.setCount(new BigInteger( Integer.toString(payloads.getPayload().size()) ));
		envelope.setPayloads(payloads);
		
		DistributionHeaderType header = oFactory.createDistributionHeaderType();
		header.setService(CommonValues.PATIENTDETAILS_REQUEST_SERVICE);
		header.setTrackingid(UUID.randomUUID().toString().toUpperCase());
		//we don't need to add address
		//AddressListType addressType = oFactory.createAddressListType();
		//AddressType address = oFactory.createAddressType();		
		//addressType.getAddress().add(address);
		//header.setAddresslist(addressType);
		Properties properties = new Properties();
		
		AuditIdentityType auditIdentityType = oFactory.createAuditIdentityType();
		IdentityType identityType = oFactory.createIdentityType();
		//identityType.setUri(CommonValues.ODS_URI);
		try {
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties"));
			String asID = properties.getProperty("services.pds.endpoint.asid");
			identityType.setUri(asID);//This is our ASID!
		}
		catch(Exception e ){
			e.printStackTrace();
		}
		
		auditIdentityType.getId().add(identityType);
		//identityType.setType("2.16.840.1.113883.2.1.3.2.4.18.27");
		identityType.setType("1.2.826.0.1285.0.2.0.107");
		header.setAuditIdentity(auditIdentityType);
		
		
		//should be an itemType for each payload item but we only have one..
		ManifestItemType manifestItemType = oFactory.createManifestItemType();
		manifestItemType.setMimetype("text/xml");
		ManifestType manifestType = oFactory.createManifestType();		
		manifestType.setCount(new BigInteger( Integer.toString(payloads.getPayload().size()) ) );		
		PayloadType payloadT = (PayloadType)payloads.getPayload().get(0);
		manifestItemType.setId( payloadT);		
		manifestItemType.setProfileid(CommonValues.PATIENTDETAILS_REQUEST_PROFILE);
		//manifestItemType.setBase64(false);
		//manifestItemType.setCompressed(false);
		//manifestItemType.setEncrypted(false);
		manifestType.getManifestitem().add(manifestItemType);
		
		AddressType senderAddressType = oFactory.createAddressType();
		senderAddressType.setUri(_commonValues.ODS_ADDRESSING_URI);
		
		header.setSenderAddress(senderAddressType);
				
		header.setManifest(manifestType);
		
		
		envelope.setHeader(header);
		
		return envelope;
	}
	
	@SuppressWarnings("unused")
	private String GetDistributionEnvelopeV2XML(JAXBElement<DistributionEnvelopeType> message)
	{
		JAXBContext jaxbContext;
		String re = "";
		try {
			jaxbContext = JAXBContext.newInstance(DistributionEnvelopeType.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			StringWriter sw = new StringWriter();
			jaxbMarshaller.marshal(message, sw);
			re = sw.toString();
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block			
			e.printStackTrace();
		}
		return re;
	}
	
	
	
	
}
