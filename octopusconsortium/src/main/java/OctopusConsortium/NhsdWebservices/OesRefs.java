
package OctopusConsortium.NhsdWebservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OesRefs complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OesRefs">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ReferenceText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OesRefs", propOrder = {
    "referenceText"
})
public class OesRefs {

    @XmlElement(name = "ReferenceText")
    protected String referenceText;

    /**
     * Gets the value of the referenceText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenceText() {
        return referenceText;
    }

    /**
     * Sets the value of the referenceText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenceText(String value) {
        this.referenceText = value;
    }

}
