package OctopusConsortium.Core.Transformers.ITK;

import javax.xml.bind.JAXBElement;

import org.junit.Assert;
import org.junit.Test;

import OctopusConsortium.Models.RCS.AD;
import OctopusConsortium.Models.RCS.CsNullFlavor;
import OctopusConsortium.Models.RCS.ObjectFactory;
import OctopusConsortium.Models.RCS.POCDMT000002UK01EncompassingEncounter;
import OctopusConsortium.Service.Models.SubmitPatientService;
import OctopusConsortium.Service.Models.SubmitToCallQueueDetails;

public class CallQueueHelperTest {

	@SuppressWarnings("unchecked")
	@Test
	public void CreateEncompassingEncounter_HealthCareFacility(){
		//assemble
		SubmitPatientService patient = PayloadGeneration.populateSubmitPatientService_Success(); 
		SubmitToCallQueueDetails callQueueDetails = PayloadGeneration.populateSubmitToCallQueueDetails_Success();
		ObjectFactory of = new ObjectFactory();
		
		//act
		POCDMT000002UK01EncompassingEncounter result = CallQueueHelper.CreateEncompassingEncounter(of, callQueueDetails, patient);
		
		//assert
		Assert.assertEquals("ISDLOC", result.getLocation().getHealthCareFacility().getClassCode());
		Assert.assertEquals(CsNullFlavor.NA, result.getLocation().getHealthCareFacility().getId().get(0).getNullFlavor());
		Assert.assertEquals("2.16.840.1.113883.2.1.3.2.4.18.2", result.getLocation().getHealthCareFacility().getTemplateId().get(0).getRoot());
		Assert.assertEquals("COCD_TP145222GB02#HealthCareFacility", result.getLocation().getHealthCareFacility().getTemplateId().get(0).getExtension());
		
		JAXBElement<AD.StreetAddressLine> patientCurrentAddressLine2Test = (JAXBElement<AD.StreetAddressLine>)result.getLocation().getHealthCareFacility().getLocation().getAddr().getContent().get(1);
		Assert.assertEquals(PayloadGeneration.patientCurrentAddress2, patientCurrentAddressLine2Test.getValue().getContent());
		JAXBElement<AD.PostalCode> patientCurrentAddressPostcodeTest = (JAXBElement<AD.PostalCode>)result.getLocation().getHealthCareFacility().getLocation().getAddr().getContent().get(5);
		Assert.assertEquals(PayloadGeneration.patientCurrentPostCode.toUpperCase(), patientCurrentAddressPostcodeTest.getValue().getContent().toUpperCase());
		
		Assert.assertEquals("PLC", result.getLocation().getHealthCareFacility().getLocation().getClassCode());
		Assert.assertEquals("INSTANCE", result.getLocation().getHealthCareFacility().getLocation().getDeterminerCode().get(0));			
		Assert.assertEquals(CsNullFlavor.UNK, result.getLocation().getHealthCareFacility().getLocation().getName().getNullFlavor());
		Assert.assertEquals("2.16.840.1.113883.2.1.3.2.4.18.2", result.getLocation().getHealthCareFacility().getLocation().getTemplateId().get(0).getRoot());
		Assert.assertEquals("COCD_TP145222GB02#location", result.getLocation().getHealthCareFacility().getLocation().getTemplateId().get(0).getExtension());
	}
	
	@Test
	public void CreateEncompassingEncounter_HealthCareFacility_NoCurrentAddress(){
		//assemble
		SubmitPatientService patient = PayloadGeneration.populateSubmitPatientService_Success();
		patient.setCurrentAddress(null);
		SubmitToCallQueueDetails callQueueDetails = PayloadGeneration.populateSubmitToCallQueueDetails_Success();
		ObjectFactory of = new ObjectFactory();
		//act
		POCDMT000002UK01EncompassingEncounter result = CallQueueHelper.CreateEncompassingEncounter(of, callQueueDetails, patient);
		//assert
		Assert.assertEquals(null, result.getLocation().getHealthCareFacility().getLocation());
	}
	
