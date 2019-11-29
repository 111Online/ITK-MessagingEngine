/**
 * 
 */
package OctopusConsortium.Core.Transformers.RCS;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.TimeZone;
import java.util.UUID;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.NotImplementedException;
import org.apache.xml.utils.PrefixResolver;
import org.apache.xml.utils.PrefixResolverDefault;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import OctopusConsortium.Core.InvalidHascException;
import OctopusConsortium.Core.CommonValues;
import OctopusConsortium.Models.CDA.InformantType;
import OctopusConsortium.Models.RCS.AD;
import OctopusConsortium.Models.RCS.AD.PostalCode;
import OctopusConsortium.Models.RCS.AD.StreetAddressLine;
import OctopusConsortium.Models.RCS.CsBinaryDataEncoding;
import OctopusConsortium.Models.RCS.CsNullFlavor;
import OctopusConsortium.Models.RCS.CsPostalAddressUse;
import OctopusConsortium.Models.RCS.CsTelecommunicationAddressUse;
import OctopusConsortium.Models.RCS.II;
import OctopusConsortium.Models.RCS.ON;
import OctopusConsortium.Models.RCS.ObjectFactory;
import OctopusConsortium.Models.RCS.PN;
import OctopusConsortium.Models.RCS.POCDMT000002UK01AssignedAuthor;
import OctopusConsortium.Models.RCS.POCDMT000002UK01AssignedCustodian;
import OctopusConsortium.Models.RCS.POCDMT000002UK01Author;
import OctopusConsortium.Models.RCS.POCDMT000002UK01ClinicalDocument;
import OctopusConsortium.Models.RCS.POCDMT000002UK01Component3;
import OctopusConsortium.Models.RCS.POCDMT000002UK01Component5;
import OctopusConsortium.Models.RCS.POCDMT000002UK01Custodian;
import OctopusConsortium.Models.RCS.POCDMT000002UK01CustodianOrganization;
import OctopusConsortium.Models.RCS.POCDMT000002UK01Device;
import OctopusConsortium.Models.RCS.POCDMT000002UK01EncompassingEncounter;
import OctopusConsortium.Models.RCS.POCDMT000002UK01Entry;
import OctopusConsortium.Models.RCS.POCDMT000002UK01Informant12;
import OctopusConsortium.Models.RCS.POCDMT000002UK01InformationRecipient;
import OctopusConsortium.Models.RCS.POCDMT000002UK01IntendedRecipient;
import OctopusConsortium.Models.RCS.POCDMT000002UK01ObservationMedia;
import OctopusConsortium.Models.RCS.POCDMT000002UK01Participant2;
import OctopusConsortium.Models.RCS.POCDMT000002UK01ParticipantRole;
import OctopusConsortium.Models.RCS.POCDMT000002UK01PatientRole;
import OctopusConsortium.Models.RCS.POCDMT000002UK01Place;
import OctopusConsortium.Models.RCS.POCDMT000002UK01RecordTarget;
import OctopusConsortium.Models.RCS.POCDMT000002UK01Section;
import OctopusConsortium.Models.RCS.POCDMT000002UK01StructuredBody;
import OctopusConsortium.Models.RCS.StrucDocContent;
import OctopusConsortium.Models.RCS.TEL;
import OctopusConsortium.Models.RCS.XActRelationshipEntry;
import OctopusConsortium.Models.RCS.XBasicConfidentialityKind;
import OctopusConsortium.Service.Models.Address;
import OctopusConsortium.Service.Models.GPPractice;
import OctopusConsortium.Service.Models.HaSC;
import OctopusConsortium.Service.Models.Patient;
import OctopusConsortium.Service.Models.SubmitEncounterResponse;


/**
 * @author stuart.yeates
 *
 */
