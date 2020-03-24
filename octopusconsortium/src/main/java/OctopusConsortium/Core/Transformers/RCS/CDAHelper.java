package OctopusConsortium.Core.Transformers.RCS;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.UUID;

import OctopusConsortium.Core.InvalidHascException;
import OctopusConsortium.Core.CommonValues;
import OctopusConsortium.Core.Transformers.ITK.CallQueueHelper;
import OctopusConsortium.Models.IITKPatient;
import OctopusConsortium.Models.CDA.InformantType;
import OctopusConsortium.Models.RCS.CD;
import OctopusConsortium.Models.RCS.CE;
import OctopusConsortium.Models.RCS.CS;
import OctopusConsortium.Models.RCS.AD;
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
import OctopusConsortium.Models.RCS.POCDMT000002UK01Authorization;
import OctopusConsortium.Models.RCS.POCDMT000002UK01Component3;
import OctopusConsortium.Models.RCS.POCDMT000002UK01Component5;
import OctopusConsortium.Models.RCS.POCDMT000002UK01Consent;
import OctopusConsortium.Models.RCS.POCDMT000002UK01Custodian;
import OctopusConsortium.Models.RCS.POCDMT000002UK01CustodianOrganization;
import OctopusConsortium.Models.RCS.POCDMT000002UK01Device;
import OctopusConsortium.Models.RCS.POCDMT000002UK01Entry;
import OctopusConsortium.Models.RCS.POCDMT000002UK01Informant12;
import OctopusConsortium.Models.RCS.POCDMT000002UK01IntendedRecipient;
import OctopusConsortium.Models.RCS.POCDMT000002UK01ObservationMedia;
import OctopusConsortium.Models.RCS.POCDMT000002UK01Organization;
import OctopusConsortium.Models.RCS.POCDMT000002UK01Participant2;
import OctopusConsortium.Models.RCS.POCDMT000002UK01ParticipantRole;
import OctopusConsortium.Models.RCS.POCDMT000002UK01PatientRole;
import OctopusConsortium.Models.RCS.POCDMT000002UK01Person;
import OctopusConsortium.Models.RCS.POCDMT000002UK01RecordTarget;
import OctopusConsortium.Models.RCS.POCDMT000002UK01Section;
import OctopusConsortium.Models.RCS.POCDMT000002UK01StructuredBody;
import OctopusConsortium.Models.RCS.TEL;
import OctopusConsortium.Models.RCS.XActRelationshipEntry;
import OctopusConsortium.Models.RCS.AD.PostalCode;
import OctopusConsortium.Models.RCS.AD.StreetAddressLine;
import OctopusConsortium.Service.Models.Address;
import OctopusConsortium.Service.Models.AgeType;
import OctopusConsortium.Service.Models.GPPractice;
import OctopusConsortium.Service.Models.SubmitToCallQueueDetails;
import OctopusConsortium.Service.Models.SubmitToServiceDetails;

public class CDAHelper {
	
	private CommonValues commonValues;
	
	public CDAHelper(CommonValues commonValues){
		this.commonValues = commonValues;
	}
	
	public static POCDMT000002UK01Informant12 createInformantRelatedEntity(ObjectFactory of, Address homeAddress, OctopusConsortium.Models.CDA.InformantType cdaPersonRelationshipType, String telephoneHome, String telephoneMobile, String emailAddress, String informantName)
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
		
		if (homeAddress != null && cdaPersonRelationshipType.equals(InformantType.Self)) {
			informant.getRelatedEntity().getAddr().add(CreateRecordTargetAddress(of, homeAddress,CsPostalAddressUse.HP));
		}
		
