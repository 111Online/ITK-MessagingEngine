package OctopusConsortium.Core.Transformers.PathwaysCase;

import java.io.StringWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.apache.commons.codec.binary.Base64;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;
import org.xml.sax.SAXException;

import OctopusConsortium.Core.CommonValues;
import OctopusConsortium.Core.PathwaysValues;
import OctopusConsortium.Models.CombinedPayloads;
import OctopusConsortium.Models.CDA.InformantType;
import OctopusConsortium.Models.PathwaysCase2_4.*;
import OctopusConsortium.Service.Models.Address;
import OctopusConsortium.Service.Models.GPPractice;
import OctopusConsortium.Service.Models.SubmitEncounterToServiceRequest;
import OctopusConsortium.Service.Models.SubmitPatientService;
import OctopusConsortium.Service.Models.SubmitToCallQueueDetails;
import OctopusConsortium.Models.PathwaysTriage.Answer;
import OctopusConsortium.Models.PathwaysTriage.QuestionWithAnswers;

public class SubmitEncounterToServiceRequestToPathwaysCase extends AbstractTransformer
{
	private ObjectFactory pathwaysCaseObjectFactory;
	private SubmitEncounterToServiceRequest _encounter;
	private QuestionWithAnswers[] _questionWithAnswersList;
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

	private String _pathwaysSchema;

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	
	public SubmitEncounterToServiceRequest getEncounter() {
		return _encounter;
	}

	public void setEncounter(SubmitEncounterToServiceRequest encounter) {
		_encounter = encounter;
	}

	public QuestionWithAnswers[] getQuestionWithAnswersList() {
		return _questionWithAnswersList;
	}

	public void setQuestionWithAnswersList(QuestionWithAnswers[] questionWithAnswersList) {
		_questionWithAnswersList = questionWithAnswersList;
	}

	public String getPathwaysSchema(){
		return _pathwaysSchema;
	}
	
	public void setPathwaysSchema(String pathwaysSchema) {
		_pathwaysSchema = pathwaysSchema;
	}
		
	public SubmitEncounterToServiceRequestToPathwaysCase() throws DatatypeConfigurationException{
		super();
		pathwaysCaseObjectFactory = new ObjectFactory();
		
		this.registerSourceType(DataTypeFactory.create(OctopusConsortium.Models.CombinedPayloads.class));

		this.setReturnDataType(DataTypeFactory.create(String.class));
	}
	
	@Override
	protected Object doTransform(Object src, String enc) throws TransformerException {
		if (src instanceof OctopusConsortium.Models.CombinedPayloads) {
			CombinedPayloads payloads = (CombinedPayloads)src;
			
			if (payloads.getPayload1() instanceof SubmitEncounterToServiceRequest){
				setEncounter((SubmitEncounterToServiceRequest)payloads.getPayload1());
			}
			
			if (payloads.getPayload2() instanceof QuestionWithAnswers[]){
				setQuestionWithAnswersList((QuestionWithAnswers[])payloads.getPayload2());
			}
			
			commonValues = new CommonValues(ods,orgName);
			PathwaysCase pathwaysCase;
			try {
				pathwaysCase = convertToCase();
				
				return base64encode(convertToXml(pathwaysCase, getPathwaysSchema()));
			} catch (DatatypeConfigurationException e) {
				throw new TransformerException(this, e);
			}
		}
		return null;
	}
	
	public PathwaysCase convertToCase() throws DatatypeConfigurationException{
		
		PathwaysCase pathwaysCase = pathwaysCaseObjectFactory.createPathwaysCase();
		
		pathwaysCase.setServiceDestination(pathwaysCaseObjectFactory.createServiceDestination());
		pathwaysCase.getServiceDestination().setCode(Integer.toString(getEncounter().getServiceDetails().getId()));
		pathwaysCase.getServiceDestination().setName(getEncounter().getServiceDetails().getName());

		pathwaysCase.setMessageStatus(MessageStatusType.Complete);
		
		
		pathwaysCase.setOutcome(pathwaysCaseObjectFactory.createOutcome());
		pathwaysCase.getOutcome().setCode(getEncounter().getCaseDetails().getDispositionCode());
		pathwaysCase.getOutcome().setTitle(getEncounter().getCaseDetails().getDispositionName());

		pathwaysCase.setCaseDetails(pathwaysCaseObjectFactory.createCaseDetails());
		pathwaysCase.getCaseDetails().setCaseRef(getEncounter().getCaseDetails().getExternalReference());
		pathwaysCase.getCaseDetails().setAddress(ConvertAddress(getEncounter().getPatientDetails().getCurrentAddress()));
		pathwaysCase.getCaseDetails().setCondition(getEncounter().getCaseDetails().getConditionTitle());
		pathwaysCase.getCaseDetails().setContactDetails(CreateContactDetails(getEncounter().getPatientDetails()));
		
		pathwaysCase.setPatient(CreatePatient(getEncounter().getPatientDetails()));

		pathwaysCase.setReturnPhone(CreateReturnPhone(getEncounter().getPatientDetails()));
		
		pathwaysCase.setPathwayDetails(CreatePathwayDetails());
		
		pathwaysCase.setSite(CreateSite());
		
		TimeManipulation timeManipulation = new TimeManipulation();
		return timeManipulation.SetTimeStamps(pathwaysCase);
	}
	
