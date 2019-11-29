
package OctopusConsortium.DosService1_3;

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
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TransactionId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="CheckCapacitySummaryResult" type="{https://nww.pathwaysdos.nhs.uk/app/api/webservices}ArrayOfServiceCareSummaryDestination"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "transactionId",
    "checkCapacitySummaryResult"
})
@XmlRootElement(name = "CheckCapacitySummaryResponse")
public class CheckCapacitySummaryResponse {

    @XmlElement(name = "TransactionId", required = true)
    protected String transactionId;
    @XmlElement(name = "CheckCapacitySummaryResult", required = true)
    protected ArrayOfServiceCareSummaryDestination checkCapacitySummaryResult;

    /**
     * Gets the value of the transactionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * Sets the value of the transactionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionId(String value) {
        this.transactionId = value;
    }

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
