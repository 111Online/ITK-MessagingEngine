
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
 *         &lt;element name="GetOESRefsResult" type="{http://services.nhsdirect.nhs.uk/}OesRefs" minOccurs="0"/>
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
    "getOESRefsResult"
})
@XmlRootElement(name = "GetOESRefsResponse")
public class GetOESRefsResponse {

    @XmlElement(name = "GetOESRefsResult")
    protected OesRefs getOESRefsResult;

    /**
     * Gets the value of the getOESRefsResult property.
     * 
     * @return
     *     possible object is
     *     {@link OesRefs }
     *     
     */
    public OesRefs getGetOESRefsResult() {
        return getOESRefsResult;
    }

    /**
     * Sets the value of the getOESRefsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link OesRefs }
     *     
     */
    public void setGetOESRefsResult(OesRefs value) {
        this.getOESRefsResult = value;
    }

}
