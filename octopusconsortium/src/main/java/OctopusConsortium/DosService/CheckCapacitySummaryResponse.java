
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
 *         &lt;element name="CheckCapacitySummaryResult" type="{https://nww.pathwaysdos.nhs.uk/app/api/webservices}ArrayOfServiceCareSummaryDestination" minOccurs="0"/>
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
    "checkCapacitySummaryResult"
})
@XmlRootElement(name = "CheckCapacitySummaryResponse")
public class CheckCapacitySummaryResponse {

    @XmlElement(name = "CheckCapacitySummaryResult")
    protected ArrayOfServiceCareSummaryDestination checkCapacitySummaryResult;

    /**
     * Gets the value of the checkCapacitySummaryResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfServiceCareSummaryDestination }
     *     
     */
    public ArrayOfServiceCareSummaryDestination getCheckCapacitySummaryResult() {
        return checkCapacitySummaryResult;
    }

    /**
     * Sets the value of the checkCapacitySummaryResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfServiceCareSummaryDestination }
     *     
     */
    public void setCheckCapacitySummaryResult(ArrayOfServiceCareSummaryDestination value) {
        this.checkCapacitySummaryResult = value;
    }

}