	private Site CreateSite() {
		Site site = pathwaysCaseObjectFactory.createSite();
		site.setName(commonValues.getOrganisation_Name());
		site.setId(commonValues.ODS_ORGANISATION_CODE);
		return site;
	}

	private PathwayDetails CreatePathwayDetails() {
		PathwayDetails pathwayDetails = pathwaysCaseObjectFactory.createPathwayDetails();
		pathwayDetails.setDemographics(CreateDemographics(getEncounter().getPatientDetails()));
		pathwayDetails.setSharedCaseId(getEncounter().getCaseDetails().getExternalReference());
		pathwayDetails.setPathwayTriageDetails(CreatePathwaysTriageDetails());
		
		return pathwayDetails;
	}

	private PathwayTriageDetails CreatePathwaysTriageDetails() {
		PathwayTriageDetails triageDetails = pathwaysCaseObjectFactory.createPathwayTriageDetails();
		PathwayTriage triageDetail = pathwaysCaseObjectFactory.createPathwayTriage();
		triageDetails.getPathwayTriage().add(triageDetail);
		triageDetail.setTriageDisposition(pathwaysCaseObjectFactory.createTriageDisposition());
		triageDetail.getTriageDisposition().setInitialDispCode(getEncounter().getCaseDetails().getDispositionCode());
		triageDetail.getTriageDisposition().setInitialDispText(getEncounter().getCaseDetails().getDispositionName());
		
		triageDetail.setFinalDisposition(pathwaysCaseObjectFactory.createFinalDisposition());
		triageDetail.getFinalDisposition().setFinalDispCode(getEncounter().getCaseDetails().getDispositionCode());
		triageDetail.getFinalDisposition().setFinalDisptext(getEncounter().getCaseDetails().getDispositionName());
		
		triageDetail.setTransferCodeDetails(CreateTransferCodeDetails(getEncounter().getCaseDetails().getDispositionCode()));
		triageDetail.setSystemFlags(CreateSystemFlags(getEncounter().getCaseDetails()));
		triageDetail.setUser(CreateUser());
		triageDetail.setOrigSite(CreateOrigSite(getEncounter().getCaseDetails().getExternalReference()));
		
		triageDetail.setCallerIsPatient(CallerIsPatient());
		
		triageDetail.setTriageLineDetails(CreateTriageLineDetails());
		
		return triageDetails;
	}

	private boolean CallerIsPatient(){
		return (_encounter.getPatientDetails().getInformantType() == InformantType.Self);
	}
	
