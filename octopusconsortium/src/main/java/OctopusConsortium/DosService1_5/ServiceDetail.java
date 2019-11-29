
package OctopusConsortium.DosService1_5;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ServiceDetail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="odsCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="serviceEndpoints" type="{https://nww.pathwaysdos.nhs.uk/app/api/webservices}ArrayOfServiceEndpoints" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceDetail", propOrder = {
    "id",
    "odsCode",
    "serviceEndpoints"
})
public class ServiceDetail {

    @XmlElement(required = true)
    protected String id;
    @XmlElement(required = true)
    protected String odsCode;
    protected ArrayOfServiceEndpoints serviceEndpoints;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the odsCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOdsCode() {
        return odsCode;
    }

    /**
     * Sets the value of the odsCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOdsCode(String value) {
        this.odsCode = value;
    }

    /**
     * Gets the value of the serviceEndpoints property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfServiceEndpoints }
     *     
     */
    public ArrayOfServiceEndpoints getServiceEndpoints() {
        return serviceEndpoints;
    }

    /**
     * Sets the value of the serviceEndpoints property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfServiceEndpoints }
     *     
     */
    public void setServiceEndpoints(ArrayOfServiceEndpoints value) {
        this.serviceEndpoints = value;
    }

}
