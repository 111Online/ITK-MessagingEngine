
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
 *         &lt;element name="SubmitUsefulInformationResult" type="{http://services.nhsdirect.nhs.uk/}CallResult" minOccurs="0"/>
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
    "submitUsefulInformationResult"
})
@XmlRootElement(name = "SubmitUsefulInformationResponse")
public class SubmitUsefulInformationResponse {

    @XmlElement(name = "SubmitUsefulInformationResult")
    protected CallResult submitUsefulInformationResult;

    /**
     * Gets the value of the submitUsefulInformationResult property.
     * 
     * @return
     *     possible object is
     *     {@link CallResult }
     *     
     */
    public CallResult getSubmitUsefulInformationResult() {
        return submitUsefulInformationResult;
    }

    /**
     * Sets the value of the submitUsefulInformationResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link CallResult }
     *     
     */
    public void setSubmitUsefulInformationResult(CallResult value) {
        this.submitUsefulInformationResult = value;
    }

}