	private TriageLineDetails CreateTriageLineDetails() {
		TriageLineDetails triageLineDetails = pathwaysCaseObjectFactory.createTriageLineDetails();
		
        for(int i=0; i < getQuestionWithAnswersList().length; i++){

			QuestionWithAnswers questionWithAnswers = getQuestionWithAnswersList()[i];
			
			TriageLine triageLine = pathwaysCaseObjectFactory.createTriageLine();
			
			triageLine.setQuestionType(ConvertQuestionType(questionWithAnswers.getLabels()));
			if (triageLine.getQuestionType().equals(QuestionType.UNKNOWN)) continue;
										
			triageLine.setIncludeInReport(true);
			
			switch(triageLine.getQuestionType()){
				case Disposition:
					if (questionWithAnswers.getQuestion().getCareAdviceId() != null && !questionWithAnswers.getQuestion().getCareAdviceId().isEmpty()){
						triageLine.setDispositionInstruction(pathwaysCaseObjectFactory.createDispositionInstruction());
						triageLine.getDispositionInstruction().setId(questionWithAnswers.getQuestion().getCareAdviceId());
					}
					
					if (questionWithAnswers.getAnswers() != null && !questionWithAnswers.getAnswers().isEmpty()){
						Answer answer = questionWithAnswers.getAnswers().get(0);
						
						ItemDetails itemDetails = pathwaysCaseObjectFactory.createItemDetails();
						itemDetails.getItem().add(pathwaysCaseObjectFactory.createItem());
						itemDetails.getItem().get(0).setId(answer.getOrder().toString());
						itemDetails.getItem().get(0).setText(answer.getReportText());
						
						triageLine.getDispositionInstruction().setItemDetails(itemDetails);
					}

					triageLine.setReportText(pathwaysCaseObjectFactory.createReportText());
					if(questionWithAnswers.getQuestion().getReportText() != null && !questionWithAnswers.getQuestion().getReportText().isEmpty()){
						triageLine.getReportText().setText(questionWithAnswers.getQuestion().getReportText());
					}else{
						triageLine.getReportText().setText("");
					}
					
					triageLine.setAction(TriageLineActionType.Next);
					
					break;
				case InterimCareAdvice:	
					CareAdvice careAdvice = pathwaysCaseObjectFactory.createCareAdvice();
					careAdvice.setId(questionWithAnswers.getQuestion().getCareAdviceId());
					careAdvice.setTopic(questionWithAnswers.getQuestion().getTopic());
					
					if (!questionWithAnswers.getAnswers().isEmpty()) {
						careAdvice.setItemDetails(pathwaysCaseObjectFactory.createItemDetails());
						
						for(Iterator<Answer> iterator = questionWithAnswers.getAnswers().iterator(); iterator.hasNext();){
							Answer careAdviceItem = iterator.next();
							
							Item item = pathwaysCaseObjectFactory.createItem();			
							item.setId(careAdviceItem.getOrder().toString());
							item.setText(careAdviceItem.getTitle());
							
							careAdvice.getItemDetails().getItem().add(item);
						}
					}
					
					triageLine.setCareAdviceDetails(pathwaysCaseObjectFactory.createCareAdviceDetails());
					triageLine.getCareAdviceDetails().getCareAdvice().add(careAdvice);
					
					triageLine.setReportText(pathwaysCaseObjectFactory.createReportText());
					triageLine.getReportText().setText("Advice given: " + questionWithAnswers.getQuestion().getTopic());
					
					triageLine.setAction(TriageLineActionType.End);
					break;
				default:
					triageLine.setQuestion(pathwaysCaseObjectFactory.createQuestion());
					Question question = triageLine.getQuestion();
					question.setTriageLogicId(pathwaysCaseObjectFactory.createTriageLogicId());
					question.getTriageLogicId().setPathwayVersion(CreatePathwayVersion(questionWithAnswers));
					
					String[] pathwayId = questionWithAnswers.getQuestion().getId().split("\\.");
					if (pathwayId.length == 2){
						question.getTriageLogicId().setPathwayId(pathwayId[0]);
						question.getTriageLogicId().setPathwayOrderNo(pathwayId[1]);
					}
					
					question.setQuestionId(questionWithAnswers.getQuestion().getQuestionNo());
					
					if (questionWithAnswers.getQuestion().getTitle() != null) {
						question.setQuestionText(questionWithAnswers.getQuestion().getTitle());
					}
					else {
						question.setQuestionText("");
					}
					
					if (ShouldIncludeQuestionRationale(questionWithAnswers)) {
						question.setQuestionRationale(questionWithAnswers.getQuestion().getRationale());
					}
					
					if (ShouldIncludeDispositionRationale(questionWithAnswers.getAnswered())) {
						question.setDispositionRationale(CreateDispositionRationale(questionWithAnswers.getAnswered()));
					}
					
					if (ShouldIncludeUserComment(questionWithAnswers.getAnswered())){
						triageLine.setUserComment(questionWithAnswers.getAnswered().getSpecifyText());
					}
					
					question.setAnswers(CreateAnswers(questionWithAnswers.getAnswers(), questionWithAnswers.getAnswered(), triageLine.getQuestionType()));
					
					triageLine.setReportText(pathwaysCaseObjectFactory.createReportText());
					triageLine.getReportText().setText(questionWithAnswers.getAnswered().getReportText());
					triageLine.getReportText().setPositive(questionWithAnswers.getAnswered().getIsPositive());
					
					triageLine.setAction(TriageLineActionType.Next);
					break;
			}
			
			triageLineDetails.getTriageLine().add(triageLine);
		}
		return triageLineDetails;
	}
	