		// add telephone details
		TEL tel = null;
		if(telephoneMobile!=null && !telephoneMobile.isEmpty())
		{	
			//tel = of.createTEL();
			//tel.getUse().add(CsTelecommunicationAddressUse.MC);
			//tel.setValue("tel:" + telephoneMobile.replaceAll("\\s+",""));
			//informant.getRelatedEntity().getTelecom().add(tel);

			tel = of.createTEL();
			tel.getUse().add(CsTelecommunicationAddressUse.EC);
			tel.setValue("tel:" + telephoneMobile.replaceAll("\\s+",""));
			informant.getRelatedEntity().getTelecom().add(tel);
		}
		else if(telephoneHome!=null && !telephoneHome.isEmpty())
		{
			//tel = of.createTEL();
			//tel.getUse().add(CsTelecommunicationAddressUse.HP);
			//tel.setValue("tel:" + telephoneHome.replaceAll("\\s+",""));
			//informant.getRelatedEntity().getTelecom().add(tel);
			
			tel = of.createTEL();
			tel.getUse().add(CsTelecommunicationAddressUse.EC);
			tel.setValue("tel:" + telephoneHome.replaceAll("\\s+",""));
			informant.getRelatedEntity().getTelecom().add(tel);
		}
		
		if(emailAddress!=null && !emailAddress.isEmpty()){
			TEL email = null;
			
			email = of.createTEL();
			email.getUse().add(CsTelecommunicationAddressUse.EC);
			email.setValue("mailto:" + emailAddress);
			informant.getRelatedEntity().getTelecom().add(email);
		}
		
		II e = of.createII();
		e.setRoot("2.16.840.1.113883.2.1.3.2.4.18.2");
		e.setExtension("COCD_TP145007UK03#RelatedEntity");
		informant.getRelatedEntity().getTemplateId().add(e);		
	
		
		if (informantName != null && !informantName.isEmpty()) {
			PN pn = of.createPN();
			pn.getContent().add(informantName);

			POCDMT000002UK01Person person = of.createPOCDMT000002UK01Person();
			person.getName().add(pn);
			person.getClassCode().add("PSN");
			person.getDeterminerCode().add("INSTANCE");
			e = of.createII();
			e.setRoot("2.16.840.1.113883.2.1.3.2.4.18.2");
			e.setExtension("COCD_TP145007UK03#relationshipHolder");
			person.getTemplateId().add(e);
			
			informant.getRelatedEntity().setRelatedPerson(person);
			
		}
		
