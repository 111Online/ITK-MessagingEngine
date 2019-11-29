
package OctopusConsortium.NhsdWebservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="message" type="{http://services.nhsdirect.nhs.uk/}UsefulInfoFeedback" minOccurs="0"/>
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
    "message"
})
@XmlRootElement(name = "SubmitUsefulInformation")
public class SubmitUsefulInformation {

    protected UsefulInfoFeedback message;

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link UsefulInfoFeedback }
     *     
     */
    public UsefulInfoFeedback getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link UsefulInfoFeedback }
     *     
     */
    public void setMessage(UsefulInfoFeedback value) {
        this.message = value;
    }

}
