package OctopusConsortium.Core;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import static org.mockito.Mockito.*;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.interceptor.Fault;
import org.junit.Test;

//import edu.umd.cs.findbugs.annotations.ExpectWarning;

public class SubmitToCallQueueDobValidationInterceptorTests {

	private String _enquiry = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"services.nhsd.messages\">" +
			   "<soapenv:Header/>" +
			   "<soapenv:Body>" +
			      "<ser:SubmitToCallQueueEnquiry>" +
			         "<Authentication>" +
			            "<Username>admn</Username>" +
			            "<Password>admnUat</Password>" +
			         "</Authentication>" +
			         "<SubmitToCallQueueRequest>" +
			            "<CaseDetails>" +
			               "<ExternalReference>test ref</ExternalReference>" +
			               "<Source>test source</Source>" +
			               "<DispositionCode>19</DispositionCode>" +
			               "<DispositionName> test DispositionName</DispositionName>" +
			               "<CaseSummary>" +
			                  "<SummaryItem>" +
			                     "<Name>testItem1</Name>" +
			                     "<Caption>testItem1 caption</Caption>" +
			                     "<Values>" +
			                        "<Value>testItem1 Value 1</Value>" +
			                        "<Value>testItem1 Value 2</Value>" +
			                     "</Values>" +
			                  "</SummaryItem>" +
			                  "<SummaryItem>" +
			                     "<Name>testItem2</Name>" +
			                     "<Caption>testItem2 caption</Caption>" +
			                     "<Values>" +
			                        "<Value>testItem2 Value 1</Value>" +
			                        "<Value>testItem2 Value 2</Value>" +
			                        "<Value>testItem2 Value 3</Value>" +
			                     "</Values>" +
			                  "</SummaryItem>" +
			               "</CaseSummary>" +
			               "<Provider>Hurley Group Test</Provider>" +
			            "</CaseDetails>" +
			            "<PatientDetails>" +
			               "<Forename>test1forename</Forename>" +
			               "<Surname>tSurname</Surname>" +
			               "<DateOfBirth>" +
			                  "<dateOfBirth>%s</dateOfBirth>" +
			               "</DateOfBirth>" +
			               "<Gender>Male</Gender>" +
			               "<NhsNumber>12345</NhsNumber>" +
			               "<InformantType>Self</InformantType>" +
			               "<InformantName>InformantName</InformantName>" +
			               "<CurrentAddress>" +
			                  "<StreetAddressLine1>CA StreetAddressLine1</StreetAddressLine1>" +
			                  "<StreetAddressLine2>CA StreetAddressLine2</StreetAddressLine2>" +
			                  "<StreetAddressLine3>CA StreetAddressLine3</StreetAddressLine3>" +
			                  "<StreetAddressLine4>CA StreetAddressLine4</StreetAddressLine4>" +
			                  "<StreetAddressLine5>CA StreetAddressLine5</StreetAddressLine5>" +
			                  "<PostalCode>SP1 3DX</PostalCode>" +
			               "</CurrentAddress>" +
			               "<HomeAddress>" +
			                  "<StreetAddressLine1>HA StreetAddressLine1</StreetAddressLine1>" +
			                  "<StreetAddressLine2>HA StreetAddressLine2</StreetAddressLine2>" +
			                  "<StreetAddressLine3>HA StreetAddressLine3</StreetAddressLine3>" +
			                  "<StreetAddressLine4>HA StreetAddressLine4</StreetAddressLine4>" +
			                  "<StreetAddressLine5>HA StreetAddressLine5</StreetAddressLine5>" +
			                  "<PostalCode>SP1 3DX</PostalCode>" +
			               "</HomeAddress>" +
			               "<GpPractice>" +
			                  "<Name>GpPractice Name</Name>" +
			                  "<Address>" +
			                     "<StreetAddressLine1>GP StreetAddressLine1</StreetAddressLine1>" +
			                     "<StreetAddressLine2>GP StreetAddressLine2</StreetAddressLine2>" +
			                     "<StreetAddressLine3>GP StreetAddressLine3</StreetAddressLine3>" +
			                     "<StreetAddressLine4>GP StreetAddressLine4</StreetAddressLine4>" +
			                     "<StreetAddressLine5>GP StreetAddressLine5</StreetAddressLine5>" +
			                     "<PostalCode>SP1 3NW</PostalCode>" +
			                  "</Address>" +
			                  "<Telephone>01722 123123</Telephone>" +
			                  "<ODS>ODStest</ODS>" +
			               "</GpPractice>" +
			               "<EmailAddress>?</EmailAddress>" +
			               "<TelephoneNumber>test@nhsdirect.nhs.uk</TelephoneNumber>" +
			            "</PatientDetails>" +
			         "</SubmitToCallQueueRequest>" +
			      "</ser:SubmitToCallQueueEnquiry>" +
			   "</soapenv:Body>" +
			"</soapenv:Envelope>";
	
