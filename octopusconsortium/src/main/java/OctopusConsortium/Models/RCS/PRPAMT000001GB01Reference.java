//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-257 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.10.24 at 03:44:55 PM BST 
//


package OctopusConsortium.Models.RCS;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for PRPA_MT000001GB01.Reference complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PRPA_MT000001GB01.Reference">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{urn:hl7-org:v3}InfrastructureRootElements"/>
 *         &lt;element name="seperatableInd">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{urn:hl7-org:v3}BL">
 *                 &lt;attribute name="value" use="required" type="{urn:hl7-org:v3}bl" fixed="false" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="referredToRequest" type="{urn:hl7-org:v3}PRPA_MT000001GB01.Request"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{urn:hl7-org:v3}InfrastructureRootAttributes"/>
 *       &lt;attribute name="typeCode" use="required" type="{urn:hl7-org:v3}cs" fixed="REFR" />
 *       &lt;attribute name="contextConductionInd" use="required" type="{urn:hl7-org:v3}bl" fixed="false" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PRPA_MT000001GB01.Reference", propOrder = {
    "seperatableInd",
    "referredToRequest"
})
public class PRPAMT000001GB01Reference {

    @XmlElement(required = true)
    protected PRPAMT000001GB01Reference.SeperatableInd seperatableInd;
    @XmlElement(required = true)
    protected PRPAMT000001GB01Request referredToRequest;
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String typeCode;
    @XmlAttribute(required = true)
    protected boolean contextConductionInd;
    @XmlAttribute
    protected List<String> nullFlavor;
    @XmlAttribute
    protected CsUpdateMode updateMode;

    /**
     * Gets the value of the seperatableInd property.
     * 
     * @return
     *     possible object is
     *     {@link PRPAMT000001GB01Reference.SeperatableInd }
     *     
     */
    public PRPAMT000001GB01Reference.SeperatableInd getSeperatableInd() {
        return seperatableInd;
    }

    /**
     * Sets the value of the seperatableInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link PRPAMT000001GB01Reference.SeperatableInd }
     *     
     */
    public void setSeperatableInd(PRPAMT000001GB01Reference.SeperatableInd value) {
        this.seperatableInd = value;
    }

    /**
     * Gets the value of the referredToRequest property.
     * 
     * @return
     *     possible object is
     *     {@link PRPAMT000001GB01Request }
     *     
     */
    public PRPAMT000001GB01Request getReferredToRequest() {
        return referredToRequest;
    }

    /**
     * Sets the value of the referredToRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link PRPAMT000001GB01Request }
     *     
     */
    public void setReferredToRequest(PRPAMT000001GB01Request value) {
        this.referredToRequest = value;
    }

    /**
     * Gets the value of the typeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeCode() {
        if (typeCode == null) {
            return "REFR";
        } else {
            return typeCode;
        }
    }

    /**
     * Sets the value of the typeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeCode(String value) {
        this.typeCode = value;
    }

    /**
     * Gets the value of the contextConductionInd property.
     * 
     */
    public boolean isContextConductionInd() {
        return contextConductionInd;
    }

    /**
     * Sets the value of the contextConductionInd property.
     * 
     */
    public void setContextConductionInd(boolean value) {
        this.contextConductionInd = value;
    }

    /**
     * Gets the value of the nullFlavor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nullFlavor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNullFlavor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getNullFlavor() {
        if (nullFlavor == null) {
            nullFlavor = new ArrayList<String>();
        }
        return this.nullFlavor;
    }

    /**
     * Gets the value of the updateMode property.
     * 
     * @return
     *     possible object is
     *     {@link CsUpdateMode }
     *     
     */
    public CsUpdateMode getUpdateMode() {
        return updateMode;
    }

    /**
     * Sets the value of the updateMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link CsUpdateMode }
     *     
     */
    public void setUpdateMode(CsUpdateMode value) {
        this.updateMode = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{urn:hl7-org:v3}BL">
     *       &lt;attribute name="value" use="required" type="{urn:hl7-org:v3}bl" fixed="false" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class SeperatableInd
        extends BL
    {


    }

}