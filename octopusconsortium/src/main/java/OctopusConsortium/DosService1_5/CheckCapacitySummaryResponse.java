
package OctopusConsortium.DosService1_5;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="TransactionId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RequestedAtDateTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SearchDateTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CalculatedAgeInDays" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="SearchDistance" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="SearchDistanceUsedSource" type="{https://nww.pathwaysdos.nhs.uk/app/api/webservices}DistanceSource"/>
 *         &lt;element name="CheckCapacitySummaryResult" type="{https://nww.pathwaysdos.nhs.uk/app/api/webservices}ArrayOfServiceCareSummaryDestination"/>
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
    "transactionId",
    "requestedAtDateTime",
    "searchDateTime",
    "calculatedAgeInDays",
    "searchDistance",
    "searchDistanceUsedSource",
    "checkCapacitySummaryResult"
})
@XmlRootElement(name = "CheckCapacitySummaryResponse")
public class CheckCapacitySummaryResponse {

    @XmlElement(name = "TransactionId", required = true)
    protected String transactionId;
    @XmlElement(name = "RequestedAtDateTime", required = true)
    protected String requestedAtDateTime;
    @XmlElement(name = "SearchDateTime", required = true)
    protected String searchDateTime;
    @XmlElement(name = "CalculatedAgeInDays")
    protected Float calculatedAgeInDays;
    @XmlElement(name = "SearchDistance")
    protected int searchDistance;
    @XmlElement(name = "SearchDistanceUsedSource", required = true)
    @XmlSchemaType(name = "string")
    protected DistanceSource searchDistanceUsedSource;
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
     * Gets the value of the requestedAtDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestedAtDateTime() {
        return requestedAtDateTime;
    }

    /**
     * Sets the value of the requestedAtDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestedAtDateTime(String value) {
        this.requestedAtDateTime = value;
    }

    /**
     * Gets the value of the searchDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSearchDateTime() {
        return searchDateTime;
    }

    /**
     * Sets the value of the searchDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSearchDateTime(String value) {
        this.searchDateTime = value;
    }

    /**
     * Gets the value of the calculatedAgeInDays property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getCalculatedAgeInDays() {
        return calculatedAgeInDays;
    }

    /**
     * Sets the value of the calculatedAgeInDays property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setCalculatedAgeInDays(Float value) {
        this.calculatedAgeInDays = value;
    }

    /**
     * Gets the value of the searchDistance property.
     * 
     */
    public int getSearchDistance() {
        return searchDistance;
    }

    /**
     * Sets the value of the searchDistance property.
     * 
     */
    public void setSearchDistance(int value) {
        this.searchDistance = value;
    }

    /**
     * Gets the value of the searchDistanceUsedSource property.
     * 
     * @return
     *     possible object is
     *     {@link DistanceSource }
     *     
     */
    public DistanceSource getSearchDistanceUsedSource() {
        return searchDistanceUsedSource;
    }

    /**
     * Sets the value of the searchDistanceUsedSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link DistanceSource }
     *     
     */
    public void setSearchDistanceUsedSource(DistanceSource value) {
        this.searchDistanceUsedSource = value;
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
