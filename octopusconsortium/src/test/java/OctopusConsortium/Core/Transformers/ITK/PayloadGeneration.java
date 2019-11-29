package OctopusConsortium.Core.Transformers.ITK;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.apache.commons.codec.binary.Base64;

import OctopusConsortium.Models.CDA.InformantType;
import OctopusConsortium.Service.Models.Address;
import OctopusConsortium.Service.Models.DataInstance;
import OctopusConsortium.Service.Models.DateOfBirth;
import OctopusConsortium.Service.Models.GPPractice;
import OctopusConsortium.Service.Models.Gender;
import OctopusConsortium.Service.Models.SubmitEncounterToServiceRequest;
import OctopusConsortium.Service.Models.SubmitPatientCallback;
import OctopusConsortium.Service.Models.SubmitPatientEnquiry;
import OctopusConsortium.Service.Models.SubmitPatientService;
import OctopusConsortium.Service.Models.SubmitToCallQueueCallbackRequest;
import OctopusConsortium.Service.Models.SubmitToCallQueueDetails;
import OctopusConsortium.Service.Models.SubmitToCallQueueEnquiryRequest;
import OctopusConsortium.Service.Models.SubmitToServiceDetails;

public class PayloadGeneration {
	//correct values assigned, to be checked in asserts
	final static String dispositionPrefix = "Dx";
	final static String dispositionCode = "46";
	final static String dispositionName = "dispo name";
	final static String recipientOdsCode = "RHY HHY";
	final static int recipientDosId = 12358;
	final static String journeyId =  "131b7c5f-dd68-45ce-b7b9-6b8aff9a19b8";
	final static String externalReference = "111-online-1A2B3";
	final static String recipientPostCode = "POST C0D3";
	final static String assessName = SummaryType.ReportText.toString();
	final static String assessCaption = "Was there vomiting";
	final static String assessAnswer = "There was vomiting";
	final static String conSumName = SummaryType.DispositionDisplayText.toString();
	final static String conSumCaption = "Was there vomiting";
	final static String conSumAnswer = "The pain interfered with normal activity";
	final static String source = "Abdominal Pain";
	final static String patientEmail = "test@nhsdirect.nhs.uk";
	final static String patientTelephone = "118 118";
	final static String patientForename = "Billy";
	final static String patientSurname = "Bob";
	final static String patientHomeAddress3 = "H3 Town";
	final static String patientCurrentAddress2 = "C2 Village";
	final static String patientCurrentPostCode = "cP05TC0D3";
	final static String unstructuredData = "<ns2:component contextConductionInd=\"true\" typeCode=\"COMP\">\n"+
	                                            "<ns3:contentId extension=\"COCD_TP146246GB01#Section1\" root=\"2.16.840.1.113883.2.1.3.2.4.18.16\"/>\n"+
	                                    		"<ns2:section moodCode=\"EVN\" classCode=\"DOCSECT\">\n"+
		                            				"<ns2:templateId extension=\"COCD_TP146246GB01#Section1\" root=\"2.16.840.1.113883.2.1.3.2.4.18.2\"/>\n"+
		                            				"<ns2:id root=\"D19E8577-4FDB-4F90-943B-C54239FA8BE3\"/>\n"+
		                            				"<ns2:title>Case Summary</ns2:title>\n"+
		                            				"<ns2:text mediaType=\"text/x-hl7-text+xml\">\n"+
			                            				"<ns2:content styleCode=\"bold\">\n"+
			                            						"Pathways Assessment:<ns2:br/>\n"+
			                            					"</ns2:content>\n"+
			                            					"<ns2:content>\n"+
			                            						"Test line 1<ns2:br/>Another line<ns2:br/>\n"+
			                            				"</ns2:content>\n"+
		                            				"</ns2:text>\n"+
		                            				"</ns2:section>\n";
	
	public static List<DataInstance> GenerateCaseSummary(boolean includePathwaysAssessment, boolean includeConsultationSummary){
		List<DataInstance> dataItems = new ArrayList<DataInstance>();
		
		if (includePathwaysAssessment){
			DataInstance assessmentDI = new DataInstance();
			assessmentDI.setName(PayloadGeneration.assessName);
			assessmentDI.setCaption(PayloadGeneration.assessCaption);
			List<String> values = new ArrayList<String>();
			values.add(PayloadGeneration.assessAnswer);
			assessmentDI.setValues(values);
			dataItems.add(assessmentDI);
		}
		
		if (includeConsultationSummary) {
			DataInstance consultationSummaryDI = new DataInstance();
			consultationSummaryDI.setName(PayloadGeneration.conSumName);
			consultationSummaryDI.setCaption(PayloadGeneration.conSumCaption);
			List<String> values2 = new ArrayList<String>();
			values2.add(PayloadGeneration.conSumAnswer);
			consultationSummaryDI.setValues(values2);
			dataItems.add(consultationSummaryDI);
		}
		
		return dataItems;
	}
		
