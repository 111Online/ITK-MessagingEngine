/**
 * 
 */
package OctopusConsortium.Service.Models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author stuart.yeates
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubmitEncounterToServiceRequest", propOrder = {
			"caseDetails",
		    "patientDetails",
		    "serviceDetails",
		    "sendToRepeatCaller"
		})
@XmlRootElement(name = "SubmitEncounterToServiceRequest")
public class SubmitEncounterToServiceRequest {
	@XmlElement(name = "CaseDetails", required = true)
	protected SubmitToCallQueueDetails caseDetails;
	@XmlElement(name = "PatientDetails", required = true)
	protected SubmitPatientService patientDetails;
	@XmlElement(name = "ServiceDetails", required = true)
	protected SubmitToServiceDetails serviceDetails;
	@XmlElement(name = "SendToRepeatCaller")
	protected boolean sendToRepeatCaller;
			
	public SubmitToCallQueueDetails getCaseDetails()
	{
		return caseDetails;
	}
	public void setCaseDetails(SubmitToCallQueueDetails value)
	{
		caseDetails = value;
	}
	public SubmitPatientService getPatientDetails()
	{
		return patientDetails;
	}
	public void setPatientDetails(SubmitPatientService value)
	{
		patientDetails = value;
	}
		
	public SubmitToServiceDetails getServiceDetails() {
		return serviceDetails;
	}
	public void setServiceDetails(SubmitToServiceDetails value) {
		serviceDetails = value;
	}
	
	public boolean getSendToRepeatCaller() {
		return sendToRepeatCaller;
	}
	public void setSendToRepeatCaller(boolean value) {
		sendToRepeatCaller = value;
	}
}