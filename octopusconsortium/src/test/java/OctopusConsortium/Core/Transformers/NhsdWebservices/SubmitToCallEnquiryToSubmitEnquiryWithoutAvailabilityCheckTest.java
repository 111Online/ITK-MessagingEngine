package OctopusConsortium.Core.Transformers.NhsdWebservices;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.junit.Test;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.types.DataTypeFactory;

import OctopusConsortium.NhsdWebservices.*;
import OctopusConsortium.Service.Models.Address;
import OctopusConsortium.Service.Models.DataInstance;
import OctopusConsortium.Service.Models.DateOfBirth;
import OctopusConsortium.Service.Models.Gender;
import OctopusConsortium.Service.Models.SubmitPatientEnquiry;
import OctopusConsortium.Service.Models.SubmitToCallQueueDetails;
import OctopusConsortium.Service.Models.SubmitToCallQueueEnquiryRequest;
import OctopusConsortium.Models.CDA.InformantType;

public class SubmitToCallEnquiryToSubmitEnquiryWithoutAvailabilityCheckTest {

		
	@Test
	public void testDataTypeSupported()  {
		SubmitToCallEnquiryToSubmitEnquiryWithoutAvailabilityCheck target = new SubmitToCallEnquiryToSubmitEnquiryWithoutAvailabilityCheck();
		assertTrue("input of OctopusConsortium.Models.SubmitToCallQueueEnquiryRequest not supported",target.isSourceDataTypeSupported(DataTypeFactory.create(OctopusConsortium.Service.Models.SubmitToCallQueueEnquiryRequest.class)));
		assertTrue("output of OctopusConsortium.NhsdWebservices.OesEnquiry not supported",target.getReturnDataType().equals(DataTypeFactory.create(OctopusConsortium.NhsdWebservices.OesEnquiry.class)));
	}
	
	@Test
	public void testDoTransformObjectString() {
				
		//Arrange
		//########
		SubmitToCallEnquiryToSubmitEnquiryWithoutAvailabilityCheck target = new SubmitToCallEnquiryToSubmitEnquiryWithoutAvailabilityCheck();		
		
		SubmitToCallQueueEnquiryRequest payload = new SubmitToCallQueueEnquiryRequest();
		OesEnquiry results = null;
		
		//populate the payload
		payload.setCaseDetails(createSubmitToCallQueueDetails());
		
		SubmitPatientEnquiry patientD = new SubmitPatientEnquiry();
		patientD.setForename("test forename");
		patientD.setSurname("test surname");
		patientD.setGender(Gender.MALE);		
		XMLGregorianCalendar dob = null;
		try {
			dob = DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar(1980, 1, 1));
		} catch (DatatypeConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		patientD.setDateOfBirth(new DateOfBirth());
		patientD.getDateOfBirth().setDob(dob);
		Address address = new Address();
		address.setPostalCode("test postcode");
		address.setStreetAddressLine1("test addressline1");
		patientD.setCurrentAddress(address);
		address = new Address();
		address.setPostalCode("test2 postcode");
		address.setStreetAddressLine1("test2 addressline1");
		patientD.setHomeAddress(address);
		patientD.setEmailAddress("test@nhsdirect.nhs.uk");		
		patientD.setNhsNumber("test nhsnumber");
		patientD.setTelephoneNumber("test telephone");	
		patientD.setInformantType(InformantType.Mother);
		patientD.setInformantContactName("test informant");
	
		
		payload.setPatientDetails(patientD);
		
		//Act
		//########
		try {
			results = (OesEnquiry) target.doTransform(payload, "");
		} catch (TransformerException e) {
			e.printStackTrace();
			assertTrue("Error", false);
		}
		
		//Assert
		//########
		assertNotNull("Transform returned null", results);
		
		assertTrue("missing forename ",results.getEnquiry().contains("test forename"));
		assertTrue("missing surname ",results.getEnquiry().contains("test surname"));
		assertEquals("incorrect Gender","M",results.getGender());
		assertEquals("incorrect dob",dob,results.getDob());
		assertTrue("incorrect Enquiry Current address",results.getEnquiry().contains("Test Addressline1"));
		assertEquals("incorrect Postcode","TEST POST",results.getPostcode()); //long postcodes now get truncated
		assertTrue("incorrect Enquiry Home address",results.getEnquiry().contains("Test2 Addressline1"));
		assertEquals("incorrect email","test@nhsdirect.nhs.uk",results.getEmailAddress());
		assertTrue("incorrect nhsnumber ",results.getEnquiry().contains("test nhsnumber"));
		assertTrue("incorrect telephone ",results.getEnquiry().contains("test telephone"));
		assertTrue("incorrect informant type ",results.getEnquiry().contains("Informant Type : Mother"));
		assertTrue("incorrect informant name ",results.getEnquiry().contains("Informant Name : test informant"));
		
		//autoset values
		assertEquals("incorrect Ethnicity","Prefer not to say",results.getEthnicity());		
		assertEquals("incorrect LevelOfInfo","Advanced",results.getLevelOfInfo());
		assertNotNull("null Partner",results.getPartner());
		assertNotNull("null PartnerPassword",results.getPartnerPassword());
		assertNotNull("null Password",results.getPassword());
		assertEquals("incorrect Subject","Self",results.getSubject());
		assertFalse("incorrect canContact",results.isCanContact());
		assertFalse("incorrect isSecure",results.isSecure());
		
		//enquiry body	
		assertTrue("incorrect Enquiry Medical_Conditions",results.getEnquiry().contains("test Medical_Conditions"));
		assertTrue("incorrect Enquiry test",results.getEnquiry().contains("This is a test caption"));
		assertTrue("incorrect Enquiry test",results.getEnquiry().contains("test value"));		
		assertTrue("incorrect Enquiry Allergies",results.getEnquiry().contains("test Allergies"));		
		assertTrue("incorrect Enquiry Breast_Feeding",results.getEnquiry().contains("test Breast_Feeding"));
		assertTrue("incorrect Enquiry Breastfeeding_Age",results.getEnquiry().contains("test Breastfeeding_Age"));		
		assertTrue("incorrect Enquiry SymptomGroup",results.getEnquiry().contains("test SymptomGroup 1"));
		assertTrue("incorrect Enquiry SymptomGroup",results.getEnquiry().contains("test SymptomGroup 2"));
		
		//medical conditions
		assertTrue("incorrect MedsInfo",results.getMedsInfo().contains("test Medical_Conditions"));
		
	}
	
