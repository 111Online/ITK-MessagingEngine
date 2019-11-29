
package OctopusConsortium.NhsdWebservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SubmitEnquiryWithoutAvailabilityCheckResult" type="{http://services.nhsdirect.nhs.uk/}CallResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "submitEnquiryWithoutAvailabilityCheckResult"
})
@XmlRootElement(name = "SubmitEnquiryWithoutAvailabilityCheckResponse")
public class SubmitEnquiryWithoutAvailabilityCheckResponse {

    @XmlElement(name = "SubmitEnquiryWithoutAvailabilityCheckResult")
    protected CallResult submitEnquiryWithoutAvailabilityCheckResult;

    /**
     * Gets the value of the submitEnquiryWithoutAvailabilityCheckResult property.
     * 
     * @return
     *     possible object is
     *     {@link CallResult }
     *     
     */
    public CallResult getSubmitEnquiryWithoutAvailabilityCheckResult() {
        return submitEnquiryWithoutAvailabilityCheckResult;
    }

    /**
     * Sets the value of the submitEnquiryWithoutAvailabilityCheckResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link CallResult }
     *     
     */
    public void setSubmitEnquiryWithoutAvailabilityCheckResult(CallResult value) {
        this.submitEnquiryWithoutAvailabilityCheckResult = value;
    }

}
