//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.09.12 at 02:51:14 PM BST 
//


package OctopusConsortium.Models.PathwaysCase2_4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="initialDispCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="initialDispText" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="timeReached" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
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
    "initialDispCode",
    "initialDispText",
    "timeReached"
})
public class TriageDisposition {

    @XmlElement(required = true)
    protected String initialDispCode;
    @XmlElement(required = true)
    protected String initialDispText;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar timeReached;

    /**
     * Gets the value of the initialDispCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInitialDispCode() {
        return initialDispCode;
    }

    /**
     * Sets the value of the initialDispCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInitialDispCode(String value) {
        this.initialDispCode = value;
    }

    /**
     * Gets the value of the initialDispText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInitialDispText() {
        return initialDispText;
    }

    /**
     * Sets the value of the initialDispText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInitialDispText(String value) {
        this.initialDispText = value;
    }

    /**
     * Gets the value of the timeReached property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTimeReached() {
        return timeReached;
    }

    /**
     * Sets the value of the timeReached property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTimeReached(XMLGregorianCalendar value) {
        this.timeReached = value;
    }

}