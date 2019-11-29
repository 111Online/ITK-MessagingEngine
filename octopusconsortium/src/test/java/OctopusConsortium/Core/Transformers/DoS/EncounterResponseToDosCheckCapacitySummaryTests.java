package OctopusConsortium.Core.Transformers.DoS;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;


import org.junit.Test;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.types.DataTypeFactory;

import OctopusConsortium.DosService.AgeFormatType;
import OctopusConsortium.DosService.Case;
import OctopusConsortium.DosService.GenderType;
import OctopusConsortium.DosService.UserInfo;
import OctopusConsortium.Service.Models.Address;
import OctopusConsortium.Service.Models.CacheOOHAvailabilityRequest;
import OctopusConsortium.Service.Models.CheckOOHAvailabilityRequest;
import OctopusConsortium.Service.Models.DispositionDetails;
import OctopusConsortium.Service.Models.FindServicesRequest;
import OctopusConsortium.Service.Models.Gender;
import OctopusConsortium.Service.Models.HaSC;
import OctopusConsortium.Service.Models.Patient;
import OctopusConsortium.Service.Models.SubmitEncounterResponse;


/**
 * @author stuart.yeates
 *
 */
public class EncounterResponseToDosCheckCapacitySummaryTests  {

	/**
	 * Test method for {@link OctopusConsortium.Core.Transformers.Dos.EncounterResponseToDosCheckCapacitySummary()}.
	 */
	@Test
	public void testDataTypeSupport() {
		EncounterResponseToDosCheckCapacitySummary target = new EncounterResponseToDosCheckCapacitySummary();
		assertTrue("input of SubmitEncounterResponse not supported",target.isSourceDataTypeSupported(DataTypeFactory.create(OctopusConsortium.Service.Models.SubmitEncounterResponse.class)));
		assertTrue("input of FindServicesRequest not supported",target.isSourceDataTypeSupported(DataTypeFactory.create(OctopusConsortium.Service.Models.FindServicesRequest.class)));
		assertTrue("input of CacheOOHAvailabilityRequest not supported",target.isSourceDataTypeSupported(DataTypeFactory.create(OctopusConsortium.Service.Models.CacheOOHAvailabilityRequest.class)));
		assertTrue("input of CheckOOHAvailabilityRequest not supported",target.isSourceDataTypeSupported(DataTypeFactory.create(OctopusConsortium.Service.Models.CheckOOHAvailabilityRequest.class)));
		assertTrue("output of Object[] not supported",target.getReturnDataType().equals(DataTypeFactory.create(Object[].class)));
	}

	
	
	/**
	 * 
	 */
	@Test
	public void testDoTransformFindServicesRequest() {
		//Arrange
		//########
		EncounterResponseToDosCheckCapacitySummary target = new EncounterResponseToDosCheckCapacitySummary();		
		target._username = "testusername";
		target._password = "testpassword";
		
		FindServicesRequest payload = new FindServicesRequest();
		payload.setAge(25);
		payload.setDispositionCode(11);
		payload.setGender(Gender.NOT_KNOWN);
		payload.setPostcode("testpostcode");
		payload.setSearchDistance(10);
		payload.setSurgery("testodscode");
		payload.setSymptomDiscriminatorList(new ArrayList<Integer>());
		payload.getSymptomDiscriminatorList().add(1);
		payload.getSymptomDiscriminatorList().add(2);
		payload.setSymptomGroup(5);		
			
		
		//Act
		//########
		Object[] results = null;
		try {
			results = (Object[]) target.doTransform(payload, "");
		} catch (TransformerException e) {
			e.printStackTrace();
			assertTrue("Error", false);
		}
		//Assert
		//########
		assertNotNull("Transform returned null", results);
		
		//the object array should have two objects 
		assertTrue("incorrect number of objects",results.length==2);
		
		//check the first object is type UserInfo and the second is type Case
		assertTrue("incorrect type for object[0]", results[0] instanceof UserInfo);
		assertTrue("incorrect type for object[1]", results[1] instanceof Case);
		
		//check userInfo object
		UserInfo userInfo = (UserInfo) results[0];	
		assertEquals("username incorrect", "testusername", userInfo.getUsername());
		assertEquals("username incorrect", "testpassword", userInfo.getPassword());
		
		//check casee object
		Case dosCase = (Case) results[1];
		assertEquals("incorrect ageFormat", AgeFormatType.YEARS , dosCase.getAgeFormat());
		assertEquals("incorrect age", 25 , dosCase.getAge());
		assertEquals("incorrect disposition", 11 , dosCase.getDisposition());
		assertEquals("incorrect gender", GenderType.I , dosCase.getGender());
		assertEquals("incorrect postcode", "testpostcode" , dosCase.getPostcode());
		assertEquals("incorrect searchdistance", (Integer)10 , dosCase.getSearchDistance());
		assertEquals("incorrect surgery", "testodscode" , dosCase.getSurgery());
		assertTrue("incorrect DiscriminatorList", dosCase.getSymptomDiscriminatorList().getInt().contains(1));
		assertTrue("incorrect DiscriminatorList", dosCase.getSymptomDiscriminatorList().getInt().contains(2));
		assertEquals("incorrect SymptomGroup", 5 , dosCase.getSymptomGroup());
	}
	
