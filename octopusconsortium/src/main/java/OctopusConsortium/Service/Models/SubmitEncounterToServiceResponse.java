package OctopusConsortium.Service.Models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubmitEncounterToServiceResponse", propOrder = {
		    "overallStatus",
		    "repeatCallerStatus"
		})
public class SubmitEncounterToServiceResponse {
    @XmlElement(name = "OverallStatus", required = true)
    protected SubmitEncounterToServiceResponseOverallStatus overallStatus;
    @XmlElement(name = "RepeatCallerStatus", required = true)
    protected RepeatCallerStatus repeatCallerStatus;
    
    public SubmitEncounterToServiceResponse() {
    	overallStatus = SubmitEncounterToServiceResponseOverallStatus.FAILED_CALL_TO_WEBSERVICE;
    	repeatCallerStatus = RepeatCallerStatus.UNDETERMINED;
    }
    
    /**
     * Gets the value of the overallStatus property.
     * 
     * @return
     *     possible object is
     *     {@link SubmitEncounterToServiceResponseOverallStatus }
     *     
     */
    public SubmitEncounterToServiceResponseOverallStatus getOverallStatus() {
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
    public void setOverallStatus(SubmitEncounterToServiceResponseOverallStatus value) {
        this.overallStatus = value;
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