public class ToRepeatCallerCDA_UK extends
		AbstractTransformer {

	private CommonValues commonValues;
	protected String CdaNarritive;
	protected String ods;
	protected String orgName;
	
	public String getOds() {
		return ods;
	}

	public void setOds(String ods) {
		this.ods = ods;
	}
	
	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	
	public String getCdaNarritive() {
		return CdaNarritive;
	}


	public void setCdaNarritive(String cdaNarritive) {
		CdaNarritive = cdaNarritive;
	}


	/**
	 * 
	 */
	public ToRepeatCallerCDA_UK() {	
		super();			
		this.registerSourceType(DataTypeFactory.create(OctopusConsortium.Service.Models.SubmitEncounterResponse.class));
		//this.registerSourceType(DataTypeFactory.create(OctopusConsortium.Models.IdentifyPatientResponseV1.class));
		this.setReturnDataType(DataTypeFactory.create(OctopusConsortium.Models.RCS.POCDMT000002UK01ClinicalDocument.class));
	}

	
	@Override
	protected Object doTransform(Object src, String enc)
			throws TransformerException {
		
		SubmitEncounterResponse msg = (SubmitEncounterResponse)src;
		//RepeatCallerRequest msg = (RepeatCallerRequest)src;
		ObjectFactory of = new ObjectFactory();		
		commonValues = new CommonValues(ods,orgName);
		
		if((CdaNarritive == null || CdaNarritive =="") && msg.getHaSC() !=null)
		{
			CdaNarritive = msg.getHaSC().getHascCDANarrative(); 
		}
		POCDMT000002UK01ClinicalDocument cda = of.createPOCDMT000002UK01ClinicalDocument();
		
		try {			
			cda.setClassCode("DOCCLIN");
			cda.getMoodCode().add("EVN");
			
			cda.setCode(of.createCE());
			cda.getCode().setCode("819551000000100");
			cda.getCode().setCodeSystem("2.16.840.1.113883.2.1.3.2.4.15");
			cda.setConfidentialityCode(of.createCE());
			cda.getConfidentialityCode().setCode(XBasicConfidentialityKind.N.toString());
			cda.getConfidentialityCode().setCodeSystem("2.16.840.1.113883.1.11.16926");
			cda.getConfidentialityCode().setDisplayName("normal");
			
			cda.setEffectiveTime(of.createTS());
			cda.getEffectiveTime().setValue(ClinicalDocumentEffectiveTimeString());
			
			cda.setId(of.createII());
			cda.getId().setRoot(UUID.randomUUID().toString().toUpperCase());		
			cda.setMessageType(of.createMessageType());
			cda.getMessageType().setRoot("2.16.840.1.113883.2.1.3.2.4.18.17");
			cda.getMessageType().setExtension("POCD_MT200001GB02");		
			cda.setSetId(of.createII());
			cda.getSetId().setRoot(UUID.randomUUID().toString().toUpperCase());
			cda.setTitle(of.createST());
			cda.getTitle().setContent("NHS 111 Report");
			cda.setTypeId(of.createPOCDMT000002UK01InfrastructureRootTypeId());
			cda.getTypeId().setRoot("2.16.840.1.113883.1.3");
			cda.getTypeId().setExtension("POCD_HD000040");
			cda.setVersionNumber(of.createINT());
			cda.getVersionNumber().setValue(CommonValues.HASC_VERSION);
			
			cda.getAuthor().add(CreateAuthor(of));
			
			//StructuredBody
			cda.setComponent(of.createPOCDMT000002UK01Component2());
			cda.getComponent().setTypeCode("COMP");
			cda.getComponent().setContextConductionInd(true);
			cda.getComponent().setStructuredBody(createStructuredBody(of,msg));
		
			//encompassingEncounter
			cda.setComponentOf(of.createPOCDMT000002UK01Component1());
			cda.getComponentOf().setTypeCode("COMP");
			cda.getComponentOf().setContentId(of.createTemplateContent());
			cda.getComponentOf().getContentId().setRoot("2.16.840.1.113883.2.1.3.2.4.18.16");
			cda.getComponentOf().getContentId().setExtension("COCD_TP146232GB01#EncompassingEncounter");		
			cda.getComponentOf().setEncompassingEncounter(CreateEncompassingEncounter(of,msg));
			
			//Custodian
			cda.setCustodian(CreateCustodian(of));
			
			//TODO update the DocumentationOf list from  information in the hasc using 'INFRM' class code
			//cda.getDocumentationOf().add(e)
				
			POCDMT000002UK01InformationRecipient informationRecipient = of.createPOCDMT000002UK01InformationRecipient();
			
			informationRecipient.setTypeCode("PRCP");
			informationRecipient.setContentId(of.createTemplateContent());
			informationRecipient.getContentId().setRoot("2.16.840.1.113883.2.1.3.2.4.18.16");
			//TODO check what template to use. At present its only Organization:
			//	RecipientOrganizationUniversal (COCD_TP145203GB03)
			//	RecipientPersonUniversal (COCD_TP145202GB02)
			//	RecipientWorkgroupUniversal (COCD_TP145204GB03)
			String selectedType = "RecipientOrganizationUniversal"; 
			if(selectedType == "RecipientOrganizationUniversal")
			{
				informationRecipient.getContentId().setExtension("COCD_TP145203GB03#IntendedRecipient");			
				informationRecipient.setIntendedRecipient(CreateInformationRecipientOrganizationUniversal(of,msg.getPatient().getGPPractice()));
			}	
			else if(selectedType == "RecipientPersonUniversal")	
			{
				informationRecipient.getContentId().setExtension("COCD_TP145202GB02#IntendedRecipient");
				throw new NotImplementedException();				
				//informationRecipient.setIntendedRecipient(CreateInformationRecipientPersonUniversal(of,null));
			}
			else if(selectedType =="RecipientWorkgroupUniversal")
			{
				informationRecipient.getContentId().setExtension("COCD_TP145204GB03#IntendedRecipient");
				throw new NotImplementedException();
				//informationRecipient.setIntendedRecipient(CreateInformationRecipientWorkgroupUniversal(of,null));
			}
			cda.getInformationRecipient().add(informationRecipient);
			
			//patient
			POCDMT000002UK01RecordTarget patient = CreateRecordTarget(of,msg);
			cda.getRecordTarget().add(patient);
			
			
			//An informant is a person who informed the author about information contained in the CDA document. 
			cda.getInformant().add(createInformantAsSelf(of,msg));
		} catch (Exception e) {		
			throw new TransformerException(this,e);
		}
		finally
		{
			CdaNarritive = null;
		}
		
		return cda;
	}
	
	
	private POCDMT000002UK01Informant12 createInformantAsSelf(ObjectFactory of, SubmitEncounterResponse request)
	{
		Address address = null;	
		String telMob = null;
		String telHome = null;
		Patient patient = request.getPatient();
		//add address
		if(patient.getAddress()!=null)
		{
			address = patient.getAddress();
			telMob = patient.getTelephoneMobile();
			telHome = patient.getTelephoneHome();
		}
		InformantType cdaInformantType = InformantType.NotKnown;
		if(request.getHaSC().getInformantType() == InformantType.Self){
			cdaInformantType = InformantType.Self;
		}

		return createInformantRelatedEntity(of,address,cdaInformantType,telHome,telMob);	
	}

	/**
	 * 
	 * @param of 
	 * @param address
	 * @param cdaPersonRelationshipType
	 * 
	 * 
	 * @return
	 */
	private POCDMT000002UK01Informant12 createInformantRelatedEntity(ObjectFactory of, Address address, OctopusConsortium.Models.CDA.InformantType cdaPersonRelationshipType, String telephoneHome, String telephoneMobile)
	{
		POCDMT000002UK01Informant12 informant = of.createPOCDMT000002UK01Informant12();
		informant.getTypeCode().add("INF");
		informant.getContextControlCode().add("OP");
		informant.setContentId(of.createTemplateContent());
		informant.getContentId().setRoot("2.16.840.1.113883.2.1.3.2.4.18.16");
		informant.getContentId().setExtension("COCD_TP145007UK03#RelatedEntity");
		
		informant.setRelatedEntity(of.createPOCDMT000002UK01RelatedEntity());
		informant.getRelatedEntity().getClassCode().add("PRS");
		informant.getRelatedEntity().setCode(of.createCE());	
		informant.getRelatedEntity().getCode().setCode(cdaPersonRelationshipType.getCode());		
		informant.getRelatedEntity().getCode().setCodeSystem("2.16.840.1.113883.2.1.3.2.4.16.45");
		informant.getRelatedEntity().getCode().setDisplayName(cdaPersonRelationshipType.toString());
		//add address
		if( address!=null )
		{		
			AD addr = of.createAD();
			addr.getUse().add(CsPostalAddressUse.HP);//Set as primary home address
			
			StreetAddressLine addValue = of.createADStreetAddressLine();
			addValue.setContent(address.getStreetAddressLine1());
			addr.getContent().add(of.createADStreetAddressLine(addValue));
			
			addValue = of.createADStreetAddressLine();
			addValue.setContent(address.getStreetAddressLine2());
			addr.getContent().add((of.createADStreetAddressLine(addValue)));
			
			addValue = of.createADStreetAddressLine();
			addValue.setContent(address.getStreetAddressLine3());
			addr.getContent().add(of.createADStreetAddressLine(addValue));
			
			addValue = of.createADStreetAddressLine();
			addValue.setContent(address.getStreetAddressLine4());
			addr.getContent().add(of.createADStreetAddressLine(addValue));
			
			addValue = of.createADStreetAddressLine();
			addValue.setContent(address.getStreetAddressLine5());
			addr.getContent().add(of.createADStreetAddressLine(addValue));
			
			PostalCode adPostalCode = of.createADPostalCode();
			adPostalCode.setContent(address.getPostalCode());
			addr.getContent().add(of.createADPostalCode( adPostalCode));
			informant.getRelatedEntity().getAddr().add(addr);
		}
		// add telephone details
		TEL tel = null;
		if(telephoneMobile!=null && !telephoneMobile.isEmpty())
		{
			tel = of.createTEL();
			tel.getUse().add(CsTelecommunicationAddressUse.MC);
			tel.setValue("tel:" + telephoneMobile.replaceAll("\\s+",""));
			informant.getRelatedEntity().getTelecom().add(tel);
		}
		if(telephoneHome!=null && !telephoneHome.isEmpty())
		{
			tel = of.createTEL();
			tel.getUse().add(CsTelecommunicationAddressUse.HP);
			tel.setValue("tel:" + telephoneHome.replaceAll("\\s+",""));
			informant.getRelatedEntity().getTelecom().add(tel);
		}
		II e = of.createII();
		informant.getRelatedEntity().getTemplateId().add(e);
		e.setRoot("2.16.840.1.113883.2.1.3.2.4.18.2");
		e.setExtension("COCD_TP145007UK03#RelatedEntity");
		
		return informant;
	}
	
	private POCDMT000002UK01RecordTarget  CreateRecordTarget(ObjectFactory of, SubmitEncounterResponse request) throws OctopusConsortium.Core.InvalidMessageException {
						
		POCDMT000002UK01RecordTarget  target = of.createPOCDMT000002UK01RecordTarget();
		target.getTypeCode().add("RCT");
		target.getContextControlCode().add("OP");
		target.setContentId(of.createTemplateContent());
		target.getContentId().setRoot("2.16.840.1.113883.2.1.3.2.4.18.16");
		target.getContentId().setExtension("COCD_TP145201GB01#PatientRole");
		POCDMT000002UK01PatientRole patientRole = of.createPOCDMT000002UK01PatientRole();
		target.setPatientRole(patientRole);
		
		patientRole.getClassCode().add("PAT");
		
		Patient patient = request.getPatient();
		//add address
		if( patient.getAddress()!=null)
		{
			Address address = patient.getAddress();
			AD addr = of.createAD();
			addr.getUse().add(CsPostalAddressUse.HP);//Set as primary home address
			
			StreetAddressLine addValue = of.createADStreetAddressLine();
			addValue.setContent(address.getStreetAddressLine1());
			addr.getContent().add(of.createADStreetAddressLine(addValue));
			
			addValue = of.createADStreetAddressLine();
			addValue.setContent(address.getStreetAddressLine2());
			addr.getContent().add((of.createADStreetAddressLine(addValue)));
			
			addValue = of.createADStreetAddressLine();
			addValue.setContent(address.getStreetAddressLine3());
			addr.getContent().add(of.createADStreetAddressLine(addValue));
			
			addValue = of.createADStreetAddressLine();
			addValue.setContent(address.getStreetAddressLine4());
			addr.getContent().add(of.createADStreetAddressLine(addValue));
			
			addValue = of.createADStreetAddressLine();
			addValue.setContent(address.getStreetAddressLine5());
			addr.getContent().add(of.createADStreetAddressLine(addValue));
//			ADXP addValue = of.createADHouseNumber();
//			addValue.setContent(address.getHouseNumber());
//			addr.getContent().add((Serializable)addValue);
//			
//			addValue = of.createADStreetName();
//			addValue.setContent(address.getStreetName());
//			addr.getContent().add((Serializable)addValue);
//			
//			addValue = of.createADCity();
//			addValue.setContent(address.getCity());
//			addr.getContent().add((Serializable)addValue);
//			
//			addValue = of.createADCounty();
//			addValue.setContent(address.getCounty());
//			addr.getContent().add((Serializable)addValue);
			
			PostalCode adPostalCode = of.createADPostalCode();
			adPostalCode.setContent(address.getPostalCode());
			addr.getContent().add(of.createADPostalCode( adPostalCode));
			patientRole.getAddr().add(addr);
		}
		
		
		//Add NHS Number
		II id = of.createII();
		if(patient.getNhsNumber()== null || patient.getNhsNumber().isEmpty())
		{	//Where the NHS number is not available
			
			//throw error 
			throw new OctopusConsortium.Core.InvalidMessageException("missing NHS number");
			//id.setRoot("2.16.840.1.113883.2.1.3.2.4.18.24");
			////TODO check what values to put in the extension and AssigningAuthorityName
			////file:///C:/111/NHS111%20DMS/NHS111%20DMS/Domains/Templates/Tabular%20View/COCD_TP145201GB01-NoEdit.htm
			//id.setExtension("an id");
			//id.setAssigningAuthorityName(CommonValues.ODS_ASSIGNING_AUTHORITY_NAME);
		}
		else
		{
			//For a verified NHS Number: 
			id.setRoot("2.16.840.1.113883.2.1.4.1");
			id.setExtension(patient.getNhsNumber());			
		}
		patientRole.getId().add(id);
		// add telephone details
		TEL tel = null;
		if(patient.getTelephoneMobile()!=null && !patient.getTelephoneMobile().isEmpty())
		{
			tel = of.createTEL();
			tel.getUse().add(CsTelecommunicationAddressUse.MC);
			tel.setValue("tel:" + patient.getTelephoneMobile());
			patientRole.getTelecom().add(tel);
		}
		if(patient.getTelephoneHome()!=null && !patient.getTelephoneHome().isEmpty())
		{
			tel = of.createTEL();
			tel.getUse().add(CsTelecommunicationAddressUse.HP);
			tel.setValue("tel:" + patient.getTelephoneHome());
			patientRole.getTelecom().add(tel);
		}
		II ii = of.createII();
		patientRole.getTemplateId().add(ii);
		ii.setRoot("2.16.840.1.113883.2.1.3.2.4.18.2");
		ii.setExtension("COCD_TP145201GB01#PatientRole");
		
		patientRole.setPatient(of.createPOCDMT000002UK01Patient());
		
		patientRole.getPatient().getClassCode().add("PSN");
		patientRole.getPatient().getDeterminerCode().add("INSTANCE");
		patientRole.getPatient().setAdministrativeGenderCode(of.createCE());
		patientRole.getPatient().getAdministrativeGenderCode().setCode("" + patient.getGender().value());
		patientRole.getPatient().getAdministrativeGenderCode().setCodeSystem("2.16.840.1.113883.2.1.3.2.4.16.25");
		patientRole.getPatient().getAdministrativeGenderCode().setDisplayName(patient.getGender().toString());
		
		patientRole.getPatient().setBirthTime(of.createTS());
		if(patient.getDOB()!= null)
		{
			DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
			String DOB = df.format( patient.getDOB().toGregorianCalendar().getTime());
			patientRole.getPatient().getBirthTime().setValue(DOB);
		}else{
			patientRole.getPatient().getBirthTime().setNullFlavor(CsNullFlavor.UNK);
		}
		
		PN name = of.createPN();
		if(patient.getForename()!=null)
		{
			OctopusConsortium.Models.RCS.EnGiven g = of.createEnGiven();
			g.setContent(patient.getForename());
			name.getContent().add(of.createENGiven(g));
		}
		if(patient.getSurname()!=null)
		{
			OctopusConsortium.Models.RCS.EnFamily f = of.createEnFamily();
			f.setContent(patient.getSurname());
			name.getContent().add(of.createENFamily(f));
		}
		if(patient.getTitle() !=null)
		{
			OctopusConsortium.Models.RCS.EnPrefix p = of.createEnPrefix();
			p.setContent(patient.getTitle());
			name.getContent().add(of.createENPrefix(p));
		}
		
		patientRole.getPatient().getName().add(name);
		
		ii = of.createII();
		patientRole.getPatient().getTemplateId().add(ii);
		ii.setRoot("2.16.840.1.113883.2.1.3.2.4.18.2");
		ii.setExtension("COCD_TP145201GB01#patientPatient");
		
		
		return target;
	}

	

	private POCDMT000002UK01Custodian  CreateCustodian(ObjectFactory of) {
		
		POCDMT000002UK01Custodian  custodian = of.createPOCDMT000002UK01Custodian();
		custodian.getTypeCode().add("CST");
		custodian.setContentId(of.createTemplateContent());
		custodian.getContentId().setRoot("2.16.840.1.113883.2.1.3.2.4.18.16");
		custodian.getContentId().setExtension("COCD_TP145018UK03#AssignedCustodian");
		POCDMT000002UK01AssignedCustodian assignedCustodian = of.createPOCDMT000002UK01AssignedCustodian();
		custodian.setAssignedCustodian(assignedCustodian);
				
		assignedCustodian.getClassCode().add("ASSIGNED");
		II ii = of.createII();
		assignedCustodian.getTemplateId().add(ii);
		ii.setRoot("2.16.840.1.113883.2.1.3.2.4.18.2");
		ii.setExtension("COCD_TP145018UK03#AssignedCustodian");
		POCDMT000002UK01CustodianOrganization co = of.createPOCDMT000002UK01CustodianOrganization();
		assignedCustodian.setRepresentedCustodianOrganization(co);
		
		co.setClassCode("ORG");
		co.getDeterminerCode().add("INSTANCE");
		ii = of.createII();
		co.getId().add(ii);
		ii.setRoot("2.16.840.1.113883.2.1.3.2.4.19.1");
		ii.setExtension(commonValues.ODS_ORGANISATION_CODE);
		co.setName(of.createON());
		co.getName().getContent().add(commonValues.getOrganisation_Name());
		ii = of.createII();
		co.getTemplateId().add(ii);
		ii.setRoot("2.16.840.1.113883.2.1.3.2.4.18.2");
		ii.setExtension("COCD_TP145018UK03#representedCustodianOrganization");
		return custodian;
	}

	
	public String ClinicalDocumentEffectiveTimeString()
	{
		Date date = Calendar.getInstance().getTime();	
		TimeZone tz = Calendar.getInstance().getTimeZone();
		//gives you the current offset in ms from GMT at the current date
		long msFromEpochGmt = date.getTime();
        int offsetFromUTC = tz.getOffset(msFromEpochGmt);
        //create a new calendar in GMT time zone, set to this date and add the offset
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));        
        gmtCal.setTime(date);
        gmtCal.add(Calendar.MILLISECOND, offsetFromUTC);
    
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");	
		String value = df.format(gmtCal.getTime());
		
		return value + "+0000";
	}
	
	private POCDMT000002UK01Author CreateAuthor(ObjectFactory of)
	{
		POCDMT000002UK01Author  author =  of.createPOCDMT000002UK01Author();
		
		author.getTypeCode().add("AUT");
		author.getContextControlCode().add("OP");
		author.setContentId(of.createTemplateContent());
		author.getContentId().setRoot("2.16.840.1.113883.2.1.3.2.4.18.16");
		author.getContentId().setExtension("COCD_TP145208GB01#AssignedAuthor");
		author.setFunctionCode(of.createCE());
		author.getFunctionCode().setCode("OA");
		author.getFunctionCode().setCodeSystem("2.16.840.1.113883.2.1.3.2.4.17.178");
		author.getFunctionCode().setDisplayName("Originating Author");
		author.setTime(of.createTS());
		author.getTime().setValue(ClinicalDocumentEffectiveTimeString());
		POCDMT000002UK01AssignedAuthor  assignedAuthor = of.createPOCDMT000002UK01AssignedAuthor();
		
		assignedAuthor.getClassCode().add("ASSIGNED");
		assignedAuthor.setCode(of.createCE());
		assignedAuthor.getCode().setNullFlavor(CsNullFlavor.NI);

		II ii = of.createII();
		ii.setNullFlavor(CsNullFlavor.NI);
		assignedAuthor.getId().add(ii);
		
		ii = of.createII();
		assignedAuthor.getTemplateId().add(ii);
		ii.setRoot("2.16.840.1.113883.2.1.3.2.4.18.2");
		ii.setExtension("COCD_TP145208GB01#AssignedAuthor");
	
		assignedAuthor.setRepresentedOrganization(of.createPOCDMT000002UK01Organization());
		assignedAuthor.getRepresentedOrganization().setClassCode("ORG");
		assignedAuthor.getRepresentedOrganization().getDeterminerCode().add("INSTANCE");
		
		ii = of.createII();
		assignedAuthor.getRepresentedOrganization().getId().add(ii);
		ii.setRoot("2.16.840.1.113883.2.1.3.2.4.19.1");
		ii.setExtension(commonValues.ODS_ORGANISATION_CODE);
		ON on = of.createON();
		assignedAuthor.getRepresentedOrganization().getName().add(on);
		on.getContent().add(commonValues.getOrganisation_Name());
		ii = of.createII();
		assignedAuthor.getRepresentedOrganization().getTemplateId().add(ii);
		ii.setRoot("2.16.840.1.113883.2.1.3.2.4.18.2");
		ii.setExtension("COCD_TP145208GB01#representedOrganization");
		author.setAssignedAuthor(assignedAuthor);
		return author;
	}
	
	private POCDMT000002UK01StructuredBody createStructuredBody(ObjectFactory of,SubmitEncounterResponse message) throws InvalidHascException
	{
		POCDMT000002UK01StructuredBody  body = of.createPOCDMT000002UK01StructuredBody();
		body.getClassCode().add("DOCBODY");
		body.getMoodCode().add("EVN");
		
		POCDMT000002UK01Component3 comp3 = of.createPOCDMT000002UK01Component3();
		body.getComponent().add(comp3);
		comp3.setTypeCode("COMP");
		comp3.setContextConductionInd(true);
		POCDMT000002UK01Section csection = of.createPOCDMT000002UK01Section();
		comp3.setSection(csection);
		
		csection.getClassCode().add("DOCSECT");
		csection.getMoodCode().add("EVN");
		csection.setId(of.createII());
		csection.getId().setRoot(UUID.randomUUID().toString().toUpperCase());
		
		POCDMT000002UK01Component5 component = of.createPOCDMT000002UK01Component5();
		csection.getComponent().add(component);
		
		
		//NHS111TextSection Disposition
		component.setTypeCode("COMP");
		component.setContextConductionInd(true);
		component.setContentId(of.createTemplateContent());
		component.getContentId().setRoot("2.16.840.1.113883.2.1.3.2.4.18.16");
		component.getContentId().setExtension("COCD_TP146246GB01#Section1");	
		component.setSection(CreateDispositionSection(of,message));
		
		component = of.createPOCDMT000002UK01Component5();
		csection.getComponent().add(component);
		//NHS111TextSection HaSC
		component.setTypeCode("COMP");
		component.setContextConductionInd(true);
		component.setContentId(of.createTemplateContent());
		component.getContentId().setRoot("2.16.840.1.113883.2.1.3.2.4.18.16");
		component.getContentId().setExtension("COCD_TP146246GB01#Section1");	
		component.setSection(CreateSection(of,message));
		
		// add entry (original Hasc xml)	
		csection.getEntry().add(createEntry(of,message));
		
		return body;
	}
	
	private POCDMT000002UK01Entry createEntry(ObjectFactory of,SubmitEncounterResponse message)
	{
		POCDMT000002UK01Entry entry = of.createPOCDMT000002UK01Entry();
		
		entry.setTypeCode(XActRelationshipEntry.COMP);
		entry.setContextConductionInd(true);
		entry.setContentId(of.createTemplateContent());
		entry.getContentId().setRoot("2.16.840.1.113883.2.1.3.2.4.18.16");
		entry.getContentId().setExtension("COCD_TP146002GB01#ObservationMedia");
		
		POCDMT000002UK01ObservationMedia observation = of.createPOCDMT000002UK01ObservationMedia();
		entry.setObservationMedia(observation);
		
		observation.getClassCode().add("OBS");
		observation.getMoodCode().add("EVN");
		II ii = of.createII();
		ii.setRoot(UUID.randomUUID().toString().toUpperCase());
		observation.getId().add(ii);
		
		ii = of.createII();
		observation.getTemplateId().add(ii);
		ii.setRoot("2.16.840.1.113883.2.1.3.2.4.18.2");
		ii.setExtension("COCD_TP146002GB01#ObservationMedia");
		
		observation.setValue(of.createED());
		observation.getValue().setRepresentation(CsBinaryDataEncoding.B_64);
		observation.getValue().setMediaType("text/xml");		
		observation.getValue().setContent(
				new String(Base64.encodeBase64(message.getHaSC().getValue().getBytes())));		
		
		POCDMT000002UK01Participant2 p = of.createPOCDMT000002UK01Participant2();
		observation.getParticipant().add(p);
		p.getTypeCode().add("DEV");
		p.getContextControlCode().add("OP");
		
		p.setContentId(of.createTemplateContent());
		p.getContentId().setRoot("2.16.840.1.113883.2.1.3.2.4.18.16");
		p.getContentId().setExtension("COCD_TP145000GB01#ParticipantRole");
		
		ii = of.createII();
		p.getTemplateId().add(ii);
		ii.setRoot("2.16.840.1.113883.2.1.3.2.4.18.2");
		ii.setExtension("COCD_TP146002GB01#participant");
		
		POCDMT000002UK01ParticipantRole role = of.createPOCDMT000002UK01ParticipantRole();
		p.setParticipantRole(role);
		role.getClassCode().add("ROL");
		role.setCode(of.createCE());
		role.getCode().setCode("TS");
		role.getCode().setCodeSystem("2.16.840.1.113883.2.1.3.2.4.17.418");
		
		ii = of.createII();
		ii.setRoot("2.16.840.1.113883.2.1.3.2.4.18.2");
		ii.setExtension("COCD_TP145000GB01#ParticipantRole");
		role.getTemplateId().add(ii);
		
		POCDMT000002UK01Device device = of.createPOCDMT000002UK01Device();
		role.setPlayingDevice(device);
		device.setClassCode("DEV");
		device.getDeterminerCode().add("INSTANCE");
		device.setManufacturerModelName(of.createSC());
		device.getManufacturerModelName().setDisplayName(commonValues.MANUFACTURER_NAME);
		//TODO: pull manufacturer, software and version from config file.
		device.setSoftwareName(of.createSC());
		device.getSoftwareName().setDisplayName(CommonValues.SOFTWARE_NAME);
		device.getSoftwareName().setCode("1.0");
		ii = of.createII();
		ii.setRoot("2.16.840.1.113883.2.1.3.2.4.18.2");
		ii.setExtension("COCD_TP145000GB01#playingDevice");
		device.getTemplateId().add(ii);
		
		return entry;		
	}
	
	// populate this method with GP/Organisation info from PDS lookup
	private POCDMT000002UK01IntendedRecipient CreateInformationRecipientOrganizationUniversal (
			ObjectFactory of, GPPractice gpInfo) throws OctopusConsortium.Core.InvalidMessageException {
		
		if(gpInfo==null)
			throw new OctopusConsortium.Core.InvalidMessageException("GPPractice is null");
		POCDMT000002UK01IntendedRecipient recipent = of.createPOCDMT000002UK01IntendedRecipient();
		recipent.setClassCode("ASSIGNED");
		AD addr = of.createAD();
		recipent.getAddr().add(addr);
		
		if(gpInfo.getAddress()!=null){
			AD.StreetAddressLine addline1 = new StreetAddressLine();
			AD.StreetAddressLine addline2 = new StreetAddressLine();
			AD.StreetAddressLine addline3 = new StreetAddressLine();
			AD.StreetAddressLine addline4 = new StreetAddressLine();
			AD.StreetAddressLine addline5 = new StreetAddressLine();
			AD.PostalCode addpost = new PostalCode();
			addline1.setContent(gpInfo.getAddress().getStreetAddressLine1());
			addline2.setContent(gpInfo.getAddress().getStreetAddressLine2());
			addline3.setContent(gpInfo.getAddress().getStreetAddressLine3());
			addline4.setContent(gpInfo.getAddress().getStreetAddressLine4());
			addline5.setContent(gpInfo.getAddress().getStreetAddressLine5());
			addpost.setContent(gpInfo.getAddress().getPostalCode());
			addr.getContent().add(of.createADStreetAddressLine(addline1));
			addr.getContent().add(of.createADStreetAddressLine(addline2));
			addr.getContent().add(of.createADStreetAddressLine(addline3));
			addr.getContent().add(of.createADStreetAddressLine(addline4));
			addr.getContent().add(of.createADStreetAddressLine(addline5));
			addr.getContent().add(of.createADPostalCode(addpost));
		}
				
		TEL tel = of.createTEL();
		recipent.getTelecom().add(tel);
		tel.setValue("tel:" + gpInfo.getTelephone());
			
		II ii = of.createII();
		recipent.getTemplateId().add(ii);
		ii.setRoot("2.16.840.1.113883.2.1.3.2.4.18.2");
		ii.setExtension("COCD_TP145203GB03#IntendedRecipient");
		
		recipent.setReceivedOrganization(of.createPOCDMT000002UK01Organization());		
		recipent.getReceivedOrganization().setClassCode("ORG");
		recipent.getReceivedOrganization().getDeterminerCode().add("INSTANCE");
		ii = of.createII();
		recipent.getReceivedOrganization().getId().add(ii);
		
		ii.setExtension(gpInfo.getODS());
		ii.setRoot("2.16.840.1.113883.2.1.3.2.4.19.1");		
		ON on = of.createON();
		recipent.getReceivedOrganization().getName().add(on);
		on.getContent().add(gpInfo.getName());
		
		//TODO optionally set the class code 
		//recipent.getRepresentedOrganization().setStandardIndustryClassCode(value);
		ii=of.createII();
		recipent.getReceivedOrganization().getTemplateId().add(ii);
		ii.setRoot("2.16.840.1.113883.2.1.3.2.4.18.2");
		ii.setExtension("COCD_TP145203GB03#representedOrganization");
		
		return recipent;
	}
	
	//file:///C:/111/NHS111%20DMS/NHS111%20DMS/Domains/Templates/Document%20files/NPFIT-000040_Section.htm
	private POCDMT000002UK01Section  CreateDispositionSection(ObjectFactory of,SubmitEncounterResponse message) throws InvalidHascException
	{
		POCDMT000002UK01Section  section = of.createPOCDMT000002UK01Section();
		
		section.getClassCode().add("DOCSECT");
		section.getMoodCode().add("EVN");
		
		section.setId(of.createII());
		section.getId().setRoot(UUID.randomUUID().toString().toUpperCase());
		
		II ii = of.createII();
		section.getTemplateId().add(ii);
		ii.setRoot("2.16.840.1.113883.2.1.3.2.4.18.2");
		ii.setExtension("COCD_TP146246GB01#Section1");
				
		section.setTitle(of.createST());
		section.getTitle().setContent("Disposition");
		
		section.setText(of.createStrucDocText());
		section.getText().setMediaType("text/x-hl7-text+xml");
		
		JAXBElement<StrucDocContent> content = of.createStrucDocContentContent(of.createStrucDocContent());
		content.getValue().getContent().add("Disposition: " + message.getHaSC().getDispositionDetails().getDispositionName());
		content.getValue().getContent().add(of.createStrucDocContentBr(of.createStrucDocBr()));
		content.getValue().getContent().add("Disposition Code: " + message.getHaSC().getDispositionDetails().getDispositionCode());
		content.getValue().getContent().add(of.createStrucDocContentBr(of.createStrucDocBr()));		
		content.getValue().getContent().add("Symptom Group: " + message.getHaSC().getDispositionDetails().getSymptomGroup());
		content.getValue().getContent().add(of.createStrucDocContentBr(of.createStrucDocBr()));
		section.getText().getContent().add(content);
		return section;
		
	}
	//file:///C:/111/NHS111%20DMS/NHS111%20DMS/Domains/Templates/Document%20files/NPFIT-000040_Section.htm
	private POCDMT000002UK01Section  CreateSection(ObjectFactory of,SubmitEncounterResponse message) throws InvalidHascException
	{
		POCDMT000002UK01Section  section = of.createPOCDMT000002UK01Section();
		
		section.getClassCode().add("DOCSECT");
		section.getMoodCode().add("EVN");
		
		section.setId(of.createII());
		section.getId().setRoot(UUID.randomUUID().toString().toUpperCase());
		
		II ii = of.createII();
		section.getTemplateId().add(ii);
		ii.setRoot("2.16.840.1.113883.2.1.3.2.4.18.2");
		ii.setExtension("COCD_TP146246GB01#Section1");
		
		//Add the CDA markup for the HaSK here
		section.setText(of.createStrucDocText());
		section.getText().setMediaType("text/x-hl7-text+xml");
		//section.getText().getContent().add(GetCdaFromHaSC(hasc.getHaSC().getValue()));		
		section.getText().getContent().addAll(getCDANarrativeObjects(message.getHaSC()));
		
		section.setTitle(of.createST());
		section.getTitle().setContent("Case Details");
		
		//TODO optional
		//section.setAuthor(value) this is optional
				
		return section;
	}
	
	@SuppressWarnings("unused")
	private Serializable GetCdaFromHaSC(String value) {
		//this is now passed in		
		return CdaNarritive==null?"":CdaNarritive;
	}
	
	private Collection<? extends Serializable> getCDANarrativeObjects(HaSC hasc) throws InvalidHascException
	{		
		ArrayList<Serializable> returnObjs = new ArrayList<Serializable>();
		ObjectFactory oFactory = new ObjectFactory();
				
		try
		{
			DocumentBuilderFactory xmlFact = DocumentBuilderFactory.newInstance();
	        xmlFact.setNamespaceAware(false);
	        DocumentBuilder builder = xmlFact.newDocumentBuilder();
	        Document doc = builder.parse(new java.io.ByteArrayInputStream(hasc.getValue().getBytes()));
	                
	        XPathFactory xpathFact = XPathFactory.newInstance();
	        XPath xpath = xpathFact.newXPath();
	        xpath.setNamespaceContext(getNamespaceContext(doc));
	        
	        XPathExpression expr = xpath.compile("//DataInstance");
	        NodeList result = (NodeList) expr.evaluate(doc,XPathConstants.NODESET);
			
	        for (int i = 0; i < result.getLength(); i++) {
	        	Node n = result.item(i);
	            if (n != null && n.getNodeType() == Node.ELEMENT_NODE) {
	                Element dataInstance = (Element) n;
	                StrucDocContent content;
	                NodeList nodes;
	                
	                //Add Name
	                expr = xpath.compile("Name");//xpath to find name in dataInstance
	                nodes = (NodeList)  expr.evaluate(dataInstance,XPathConstants.NODESET);
	                content = oFactory.createStrucDocContent();
	                content.getContent().add("Name: " + nodes.item(0).getTextContent());
	                returnObjs.add(oFactory.createStrucDocContentContent(content));
	                returnObjs.add(oFactory.createStrucDocContentBr(oFactory.createStrucDocBr()));
	                
	                //Add Caption
	                expr = xpath.compile("Caption");//xpath to find caption in dataInstance
	                nodes = (NodeList)  expr.evaluate(dataInstance,XPathConstants.NODESET);
	                content = oFactory.createStrucDocContent();
	                content.getContent().add("Caption: " + nodes.item(0).getTextContent());
	                returnObjs.add(oFactory.createStrucDocContentContent(content));
	                returnObjs.add(oFactory.createStrucDocContentBr(oFactory.createStrucDocBr()));
	                
	                //Add Values
	                expr = xpath.compile("Values");//xpath to find values in dataInstance
	                nodes = (NodeList)  expr.evaluate(dataInstance,XPathConstants.NODESET);                
	                for (int j = 0; j < nodes.getLength(); j++) {
	                	content = oFactory.createStrucDocContent();
	                    content.getContent().add("Value: " + nodes.item(0).getTextContent());
	                    returnObjs.add(oFactory.createStrucDocContentContent(content));
	                    returnObjs.add(oFactory.createStrucDocContentBr(oFactory.createStrucDocBr()));
					}    
	                returnObjs.add(oFactory.createStrucDocContentBr(oFactory.createStrucDocBr()));
	                returnObjs.add(oFactory.createStrucDocContentBr(oFactory.createStrucDocBr()));
	            }
	        }
		}
		catch(Exception e)
		{
			throw new InvalidHascException("Error parsing HaSC " + hasc.getId());
		}
        
		return  returnObjs;		
	}
	private NamespaceContext getNamespaceContext(Node node)
	{
		final PrefixResolver resolver =  new PrefixResolverDefault(node);
        NamespaceContext ctx = new NamespaceContext() {
            public String getNamespaceURI(String prefix) {
                return resolver.getNamespaceForPrefix(prefix);
            }
           
            // Dummy implementation - not used!
            public Iterator<?> getPrefixes(String val) {
                return null;
            }
           
            // Dummy implemenation - not used!
            public String getPrefix(String uri) {
                return null;
            }
        };
        return ctx;
	}

	// populate this method
	//file:///C:/111/NHS111%20DMS/NHS111%20DMS/Domains/Templates/Tabular%20View/COCD_TP146232GB01-NoEdit.htm
	private POCDMT000002UK01EncompassingEncounter CreateEncompassingEncounter(ObjectFactory of,SubmitEncounterResponse msg)
	{
		POCDMT000002UK01EncompassingEncounter encounter = of.createPOCDMT000002UK01EncompassingEncounter();
		
		encounter.getClassCode().add("ENC");
		encounter.getMoodCode().add("EVN");
		encounter.setCode(of.createCE());
		encounter.getCode().setCode("NHS111Encounter");
		encounter.getCode().setCodeSystem("2.16.840.1.113883.2.1.3.2.4.17.326");
		encounter.getCode().setDisplayName("NHS111 Encounter");
		
		encounter.setDischargeDispositionCode(of.createCE());
		
		//get the code and display name form the HaSC message
		//file:///C:/111/NHS111%20DMS/NHS111%20DMS/Domains/Templates/Tabular%20View/COCD_TP146232GB01-NoEdit.htm
		//http://www.connectingforhealth.nhs.uk/systemsandservices/data/uktc/snomed/release
		encounter.getDischargeDispositionCode().setCode("" + msg.getHaSC().getDispositionDetails().getDispositionCode());
		encounter.getDischargeDispositionCode().setDisplayName(msg.getHaSC().getDispositionDetails().getDispositionName());	
		encounter.getDischargeDispositionCode().setCodeSystem("2.16.840.1.113883.2.1.3.2.4.17.414");
		
		//set this to the start date time of the HaSC encounter	
		encounter.setEffectiveTime(of.createIVLTS());					
		encounter.getEffectiveTime().setLow(of.createTS());		
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String startDate = "";
		if(msg.getHaSC().getStartDate()!=null)
			startDate = df.format( msg.getHaSC().getStartDate().toGregorianCalendar().getTime());	
		else
			startDate = df.format(GregorianCalendar.getInstance().getTime());
		encounter.getEffectiveTime().getLow().setValue(startDate);
		
		II ii = of.createII();
		ii.setRoot("2.16.840.1.113883.2.1.3.2.4.18.34");
		ii.setExtension(msg.getHaSC().getId()); //set extension to contain the case reference
		encounter.getId().add(ii);
		
		//TODO optionally set the case id
//		ii = of.createII();
//		ii.setRoot("2.16.840.1.113883.2.1.3.2.4.18.35");
//		ii.setExtension("example-caseid"); //TODO set extension to contain the case id
//		encounter.getId().add(ii);
		
		ii = of.createII();
		encounter.getTemplateId().add(ii);		
		ii.setRoot("2.16.840.1.113883.2.1.3.2.4.18.2");
		ii.setExtension("COCD_TP146232GB01#EncompassingEncounter");
		
		//TODO [0..*] encounterParticipant
		
		encounter.setLocation(of.createPOCDMT000002UK01Location());
		encounter.getLocation().setTypeCode("LOC");
		encounter.getLocation().setContentId(of.createTemplateContent());
		encounter.getLocation().getContentId().setRoot("2.16.840.1.113883.2.1.3.2.4.18.16");
		encounter.getLocation().getContentId().setExtension("COCD_TP145222GB02#HealthCareFacility");
		
		//location
		ii = of.createII();
		encounter.getLocation().getTemplateId().add(ii);
		ii.setRoot("2.16.840.1.113883.2.1.3.2.4.18.2");
		ii.setExtension("COCD_TP146232GB01#location");
				
		encounter.getLocation().setHealthCareFacility(of.createPOCDMT000002UK01HealthCareFacility());
		encounter.getLocation().getHealthCareFacility().setClassCode("ISDLOC");
		
		POCDMT000002UK01Place place = of.createPOCDMT000002UK01Place();
		AD address = of.createAD();
		
		address.getUse().add(CsPostalAddressUse.PHYS);
		
		
		place.setAddr(address);
		encounter.getLocation().getHealthCareFacility().setLocation(place);
		
		
		//TODO optional set the code 
		//A snomedCT code to describe a incidental location such as the scene of an RTA.
		//encounter.getLocation().getCOCDTP145222GB02HealthCareFacility().setCode(of.createCE());
		//encounter.getLocation().getCOCDTP145222GB02HealthCareFacility().getCode().setCode("");
		
		II oid =  of.createII();
		encounter.getLocation().getHealthCareFacility().getId().add(oid);
		oid.setNullFlavor(CsNullFlavor.NA);
		
		ii = of.createII();
		encounter.getLocation().getHealthCareFacility().getTemplateId().add(ii); 
		ii.setRoot("2.16.840.1.113883.2.1.3.2.4.18.2");
		ii.setExtension("COCD_TP145222GB02#HealthCareFacility");
		
		
		//TODO optional set responsibleParty
		//A class which holds details of how the person was responsible for the encompassing encounter.
		//Note this participation is required to be included if available on the sending system.
		
		
		return encounter;
	}
}
