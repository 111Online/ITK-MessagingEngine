package OctopusConsortium.Core.Transformers.ITK;

import java.util.UUID;

import javax.xml.bind.JAXBElement;

import OctopusConsortium.Core.InvalidHascException;
import OctopusConsortium.Core.Transformers.RCS.CDAHelper;
import OctopusConsortium.Models.IITKPatient;
import OctopusConsortium.Models.RCS.StrucDocLinkHtml;
import OctopusConsortium.Models.RCS.CsNullFlavor;
import OctopusConsortium.Models.RCS.CsPostalAddressUse;
import OctopusConsortium.Models.RCS.EN;
import OctopusConsortium.Models.RCS.II;
import OctopusConsortium.Models.RCS.ObjectFactory;
import OctopusConsortium.Models.RCS.POCDMT000002UK01EncompassingEncounter;
import OctopusConsortium.Models.RCS.POCDMT000002UK01Place;
import OctopusConsortium.Models.RCS.POCDMT000002UK01Section;
import OctopusConsortium.Models.RCS.StrucDocContent;
import OctopusConsortium.Service.Models.DataInstance;
import OctopusConsortium.Service.Models.SubmitToCallQueueDetails;
import OctopusConsortium.Service.Models.SubmitToServiceDetails;

public class CallQueueHelper {
	
	public static POCDMT000002UK01Section  CreateDispositionSection(ObjectFactory of, SubmitToCallQueueDetails message, SubmitToServiceDetails serviceDetails) throws InvalidHascException
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
		section.getTitle().setContent("Pathways Disposition");
		
		section.setText(of.createStrucDocText());
		
		section.getText().setMediaType("text/x-hl7-text+xml");
		
		JAXBElement<StrucDocContent> titleContent = of.createStrucDocTextContent(of.createStrucDocContent());
		titleContent.getValue().getStyleCode().add("bold");
		titleContent.getValue().getContent().add("Disposition:");
		titleContent.getValue().getContent().add(of.createStrucDocContentBr(of.createStrucDocBr()));
		
		section.getText().getContent().add(titleContent);
		
		JAXBElement<StrucDocContent> dispoContent = of.createStrucDocTextContent(of.createStrucDocContent());
		String dispoContentValue = CreateDispositionContent(message.getDispositionName(),message.getDispositionCode());
		
		if (dispoContentValue != null || dispoContentValue != "")
		{
			dispoContent.getValue().getContent().add(dispoContentValue);
			dispoContent.getValue().getContent().add(of.createStrucDocContentBr(of.createStrucDocBr()));
			section.getText().getContent().add(dispoContent);
		}
		
		JAXBElement<StrucDocContent> serviceCodeTitleContent = of.createStrucDocTextContent(of.createStrucDocContent());
		serviceCodeTitleContent.getValue().getStyleCode().add("bold");
		serviceCodeTitleContent.getValue().getContent().add("Selected care service:");
		serviceCodeTitleContent.getValue().getContent().add(of.createStrucDocContentBr(of.createStrucDocBr()));		

		if (serviceDetails!= null &&  serviceDetails.getName() != null && serviceDetails.getName() != ""){
			section.getText().getContent().add(serviceCodeTitleContent);
	
			JAXBElement<StrucDocContent> serviceCodeContent = of.createStrucDocTextContent(of.createStrucDocContent());
			serviceCodeContent.getValue().getContent().add(serviceDetails.getName());
			serviceCodeContent.getValue().getContent().add(of.createStrucDocContentBr(of.createStrucDocBr()));		
	
			section.getText().getContent().add(serviceCodeContent);
		}
		