	public static SubmitToCallQueueDetails populateSubmitToCallQueueDetails_Success()
	{
		SubmitToCallQueueDetails callDetails = new SubmitToCallQueueDetails();
				
		callDetails.setCaseSummary(GenerateCaseSummary(true,true));
		callDetails.setDispositionCode(dispositionCode);
		callDetails.setDispositionName(dispositionName);
		callDetails.setExternalReference(externalReference);
		callDetails.setJourneyId(journeyId);
		callDetails.setConditionTitle(source);
		
		byte[] unstructuredBytes = Base64.encodeBase64(unstructuredData.getBytes());
		
		String unstructuredString = new String(unstructuredBytes);
		
		callDetails.setUnstructuredData(unstructuredString);
		
		return callDetails;
	}
	
	public static SubmitPatientService populateSubmitPatientService_Success()
	{
		SubmitPatientService patient = new SubmitPatientService();
		Address current = new Address();
		current.setStreetAddressLine1("c1 Road");
		current.setStreetAddressLine2(patientCurrentAddress2);
		current.setStreetAddressLine3("c3 Town");
		current.setStreetAddressLine4("c4 County");
		current.setStreetAddressLine5("c5 Country");
		current.setPostalCode(patientCurrentPostCode);
		patient.setCurrentAddress(current);
		Address home = new Address();
		home.setStreetAddressLine1("h1 Road");
		home.setStreetAddressLine2("h2 Village");
		home.setStreetAddressLine3(patientHomeAddress3);
		home.setStreetAddressLine4("h4 County");
		home.setStreetAddressLine5("h5 Country");
		home.setPostalCode("hP05TC0D3");
		patient.setHomeAddress(home);
		
		try {
			patient.setDateOfBirth(new DateOfBirth());
			patient.getDateOfBirth().setDob(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar(1985, 4, 31)));
		} catch (DatatypeConfigurationException e1) {
			e1.printStackTrace();
		}
		patient.setEmailAddress(patientEmail);
		patient.setForename(patientForename);
		patient.setSurname(patientSurname);
		patient.setGender(Gender.MALE);
		patient.setInformantType(InformantType.Self);
		GPPractice gp = new GPPractice();
		Address gpAddress = new Address();
		gpAddress.setStreetAddressLine1("g1 Road");
		gpAddress.setStreetAddressLine2("g2 Village");
		gpAddress.setStreetAddressLine3("g3 Town");
		gpAddress.setStreetAddressLine4("g4 County");
		gpAddress.setStreetAddressLine5("g5 Country");
		gpAddress.setPostalCode("gP05TC0D3");
		gp.setAddress(gpAddress);
		gp.setName("Test GP");
		gp.setODS("RYH ODS");
		gp.setTelephone("118 118 118");
		
		patient.setGpPractice(gp);
		patient.setInformantContactName("Self");
		patient.setNhsNumber("005245 22451365");
		patient.setTelephoneNumber(patientTelephone);
		