		return informant;
	}

	
	
	public static AD CreateRecordTargetAddress(ObjectFactory of, Address address, CsPostalAddressUse cpau)
	{
		if(address != null)
		{
			AD addr = of.createAD();
			addr.getUse().add(cpau);//Set as home address / current address / etc 
			

			StreetAddressLine addValue;

			if (address.getStreetAddressLine1() != null && !address.getStreetAddressLine1().isEmpty()) {
				addValue = of.createADStreetAddressLine();
				addValue.setContent(address.getStreetAddressLine1());
				addr.getContent().add(of.createADStreetAddressLine(addValue));
			}
			
			if (address.getStreetAddressLine2() != null && !address.getStreetAddressLine2().isEmpty()) {
				addValue = of.createADStreetAddressLine();
				addValue.setContent(address.getStreetAddressLine2());
				addr.getContent().add((of.createADStreetAddressLine(addValue)));
			}
			
			if (address.getStreetAddressLine3() != null && !address.getStreetAddressLine3().isEmpty()) {
				addValue = of.createADStreetAddressLine();
				addValue.setContent(address.getStreetAddressLine3());
				addr.getContent().add(of.createADStreetAddressLine(addValue));
			}
			
			if (address.getStreetAddressLine4() != null && !address.getStreetAddressLine4().isEmpty()) {
				addValue = of.createADStreetAddressLine();
				addValue.setContent(address.getStreetAddressLine4());
				addr.getContent().add(of.createADStreetAddressLine(addValue));
			}
			
			if (address.getStreetAddressLine5() != null && !address.getStreetAddressLine5().isEmpty()) {
				addValue = of.createADStreetAddressLine();
				addValue.setContent(address.getStreetAddressLine5());
				addr.getContent().add(of.createADStreetAddressLine(addValue));
			}

			PostalCode adPostalCode = of.createADPostalCode();
			adPostalCode.setContent(address.getPostalCode());
			addr.getContent().add(of.createADPostalCode( adPostalCode));
			
			return addr;
		}
		return new AD();
	}
	
	public static String ClinicalDocumentEffectiveTimeString()
	{
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");			
		df.setTimeZone(TimeZone.getTimeZone("UTC"));
		String value = df.format(new Date());
		return value + "+0000";
	}

	public POCDMT000002UK01Author CreateAuthor(ObjectFactory of, String provider)
	{
		POCDMT000002UK01Author author = of.createPOCDMT000002UK01Author();
		
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
		provider = provider == null ? provider = commonValues.getOrganisation_Name() : provider;
		on.getContent().add(provider);
		ii = of.createII();
		assignedAuthor.getRepresentedOrganization().getTemplateId().add(ii);
		ii.setRoot("2.16.840.1.113883.2.1.3.2.4.18.2");
		ii.setExtension("COCD_TP145208GB01#representedOrganization");
		author.setAssignedAuthor(assignedAuthor);
		return author;
	}
	
	public POCDMT000002UK01Author CreateNamedAuthor(ObjectFactory of, String provider)
	{		
		POCDMT000002UK01Author author = of.createPOCDMT000002UK01Author();
		
		author.getTypeCode().add("AUT");
		author.getContextControlCode().add("OP");
		
		author.setContentId(of.createTemplateContent());
		author.getContentId().setRoot("2.16.840.1.113883.2.1.3.2.4.18.16");
		author.getContentId().setExtension("COCD_TP145200GB01#AssignedAuthor");
		
		author.setFunctionCode(of.createCE());
		author.getFunctionCode().setCode("OA");
		author.getFunctionCode().setCodeSystem("2.16.840.1.113883.2.1.3.2.4.17.178");
		author.getFunctionCode().setDisplayName("Originating Author");
		
		author.setTime(of.createTS());
		author.getTime().setValue(ClinicalDocumentEffectiveTimeString());
		
		POCDMT000002UK01AssignedAuthor assignedAuthor = of.createPOCDMT000002UK01AssignedAuthor();
		assignedAuthor.getClassCode().add("ASSIGNED");
		
		assignedAuthor.setCode(of.createCE());
		assignedAuthor.getCode().setCode("T1");
		assignedAuthor.getCode().setCodeSystem("2.16.840.1.113883.2.1.3.2.4.17.196");
		assignedAuthor.getCode().setDisplayName("OOH call handler");
		
		II ii = of.createII();
		ii.setRoot("2.16.840.1.113883.2.1.3.2.4.18.24");
		
		provider = provider == null ? provider = commonValues.getOrganisation_Name() : provider;
		ii.setExtension(provider);
		ii.setAssigningAuthorityName(provider);
		assignedAuthor.getId().add(ii);
		
		ii = of.createII();
		assignedAuthor.getTemplateId().add(ii);
		ii.setRoot("2.16.840.1.113883.2.1.3.2.4.18.2");
		ii.setExtension("COCD_TP145200GB01#AssignedAuthor");
	
		POCDMT000002UK01Person assignedPerson = of.createPOCDMT000002UK01Person();
		assignedAuthor.setAssignedPerson(assignedPerson);
		assignedPerson.getClassCode().add("PSN");
		assignedPerson.getDeterminerCode().add("INSTANCE");
		II templateId = of.createII();
		assignedPerson.getTemplateId().add(templateId);
		templateId.setRoot("2.16.840.1.113883.2.1.3.2.4.18.2");
		templateId.setExtension("COCD_TP145200GB01#assignedPerson");

		//create fake person, do a bit of a sick in the nearest bin.
		PN namedPerson = of.createPN();
		assignedPerson.getName().add(namedPerson);
		OctopusConsortium.Models.RCS.EnGiven givenName = of.createEnGiven();
		givenName.setContent("Online");
		OctopusConsortium.Models.RCS.EnFamily familyName = of.createEnFamily();
		familyName.setContent("User");
		namedPerson.getContent().add(of.createENGiven(givenName));
		namedPerson.getContent().add(of.createENFamily(familyName));	
		
		assignedAuthor.setRepresentedOrganization(of.createPOCDMT000002UK01Organization());
		assignedAuthor.getRepresentedOrganization().setClassCode("ORG");
		assignedAuthor.getRepresentedOrganization().getDeterminerCode().add("INSTANCE");
		
		ii = of.createII();
		assignedAuthor.getRepresentedOrganization().getId().add(ii);
		ii.setRoot("2.16.840.1.113883.2.1.3.2.4.19.1");
		ii.setExtension(commonValues.ODS_ORGANISATION_CODE);
		ON on = of.createON();
		assignedAuthor.getRepresentedOrganization().getName().add(on);
		provider = provider == null ? provider = commonValues.getOrganisation_Name() : provider;
		on.getContent().add(provider);
		ii = of.createII();
		assignedAuthor.getRepresentedOrganization().getTemplateId().add(ii);
		ii.setRoot("2.16.840.1.113883.2.1.3.2.4.18.2");
		ii.setExtension("COCD_TP145200GB01#representedOrganization");
		author.setAssignedAuthor(assignedAuthor);
		return author;
	}
	
	public POCDMT000002UK01Custodian  CreateCustodian(ObjectFactory of) {
		
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
	
	public static POCDMT000002UK01IntendedRecipient CreateInformationRecipientOrganizationUniversal (
			ObjectFactory of, GPPractice gpInfo, String recipientId) throws OctopusConsortium.Core.InvalidMessageException {
		
		if(gpInfo==null)
			throw new OctopusConsortium.Core.InvalidMessageException("GPPractice is null");
		POCDMT000002UK01IntendedRecipient recipent = of.createPOCDMT000002UK01IntendedRecipient();
		recipent.setClassCode("ASSIGNED");
		AD addr = of.createAD();
		
		if(gpInfo.getAddress()!=null) {
			
			if (gpInfo.getAddress().getStreetAddressLine1() != null && !gpInfo.getAddress().getStreetAddressLine1().isEmpty()) {
				AD.StreetAddressLine addline1 = new StreetAddressLine();
				addline1.setContent(gpInfo.getAddress().getStreetAddressLine1());
				addr.getContent().add(of.createADStreetAddressLine(addline1));
			}
			
			if (gpInfo.getAddress().getStreetAddressLine2() != null && !gpInfo.getAddress().getStreetAddressLine2().isEmpty()) {
				AD.StreetAddressLine addline2 = new StreetAddressLine();
				addline2.setContent(gpInfo.getAddress().getStreetAddressLine2());
				addr.getContent().add(of.createADStreetAddressLine(addline2));
			}
			
			if (gpInfo.getAddress().getStreetAddressLine3() != null && !gpInfo.getAddress().getStreetAddressLine3().isEmpty()) {			
				AD.StreetAddressLine addline3 = new StreetAddressLine();
				addline3.setContent(gpInfo.getAddress().getStreetAddressLine3());
				addr.getContent().add(of.createADStreetAddressLine(addline3));
			}
			
			if (gpInfo.getAddress().getStreetAddressLine4() != null && !gpInfo.getAddress().getStreetAddressLine4().isEmpty()) {
				AD.StreetAddressLine addline4 = new StreetAddressLine();
				addline4.setContent(gpInfo.getAddress().getStreetAddressLine4());
				addr.getContent().add(of.createADStreetAddressLine(addline4));
			}
			
			if (gpInfo.getAddress().getStreetAddressLine5() != null && !gpInfo.getAddress().getStreetAddressLine5().isEmpty()) {
				AD.StreetAddressLine addline5 = new StreetAddressLine();
				addline5.setContent(gpInfo.getAddress().getStreetAddressLine5());
				addr.getContent().add(of.createADStreetAddressLine(addline5));
			}
			
			if (gpInfo.getAddress().getPostalCode() != null && !gpInfo.getAddress().getPostalCode().isEmpty()) {
				AD.PostalCode addpost = new PostalCode();
				addpost.setContent(gpInfo.getAddress().getPostalCode());
				addr.getContent().add(of.createADPostalCode(addpost));
			}

			if (addr.getContent().size() > 0) //don't add empty element
				recipent.getAddr().add(addr);
		}
				
		if (gpInfo.getTelephone() != null && !gpInfo.getTelephone().isEmpty()){
			TEL tel = of.createTEL();
			recipent.getTelecom().add(tel);
			tel.setValue("tel:" + gpInfo.getTelephone().replaceAll("\\s+",""));
		}
		
		II ii = of.createII();
		recipent.getTemplateId().add(ii);
		ii.setRoot("2.16.840.1.113883.2.1.3.2.4.18.2");
		ii.setExtension("COCD_TP145203GB03#IntendedRecipient");
		
		recipent.setReceivedOrganization(of.createPOCDMT000002UK01Organization());		
		recipent.getReceivedOrganization().setClassCode("ORG");
		recipent.getReceivedOrganization().getDeterminerCode().add("INSTANCE");
		ii = of.createII();
		recipent.getReceivedOrganization().getId().add(ii);
		
		ii.setExtension(recipientId);
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
		
	public static POCDMT000002UK01Informant12 createInformant(ObjectFactory of, IITKPatient patient)
	{
		Address homeAddress = null;	
		String telMob = null;
		String telHome = null;
		
		//add address
		if(patient.getHomeAddress() != null)
		{
			homeAddress = patient.getHomeAddress();
			telMob = "";
		}
		
		if (patient.getTelephoneNumber() != null && !patient.getTelephoneNumber().isEmpty()) {
			telHome = patient.getTelephoneNumber().replaceAll("\\s+","");
		}
		
		InformantType cdaInformantType = patient.getInformantType();
		String informantName = patient.getInformantContactName();
		String email = patient.getEmailAddress();
		
		return createInformantRelatedEntity(of,homeAddress,cdaInformantType,telHome,telMob, email,informantName);	
	}
	
	public POCDMT000002UK01RecordTarget CreateRecordTarget(ObjectFactory of, IITKPatient patient, String externalReference, String journeyId) throws OctopusConsortium.Core.InvalidMessageException {
		POCDMT000002UK01RecordTarget  target = of.createPOCDMT000002UK01RecordTarget();
		target.getTypeCode().add("RCT");
		target.getContextControlCode().add("OP");
		target.setContentId(of.createTemplateContent());
		target.getContentId().setRoot("2.16.840.1.113883.2.1.3.2.4.18.16");
		target.getContentId().setExtension("COCD_TP145201GB01#PatientRole");
		POCDMT000002UK01PatientRole patientRole = of.createPOCDMT000002UK01PatientRole();
		target.setPatientRole(patientRole);
		
		patientRole.getClassCode().add("PAT");
		
		if (patient.getHomeAddress() != null) {
			patientRole.getAddr().add(CreateRecordTargetAddress(of, patient.getHomeAddress(),CsPostalAddressUse.HP));
		}
		
		if (patient.getCurrentAddress() != null) {
			patientRole.getAddr().add(CreateRecordTargetAddress(of, patient.getCurrentAddress(),CsPostalAddressUse.PHYS));
		}
		
		if(patient.getNhsNumber() != null && !patient.getNhsNumber().isEmpty())
		{	
			II nhsNumber = of.createII();
			//Root for a verified NHS Number: 
			nhsNumber.setRoot("2.16.840.1.113883.2.1.4.1");
			nhsNumber.setExtension(patient.getNhsNumber());
			patientRole.getId().add(nhsNumber);
		}

		if (externalReference != null && !externalReference.isEmpty()){
			II friendlyReference = of.createII();
			//Root for local generated id, to be supplied with who generated it
			friendlyReference.setRoot("2.16.840.1.113883.2.1.3.2.4.18.24");
			friendlyReference.setExtension(externalReference);
			friendlyReference.setAssigningAuthorityName(commonValues.ODS_ORGANISATION_CODE + ":" + commonValues.ODS_ASSIGNING_AUTHORITY_NAME);
			patientRole.getId().add(friendlyReference);
		}else if (journeyId != null && !journeyId.isEmpty()){
			II journeyReference = of.createII();
			//Root for local generated id, to be supplied with who generated it
			journeyReference.setRoot("2.16.840.1.113883.2.1.3.2.4.18.24");
			journeyReference.setExtension(journeyId);
			journeyReference.setAssigningAuthorityName(commonValues.ODS_ORGANISATION_CODE + ":" + commonValues.ODS_ASSIGNING_AUTHORITY_NAME);
			patientRole.getId().add(journeyReference);
		}
		
		if (patient.getInformantType() == InformantType.Self && patient.getTelephoneNumber() != null && !patient.getTelephoneNumber().isEmpty())
		{
			// add telephone details
			TEL tel = null;
			
			tel = of.createTEL();
			tel.getUse().add(CsTelecommunicationAddressUse.HP);
			tel.setValue("tel:" + patient.getTelephoneNumber().replaceAll("\\s+",""));
			patientRole.getTelecom().add(tel);
			
			tel = of.createTEL();
			tel.getUse().add(CsTelecommunicationAddressUse.EC);
			tel.setValue("tel:" + patient.getTelephoneNumber().replaceAll("\\s+",""));
			patientRole.getTelecom().add(tel);
		}

		if (patient.getInformantType() == InformantType.Self && patient.getEmailAddress() != null && !patient.getEmailAddress().isEmpty())
		{
			TEL email = null;
			
			email = of.createTEL();
			email.getUse().add(CsTelecommunicationAddressUse.HP);
			email.setValue("mailto:" + patient.getEmailAddress());
			patientRole.getTelecom().add(email);
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
		if(patient.getDateOfBirth()!= null)
		{
			if(patient.getDateOfBirth().getDob() != null){
				DateFormat df = new SimpleDateFormat("yyyyMMdd");		
				String DOB = df.format( patient.getDateOfBirth().getDob().toGregorianCalendar().getTime() );
				patientRole.getPatient().getBirthTime().setValue(DOB);
			}else if(patient.getDateOfBirth().getYearOfBirth() != null){				
				patientRole.getPatient().getBirthTime().setValue(patient.getDateOfBirth().getYearOfBirth().toString());
			}else if(patient.getDateOfBirth().getAge() != null){
				if(patient.getDateOfBirth().getAge().type == AgeType.Years){
					Calendar cal = Calendar.getInstance();
					cal.add(Calendar.YEAR, 0 - patient.getDateOfBirth().getAge().value);
					Integer year = cal.get(Calendar.YEAR);
					patientRole.getPatient().getBirthTime().setValue(year.toString());
				}else if(patient.getDateOfBirth().getAge().type == AgeType.Months){
					Calendar cal = Calendar.getInstance();
					cal.add(Calendar.MONTH, 0 - patient.getDateOfBirth().getAge().value);
					DateFormat df = new SimpleDateFormat("yyyyMM");
					String DOB = df.format( cal.getTime() );
					patientRole.getPatient().getBirthTime().setValue(DOB);
				}if(patient.getDateOfBirth().getAge().type == AgeType.Days){
					Calendar cal = Calendar.getInstance();
					cal.add(Calendar.DATE, 0 - patient.getDateOfBirth().getAge().value);
					DateFormat df = new SimpleDateFormat("yyyyMMdd");
					String DOB = df.format( cal.getTime() );
					patientRole.getPatient().getBirthTime().setValue(DOB);
				}
			}else{
				patientRole.getPatient().getBirthTime().setNullFlavor(CsNullFlavor.UNK);
			}
		}else{
			patientRole.getPatient().getBirthTime().setNullFlavor(CsNullFlavor.UNK);
		}
		
		if(patient.getGpPractice() != null)
		{	
			patientRole.setProviderOrganization(of.createPOCDMT000002UK01Organization());			
			
			POCDMT000002UK01Organization providerOrganisation = patientRole.getProviderOrganization();
			providerOrganisation.setClassCode("ORG");
			providerOrganisation.getDeterminerCode().add("INSTANCE");
		
			ii = of.createII();
			providerOrganisation.getTemplateId().add(ii);
			ii.setRoot("2.16.840.1.113883.2.1.3.2.4.18.2");
			ii.setExtension("COCD_TP145201GB01#providerOrganization");
			
			ii = of.createII();
			providerOrganisation.getId().add(ii);
			ii.setRoot("2.16.840.1.113883.2.1.3.2.4.19.1");
			ii.setExtension(patient.getGpPractice().getODS());
			
			ON on = of.createON();
			providerOrganisation.getName().add(on);
			on.getContent().add(patient.getGpPractice().getName());
			
			if (patient.getGpPractice().getTelephone() != null && !patient.getGpPractice().getTelephone().isEmpty()) {
				TEL tel = of.createTEL();
				providerOrganisation.getTelecom().add(tel);
  
				if(!patient.getGpPractice().getTelephone().startsWith("tel:")) {
					patient.getGpPractice().setTelephone("tel:" + patient.getGpPractice().getTelephone());
				}
				tel.setValue(patient.getGpPractice().getTelephone().replaceAll("\\s+", ""));
				tel.getUse().add(CsTelecommunicationAddressUse.WP);
			}
			
			providerOrganisation.getAddr().add(CreateRecordTargetAddress(of, patient.getGpPractice().getAddress(), CsPostalAddressUse.WP));
			
			CE industryClassCode = of.createCE();
			industryClassCode.setCode("001");
			industryClassCode.setDisplayName("GP Practice");
			industryClassCode.setCodeSystem("2.16.840.1.113883.2.1.3.2.4.17.289");
			
			providerOrganisation.setStandardIndustryClassCode(industryClassCode);
		}
		
		PN name = of.createPN();
		//if(patient.getForename()!=null)
		//{
			OctopusConsortium.Models.RCS.EnGiven g = of.createEnGiven();
			g.setContent(patient.getForename());
			name.getContent().add(of.createENGiven(g));
		//}
		//if(patient.getSurname()!=null)
		//{
			OctopusConsortium.Models.RCS.EnFamily f = of.createEnFamily();
			f.setContent(patient.getSurname());
			name.getContent().add(of.createENFamily(f));
		//}
		
		patientRole.getPatient().getName().add(name);
		
		ii = of.createII();
		patientRole.getPatient().getTemplateId().add(ii);
		ii.setRoot("2.16.840.1.113883.2.1.3.2.4.18.2");
		ii.setExtension("COCD_TP145201GB01#patientPatient");
		
		return target;
	}
	
	public static POCDMT000002UK01StructuredBody createStructuredBody(ObjectFactory of,SubmitToCallQueueDetails caseDetails, byte[]summary, SubmitToServiceDetails serviceDetails) throws InvalidHascException
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
		
				
		//NHS111TextSection Patient’s Reported Condition
		POCDMT000002UK01Component5 sourceComponent = of.createPOCDMT000002UK01Component5();
		sourceComponent.setTypeCode("COMP");
		sourceComponent.setContextConductionInd(true);
		sourceComponent.setContentId(of.createTemplateContent());
		sourceComponent.getContentId().setRoot("2.16.840.1.113883.2.1.3.2.4.18.16");
		sourceComponent.getContentId().setExtension("COCD_TP146246GB01#Section1");	
		sourceComponent.setSection(CallQueueHelper.CreateSourceSection(of,caseDetails));
		
		if (!sourceComponent.getSection().getText().getContent().isEmpty()){
			csection.getComponent().add(sourceComponent);
		}
		
		//NHS111TextSection Pathways Disposition
		POCDMT000002UK01Component5 dispositionComponent = of.createPOCDMT000002UK01Component5();
		dispositionComponent.setTypeCode("COMP");
		dispositionComponent.setContextConductionInd(true);
		dispositionComponent.setContentId(of.createTemplateContent());
		dispositionComponent.getContentId().setRoot("2.16.840.1.113883.2.1.3.2.4.18.16");
		dispositionComponent.getContentId().setExtension("COCD_TP146246GB01#Section1");	
		dispositionComponent.setSection(CallQueueHelper.CreateDispositionSection(of,caseDetails,serviceDetails));
		
		if (!dispositionComponent.getSection().getText().getContent().isEmpty()){
			csection.getComponent().add(dispositionComponent);
		}
		
		//NHS111TextSection Consultation Summary
		POCDMT000002UK01Component5 consultationComponent = of.createPOCDMT000002UK01Component5();
		consultationComponent.setTypeCode("COMP");
		consultationComponent.setContextConductionInd(true);
		consultationComponent.setContentId(of.createTemplateContent());
		consultationComponent.getContentId().setRoot("2.16.840.1.113883.2.1.3.2.4.18.16");
		consultationComponent.getContentId().setExtension("COCD_TP146246GB01#Section1");	
		consultationComponent.setSection(CallQueueHelper.CreateConsultationSection(of,caseDetails));
				
		if (!consultationComponent.getSection().getText().getContent().isEmpty()){
			csection.getComponent().add(consultationComponent);
		}
		
		//NHS111TextSection Pathways Assessment
		POCDMT000002UK01Component5 assessmentComponent = of.createPOCDMT000002UK01Component5();
		assessmentComponent.setTypeCode("COMP");
		assessmentComponent.setContextConductionInd(true);
		assessmentComponent.setContentId(of.createTemplateContent());
		assessmentComponent.getContentId().setRoot("2.16.840.1.113883.2.1.3.2.4.18.16");
		assessmentComponent.getContentId().setExtension("COCD_TP146246GB01#Section1");	
		assessmentComponent.setSection(CallQueueHelper.CreateAssessmentSection(of,caseDetails));
		
		if (!assessmentComponent.getSection().getText().getContent().isEmpty()){
			csection.getComponent().add(assessmentComponent);
		}
		
		// add entry (original Hasc xml)
		POCDMT000002UK01Entry entry = createEntry(of,summary);
		
		if (entry != null){
			csection.getEntry().add(entry);
		}
		
		return body;
	}
	
	public static POCDMT000002UK01Entry createEntry(ObjectFactory of, byte[] summary)
	{
		if (summary == null || summary.length < 1)
			return null;
		
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
		observation.getValue().setContent(new String(summary));		
		
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
		//TODO: I Think this should be pathways schema version. May need to change
		device.getManufacturerModelName().setDisplayName("Pathways");
		device.setSoftwareName(of.createSC());
		device.getSoftwareName().setDisplayName("Pathways");
		device.getSoftwareName().setCode("2.4");
		ii = of.createII();
		ii.setRoot("2.16.840.1.113883.2.1.3.2.4.18.2");
		ii.setExtension("COCD_TP145000GB01#playingDevice");
		device.getTemplateId().add(ii);
		
		return entry;
	}
	
	public static POCDMT000002UK01Authorization CreateAuthorizationSection(ObjectFactory of){
		POCDMT000002UK01Authorization authorization = of.createPOCDMT000002UK01Authorization();
		authorization.getTypeCode().add("AUTH");
		authorization.setContentId(of.createTemplateContent());
		authorization.getContentId().setRoot("2.16.840.1.113883.2.1.3.2.4.18.16");
		authorization.getContentId().setExtension("COCD_TP146226GB02#Consent");
		
		authorization.setConsent(of.createPOCDMT000002UK01Consent());
		authorization.getConsent().getClassCode().add("CONS");
		authorization.getConsent().getMoodCode().add("EVN");
		
		II templateii = of.createII();
		templateii.setRoot("2.16.840.1.113883.2.1.3.2.4.18.2");
		templateii.setExtension("COCD_TP146226GB02#Consent");
		authorization.getConsent().getTemplateId().add(templateii);
		
		II consentii = of.createII();
		consentii.setRoot("A709A442-3CF4-476E-8377-377700E727C7");
		authorization.getConsent().getId().add(consentii);
		
		CE consentCode = of.createCE();
		consentCode.setCode("425691002");
		consentCode.setCodeSystem("2.16.840.1.113883.2.1.3.2.4.15");
		consentCode.setDisplayName("Consent given for electronic record sharing");
		
		authorization.getConsent().setCode(consentCode);
				
		CS statusCode = of.createCS();
		statusCode.setCode("completed");
		authorization.getConsent().setStatusCode(statusCode);
		
		return authorization;
	}
	
}