	private boolean ShouldIncludeQuestionRationale(QuestionWithAnswers questionWithAnswers) {
		return (questionWithAnswers.getQuestion().getRationale() != null && !questionWithAnswers.getQuestion().getRationale().isEmpty());
	}
	
	private boolean ShouldIncludeDispositionRationale(Answer answer) {
		if (answer.getDispoDisplayText() != null && !answer.getDispoDisplayText().isEmpty())
			return true;
		else
			return false;
	}
	
	private boolean ShouldIncludeUserComment(Answer answer) {
		if (answer.getSpecifyText() != null && !answer.getSpecifyText().isEmpty())
			return true;
		else
			return false;
	}
	
	private DispositionRationale CreateDispositionRationale(Answer answer) {
		String rationaleTerm = answer.getDispoDisplayText();
		
		DispositionRationale dispoRationale = pathwaysCaseObjectFactory.createDispositionRationale();
		dispoRationale.setTerm(rationaleTerm);
		dispoRationale.setCode("");
		return dispoRationale;
	}

	private Answers CreateAnswers(List<Answer> answers, Answer answered, QuestionType questionType) {
		Answers answersResult = pathwaysCaseObjectFactory.createAnswers();
		
		if (!questionType.equals(QuestionType.MultipleChoice)){
			if((answers == null || answers.isEmpty()) && answered != null){
				answers = new ArrayList<Answer>();
				answers.add(answered);
			}
		}
		
		for(Iterator<Answer> i = answers.iterator(); i.hasNext();){
			Answer answer = i.next();
			OctopusConsortium.Models.PathwaysCase2_4.Answer answerResult = pathwaysCaseObjectFactory.createAnswer();
			answerResult.setText(answer.getTitle());
			answerResult.setRationale(answer.getSupportingInfo());
			
			if (questionType.equals(QuestionType.MultipleChoice)){
				answerResult.setSelected(true);
			}
			else {
				answerResult.setSelected(answer.getOrder() == answered.getOrder());
			}
						
			answersResult.getAnswer().add(answerResult);
		}
		
		return answersResult;
	}
	
	private QuestionType ConvertQuestionType(List<String> typeList){
		if (typeList.isEmpty()) return QuestionType.UNKNOWN;
		
		switch(typeList.get(0)){
			case "Question":return QuestionType.SingleAnswer;
			case "Set":return QuestionType.SetVariable;
			case "Read":return QuestionType.QueryVariable;
			case "Outcome":return QuestionType.Disposition;
			case "CareAdvice": return QuestionType.MultipleChoice;
			case "InterimCareAdvice": return QuestionType.InterimCareAdvice;
			default: return QuestionType.UNKNOWN; //Unknown type, or not mapped as a pathways 'question' e.g. 'Pathway'
		}
	}
	
	private SystemFlag ConvertConditionType(String type){
		switch(type.toLowerCase()){
			case "trauma":return SystemFlag.Trauma;
			case "non trauma":return SystemFlag.NonTrauma;
			case "nontrauma":return SystemFlag.NonTrauma;
			default: return SystemFlag.UNKNOWN; //Unknown type
		}
	}
	
	private OrigSite CreateOrigSite(String externalReference) {
		OrigSite origSite = pathwaysCaseObjectFactory.createOrigSite();
		origSite.setCaseId(externalReference);
		origSite.setPathwaysContentVersion(CreatePathwayBaseVersion());
		
		origSite.setSiteId(commonValues.ODS_ORGANISATION_CODE);
		origSite.setSiteName(commonValues.getOrganisation_Name());
		origSite.setSoftware(pathwaysCaseObjectFactory.createSoftware());
		origSite.getSoftware().setProductName(CommonValues.SOFTWARE_NAME);
		origSite.getSoftware().setVersion(CommonValues.APP_VERSION);

		return origSite;
	}
	