		return patient;
	}
	
	public static SubmitEncounterToServiceRequest populateSubmitEncounterToServiceRequest_Success()
	{
		SubmitEncounterToServiceRequest payload = new SubmitEncounterToServiceRequest();

		SubmitToCallQueueDetails callDetails = populateSubmitToCallQueueDetails_Success();
		
		payload.setCaseDetails(callDetails);
		
		SubmitPatientService patient = populateSubmitPatientService_Success();
		payload.setPatientDetails(patient);

		payload.setServiceDetails(populateSubmitToServiceDetails_Success());
		
		return payload;
	}

	private static SubmitToServiceDetails populateSubmitToServiceDetails_Success(){
		SubmitToServiceDetails stsd = new SubmitToServiceDetails();
		stsd.setAddress("123 The Road,The Village");
		stsd.setContactDetails("0123456");
		stsd.setPostcode(recipientPostCode);
		stsd.setId(recipientDosId);
		stsd.setName("Some GP OOH");
		stsd.setOdsCode(recipientOdsCode);
		return stsd;
	}
		
	private static SubmitPatientEnquiry populateSubmitPatientEnquiry_Success() {
		SubmitPatientEnquiry patient = new SubmitPatientEnquiry();
		Address current = new Address();
		current.setStreetAddressLine1("c1 Road");
		current.setStreetAddressLine2(patientCurrentAddress2);
		current.setStreetAddressLine3("c3 Town");
		current.setStreetAddressLine4("c4 County");
		current.setStreetAddressLine5("c5 Country");
		current.setPostalCode(patientCurrentPostCode);
		patient.setCurrentAddress(current);
		Address home = new Address();
		home.setStreetAddressLine1("h1 Road");
		home.setStreetAddressLine2("h2 Village");
		home.setStreetAddressLine3(patientHomeAddress3);
		home.setStreetAddressLine4("h4 County");
		home.setStreetAddressLine5("h5 Country");
		home.setPostalCode("hP05TC0D3");
		patient.setHomeAddress(home);
		
		try {
			patient.setDateOfBirth(new DateOfBirth());
			patient.getDateOfBirth().setDob(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar(1985, 4, 31)));
		} catch (DatatypeConfigurationException e1) {
			e1.printStackTrace();
		}
		patient.setEmailAddress(patientEmail);
		patient.setForename(patientForename);
		patient.setSurname(patientSurname);
		patient.setGender(Gender.MALE);
		patient.setInformantType(InformantType.Self);
		GPPractice gp = new GPPractice();
		Address gpAddress = new Address();
		gpAddress.setStreetAddressLine1("g1 Road");
		gpAddress.setStreetAddressLine2("g2 Village");
		gpAddress.setStreetAddressLine3("g3 Town");
		gpAddress.setStreetAddressLine4("g4 County");
		gpAddress.setStreetAddressLine5("g5 Country");
		gpAddress.setPostalCode("gP05TC0D3");
		gp.setAddress(gpAddress);
		gp.setName("Test GP");
		gp.setODS("RYH ODS");
		gp.setTelephone("118 118 118");
		
		patient.setGpPractice(gp);
		patient.setInformantContactName("Self");
		patient.setNhsNumber("005245 22451365");
		patient.setTelephoneNumber(patientTelephone);
		return patient;
	}
	
	public static SubmitToCallQueueEnquiryRequest populateSubmitToCallQueueEnquiryRequest_Success()
	{
		SubmitToCallQueueDetails detail = populateSubmitToCallQueueDetails_Success();
			
		SubmitToCallQueueEnquiryRequest payload = new SubmitToCallQueueEnquiryRequest();
		payload.setCaseDetails(detail);
		payload.setPatientDetails(populateSubmitPatientEnquiry_Success());
		
		return payload;
	}
	
	private static SubmitPatientCallback populateSubmitPatientCallback_Success() {
		SubmitPatientCallback patient = new SubmitPatientCallback();
		Address current = new Address();
		current.setStreetAddressLine1("c1 Road");
		current.setStreetAddressLine2(patientCurrentAddress2);
		current.setStreetAddressLine3("c3 Town");
		current.setStreetAddressLine4("c4 County");
		current.setStreetAddressLine5("c5 Country");
		current.setPostalCode(patientCurrentPostCode);
		patient.setCurrentAddress(current);
		Address home = new Address();
		home.setStreetAddressLine1("h1 Road");
		home.setStreetAddressLine2("h2 Village");
		home.setStreetAddressLine3(patientHomeAddress3);
		home.setStreetAddressLine4("h4 County");
		home.setStreetAddressLine5("h5 Country");
		home.setPostalCode("hP05TC0D3");
		patient.setHomeAddress(home);
		
		try {
			patient.setDateOfBirth(new DateOfBirth());
			patient.getDateOfBirth().setDob(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar(1985, 4, 31)));
		} catch (DatatypeConfigurationException e1) {
			e1.printStackTrace();
		}
		patient.setEmailAddress(patientEmail);
		patient.setForename(patientForename);
		patient.setSurname(patientSurname);
		patient.setGender(Gender.MALE);
		patient.setInformantType(InformantType.Self);
		GPPractice gp = new GPPractice();
		Address gpAddress = new Address();
		gpAddress.setStreetAddressLine1("g1 Road");
		gpAddress.setStreetAddressLine2("g2 Village");
		gpAddress.setStreetAddressLine3("g3 Town");
		gpAddress.setStreetAddressLine4("g4 County");
		gpAddress.setStreetAddressLine5("g5 Country");
		gpAddress.setPostalCode("gP05TC0D3");
		gp.setAddress(gpAddress);
		gp.setName("Test GP");
		gp.setODS("RYH ODS");
		gp.setTelephone("118 118 118");
		
		patient.setGpPractice(gp);
		patient.setInformantContactName("Self");
		patient.setNhsNumber("005245 22451365");
		patient.setTelephoneNumber(patientTelephone);
		
		return patient;
	}
	
	public static SubmitToCallQueueCallbackRequest populateSubmitToCallQueueCallbackRequest_Success()
	{
		SubmitToCallQueueCallbackRequest payload = new SubmitToCallQueueCallbackRequest();

		SubmitToCallQueueDetails callDetails = populateSubmitToCallQueueDetails_Success();
		payload.setCaseDetails(callDetails);
				
		payload.setPatientDetails(populateSubmitPatientCallback_Success());
		
		return payload;
	}
}