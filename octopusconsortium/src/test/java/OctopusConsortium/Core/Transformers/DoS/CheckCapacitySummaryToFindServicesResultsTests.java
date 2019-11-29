package OctopusConsortium.Core.Transformers.DoS;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;

import org.junit.Test;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.types.DataTypeFactory;

import OctopusConsortium.DosService.ArrayOfServiceCareItemRotaSession;
import OctopusConsortium.DosService.ArrayOfServiceCareSummaryDestination;
import OctopusConsortium.DosService.Capacity;
import OctopusConsortium.DosService.CheckCapacitySummaryResponse;
import OctopusConsortium.DosService.DayOfWeek;
import OctopusConsortium.DosService.ObjectFactory;
import OctopusConsortium.DosService.ServiceCareItemRotaSession;
import OctopusConsortium.DosService.ServiceCareSummaryDestination;
import OctopusConsortium.Service.Models.FindServicesResponse;


/**
 * @author stuart.yeates
 *
 */
public class CheckCapacitySummaryToFindServicesResultsTests  {

	/**
	 * Test method for {@link OctopusConsortium.Core.Transformers.Dos.EncounterResponseToDosCheckCapacitySummary()}.
	 */
	@Test
	public void testDataTypeSupport() {
		CheckCapacitySummaryToFindServicesResults target = new CheckCapacitySummaryToFindServicesResults();
		assertTrue("input of CheckCapacitySummaryResponse not supported",target.isSourceDataTypeSupported(DataTypeFactory.create(OctopusConsortium.DosService.CheckCapacitySummaryResponse.class)));
		assertTrue("input of ArrayOfServiceCareSummaryDestination not supported",target.isSourceDataTypeSupported(DataTypeFactory.create(OctopusConsortium.DosService.ArrayOfServiceCareSummaryDestination.class)));
		assertTrue("output of Object[] not supported",target.getReturnDataType().equals(DataTypeFactory.create(OctopusConsortium.Service.Models.FindServicesResponse.class)));
	}

	
	
	/**
	 * @throws DatatypeConfigurationException 
	 * 
	 */
	@Test
	public void testDoTransformCheckCapacitySummaryResponse() throws DatatypeConfigurationException {
		//Arrange
		//########
		CheckCapacitySummaryToFindServicesResults target = new CheckCapacitySummaryToFindServicesResults();		
		
		GregorianCalendar updateTime = new GregorianCalendar();	
		ObjectFactory of = new ObjectFactory();
		CheckCapacitySummaryResponse payload = of.createCheckCapacitySummaryResponse();
		payload.setCheckCapacitySummaryResult(getTestArrayOfServiceCareSummaryDestination(of,updateTime));
				
		
		//Act
		//########
		FindServicesResponse results = null;
		try {
			results = (FindServicesResponse) target.doTransform(payload, "");
		} catch (TransformerException e) {
			e.printStackTrace();
			assertTrue("Error", false);
		}
		AssertTestArrayOfServiceCareSummaryDestination(results,updateTime);
	}
	
	/**
	 * @throws DatatypeConfigurationException 
	 * 
	 */
	@Test
	public void testDoTransformArrayOfServiceCareSummaryDestination() throws DatatypeConfigurationException {
		//Arrange
		//########
		CheckCapacitySummaryToFindServicesResults target = new CheckCapacitySummaryToFindServicesResults();		
				
		ObjectFactory of = new ObjectFactory();
		GregorianCalendar updateTime = new GregorianCalendar();	
		ArrayOfServiceCareSummaryDestination payload = getTestArrayOfServiceCareSummaryDestination(of,updateTime);
		
		//Act
		//########
		FindServicesResponse results = null;
		try {
			results = (FindServicesResponse) target.doTransform(payload, "");
		} catch (TransformerException e) {
			e.printStackTrace();
			assertTrue("Error", false);
		}
		
		//Assert
		AssertTestArrayOfServiceCareSummaryDestination(results,updateTime);		
	}
	