	private PathwayVersion CreatePathwayBaseVersion(){
		PathwayVersion pathwaysVersion = pathwaysCaseObjectFactory.createPathwayVersion();
		pathwaysVersion.setMajor(PathwaysValues.PATHWAYSMAJORVERSION);
		pathwaysVersion.setMinor(PathwaysValues.PATHWAYSMINORVERSION);
		pathwaysVersion.setSubRevision(PathwaysValues.PATHWAYSSUBMINORVERSION);
		
		return pathwaysVersion;
	}

	private PathwayVersion CreatePathwayVersion(QuestionWithAnswers questionWithAnswers){
		PathwayVersion result = new PathwayVersion();
		 
		if (questionWithAnswers.getAssociatedPathway() == null 
			|| questionWithAnswers.getAssociatedPathway().getMajorVersion() == null
			|| questionWithAnswers.getAssociatedPathway().getMinorVersion() == null
			|| questionWithAnswers.getAssociatedPathway().getSubRevision() == null
			|| questionWithAnswers.getAssociatedPathway().getMajorVersion().isEmpty() 
			|| questionWithAnswers.getAssociatedPathway().getMinorVersion().isEmpty()
			|| questionWithAnswers.getAssociatedPathway().getSubRevision().isEmpty()
		){
			result = CreatePathwayBaseVersion();
		}
		else{
			result.setMajor(RemoveNonNumericCharsFromVersion(questionWithAnswers.getAssociatedPathway().getMajorVersion()));
			result.setMinor(RemoveNonNumericCharsFromVersion(questionWithAnswers.getAssociatedPathway().getMinorVersion()));
			result.setSubRevision(RemoveNonNumericCharsFromVersion(questionWithAnswers.getAssociatedPathway().getSubRevision()));
		}
		
		return result;
	}
	
	private int RemoveNonNumericCharsFromVersion(String version){
		return Integer.parseInt(version.replaceAll("[^0-9]", ""));
	}
	
	private User CreateUser() {
		User user = pathwaysCaseObjectFactory.createUser();
		user.setName(commonValues.getOrganisation_Name());
		user.setSkillSet(PathwaysValues.PATHWAYSSKILLSET);
		user.setId(commonValues.MANUFACTURER_NAME);
		return user;
	}

	private SystemFlags CreateSystemFlags(SubmitToCallQueueDetails callDetails) {
		SystemFlags systemFlags = pathwaysCaseObjectFactory.createSystemFlags();
		systemFlags.getSystemFlag().add(ConvertConditionType(callDetails.getConditionType()));
		return systemFlags;
	}

	private TransferCodeDetails CreateTransferCodeDetails(String dispositionCode) {
		TransferCodeDetails transferCodeDetails = pathwaysCaseObjectFactory.createTransferCodeDetails();
		TransferCode t1 = pathwaysCaseObjectFactory.createTransferCode();
		t1.setType(TransferCodeType.T1);
		t1.setValue(dispositionCode);
		transferCodeDetails.getTransferCode().add(t1);
		
		TransferCode t2 = pathwaysCaseObjectFactory.createTransferCode();
		t2.setType(TransferCodeType.T2);
		t2.setValue(dispositionCode);
		transferCodeDetails.getTransferCode().add(t2);
		
		TransferCode t3 = pathwaysCaseObjectFactory.createTransferCode();
		t3.setType(TransferCodeType.T3);
		t3.setValue(dispositionCode);
		transferCodeDetails.getTransferCode().add(t3);
		
		TransferCode t4 = pathwaysCaseObjectFactory.createTransferCode();
		t4.setType(TransferCodeType.T4);
		t4.setValue(dispositionCode);
		transferCodeDetails.getTransferCode().add(t4);
		
		return transferCodeDetails;
	}

	private Demographics CreateDemographics(SubmitPatientService patientDetails){
		Demographics demographics = pathwaysCaseObjectFactory.createDemographics();
		demographics.setAgeGroup(patientDetails.getAgeGroup());
		demographics.setGender(patientDetails.getGender().toString());
		
		return demographics;
	}
	
	private ReturnPhone CreateReturnPhone(SubmitPatientService patientDetails){
		ReturnPhone returnPhone = pathwaysCaseObjectFactory.createReturnPhone();
		returnPhone.setNumber(patientDetails.getTelephoneNumber());
		return returnPhone;
	}
	
