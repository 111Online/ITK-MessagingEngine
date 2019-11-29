/**
 * 
 */
package OctopusConsortium.Service.Models;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * @author stuart.yeates
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubmitEncounterResponse", propOrder = {
    "errors",
    "overallStatus",
    "patient",
    "repeatCallerStatus",
    "haSCSessionId"
})
public class SubmitEncounterResponse {

    @XmlElement(name = "Errors")
    protected List<String> errors;
    @XmlElement(name = "OverallStatus", required = true)
    protected SubmitEncounterResponseOverallStatus overallStatus;
    @XmlElement(name = "Patient", required = true)
    protected Patient patient;
    @XmlElement(name = "RepeatCallerStatus", required = true)
    protected RepeatCallerStatus repeatCallerStatus;
    @XmlElement(name = "HaSCSessionId", required = true)
    protected String haSCSessionId;
    @XmlTransient
    protected HaSC hasc;
    
    public HaSC getHaSC() {
		return hasc;
	}

	public void setHaSC(HaSC hasc) {
		if(hasc==null)
			this.haSCSessionId = null;
		else
			this.haSCSessionId = hasc.getId();
		this.hasc = hasc;
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
     *     {@link SubmitEncounterResponseOverallStatus }
     *     
     */
    public SubmitEncounterResponseOverallStatus getOverallStatus() {
        return overallStatus;
    }

    /**
     * Sets the value of the overallStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubmitEncounterResponseOverallStatus }
     *     
     */
    public void setOverallStatus(SubmitEncounterResponseOverallStatus value) {
        this.overallStatus = value;
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
    /**
     * Gets the value of the haSCSessionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHaSCSessionId() {
        return haSCSessionId;
    }

    /**
     * Sets the value of the haSCSessionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHaSCSessionId(String value) {
        this.haSCSessionId = value;
    }
    /**
     * Gets the value of the repeatCallerStatus property.
     * 
     * @return
     *     possible object is
     *     {@link RepeatCallerStatus }
     *     
     */
    public RepeatCallerStatus getRepeatCallerStatus() {
        return repeatCallerStatus;
    }

    /**
     * Sets the value of the repeatCallerStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link RepeatCallerStatus }
     *     
     */
    public void setRepeatCallerStatus(RepeatCallerStatus value) {
        this.repeatCallerStatus = value;
    }

    
    
    
}