	private void AssertTestArrayOfServiceCareSummaryDestination(FindServicesResponse results,GregorianCalendar updateTime ) throws DatatypeConfigurationException{
		//Assert
		//########
		assertNotNull("Transform returned null", results);
		
		//the object array should have two objects 
		assertTrue("incorrect number of results",results.getResults().size()==1);
		
		//check userInfo object
		OctopusConsortium.Service.Models.ServiceCareSummaryDestination scs = results.getResults().get(0);
		assertEquals("incorrect Address", "testaddress" ,scs.getAddress());
		assertEquals("incorrect Address", "testcontactdetails" ,scs.getContactDetails());
		assertEquals("incorrect Address", (Integer)12 ,scs.getEastings());
		assertEquals("incorrect Address", 10 ,scs.getId());
		assertEquals("incorrect Address", "testname" ,scs.getName());
		assertEquals("incorrect Address", (Integer)13 ,scs.getNorthings());
		assertEquals("incorrect Address", "testnotes" ,scs.getNotes());
		assertEquals("incorrect Address", "testodscode" ,scs.getOdsCode());
		assertEquals("incorrect Address", "testpostcode" ,scs.getPostcode());
		//assertEquals("incorrect Address", "testrootname" ,scs.getRootParent().getName());
		//assertEquals("incorrect Address", 123 ,scs.getRootParent().getId());
		
		assertEquals("incorrect number of rota entries", 7, scs.getRotaSessions().size());
		for (int i = 0; i < scs.getRotaSessions().size(); i++) {
			OctopusConsortium.Service.Models.ServiceCareItemRotaSession rotaS = scs.getRotaSessions().get(i);
			assertEquals("Incorrect StartDayOfWeek",OctopusConsortium.Service.Models.DayOfWeek.values()[i], rotaS.getStartDayOfWeek());	
			assertEquals("incorrect start time hours",8, rotaS.getStartTime().getHours());
			assertEquals("incorrect start time minutes",30, rotaS.getEndTime().getMinutes());
			assertEquals("incorrect end time hours",18, rotaS.getEndTime().getHours());
			assertEquals("incorrect end time minutes",30, rotaS.getEndTime().getMinutes());
		}
			
		assertEquals("incorrect Address", 456 ,scs.getServiceType().getId());
		assertEquals("incorrect Address", "testservicetypename" ,scs.getServiceType().getName());
		//assertEquals("incorrect Address", DatatypeFactory.newInstance().newXMLGregorianCalendar(updateTime) ,scs.getUpdateTime());
		assertEquals("incorrect Address", "testurl" ,scs.getUrl());
	}
	
	private ArrayOfServiceCareSummaryDestination getTestArrayOfServiceCareSummaryDestination(ObjectFactory of, GregorianCalendar updateTime) throws DatatypeConfigurationException{
		
		ArrayOfServiceCareSummaryDestination returnValue = of.createArrayOfServiceCareSummaryDestination();
		ServiceCareSummaryDestination scsd = of.createServiceCareSummaryDestination();
		returnValue.getServiceCareSummaryDestination().add(scsd);
		scsd.setAddress("testaddress");
		scsd.setCapacity(Capacity.NONE);
		scsd.setContactDetails("testcontactdetails");
		scsd.setEastings(12);
		scsd.setId(10);
		scsd.setName("testname");
		scsd.setNorthings(13);
		scsd.setNotes("testnotes");
		//scsd.setObsolete(false);
		scsd.setOdsCode("testodscode");
		scsd.setOpenAllHours(true);
		scsd.setPostcode("testpostcode");
		//scsd.setRootParent(of.createServiceDetails());
		//scsd.getRootParent().setId(123);
		//scsd.getRootParent().setName("testrootname");
		ArrayOfServiceCareItemRotaSession scirs = of.createArrayOfServiceCareItemRotaSession();
		scsd.setRotaSessions(scirs);
		ServiceCareItemRotaSession scrs = null;
		for(int i = 0; i < 7; i++)
		{
			scrs = of.createServiceCareItemRotaSession();
			scirs.getServiceCareItemRotaSession().add(scrs);
			scrs.setStartDayOfWeek(DayOfWeek.values()[i]);
			scrs.setStartTime(of.createTimeOfDay());
			scrs.getStartTime().setHours((short)8);
			scrs.getStartTime().setMinutes((short)30);
			scrs.setEndTime(of.createTimeOfDay());
			scrs.getEndTime().setHours((short)18);
			scrs.getEndTime().setMinutes((short)30);
		}
		
		
		scsd.setServiceType(of.createServiceDetails());
		scsd.getServiceType().setId(456);
		scsd.getServiceType().setName("testservicetypename");
			
		//scsd.setUpdateTime(DatatypeFactory.newInstance().newXMLGregorianCalendar(updateTime));
		scsd.setUrl("testurl");
		
		return returnValue;
	}
}
