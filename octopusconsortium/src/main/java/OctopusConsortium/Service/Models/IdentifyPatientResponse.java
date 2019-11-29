package OctopusConsortium.Service.Models;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IdentifyPatientResponse", propOrder = {
    "errors",
    "gpEndpointStatus",
    "overallStatus",
    "repeatCallerStatus",
    "patient"
})
public class IdentifyPatientResponse {

    @XmlElement(name = "Errors")
    protected List<String> errors;
    @XmlElement(name = "OverallStatus", required = true)
    protected IdentifyPatientResponseOverallStatus overallStatus;
    @XmlElement(name = "RepeatCallerStatus", required = true)
    protected RepeatCallerStatus repeatCallerStatus;
    @XmlElement(name = "GPEndpointStatus", required = true)
    protected IdentifyPatientResponseGPEndpointStatus gpEndpointStatus;
    @XmlElement(name = "Patient", required = false)
    protected Patient patient;

    
    public IdentifyPatientResponse()
    {
    	errors = new ArrayList<String>();  
    	gpEndpointStatus = IdentifyPatientResponseGPEndpointStatus.NO_GP_ENDPOINT_LISTED;
    	overallStatus = IdentifyPatientResponseOverallStatus.UNABLE_TO_IDENTIFY_PATIENT;
    	repeatCallerStatus = RepeatCallerStatus.INSUFFICIENT_INFORMATION;
    }
    /**
     * Gets the value of the errors property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the errors property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getErrors().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getErrors() {
        if (errors == null) {
            errors = new ArrayList<String>();
        }
        return this.errors;
    }

    /**
     * Gets the value of the overallStatus property.
     * 
     * @return
     *     possible object is
     *     {@link IdentifyPatientResponseOverallStatus }
     *     
     */
    public IdentifyPatientResponseOverallStatus getOverallStatus() {
        return overallStatus;
    }

    /**
     * Sets the value of the overallStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentifyPatientResponseOverallStatus }
     *     
     */
    public void setOverallStatus(IdentifyPatientResponseOverallStatus value) {
        this.overallStatus = value;
        if(this.overallStatus == IdentifyPatientResponseOverallStatus.UNABLE_TO_IDENTIFY_PATIENT)
        	this.repeatCallerStatus= RepeatCallerStatus.INSUFFICIENT_INFORMATION;
        	this.gpEndpointStatus = IdentifyPatientResponseGPEndpointStatus.NO_GP_ENDPOINT_LISTED;
    } 
    
    /**
     * 
     * @return
     */
    public RepeatCallerStatus getRepeatCallerStatus() {
		return this.repeatCallerStatus;
	}
    /**
     * 
     * @param repeatCallerStatus
     */
	public void setRepeatCallerStatus(RepeatCallerStatus repeatCallerStatus) {
		this.repeatCallerStatus = repeatCallerStatus;
	}
    
	/**
     * 
     * @return
     */
    public IdentifyPatientResponseGPEndpointStatus getGpEndpointStatus() {
		return this.gpEndpointStatus;
	}
    /**
     * 
     * @param gpEndpointStatus
     */
	public void setGpEndpointStatus(IdentifyPatientResponseGPEndpointStatus value) {
		this.gpEndpointStatus = value;
	}
	
    /**
     * Gets the value of the patient property.
     * 
     * @return
     *     possible object is
     *     {@link Patient }
     *     
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * Sets the value of the patient property.
     * 
     * @param value
     *     allowed object is
     *     {@link Patient }
     *     
     */
    public void setPatient(Patient value) {
        this.patient = value;
    }

	
}
