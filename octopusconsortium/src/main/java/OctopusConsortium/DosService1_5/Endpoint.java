
package OctopusConsortium.DosService1_5;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Endpoint complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Endpoint">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="endpointOrder" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="transport" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="format" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="interaction" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="businessScenario" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="compression" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="comment" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Endpoint", propOrder = {
    "endpointOrder",
    "transport",
    "format",
    "interaction",
    "businessScenario",
    "address",
    "compression",
    "comment"
})
public class Endpoint {

    protected int endpointOrder;
    @XmlElement(required = true)
    protected String transport;
    @XmlElement(required = true)
    protected String format;
    @XmlElement(required = true)
    protected String interaction;
    @XmlElement(required = true)
    protected String businessScenario;
    @XmlElement(required = true)
    protected String address;
    @XmlElement(required = true)
    protected String compression;
    @XmlElement(required = true)
    protected String comment;

    /**
     * Gets the value of the endpointOrder property.
     * 
     */
    public int getEndpointOrder() {
        return endpointOrder;
    }

    /**
     * Sets the value of the endpointOrder property.
     * 
     */
    public void setEndpointOrder(int value) {
        this.endpointOrder = value;
    }

    /**
     * Gets the value of the transport property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransport() {
        return transport;
    }

    /**
     * Sets the value of the transport property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransport(String value) {
        this.transport = value;
    }

    /**
     * Gets the value of the format property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormat() {
        return format;
    }

    /**
     * Sets the value of the format property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormat(String value) {
        this.format = value;
    }

    /**
     * Gets the value of the interaction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInteraction() {
        return interaction;
    }

    /**
     * Sets the value of the interaction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInteraction(String value) {
        this.interaction = value;
    }

    /**
     * Gets the value of the businessScenario property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessScenario() {
        return businessScenario;
    }

    /**
     * Sets the value of the businessScenario property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessScenario(String value) {
        this.businessScenario = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Gets the value of the compression property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompression() {
        return compression;
    }

    /**
     * Sets the value of the compression property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompression(String value) {
        this.compression = value;
    }

    /**
     * Gets the value of the comment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the value of the comment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComment(String value) {
        this.comment = value;
    }

}
