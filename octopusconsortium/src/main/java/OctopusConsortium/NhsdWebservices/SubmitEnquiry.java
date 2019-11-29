
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
 *         &lt;element name="enq" type="{http://services.nhsdirect.nhs.uk/}OesEnquiry" minOccurs="0"/>
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
    "enq"
})
@XmlRootElement(name = "SubmitEnquiry")
public class SubmitEnquiry {

    protected OesEnquiry enq;

    /**
     * Gets the value of the enq property.
     * 
     * @return
     *     possible object is
     *     {@link OesEnquiry }
     *     
     */
    public OesEnquiry getEnq() {
        return enq;
    }

    /**
     * Sets the value of the enq property.
     * 
     * @param value
     *     allowed object is
     *     {@link OesEnquiry }
     *     
     */
    public void setEnq(OesEnquiry value) {
        this.enq = value;
    }

}
