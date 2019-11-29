/**
 * 
 */
package OctopusConsortium.Core.Transformers.RCS;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.xml.bind.JAXBElement;

import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;

import OctopusConsortium.Core.CommonValues;
import OctopusConsortium.Models.RCS.COCDTP145200GB01AssignedAuthor;
import OctopusConsortium.Models.RCS.CsEntityNameUse;
import OctopusConsortium.Models.RCS.CsNullFlavor;
import OctopusConsortium.Models.RCS.EnGiven;
import OctopusConsortium.Models.RCS.IINPfITOidRequiredAssigningAuthorityName;
import OctopusConsortium.Models.RCS.IINPfITUuidMandatory;
import OctopusConsortium.Models.RCS.ObjectFactory;
import OctopusConsortium.Models.RCS.QUPAMT000001GB01PersonBirthTime;
import OctopusConsortium.Models.RCS.QUPAMT000001GB01PersonFamilyName;
import OctopusConsortium.Models.RCS.QUPAMT000001GB01PersonGivenName;
import OctopusConsortium.Models.RCS.QUPAMT000001GB01PersonId;
import OctopusConsortium.Models.RCS.QUPAMT000001GB01PersonId.Value;
import OctopusConsortium.Models.RCS.QUPAMT000001GB01PersonPostalCode;
import OctopusConsortium.Models.RCS.QUPAMT000001GB01PersonStreetAddressLine1;
import OctopusConsortium.Models.RCS.QUPAMT000001GB01RepeatCallerQuery;
import OctopusConsortium.Models.RCS.QUPAMT000001GB01RepeatCallerQuery.Code;
import OctopusConsortium.Models.RCS.QUPAMT000001GB01RepeatCallerQuery.EffectiveTime;
import OctopusConsortium.Models.RCS.ST;
import OctopusConsortium.Service.Models.IdentifyPatientResponse;
import OctopusConsortium.Service.Models.Patient;
import OctopusConsortium.Service.Models.SubmitEncounterResponse;

/**
 * @author stuart.yeates
 *
 */
