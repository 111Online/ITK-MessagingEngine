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
 *         &lt;element name="pathwayVersion">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="major" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="minor" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="subRevision" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="pathwayId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pathwayOrderNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "pathwayVersion",
    "pathwayId",
    "pathwayOrderNo"
})
public class TriageLogicId {

    @XmlElement(required = true)
    protected PathwayVersion pathwayVersion;
    @XmlElement(required = true)
    protected String pathwayId;
    @XmlElement(required = true)
    protected String pathwayOrderNo;

    /**
     * Gets the value of the pathwayVersion property.
     * 
     * @return
     *     possible object is
     *     {@link PathwayVersion }
     *     
     */
    public PathwayVersion getPathwayVersion() {
        return pathwayVersion;
    }

    /**
     * Sets the value of the pathwayVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link PathwayVersion }
     *     
     */
    public void setPathwayVersion(PathwayVersion value) {
        this.pathwayVersion = value;
    }

    /**
     * Gets the value of the pathwayId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPathwayId() {
        return pathwayId;
    }

    /**
     * Sets the value of the pathwayId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPathwayId(String value) {
        this.pathwayId = value;
    }

    /**
     * Gets the value of the pathwayOrderNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPathwayOrderNo() {
        return pathwayOrderNo;
    }

    /**
     * Sets the value of the pathwayOrderNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPathwayOrderNo(String value) {
        this.pathwayOrderNo = value;
    }

}