	private Patient CreatePatient(SubmitPatientService patientDetails){
		Patient patient = pathwaysCaseObjectFactory.createPatient();
		patient.setAddress(ConvertAddress(patientDetails.getHomeAddress()));
		patient.setDateOfBirth(pathwaysCaseObjectFactory.createDateOfBirth());
		patient.getDateOfBirth().setDob(pathwaysCaseObjectFactory.createDob());
		patient.getDateOfBirth().getDob().setValue(patientDetails.getDateOfBirth().getDob());
		patient.setForename(patientDetails.getForename());
		patient.setSurname(patientDetails.getSurname());
		patient.setGender(patientDetails.getGender().toString());

		if (patientDetails.getNhsNumber() != null && !patientDetails.getNhsNumber().isEmpty()){
			patient.setNationalNumber(patientDetails.getNhsNumber());
		}

		if (patientDetails.getGpPractice() != null){
			patient.setProviderDetails(CreateProviderDetails(patientDetails.getGpPractice()));
		}
		
		return patient;
	}

	private ProviderDetails CreateProviderDetails(GPPractice gpPractice){
		ProviderDetails providerDetails = pathwaysCaseObjectFactory.createProviderDetails();
		providerDetails.setProviderGroup(pathwaysCaseObjectFactory.createProviderGroup());
		providerDetails.getProviderGroup().setName(gpPractice.getName());
		providerDetails.getProviderGroup().setId(gpPractice.getODS());
		providerDetails.setType(ProviderDetailsType.DOCTOR);
		
		return providerDetails;
	}
		
	private ContactDetails CreateContactDetails(SubmitPatientService patientDetails) {
		ContactDetails contactDetails = pathwaysCaseObjectFactory.createContactDetails();
		
		if (patientDetails.getInformantType() == InformantType.Self){
			PatientPhone patientPhone = pathwaysCaseObjectFactory.createPatientPhone();
			patientPhone.setNumber(patientDetails.getTelephoneNumber());
			
			contactDetails.getCallerOrPatientPhone().add(patientPhone);
		}else{
			Caller caller = pathwaysCaseObjectFactory.createCaller();
			caller.setName(patientDetails.getInformantContactName());
			caller.setPhone(pathwaysCaseObjectFactory.createPhone());
			caller.getPhone().setNumber(patientDetails.getTelephoneNumber());;
			
			contactDetails.getCallerOrPatientPhone().add(caller);			
		}
		
		return contactDetails;
	}

	private OctopusConsortium.Models.PathwaysCase2_4.Address ConvertAddress(Address addressIn){
		OctopusConsortium.Models.PathwaysCase2_4.Address addressOut = pathwaysCaseObjectFactory.createAddress();
		
		addressOut.setBuilding(MapAddressField(addressIn.getStreetAddressLine1()));
		addressOut.setStreet(MapAddressField(addressIn.getStreetAddressLine2()));
		addressOut.setLocality(MapAddressField(addressIn.getStreetAddressLine3()));
		addressOut.setTown(MapAddressField(addressIn.getStreetAddressLine4()));
		addressOut.setCounty(MapAddressField(addressIn.getStreetAddressLine5()));
		addressOut.setPostcode(MapAddressField(addressIn.getPostalCode()));
		
		return addressOut;
	}
	
	private String MapAddressField(String addressPartIn) {
		if (addressPartIn != null)
			return addressPartIn;
		else
			return "";
	}

	private String convertToXml(PathwaysCase pathwaysCase, String schemaToValidate){
		try 
		{			
			JAXBContext jaxbContext = JAXBContext.newInstance(PathwaysCase.class);
	
			StringWriter sw = new StringWriter();
			Marshaller marshaller = jaxbContext.createMarshaller();
			
			if (schemaToValidate != null && !schemaToValidate.isEmpty()){
				SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
				URL schemaUrl = getClass().getResource(schemaToValidate);
				Schema schema = schemaFactory.newSchema(schemaUrl); 
				marshaller.setSchema(schema);
			}
			
			marshaller.setProperty("com.sun.xml.bind.xmlDeclaration", Boolean.FALSE);
			marshaller.marshal(pathwaysCase, sw);
	
			return sw.toString();
		}
		catch (JAXBException e)
		{
			e.printStackTrace();
			return new String();
		}
		catch (SAXException e)
		{
			e.printStackTrace();
			return new String();
		}
	}
	
	public String base64encode(String xmlString){
		return new String(Base64.encodeBase64(xmlString.getBytes()));
	}
}