	private String _verifyPatient = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"services.nhsd.messages\">" +
								   "<soapenv:Header/>" +
								   "<soapenv:Body>" +
								      "<ser:VerifyPatient>" +
								         "<Authentication>" +
								            "<Username>?</Username>" +
								            "<Password>?</Password>" +
								         "</Authentication>" +
								         "<IdentifyPatientRequest>" +
								            "<Forename>?</Forename>" +
								            "<Surname>?</Surname>" +
								            "<!--Optional:-->" +
								            "<DateOfBirth>rubbish</DateOfBirth>" +
								            "<!--Optional:-->" +
								            "<Gender>?</Gender>" +
								            "<!--Optional:-->" +
								            "<NhsNumber>?</NhsNumber>" +
								            "<!--Optional:-->" +
								            "<Address>?</Address>" +
								            "<!--Optional:-->" +
								            "<Postcode>?</Postcode>" +
								         "</IdentifyPatientRequest>" +
								      "</ser:VerifyPatient>" +
								   "</soapenv:Body>" +
								"</soapenv:Envelope>";
	
	@Test
	public void HandleMessage_WithIncorrectAction_DoesntValidateDob() {
		SubmitToCallQueueDobValidationInterceptor sut = null;
		try {
			sut = new SubmitToCallQueueDobValidationInterceptor();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
			fail("failed to create system under test.");
		}
		SoapMessage message = mock(SoapMessage.class);
		when(message.get("SOAPAction")).thenReturn("VerifyPatient");

		InputStream is = null;
		try {
			is = new ByteArrayInputStream(_verifyPatient.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			fail("error creating input stream.");
		}  
		when(message.getContent(InputStream.class)).thenReturn(is);
		
		sut.handleMessage(message);
	}
	
	@Test(expected = Fault.class)
	public void HandleMessage_WithIncorrectDob_ThrowsFaultException()
	{
		SubmitToCallQueueDobValidationInterceptor sut = null;
		try {
			sut = new SubmitToCallQueueDobValidationInterceptor();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
			fail("failed to create system under test.");
		}
		SoapMessage message = mock(SoapMessage.class);
		when(message.get("SOAPAction")).thenReturn("SubmitToCallQueueCallback");

		InputStream is = null;
		try {
			is = new ByteArrayInputStream(String.format(_enquiry, "198012-01").getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			fail("error creating input stream.");
		}  
		when(message.getContent(InputStream.class)).thenReturn(is);
		
		sut.handleMessage(message);		
	}
	
	@Test
	public void HandleMessage_WithCorrectDob_Succeeds()
	{
		SubmitToCallQueueDobValidationInterceptor sut = null;
		try {
			sut = new SubmitToCallQueueDobValidationInterceptor();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
			fail("failed to create system under test.");
		}
		SoapMessage message = mock(SoapMessage.class);
		when(message.get("SOAPAction")).thenReturn("SubmitToCallQueueCallback");

		InputStream is = null;
		try {
			is = new ByteArrayInputStream(String.format(_enquiry, "1980-12-01").getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			fail("error creating input stream.");
		}  
		when(message.getContent(InputStream.class)).thenReturn(is);
		
		sut.handleMessage(message);		
	}
}
