package OctopusConsortium.Service.Models;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubmitToCallQueueResponse", propOrder = {
		    "errors",
		    "overallStatus",
		    "queueReference"
		})
public class SubmitToCallQueueResponse {
	@XmlElement(name = "Errors")
    protected List<String> errors;
    @XmlElement(name = "OverallStatus", required = true)
    protected SubmitToCallQueueResponseOverallStatus overallStatus;
    @XmlElement(name = "QueueReference", required = true)
    protected String queueReference; 
    
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
        return errors;
    }  
    
    /**
     * Gets the value of the overallStatus property.
     * 
     * @return
     *     possible object is
     *     {@link SubmitToCallQueueResponseOverallStatus }
     *     
     */
    public SubmitToCallQueueResponseOverallStatus getOverallStatus() {
        return overallStatus;
    }

    /**
     * Sets the value of the overallStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubmitToCallQueueResponseOverallStatus }
     *     
     */
    public void setOverallStatus(SubmitToCallQueueResponseOverallStatus value) {
        overallStatus = value;
    }

    
    public void setQueueReference(String value) {
    	queueReference = value;
    }
    public String getQueueReference() {
    	return queueReference;
    }
    
    
}
