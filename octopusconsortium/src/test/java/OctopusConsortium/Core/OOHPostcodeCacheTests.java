package OctopusConsortium.Core;



import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.HashMap;

import org.junit.Test;

import OctopusConsortium.Models.PostCodes.OOHPreferredProvider;
import OctopusConsortium.Models.PostCodes.Records.Row;

public class OOHPostcodeCacheTests {

	@Test
	public void ctor_WithValidXmlFile_ReturnsCorrectMessages() {
		
		InputStream stream = this.getClass().getResourceAsStream("/testPostcodes.xml");
		
		OOHPostcodeCache sut = null;
		try {
			sut = new OOHPostcodeCache(stream);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
		HashMap<String, Row> records = sut.getPostCodeRecords();
		
		assertNotNull(records);
		assertTrue(records.size() == 2);
		assertEquals((long)1360186382, (long)records.get("e105aa").getServiceId());
		assertEquals((long)1360186382, (long)records.get("e105ab").getServiceId());
	}
	
	@Test
	public void searchForService_WithExistingPostCode_ReturnsMatch() {
		InputStream stream = this.getClass().getResourceAsStream("/testPostcodes.xml");
		
		OOHPostcodeCache sut = null;
		try {
			sut = new OOHPostcodeCache(stream);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
		OOHPreferredProvider result = sut.searchForService("E10  5AA");
		
		assertNotNull(result);
		assertEquals(1360186382, result.getServiceId());
		assertEquals("ONEL WF - GP Out of Hours Triage Only (PELC)", result.getName());
		assertEquals("Y028240003", result.getOdsCode());
		assertEquals("Becketts House", result.getAddress());
		assertEquals("E11 1NR", result.getServicePostcode());
	}
	
	@Test
	public void searchForService_WithNonExistingPostCode_ReturnsNull() {
		InputStream stream = this.getClass().getResourceAsStream("/testPostcodes.xml");
		
		OOHPostcodeCache sut = null;
		try {
			sut = new OOHPostcodeCache(stream);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
		OOHPreferredProvider result = sut.searchForService("Some Postcode");
		
		assertNull(result);
	}
	
}