	@Test
	public void testDoTransformFindServicesRequestNullAge() {
		//Arrange
		//########
		EncounterResponseToDosCheckCapacitySummary target = new EncounterResponseToDosCheckCapacitySummary();		
		target._username = "testusername";
		target._password = "testpassword";
		
		FindServicesRequest payload = new FindServicesRequest();
		//payload.setAge(25);
		payload.setDispositionCode(11);
		payload.setGender(Gender.FEMALE);
		payload.setPostcode("testpostcode");
		payload.setSearchDistance(10);
		payload.setSurgery("testodscode");
		payload.setSymptomDiscriminatorList(new ArrayList<Integer>());
		payload.getSymptomDiscriminatorList().add(1);
		payload.getSymptomDiscriminatorList().add(2);
		payload.setSymptomGroup(5);		
			
		
		//Act
		//########
		Object[] results = null;
		try {
			results = (Object[]) target.doTransform(payload, "");
		} catch (TransformerException e) {
			e.printStackTrace();
			assertTrue("Error", false);
		}
		//Assert
		//########
		assertNotNull("Transform returned null", results);
		
		//the object array should have two objects 
		assertTrue("incorrect number of objects",results.length==2);
		
		//check the first object is type UserInfo and the second is type Case
		assertTrue("incorrect type for object[0]", results[0] instanceof UserInfo);
		assertTrue("incorrect type for object[1]", results[1] instanceof Case);
		
		//check userInfo object
		UserInfo userInfo = (UserInfo) results[0];	
		assertEquals("username incorrect", "testusername", userInfo.getUsername());
		assertEquals("username incorrect", "testpassword", userInfo.getPassword());
		
		//check casee object
		Case dosCase = (Case) results[1];
		//assertEquals("incorrect ageFormat", AgeFormatType.YEARS , dosCase.getAgeFormat());
		//assertEquals("incorrect age", 25 , dosCase.getAge());
		assertEquals("incorrect disposition", 11 , dosCase.getDisposition());
		assertEquals("incorrect gender", GenderType.F , dosCase.getGender());
		assertEquals("incorrect postcode", "testpostcode" , dosCase.getPostcode());
		assertEquals("incorrect searchdistance", (Integer)10 , dosCase.getSearchDistance());
		assertEquals("incorrect surgery", "testodscode" , dosCase.getSurgery());
		assertTrue("incorrect DiscriminatorList", dosCase.getSymptomDiscriminatorList().getInt().contains(1));
		assertTrue("incorrect DiscriminatorList", dosCase.getSymptomDiscriminatorList().getInt().contains(2));
		assertEquals("incorrect SymptomGroup", 5 , dosCase.getSymptomGroup());
	}
	
