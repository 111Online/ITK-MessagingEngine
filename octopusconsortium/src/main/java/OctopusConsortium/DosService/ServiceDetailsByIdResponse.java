
package OctopusConsortium.DosService;

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
 *         &lt;element name="ContactDetails" type="{https://nww.pathwaysdos.nhs.uk/app/api/webservices}ArrayOfContactDetail" minOccurs="0"/>
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
    "contactDetails"
})
@XmlRootElement(name = "ServiceDetailsByIdResponse")
public class ServiceDetailsByIdResponse {

    @XmlElement(name = "ContactDetails")
    protected ArrayOfContactDetail contactDetails;

    /**
     * Gets the value of the contactDetails property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfContactDetail }
     *     
     */
    public ArrayOfContactDetail getContactDetails() {
        return contactDetails;
    }

    /**
     * Sets the value of the contactDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfContactDetail }
     *     
     */
    public void setContactDetails(ArrayOfContactDetail value) {
        this.contactDetails = value;
    }

}
