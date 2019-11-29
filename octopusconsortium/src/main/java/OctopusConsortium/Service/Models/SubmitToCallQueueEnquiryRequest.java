package OctopusConsortium.Service.Models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubmitToCallQueueEnquiryRequest", propOrder = {
			"caseDetails",
		    "patientDetails"
		})
@XmlRootElement(name = "SubmitToCallQueueEnquiryRequest")
public class SubmitToCallQueueEnquiryRequest {
	 @XmlElement(name = "CaseDetails", required = true)
	 protected SubmitToCallQueueDetails caseDetails;
	 @XmlElement(name = "PatientDetails", required = true)
	 protected SubmitPatientEnquiry patientDetails;
	 
	 public SubmitToCallQueueDetails getCaseDetails()
	 {
		 return caseDetails;
	 }
	 public void setCaseDetails(SubmitToCallQueueDetails value)
	 {
		 caseDetails = value;
	 }
	 public SubmitPatientEnquiry getPatientDetails()
	 {
		 return patientDetails;
	 }
	 public void setPatientDetails(SubmitPatientEnquiry value)
	 {
		 patientDetails = (SubmitPatientEnquiry)value;
	 }
}