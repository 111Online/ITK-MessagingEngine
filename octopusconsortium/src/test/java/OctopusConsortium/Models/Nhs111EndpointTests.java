package OctopusConsortium.Models;

import static org.junit.Assert.*;

import org.junit.Test;

public class Nhs111EndpointTests {
	
	@Test
	public void getUrlPort_WithUnspecifiedPort_ReturnsDefaultPort() {
		Nhs111Endpoint sut = new Nhs111Endpoint();
		sut.setUrl("https://www.somedomain.com/somepath");
		
		assertEquals("443", sut.getUrlPort());
	}
	
	@Test
	public void getUrlPort_WithSpecifiedPort_ReturnsSpecifiedPort() {
		Nhs111Endpoint sut = new Nhs111Endpoint();
		sut.setUrl("https://www.somedomain.com:1895/somepath");
		
		assertEquals("1895", sut.getUrlPort());		
	}
}
