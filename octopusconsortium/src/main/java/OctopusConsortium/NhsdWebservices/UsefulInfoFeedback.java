
package OctopusConsortium.NhsdWebservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UsefulInfoFeedback complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UsefulInfoFeedback">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Partner" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PartnerPassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UsefulInfo" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="PageLocation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UsefulInfoFeedback", propOrder = {
    "partner",
    "partnerPassword",
    "usefulInfo",
    "pageLocation"
})
public class UsefulInfoFeedback {

    @XmlElement(name = "Partner")
    protected String partner;
    @XmlElement(name = "PartnerPassword")
    protected String partnerPassword;
    @XmlElement(name = "UsefulInfo")
    protected boolean usefulInfo;
    @XmlElement(name = "PageLocation")
    protected String pageLocation;

    /**
     * Gets the value of the partner property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartner() {
        return partner;
    }

    /**
     * Sets the value of the partner property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartner(String value) {
        this.partner = value;
    }

    /**
     * Gets the value of the partnerPassword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartnerPassword() {
        return partnerPassword;
    }

    /**
     * Sets the value of the partnerPassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartnerPassword(String value) {
        this.partnerPassword = value;
    }

    /**
     * Gets the value of the usefulInfo property.
     * 
     */
    public boolean isUsefulInfo() {
        return usefulInfo;
    }

    /**
     * Sets the value of the usefulInfo property.
     * 
     */
    public void setUsefulInfo(boolean value) {
        this.usefulInfo = value;
    }

    /**
     * Gets the value of the pageLocation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPageLocation() {
        return pageLocation;
    }

    /**
     * Sets the value of the pageLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPageLocation(String value) {
        this.pageLocation = value;
    }

}