	/**
	 * @throws DatatypeConfigurationException 
	 * 
	 */
	@Test
	public void testDoTransformSubmitEncounterResponse() throws DatatypeConfigurationException {
		//Arrange
		//########
		EncounterResponseToDosCheckCapacitySummary target = new EncounterResponseToDosCheckCapacitySummary();		
		target._username = "testusername";
		target._password = "testpassword";
		
		SubmitEncounterResponse payload = new SubmitEncounterResponse();
		Patient patient = new Patient();
		payload.setPatient(patient);
		GregorianCalendar c = new GregorianCalendar();
		c.set(Calendar.getInstance().get(Calendar.YEAR) - 25, 1, 1);
		patient.setDOB(DatatypeFactory.newInstance().newXMLGregorianCalendar(c));
		patient.setGender(Gender.MALE);
		patient.setAddress(new Address());
		patient.getAddress().setPostalCode("testpostcode");
	
		DispositionDetails dispositionDetails = new DispositionDetails();
		payload.setHaSC(new HaSC());
		payload.getHaSC().setDispositionDetails(dispositionDetails);
		dispositionDetails.setDispositionCode(11);
		dispositionDetails.setSymptomGroup(5);
		ArrayList<Integer> list = new ArrayList<Integer>();	
		dispositionDetails.setSymptomDiscriminatorList(list);
		list.add(1);
		list.add(2);
					
		
		//Act
		//########
		Object[] results = null;
		try {
			results = (Object[]) target.doTransform(payload, "");
		} catch (TransformerException e) {
			e.printStackTrace();
			assertTrue("Error", false);
		}
		//Assert
		//########
		assertNotNull("Transform returned null", results);
		
		//the object array should have two objects 
		assertTrue("incorrect number of objects",results.length==2);
		
		//check the first object is type UserInfo and the second is type Case
		assertTrue("incorrect type for object[0]", results[0] instanceof UserInfo);
		assertTrue("incorrect type for object[1]", results[1] instanceof Case);
		
		//check userInfo object
		UserInfo userInfo = (UserInfo) results[0];	
		assertEquals("username incorrect", "testusername", userInfo.getUsername());
		assertEquals("username incorrect", "testpassword", userInfo.getPassword());
		
		//check casee object
		Case dosCase = (Case) results[1];
		assertEquals("incorrect ageFormat", AgeFormatType.YEARS , dosCase.getAgeFormat());
		assertEquals("incorrect age", 25 , dosCase.getAge());
		assertEquals("incorrect disposition", 11 , dosCase.getDisposition());
		assertEquals("incorrect gender", GenderType.M , dosCase.getGender());
		assertEquals("incorrect postcode", "TESTPOSTCODE" , dosCase.getPostcode());
		assertTrue("incorrect searchdistance", dosCase.getSearchDistance() == null);
		assertTrue("incorrect surgery" , dosCase.getSurgery() == null);
		assertTrue("incorrect DiscriminatorList", dosCase.getSymptomDiscriminatorList().getInt().contains(1));
		assertTrue("incorrect DiscriminatorList", dosCase.getSymptomDiscriminatorList().getInt().contains(2));
		assertEquals("incorrect SymptomGroup", 5 , dosCase.getSymptomGroup());
	}
	
	
	/**
	 * @throws DatatypeConfigurationException 
	 * 
	 */
	@Test
	public void testDoTransformCacheOOHAvailabilityRequest() throws DatatypeConfigurationException {
		//Arrange
		//########
		EncounterResponseToDosCheckCapacitySummary target = new EncounterResponseToDosCheckCapacitySummary();		
		target._username = "testusername";
		target._password = "testpassword";
		
		CacheOOHAvailabilityRequest payload = new CacheOOHAvailabilityRequest();		
		payload.setPostcode("test postcode");
		payload.setSearchDistance(10);
		Calendar a = Calendar.getInstance(); 
		java.util.Date d = a.getTime();		
		payload.setTime(OctopusConsortium.Core.XMLGregorianCalendarConversionUtil.asXMLGregorianCalendar(d));
				
		
		//Act
		//########
		Object[] results = null;
		try {
			results = (Object[]) target.doTransform(payload, "");
		} catch (TransformerException e) {
			e.printStackTrace();
			assertTrue("Error", false);
		}
		//Assert
		//########
		assertNotNull("Transform returned null", results);
		
		//the object array should have two objects 
		assertTrue("incorrect number of objects",results.length==2);
		
		//check the first object is type UserInfo and the second is type Case
		assertTrue("incorrect type for object[0]", results[0] instanceof UserInfo);
		assertTrue("incorrect type for object[1]", results[1] instanceof Case);
		
		//check userInfo object
		UserInfo userInfo = (UserInfo) results[0];	
		assertEquals("username incorrect", "testusername", userInfo.getUsername());
		assertEquals("username incorrect", "testpassword", userInfo.getPassword());
		
		//check casee object
		Case dosCase = (Case) results[1];
		assertEquals("incorrect ageFormat", AgeFormatType.YEARS , dosCase.getAgeFormat());
		assertEquals("incorrect age", 21 , dosCase.getAge());
		assertEquals("incorrect disposition", 13 , dosCase.getDisposition());
		assertEquals("incorrect gender", GenderType.I, dosCase.getGender());
		assertEquals("incorrect postcode", "TEST POSTCODE" , dosCase.getPostcode());
		assertEquals("incorrect searchdistance", (Integer)10, dosCase.getSearchDistance());
		assertEquals("incorrect SymptomGroup", 1159 , dosCase.getSymptomGroup());
		assertTrue("incorrect DiscriminatorList", dosCase.getSymptomDiscriminatorList().getInt().contains(4003));
	}
	/**
	 * @throws DatatypeConfigurationException 
	 * 
	 */
	@Test
	public void testDoTransformCheckOOHAvailabilityRequest() throws DatatypeConfigurationException {
		//Arrange
		//########
		EncounterResponseToDosCheckCapacitySummary target = new EncounterResponseToDosCheckCapacitySummary();		
		target._username = "testusername";
		target._password = "testpassword";
		
		CheckOOHAvailabilityRequest payload = new CheckOOHAvailabilityRequest();		
		payload.setDisposition("a value");		
		payload.setPostcode("test postcode");
		payload.setSearchDistance(10);
		Calendar a = Calendar.getInstance(); 
		java.util.Date d = a.getTime();		
		payload.setTime(OctopusConsortium.Core.XMLGregorianCalendarConversionUtil.asXMLGregorianCalendar(d));
					
		
		//Act
		//########
		Object[] results = null;
		try {
			results = (Object[]) target.doTransform(payload, "");
		} catch (TransformerException e) {
			e.printStackTrace();
			assertTrue("Error", false);
		}
		//Assert
		//########
		assertNotNull("Transform returned null", results);
		
		//the object array should have two objects 
		assertTrue("incorrect number of objects",results.length==2);
		
		//check the first object is type UserInfo and the second is type Case
		assertTrue("incorrect type for object[0]", results[0] instanceof UserInfo);
		assertTrue("incorrect type for object[1]", results[1] instanceof Case);
		
		//check userInfo object
		UserInfo userInfo = (UserInfo) results[0];	
		assertEquals("username incorrect", "testusername", userInfo.getUsername());
		assertEquals("username incorrect", "testpassword", userInfo.getPassword());
		
		//check casee object
		Case dosCase = (Case) results[1];
		assertEquals("incorrect ageFormat", AgeFormatType.YEARS , dosCase.getAgeFormat());
		assertEquals("incorrect age", 21 , dosCase.getAge());
		assertEquals("incorrect disposition", 13 , dosCase.getDisposition());
		assertEquals("incorrect gender", GenderType.I, dosCase.getGender());
		assertEquals("incorrect postcode", "TEST POSTCODE" , dosCase.getPostcode());
		assertEquals("incorrect searchdistance", (Integer)10, dosCase.getSearchDistance());
		assertEquals("incorrect SymptomGroup", 1159 , dosCase.getSymptomGroup());
		assertTrue("incorrect DiscriminatorList", dosCase.getSymptomDiscriminatorList().getInt().contains(4003));

		
	}

}
