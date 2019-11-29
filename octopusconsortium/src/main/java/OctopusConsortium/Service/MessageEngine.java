package OctopusConsortium.Service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

import org.apache.cxf.annotations.WSDLDocumentation;
import org.apache.cxf.annotations.WSDLDocumentationCollection;

import OctopusConsortium.Core.CommonValues;
import OctopusConsortium.Service.Models.Authentication;
import OctopusConsortium.Service.Models.FindServicesRequest;
import OctopusConsortium.Service.Models.IdentifyPatientRequest;
import OctopusConsortium.Service.Models.SubmitEncounterToServiceRequest;
import OctopusConsortium.Service.Models.SubmitToCallQueueCallbackRequest;
import OctopusConsortium.Service.Models.SubmitToCallQueueEnquiryRequest;

@WebService(targetNamespace="services.nhsd.messages")
@WSDLDocumentationCollection({
	@WSDLDocumentation("NHS Choices Digital Assesment Services"),
	@WSDLDocumentation(value = "MessageEngine WSDL Specification " +  CommonValues.WSDL_VERSION,
    	placement = WSDLDocumentation.Placement.SERVICE),
})
public interface MessageEngine {	
	@WSDLDocumentation("This operation is used to identify a patient and discover their Repeat Caller status.")
	@WebMethod(action="VerifyPatient")
	public @WebResult(name="IdentifyPatientResponse") 
			OctopusConsortium.Service.Models.IdentifyPatientResponse VerifyPatient(
					@XmlElement(required=true)
					@WebParam(name="Authentication")Authentication authentication,
					@XmlElement(required=true)
					@WebParam(name="IdentifyPatientRequest")IdentifyPatientRequest patientDetails
			);
	@WSDLDocumentation("This operation is used to discover medical services for a given disposition within a specific area.")
	@WebMethod(action="LocateServices")
	public @WebResult(name="FindServicesResponse")
			OctopusConsortium.Service.Models.FindServicesResponse LocateServices(
					@XmlElement(required=true)
					@WebParam(name="Authentication")Authentication authentication,
					@XmlElement(required=true)
					@WebParam(name="FindServicesRequest")FindServicesRequest message
			);
	/*@WebMethod(action="SubmitHaSC")
	public @WebResult(name="SubmitEncounterResponse")
			OctopusConsortium.Models.SubmitEncounterResponse SubmitHaSC(
					@XmlElement(required=true)
					@WebParam(name="Authentication")Authentication authentication,
					@XmlElement(required=true)
					@WebParam(name="SubmitEncounterRequest")SubmitEncounterRequest message
			);*/
	@WSDLDocumentation("This operation returns the service details for an out of hours if available. If the request is made within hours no services are returned.")
	@WebMethod(action="CheckOOHAvailable")
	public @WebResult(name="CheckOOHAvailabilityResponse")
			OctopusConsortium.Service.Models.CheckOOHAvailabilityResponse CheckOOHAvailable(
					@XmlElement(required=true)
					@WebParam(name="Authentication")Authentication authentication,
					@XmlElement(required=true)
					@WebParam(name="CheckOOHAvailabilityRequest")OctopusConsortium.Service.Models.CheckOOHAvailabilityRequest message
				);
	@WSDLDocumentation("This operation provides an asyncronus call that instructs the ESB to retrieve out of hours service details for a given postcode in preperation for any future service calls. It is intended to be used as a non blocking call in the event the CheckOOHAvailable operation is to be called for a specifc postcode in the near future.")
	@WebMethod(action="CacheOOHAvailable")
	public @WebResult(name="CacheOOHAvailabilityResponse")
			OctopusConsortium.Service.Models.CacheOOHAvailabilityResponse CacheOOHAvailable(
					@XmlElement(required=true)
					@WebParam(name="Authentication")Authentication authentication,
					@XmlElement(required=true)
					@WebParam(name="CacheOOHAvailabilityRequest")OctopusConsortium.Service.Models.CacheOOHAvailabilityRequest message
				);
	@WSDLDocumentation("This operation allows a consumer to enquire if a datetime is regarded as being out of hours.")
	@WebMethod(action="IsOOH")
	public @WebResult(name="OohStatus")
		OctopusConsortium.Service.Models.OohStatus IsOOH(
				@XmlElement(required=true)
				@WebParam(name="Authentication")Authentication authentication,
				@XmlElement(required=true)
				@WebParam(name="IsOOHRequest")OctopusConsortium.Service.Models.IsOOHRequest message
				);
	@WSDLDocumentation("This operation is used to submit a completed HaSC to an endpoint.")
	@WebMethod(action="SubmitHaSCToService")
	public @WebResult(name="SubmitEncounterToServiceResponse")
	OctopusConsortium.Service.Models.SubmitEncounterToServiceResponse SubmitHaSCToService(
					@XmlElement(required=true)
					@WebParam(name="Authentication")Authentication authentication,
					@XmlElement(required=true)
					@WebParam(name="SubmitEncounterToServiceRequest")SubmitEncounterToServiceRequest message
			);
	@WSDLDocumentation("This operation is used to submit a callback request into a call queue.")
	@WebMethod(action="SubmitToCallQueueEnquiry")
	public @WebResult(name="SubmitToCallQueueEnquiryResponse")
	OctopusConsortium.Service.Models.SubmitToCallQueueResponse SubmitToCallQueueEnquiry(
					@XmlElement(required=true)
					@WebParam(name="Authentication")Authentication authentication,
					@XmlElement(required=true)
					@WebParam(name="SubmitToCallQueueRequest")SubmitToCallQueueEnquiryRequest message
			);
	@WSDLDocumentation("This operation is used to submit an enquiry into a call queue.")
	@WebMethod(action="SubmitToCallQueueCallback")
	public @WebResult(name="SubmitToCallQueueCallbackResponse")
	OctopusConsortium.Service.Models.SubmitToCallQueueResponse SubmitToCallQueueCallback(
					@XmlElement(required=true)
					@WebParam(name="Authentication")Authentication authentication,
					@XmlElement(required=true)
					@WebParam(name="SubmitToCallQueueRequest")SubmitToCallQueueCallbackRequest message
			);
}