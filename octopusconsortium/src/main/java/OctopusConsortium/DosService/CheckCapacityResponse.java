
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
 *         &lt;element name="CheckCapacityResult" type="{https://nww.pathwaysdos.nhs.uk/app/api/webservices}ArrayOfServiceCareDestination" minOccurs="0"/>
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
    "checkCapacityResult"
})
@XmlRootElement(name = "CheckCapacityResponse")
public class CheckCapacityResponse {

    @XmlElement(name = "CheckCapacityResult")
    protected ArrayOfServiceCareDestination checkCapacityResult;

    /**
     * Gets the value of the checkCapacityResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfServiceCareDestination }
     *     
     */
    public ArrayOfServiceCareDestination getCheckCapacityResult() {
        return checkCapacityResult;
    }

    /**
     * Sets the value of the checkCapacityResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfServiceCareDestination }
     *     
     */
    public void setCheckCapacityResult(ArrayOfServiceCareDestination value) {
        this.checkCapacityResult = value;
    }

}