	@Test
	public void CreateEncompassingEncounter_Encounter(){
		//assemble
		SubmitPatientService patient = PayloadGeneration.populateSubmitPatientService_Success(); 
		SubmitToCallQueueDetails callQueueDetails = PayloadGeneration.populateSubmitToCallQueueDetails_Success();
		ObjectFactory of = new ObjectFactory();
		
		//act
		POCDMT000002UK01EncompassingEncounter result = CallQueueHelper.CreateEncompassingEncounter(of, callQueueDetails, patient);
		
		//assert
		Assert.assertEquals("ENC", result.getClassCode().get(0));
		Assert.assertEquals("EVN", result.getMoodCode().get(0));
		Assert.assertEquals("NHS111Encounter", result.getCode().getCode());
		Assert.assertEquals("2.16.840.1.113883.2.1.3.2.4.17.326", result.getCode().getCodeSystem());
		Assert.assertEquals("NHS111 Encounter", result.getCode().getDisplayName());
		
		Assert.assertEquals(PayloadGeneration.dispositionPrefix + PayloadGeneration.dispositionCode, result.getDischargeDispositionCode().getCode());
		Assert.assertEquals(PayloadGeneration.dispositionName, result.getDischargeDispositionCode().getDisplayName());
		Assert.assertEquals("2.16.840.1.113883.2.1.3.2.4.17.325", result.getDischargeDispositionCode().getCodeSystem());
		Assert.assertNotNull(result.getEffectiveTime().getLow().getValue());
		Assert.assertEquals("2.16.840.1.113883.2.1.3.2.4.18.34", result.getId().get(0).getRoot());
		Assert.assertEquals(PayloadGeneration.journeyId, result.getId().get(0).getExtension());
		Assert.assertEquals("2.16.840.1.113883.2.1.3.2.4.18.35", result.getId().get(1).getRoot());
		Assert.assertEquals(PayloadGeneration.externalReference, result.getId().get(1).getExtension());
		Assert.assertEquals("2.16.840.1.113883.2.1.3.2.4.18.2", result.getTemplateId().get(0).getRoot());
		Assert.assertEquals("COCD_TP146232GB01#EncompassingEncounter", result.getTemplateId().get(0).getExtension());
	}
	
	
	@Test
	public void CreateEncompassingEncounter_Location(){
		//assemble
		SubmitPatientService patient = PayloadGeneration.populateSubmitPatientService_Success(); 
		SubmitToCallQueueDetails callQueueDetails = PayloadGeneration.populateSubmitToCallQueueDetails_Success();
		ObjectFactory of = new ObjectFactory();
		
		//act
		POCDMT000002UK01EncompassingEncounter result = CallQueueHelper.CreateEncompassingEncounter(of, callQueueDetails, patient);
		
		//assert
		Assert.assertEquals("LOC", result.getLocation().getTypeCode());
		Assert.assertEquals("2.16.840.1.113883.2.1.3.2.4.18.16", result.getLocation().getContentId().getRoot());
		Assert.assertEquals("COCD_TP145222GB02#HealthCareFacility", result.getLocation().getContentId().getExtension());
		Assert.assertEquals("2.16.840.1.113883.2.1.3.2.4.18.2", result.getLocation().getTemplateId().get(0).getRoot());
		Assert.assertEquals("COCD_TP146232GB01#location", result.getLocation().getTemplateId().get(0).getExtension());
	}
	
	@Test
	public void CreateEncompassingEncounter_Encounter_NoExternalReference_ReturnsJourneyId(){
		//assemble
		SubmitPatientService patient = PayloadGeneration.populateSubmitPatientService_Success(); 
		SubmitToCallQueueDetails callQueueDetails = PayloadGeneration.populateSubmitToCallQueueDetails_Success();
		callQueueDetails.setExternalReference(null);
		ObjectFactory of = new ObjectFactory();
		
		//act
		POCDMT000002UK01EncompassingEncounter result = CallQueueHelper.CreateEncompassingEncounter(of, callQueueDetails, patient);
		
		//assert
		Assert.assertEquals("2.16.840.1.113883.2.1.3.2.4.18.34", result.getId().get(0).getRoot());
		Assert.assertEquals(PayloadGeneration.journeyId, result.getId().get(0).getExtension());
	}
}