package OctopusConsortium.Service.Models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubmitToCallQueueCallbackRequest", propOrder = {
			"caseDetails",
		    "patientDetails"
		})
@XmlRootElement(name = "SubmitToCallQueueCallbackRequest")
public class SubmitToCallQueueCallbackRequest {
	 @XmlElement(name = "CaseDetails", required = true)
	 protected SubmitToCallQueueDetails caseDetails;
	 @XmlElement(name = "PatientDetails", required = true)
	 protected SubmitPatientCallback patientDetails;
	 
	public SubmitToCallQueueDetails getCaseDetails()
	 {
		 return caseDetails;
	 }

	public void setCaseDetails(SubmitToCallQueueDetails value)
	 {
		 caseDetails = value;
	 }

	public SubmitPatientCallback getPatientDetails()
	 {
		 return patientDetails;
	 }

	public void setPatientDetails(SubmitPatientCallback value)
	 {
		 patientDetails = value;
	 } 
}