	public static SubmitToCallQueueDetails createSubmitToCallQueueDetails(){
		SubmitToCallQueueDetails callQueueD = new SubmitToCallQueueDetails();
		
		callQueueD.setConditionTitle("test source");
		callQueueD.setDispositionName("test DispositionName");
		callQueueD.setDispositionCode("test DispositionCode");
		callQueueD.setExternalReference("test external reference");
		callQueueD.setCaseSummary(getCaseSummary());
		return callQueueD;
	}

	private static List<DataInstance> getCaseSummary(){
		 List<DataInstance> result = new ArrayList<DataInstance>();
		 
		 DataInstance dataI = new DataInstance();
		 dataI.setName("Medical_Conditions");
		 dataI.setCaption("Medical Conditions");		 
		 dataI.getValues().add("test Medical_Conditions");
		 result.add(dataI);
		 
		 dataI = new DataInstance();
		 dataI.setName("Test");
		 dataI.setCaption("This is a test caption");		 
		 dataI.getValues().add("test value");
		 result.add(dataI);
		 		 
		 dataI = new DataInstance();
		 dataI.setName("Allergies");
		 dataI.setCaption("Allergies");		 
		 dataI.getValues().add("test Allergies");
		 result.add(dataI);
		 
		 dataI = new DataInstance();
		 dataI.setName("Breast_Feeding");
		 dataI.setCaption("Breast Feeding");		 
		 dataI.getValues().add("test Breast_Feeding");
		 result.add(dataI);
		 
		 dataI = new DataInstance();
		 dataI.setName("Breastfeeding_Age");
		 dataI.setCaption("Breastfeeding Age");		 
		 dataI.getValues().add("test Breastfeeding_Age");
		 result.add(dataI); 
		 
		 dataI = new DataInstance();
		 dataI.setName("SymptomGroup");
		 dataI.setCaption("Symptom Group");		 
		 dataI.getValues().add("test SymptomGroup 1");
		 dataI.getValues().add("test SymptomGroup 2");
		 result.add(dataI);
		 
		 return result;
	}
	/*
	private static String getCaseSummaryText(){
		
		return "<?xml version=\"1.0\"?> " + 
				 "<ArrayOfDataInstance xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"> " + 
				 "     <DataInstance> " + 
				 "		<Name>First_name</Name> " + 
				 "		<Caption>First Name</Caption>		 " + 
				 "		<Values> " + 
				 "			<Value>test First_name</Value> " + 
				 "		</Values> " + 
				 "     </DataInstance> " + 
				 "     <DataInstance> " + 
				 "		<Name>Surname</Name> " + 
				 "        <Caption>Surname</Caption>	 " + 
				 "		<Values>		 " + 
				 "        <Value>test Surname</Value> " + 
				 "		</Values> " + 
				 "     </DataInstance> " + 
				 "     <DataInstance> " + 
				 "		<Name>Gender</Name> " + 
				 "        <Caption>Gender</Caption> " + 
				 "		<Values> " + 
				 "        <Value>Male</Value> " + 
				 "		</Values> " + 
				 "     </DataInstance> " + 
				 "     <DataInstance> " + 
				 "		<Name>Home_address</Name> " + 
				 "          <Caption>Home address</Caption>	 " + 
				 "		<Values>		   " + 
				 "          <Value>1 Test street " + 
				 "		  Testville " + 
				 "		  Testishire</Value> " + 
				 "		  </Values> " + 
				 "     </DataInstance> " + 
				 "     <DataInstance> " + 
				 "          <Name>Current_location_Identifier</Name> " + 
				 "		  <Caption>Current_location_Identifier</Caption> " + 
				 "          <Values> " + 
				 "		  <Value>test Current_location_Identifier</Value> " + 
				 "		  </Values> " + 
				 "     </DataInstance> " + 
				 "     <DataInstance> " + 
				 "          <Name>Allergies</Name> " + 
				 "		  <Caption>Allergies</Caption> " + 
				 "		  <Values> " + 
				 "          <Value>test Allergies</Value> " + 
				 "		  </Values> " + 
				 "     </DataInstance> " + 
				 "     <DataInstance> " + 
				 "          <Name>Breast Feeding</Name> " + 
				 "		  <Caption>Breast_Feeding</Caption> " + 
				 "		  <Values> " + 
				 "          <Value>test Breast_Feeding</Value> " + 
				 "		  </Values> " + 
				 "     </DataInstance> " + 
				 "     <DataInstance> " + 
				 "          <Name></Name> " + 
				 "		  <Caption></Caption> " + 
				 "		  <Values> " + 
				 "          <Value></Value> " + 
				 "		  </Values> " + 
				 "     </DataInstance> " + 
				 "     <DataInstance> " + 
				 "          <Name>Breastfeeding_Age</Name> " + 
				 "		  <Caption>Breastfeeding Age</Caption> " + 
				 "		  <Values> " + 
				 "          <Value>test Breastfeeding_Age</Value> " + 
				 "		  </Values> " + 
				 "     </DataInstance> " + 
				 "     <DataInstance> " + 
				 "          <Name>Age_Baby</Name> " + 
				 "		  <Caption>Age Baby</Caption> " + 
				 "		  <Values> " + 
				 "          <Value>test Age_Baby</Value> " + 
				 "		  </Values> " + 
				 "     </DataInstance> " + 
				 "     <DataInstance> " + 
				 "          <Name>Contact_Option</Name> " + 
				 "		  <Caption>Contact Option</Caption> " + 
				 "		  <Values> " + 
				 "          <Value>test Contact_Option</Value> " + 
				 "		  </Values> " + 
				 "     </DataInstance> " + 
				 "     <DataInstance> " + 
				 "          <Name>Postcode</Name> " + 
				 "		  <Caption>Postcode</Caption> " + 
				 "		  <Values> " + 
				 "          <Value>test Postcode</Value> " + 
				 "		  </Values> " + 
				 "     </DataInstance> " + 
				 "     <DataInstance> " + 
				 "          <Name>Relationship_To_Patient</Name> " + 
				 "		  <Caption>Relationship To Patient</Caption> " + 
				 "		  <Values> " + 
				 "          <Value>test Relationship_To_Patient</Value> " + 
				 "		  </Values> " + 
				 "     </DataInstance> " + 
				 "     <DataInstance> " + 
				 "          <Name>GP_Care_Provider</Name> " + 
				 "		  <Caption>GP Care Provider</Caption> " + 
				 "		  <Values> " + 
				 "          <Value>test GP_Care_Provider</Value> " + 
				 "		  </Values> " + 
				 "     </DataInstance> " + 
				 "     <DataInstance> " + 
				 "          <Name>Service_Provider_ID</Name> " + 
				 "		  <Caption>Service Provider ID</Caption> " + 
				 "		  <Values> " + 
				 "          <Value>test Service_Provider_ID</Value> " + 
				 "		  </Values> " + 
				 "     </DataInstance> " + 
				 "     <DataInstance> " + 
				 "          <Name>DispositionCode</Name> " + 
				 "		  <Caption>Disposition Code</Caption> " + 
				 "		  <Values> " + 
				 "          <Value>test DispositionCode</Value> " + 
				 "		  </Values> " + 
				 "     </DataInstance> " + 
				 "     <DataInstance> " + 
				 "          <Name>SymptomDiscriminatorList</Name> " + 
				 "		  <Caption>Symptom Discriminator List</Caption> " + 
				 "		  <Values> " + 
				 "          <Value>test SymptomDiscriminatorList</Value> " + 
				 "		  </Values> " + 
				 "     </DataInstance> " + 
				 "     <DataInstance> " + 
				 "          <Name>SymptomGroup</Name> " + 
				 "		  <Caption>Symptom Group</Caption> " + 
				 "		  <Values> " + 
				 "          <Value>test SymptomGroup</Value> " + 
				 "		  </Values> " + 
				 "     </DataInstance> " + 
				 "     <DataInstance> " + 
				 "          <Name>HASC</Name> " + 
				 "		  <Caption>HASC</Caption> " + 
				 "		  <Values> " + 
				 "          <Value>test HASC</Value> " + 
				 "		  </Values> " + 
				 "     </DataInstance> " + 
				 "     <DataInstance> " + 
				 "          <Name>Information_Other</Name> " + 
				 "		  <Caption>Information Other</Caption> " + 
				 "		  <Values> " + 
				 "          <Value>test Information_Other</Value> " + 
				 "		  </Values> " + 
				 "     </DataInstance> " + 
				 "     <DataInstance> " + 
				 "          <Name>LMP_Weeks</Name> " + 
				 "		  <Caption>LMP Weeks</Caption> " + 
				 "		  <Values> " + 
				 "          <Value>test LMP_Weeks</Value> " + 
				 "		  </Values> " + 
				 "     </DataInstance> " + 
				 "     <DataInstance> " + 
				 "          <Name>Medical_Conditions</Name> " + 
				 "		  <Caption>Medical Conditions</Caption> " + 
				 "		  <Values> " + 
				 "          <Value>test Medical_Conditions</Value> " + 
				 "		  </Values> " + 
				 "     </DataInstance> " + 
				 "     <DataInstance> " + 
				 "          <Name>Pregnant</Name> " + 
				 "		  <Caption>Pregnant</Caption> " + 
				 "		  <Values> " + 
				 "          <Value>test Pregnant</Value> " + 
				 "		  </Values> " + 
				 "     </DataInstance>  " + 
				 "	 <DataInstance> " + 
				 "          <Name>Query</Name> " + 
				 "		  <Caption>Query</Caption> " + 
				 "		  <Values> " + 
				 "          <Value>test Query</Value> " + 
				 "		  </Values> " + 
				 "     </DataInstance> " + 
				 "	<DataInstance> " + 
				 "          <Name>Symptom_choice</Name> " + 
				 "		  <Caption>Symptom choice</Caption> " + 
				 "		  <Values> " + 
				 "          <Value>test Symptom_choice</Value> " + 
				 "		  </Values> " + 
				 "     </DataInstance> " + 
				 "	<DataInstance> " + 
				 "          <Name>Travel_Destination</Name> " + 
				 "		  <Caption>Travel Destination</Caption> " + 
				 "		  <Values> " + 
				 "          <Value>test Travel_Destination</Value> " + 
				 "		  </Values> " + 
				 "     </DataInstance> " + 
				 "	<DataInstance> " + 
				 "          <Name>Travel_Timing</Name> " + 
				 "		  <Caption>Travel Timing</Caption> " + 
				 "		  <Values> " + 
				 "          <Value>test Travel_Timing</Value> " + 
				 "		  </Values> " + 
				 "     </DataInstance> " + 
				 "	<DataInstance> " + 
				 "          <Name>Travel_Type</Name> " + 
				 "		  <Caption>Travel Type</Caption> " + 
				 "		  <Values> " + 
				 "          <Value>test Travel_Type</Value> " + 
				 "		  </Values> " + 
				 "     </DataInstance> " + 
				 "	<DataInstance>           " + 
				 "		  <Name>Travel_Accommodation</Name> " + 
				 "		  <Caption>Travel Accommodation</Caption> " + 
				 "		  <Values> " + 
				 "          <Value>test Travel_Accommodation</Value> " + 
				 "		  </Values> " + 
				 "     </DataInstance> " + 
				 "	<DataInstance> " + 
				 "          <Name>Journey_ID</Name> " + 
				 "		  <Caption>Journey ID</Caption> " + 
				 "		  <Values> " + 
				 "          <Value>test Journey_ID</Value> " + 
				 "		  </Values> " + 
				 "     </DataInstance>	  " + 
				 "</ArrayOfDataInstance> ";
	}
	*/
}