public class IdentifyPatientResponseToRepeatCallerQuery extends
		AbstractTransformer {

	private CommonValues commonValues;
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
	
	
	public IdentifyPatientResponseToRepeatCallerQuery() {
		// TODO Auto-generated constructor stub
		super();
		this.registerSourceType(DataTypeFactory.create(OctopusConsortium.Service.Models.IdentifyPatientResponse.class));
		this.registerSourceType(DataTypeFactory.create(OctopusConsortium.Service.Models.SubmitEncounterResponse.class));
		this.registerSourceType(DataTypeFactory.create(OctopusConsortium.Service.Models.Patient.class));
		this.setReturnDataType(DataTypeFactory.create(OctopusConsortium.Models.RCS.QUPAMT000001GB01RepeatCallerQuery.class));
	}

	
	
	/* (non-Javadoc)
	 * @see org.mule.transformer.AbstractMessageTransformer#transformMessage(org.mule.api.MuleMessage, java.lang.String)
	 */
	@Override
	public Object doTransform(Object payload, String outputEncoding)
			throws TransformerException {
		
		Patient msg = null; 
		commonValues = new CommonValues(ods, orgName);
//		if(payload instanceof OctopusConsortium.Models.RepeatCallerRequest){
//			msg = ((IdentifyPatientResponseEnvelope) ((OctopusConsortium.Models.RepeatCallerRequest)payload).getPatientIdentity()).getPatient();
//		}else
		if(payload instanceof IdentifyPatientResponse){
			msg = ((IdentifyPatientResponse) payload).getPatient();
		}
		else if(payload instanceof SubmitEncounterResponse){
			msg = ((SubmitEncounterResponse) payload).getPatient();
		}
		else{
			msg =(Patient)payload;
		}
		return PopulateCallerQuery(msg);
		
	}

	//Populates root attributes and properties
	private QUPAMT000001GB01RepeatCallerQuery PopulateCallerQuery(Patient msg)
	{
		ObjectFactory of = new ObjectFactory();	
		QUPAMT000001GB01RepeatCallerQuery rcQuery = of.createQUPAMT000001GB01RepeatCallerQuery();
		
		rcQuery.setClassCode("CACT"); 
		rcQuery.setMoodCode("EVN");
		
		rcQuery.setCode(new Code());
		rcQuery.getCode().setCode("01");
		rcQuery.getCode().setCodeSystem("2.16.840.1.113883.2.1.3.2.4.17.420");
		
		Date now = Calendar.getInstance().getTime();
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		EffectiveTime edate = of.createQUPAMT000001GB01RepeatCallerQueryEffectiveTime();
		edate.setValue(df.format(now));
		rcQuery.setEffectiveTime(edate);
		
		rcQuery.setId(new IINPfITUuidMandatory());
		rcQuery.getId().setRoot(UUID.randomUUID().toString().toUpperCase());
		
		rcQuery.setQuery(of.createQUPAMT000001GB01Query());
		rcQuery.getQuery().setPersonBirthTime(PopulatePersonBirthTime(of,msg));
		rcQuery.getQuery().setPersonFamilyName(PopulatePersonFamilyName(of,msg));
		rcQuery.getQuery().setPersonGivenName(PopulatePersonGivenName(of,msg));
		rcQuery.getQuery().setPersonId(PopulatePersonID(of,msg));
		rcQuery.getQuery().setPersonPostalCode(PopulatePersonPostalCode(of,msg));
		rcQuery.getQuery().setPersonStreetAddressLine1(PopulatePersonAddressLine1(of,msg));
		
		
		rcQuery.setAuthor(of.createQUPAMT000001GB01Author());
		rcQuery.getAuthor().setTypeCode("AUT");
		rcQuery.getAuthor().getContextControlCode().add("OP");
		
		rcQuery.getAuthor().setContentId(of.createTemplateContent());		
		//rcQuery.getAuthor().getContentId().setAssigningAuthorityName(AssigningAuthorityName);
		rcQuery.getAuthor().getContentId().setRoot("2.16.840.1.113883.2.1.3.2.4.18.16");
		rcQuery.getAuthor().getContentId().setExtension("COCD_TP145200GB01#AssignedAuthor");
		
		//the AuthorPersonUniversal (COCD_TP145200GB01) schema is represented by class COCDTP145200GB01AssignedAuthor
		rcQuery.getAuthor().setCOCDTP145200GB01AssignedAuthor(CreateAuthorPersonUniversal(of));
			
		return rcQuery;
		
	}
	
	private COCDTP145200GB01AssignedAuthor CreateAuthorPersonUniversal(ObjectFactory of)
	{
		COCDTP145200GB01AssignedAuthor authorTemplate = of.createCOCDTP145200GB01AssignedAuthor();
		authorTemplate.setClassCode("ASSIGNED");
		
		authorTemplate.setCode(of.createCVNPfITCodedplainRequired());	
		authorTemplate.getCode().setNullFlavor(CsNullFlavor.NI);
		
		IINPfITOidRequiredAssigningAuthorityName aname = of.createIINPfITOidRequiredAssigningAuthorityName();
		aname.setNullFlavor(CsNullFlavor.NI);
		authorTemplate.getId().add(aname);
		
		/*
		IINPfITOidRequiredAssigningAuthorityName aname = of.createIINPfITOidRequiredAssigningAuthorityName();
		aname.setRoot("2.16.840.1.113883.2.1.3.2.4.18.24");
		aname.setExtension(CommonValues.ODS_ORGANISATION_CODE);
		aname.setAssigningAuthorityName(CommonValues.ODS_ASSIGNING_AUTHORITY_NAME);
		authorTemplate.getId().add(aname);
		*/
		
		authorTemplate.setTemplateId(of.createCOCDTP145200GB01AssignedAuthorTemplateId());
		authorTemplate.getTemplateId().setRoot("2.16.840.1.113883.2.1.3.2.4.18.2");
		authorTemplate.getTemplateId().setExtension("COCD_TP145200GB01#AssignedAuthor");
		
		
		//person is required so create a empty person
		authorTemplate.setAssignedPerson(of.createCOCDTP145200GB01Person());
		authorTemplate.getAssignedPerson().setClassCode("PSN");
		authorTemplate.getAssignedPerson().setDeterminerCode("INSTANCE");		
		authorTemplate.getAssignedPerson().setName(of.createPN());	
		authorTemplate.getAssignedPerson().getName().getUse().add(CsEntityNameUse.L);
		EnGiven given = of.createEnGiven();
		given.setContent("");//set a blank name
		authorTemplate.getAssignedPerson().getName().getContent().add(of.createENGiven(given));
		authorTemplate.getAssignedPerson().setTemplateId(of.createCOCDTP145200GB01PersonTemplateId());
		authorTemplate.getAssignedPerson().getTemplateId().setRoot("2.16.840.1.113883.2.1.3.2.4.18.2");
		authorTemplate.getAssignedPerson().getTemplateId().setExtension("COCD_TP145200GB01#assignedPerson");
		
		authorTemplate.setRepresentedOrganization(of.createCOCDTP145200GB01Organization());
		authorTemplate.getRepresentedOrganization().setClassCode("ORG");
		authorTemplate.getRepresentedOrganization().setDeterminerCode("INSTANCE");
		authorTemplate.getRepresentedOrganization().setId(of.createCOCDTP145200GB01OrganizationId());
		//authorTemplate.getRepresentedOrganization().getId().setAssigningAuthorityName(CommonValues.ODS_ASSIGNING_AUTHORITY_NAME);
		authorTemplate.getRepresentedOrganization().getId().setRoot("2.16.840.1.113883.2.1.3.2.4.19.1");
		authorTemplate.getRepresentedOrganization().getId().setExtension(commonValues.ODS_ORGANISATION_CODE);
		authorTemplate.getRepresentedOrganization().setName(of.createON());
		authorTemplate.getRepresentedOrganization().getName().getContent().add(commonValues.getOrganisation_Name());
		authorTemplate.getRepresentedOrganization().setTemplateId(of.createCOCDTP145200GB01OrganizationTemplateId());
		authorTemplate.getRepresentedOrganization().getTemplateId().setRoot("2.16.840.1.113883.2.1.3.2.4.18.2");
		authorTemplate.getRepresentedOrganization().getTemplateId().setExtension("COCD_TP145200GB01#representedOrganization");
		return authorTemplate;
	}
	
	private JAXBElement<QUPAMT000001GB01PersonBirthTime> PopulatePersonBirthTime(
			ObjectFactory of,Patient patient)
	{
		JAXBElement<QUPAMT000001GB01PersonBirthTime> jaxbe_birthTime = null;
		if(patient.getDOB()!=null)
		{
			QUPAMT000001GB01PersonBirthTime birthTime = of.createQUPAMT000001GB01PersonBirthTime();			
			QUPAMT000001GB01PersonBirthTime.Value ts = of.createQUPAMT000001GB01PersonBirthTimeValue();
			DateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd ");			
			ts.setValue(yyyyMMdd.format(patient.getDOB().toGregorianCalendar().getTime()).trim());
			birthTime.setValue(ts);			
			birthTime.setSemanticsText(of.createST());
			birthTime.getSemanticsText().setContent("Person.birthTime");
			jaxbe_birthTime = of.createQUPAMT000001GB01QueryPersonBirthTime(birthTime);
		}
		return jaxbe_birthTime;
	}
	
	private JAXBElement<QUPAMT000001GB01PersonFamilyName> PopulatePersonFamilyName(
			ObjectFactory of, Patient patient) 
	{
		JAXBElement<QUPAMT000001GB01PersonFamilyName> jaxbe_famName = null;
		if(patient.getSurname()!=null)
		{
			QUPAMT000001GB01PersonFamilyName famName = of.createQUPAMT000001GB01PersonFamilyName();			
			famName.setValue(new ST());
			famName.getValue().setContent(patient.getSurname());
			famName.setSemanticsText(of.createST());
			famName.getSemanticsText().setContent("Person.familyName");
			jaxbe_famName = of.createQUPAMT000001GB01QueryPersonFamilyName(famName);
		}
		return jaxbe_famName;
	}
	
	private JAXBElement<QUPAMT000001GB01PersonGivenName> PopulatePersonGivenName(
			ObjectFactory of, Patient patient) 
	{
		JAXBElement<QUPAMT000001GB01PersonGivenName> jaxbe_givenName = null;
		if(patient.getForename()!=null)
		{			
			QUPAMT000001GB01PersonGivenName givenName = of.createQUPAMT000001GB01PersonGivenName();
			givenName.setValue(new ST());
			givenName.getValue().setContent(patient.getForename());
			givenName.setSemanticsText(of.createST());
			givenName.getSemanticsText().setContent("Person.givenName");
			jaxbe_givenName= of.createQUPAMT000001GB01QueryPersonGivenName(givenName);
		}
		return jaxbe_givenName;
	}
	
	private JAXBElement<QUPAMT000001GB01PersonId> PopulatePersonID(
			ObjectFactory of, Patient patient) 
	{
		JAXBElement<QUPAMT000001GB01PersonId> jaxbe_id =null;
		if(patient.getNhsNumber()!=null)
		{
			QUPAMT000001GB01PersonId id = of.createQUPAMT000001GB01PersonId();
			id.setValue(new Value() );
			id.getValue().setRoot("2.16.840.1.113883.2.1.4.1");
			id.getValue().setExtension(patient.getNhsNumber());
			id.setSemanticsText(of.createST());
			id.getSemanticsText().setContent("Person.id");
			jaxbe_id = of.createQUPAMT000001GB01QueryPersonId(id);
		}
		return jaxbe_id;
	}
	
	private JAXBElement<QUPAMT000001GB01PersonPostalCode> PopulatePersonPostalCode(
			ObjectFactory of, Patient patient) 
	{
		JAXBElement<QUPAMT000001GB01PersonPostalCode> jaxbe_postcode =null;
		if(patient.getAddress()!=null && patient.getAddress().getPostalCode()!=null)
		{
			QUPAMT000001GB01PersonPostalCode postalCode = new QUPAMT000001GB01PersonPostalCode();
			postalCode.setValue(new ST());
			postalCode.getValue().setContent(patient.getAddress().getPostalCode());
			postalCode.setSemanticsText(of.createST());
			postalCode.getSemanticsText().setContent("Person.postalCode");
			jaxbe_postcode = of.createQUPAMT000001GB01QueryPersonPostalCode(postalCode);
		}
		return jaxbe_postcode;
	}
	
	private JAXBElement<QUPAMT000001GB01PersonStreetAddressLine1> PopulatePersonAddressLine1(
			ObjectFactory of, Patient patient) {
		JAXBElement<QUPAMT000001GB01PersonStreetAddressLine1> jaxbe_add1 =null;
		if(patient.getAddress()!=null)
		{
			QUPAMT000001GB01PersonStreetAddressLine1 add1=of.createQUPAMT000001GB01PersonStreetAddressLine1();
			add1.setValue(new ST());
			//add1.getValue().setContent(patient.getPatient().getAddress().getHouseNumber() 
			//		+ " " 
			//		+ patient.getPatient().getAddress().getStreetName());
			add1.getValue().setContent(patient.getAddress().getStreetAddressLine1());
			add1.setSemanticsText(of.createST());
			add1.getSemanticsText().setContent("Person.streetAddressLine1");
			jaxbe_add1 = of.createQUPAMT000001GB01QueryPersonStreetAddressLine1(add1);
		}
		return jaxbe_add1;
	}

	
}