		return section;
	}
	
	private static String CreateDispositionContent(String dispositionName, String dispositionCode){
		if (dispositionName == null || dispositionName == "")
		{
			if (dispositionCode == null || dispositionCode == "")
				return "";
			else 
				return dispositionCode;
		}
		
		return dispositionName + "(" + dispositionCode + ")";
	}
	
	public static POCDMT000002UK01Section CreateAssessmentSection(ObjectFactory of, SubmitToCallQueueDetails message) throws InvalidHascException
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
		
		//Add the CDA markup for the HaSC here
		section.setText(of.createStrucDocText());
		section.getText().setMediaType("text/x-hl7-text+xml");
		
		JAXBElement<StrucDocContent> assessmentContent = convertSummary(SummaryType.ReportText, message, of);
		
		if (!assessmentContent.getValue().getContent().isEmpty()){
			section.getText().getContent().add(assessmentContent);
			//add final break after summary for renderer
			assessmentContent.getValue().getContent().add(of.createStrucDocContentBr(of.createStrucDocBr()));
		}
		
		section.setTitle(of.createST());
		section.getTitle().setContent("Pathways Assessment");
		
		
		
		//TODO optional
		//section.setAuthor(value) this is optional
				
		return section;
	}
	

	public static POCDMT000002UK01Section CreateConsultationSection(ObjectFactory of, SubmitToCallQueueDetails message) throws InvalidHascException
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
		
		//Add the CDA markup for the HaSC here
		section.setText(of.createStrucDocText());
		section.getText().setMediaType("text/x-hl7-text+xml");
		
		JAXBElement<StrucDocContent> summaryContent = convertSummary(SummaryType.DispositionDisplayText, message, of);
		if(!summaryContent.getValue().getContent().isEmpty()){
			section.getText().getContent().add(summaryContent);
		}
		
		section.setTitle(of.createST());
		section.getTitle().setContent("Consultation Summary");

		return section;
	}
	
	public static POCDMT000002UK01Section CreateSourceSection(ObjectFactory of, SubmitToCallQueueDetails message) throws InvalidHascException
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
		
		//Add the CDA markup for the HaSC here
		section.setText(of.createStrucDocText());
		section.getText().setMediaType("text/x-hl7-text+xml");
		
		if (message.getConditionTitle() != null && !message.getConditionTitle().isEmpty())
		{
			section.getText().getContent().add(message.getConditionTitle());
			section.getText().getContent().add(of.createStrucDocContentBr(of.createStrucDocBr()));
		}
		else
		{
			section.getText().getContent().add("Reported condition not available");
			section.getText().getContent().add(of.createStrucDocContentBr(of.createStrucDocBr()));
		}
		
		section.setTitle(of.createST());
		section.getTitle().setContent("Patient's Reported Condition");
						
		return section;
	}
	
	public static POCDMT000002UK01EncompassingEncounter CreateEncompassingEncounter(ObjectFactory of,SubmitToCallQueueDetails msg, IITKPatient patient)
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
		
		if (msg.getDispositionCode() != null && msg.getDispositionCode().toLowerCase().contains("dx")){
			encounter.getDischargeDispositionCode().setCode(msg.getDispositionCode());
		}
		else //prepend DX on front of dispo code
		{
			encounter.getDischargeDispositionCode().setCode("Dx" + msg.getDispositionCode());
		}
		
		encounter.getDischargeDispositionCode().setDisplayName(msg.getDispositionName().trim());	
		//NHS 111 dispo. code system (not SNOMED, or unknown code system)
		encounter.getDischargeDispositionCode().setCodeSystem("2.16.840.1.113883.2.1.3.2.4.17.325");
		
		//set this to the start date time of the HaSC encounter	
		encounter.setEffectiveTime(of.createIVLTS());					
		encounter.getEffectiveTime().setLow(of.createTS());		
		encounter.getEffectiveTime().getLow().setValue(CDAHelper.ClinicalDocumentEffectiveTimeString());
		
		if (msg.getJourneyId() != null && !msg.getJourneyId().isEmpty()){
			II ii = of.createII();
			ii.setRoot("2.16.840.1.113883.2.1.3.2.4.18.34");
			ii.setExtension(msg.getJourneyId()); //set extension to contain the journey id
			encounter.getId().add(ii);
		}
		if (msg.getExternalReference() != null && !msg.getExternalReference().isEmpty())
		{
			II ii = of.createII();
			ii.setRoot("2.16.840.1.113883.2.1.3.2.4.18.35");
			ii.setExtension(msg.getExternalReference()); //set extension to contain the case reference
			encounter.getId().add(ii);
		}
		
		II ii = of.createII();
		encounter.getTemplateId().add(ii);		
		ii.setRoot("2.16.840.1.113883.2.1.3.2.4.18.2");
		ii.setExtension("COCD_TP146232GB01#EncompassingEncounter");
		
		//TODO [0..*] encounterParticipant
		
		//location
		encounter.setLocation(of.createPOCDMT000002UK01Location());
		encounter.getLocation().setTypeCode("LOC");
		encounter.getLocation().setContentId(of.createTemplateContent());
		encounter.getLocation().getContentId().setRoot("2.16.840.1.113883.2.1.3.2.4.18.16");
		encounter.getLocation().getContentId().setExtension("COCD_TP145222GB02#HealthCareFacility");
		
		ii = of.createII();
		encounter.getLocation().getTemplateId().add(ii);
		ii.setRoot("2.16.840.1.113883.2.1.3.2.4.18.2");
		ii.setExtension("COCD_TP146232GB01#location");
		
		encounter.getLocation().setHealthCareFacility(of.createPOCDMT000002UK01HealthCareFacility());
		encounter.getLocation().getHealthCareFacility().setClassCode("ISDLOC");
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
		
		//add current physical address to encounter - this is the location of the patient.
		if (patient.getCurrentAddress() != null) {
			POCDMT000002UK01Place place = of.createPOCDMT000002UK01Place();
			place.setAddr(CDAHelper.CreateRecordTargetAddress(of, patient.getCurrentAddress(), CsPostalAddressUse.PHYS));
	
			place.setClassCode("PLC");//place
			place.getDeterminerCode().add("INSTANCE");
	
			EN placeName = of.createEN();
			placeName.setNullFlavor(CsNullFlavor.UNK);
			place.setName(placeName);//no 'name' as such - as no additional info about this place
			
			II templateId = of.createII();
			templateId.setRoot("2.16.840.1.113883.2.1.3.2.4.18.2");
			templateId.setExtension("COCD_TP145222GB02#location");
			place.getTemplateId().add(templateId);
					
			encounter.getLocation().getHealthCareFacility().setLocation(place);
		}
		
		return encounter;
	}
	
	public static JAXBElement<StrucDocContent> convertSummary(SummaryType summaryType, SubmitToCallQueueDetails details, ObjectFactory of)
	{
		//get all key value pairs, handling multiple values for each key if they exist.	
		JAXBElement<StrucDocContent> summaryContent = of.createStrucDocContentContent(of.createStrucDocContent());
		
		if(details.getCaseSummary() != null){
			for (DataInstance kvp : details.getCaseSummary())
			{
				if (kvp.getName().equals(summaryType.toString())){
					for (String val : kvp.getValues())
					{
						if (!val.isEmpty()) {
							String content = val;
							summaryContent.getValue().getContent().add(content);
							summaryContent.getValue().getContent().add(of.createStrucDocContentBr(of.createStrucDocBr()));
						}
					}
				}
			}
		}
		
		return summaryContent;
	}
	

	public static POCDMT000002UK01Section CreateAppointmentBookingSection(ObjectFactory of, SubmitToCallQueueDetails message) throws InvalidHascException
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
		section.getTitle().setContent("Booked Appointment Information");
		section.setText(of.createStrucDocText());
		StrucDocLinkHtml doclink = new StrucDocLinkHtml();
		if(message.getAppointmentBookingRef() != null && !message.getAppointmentBookingRef().isEmpty())
		{
			doclink.setHref(message.getAppointmentBookingRef());
			section.getText().getContent().add(of.createStrucDocTextLinkHtml(doclink));
		}

		
		return section;
	}
}