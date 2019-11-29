//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-257 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.10.24 at 11:01:41 AM BST 
//


package OctopusConsortium.Models.RCSGB;

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
 * <p>Java class for COCD_TP146246GB01.Component2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="COCD_TP146246GB01.Component2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{urn:hl7-org:v3}InfrastructureRootElements"/>
 *         &lt;element name="templateId">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{urn:hl7-org:v3}II">
 *                 &lt;attribute name="root" use="required">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{urn:hl7-org:v3}uid">
 *                       &lt;enumeration value="2.16.840.1.113883.2.1.3.2.4.18.2"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="extension" use="required">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{urn:hl7-org:v3}st">
 *                       &lt;enumeration value="COCD_TP146246GB01#component5"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="section6" type="{urn:hl7-org:v3}COCD_TP146246GB01.Section6"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{urn:hl7-org:v3}InfrastructureRootAttributes"/>
 *       &lt;attribute name="typeCode" use="required" type="{urn:hl7-org:v3}cs" fixed="COMP" />
 *       &lt;attribute name="contextConductionInd" use="required" type="{urn:hl7-org:v3}bl" fixed="true" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COCD_TP146246GB01.Component2", propOrder = {
    "templateId",
    "section6"
})
public class COCDTP146246GB01Component2 {

    @XmlElement(required = true)
    protected COCDTP146246GB01Component2 .TemplateId templateId;
    @XmlElement(required = true, nillable = true)
    protected COCDTP146246GB01Section6 section6;
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
     * Gets the value of the templateId property.
     * 
     * @return
     *     possible object is
     *     {@link COCDTP146246GB01Component2 .TemplateId }
     *     
     */
    public COCDTP146246GB01Component2 .TemplateId getTemplateId() {
        return templateId;
    }

    /**
     * Sets the value of the templateId property.
     * 
     * @param value
     *     allowed object is
     *     {@link COCDTP146246GB01Component2 .TemplateId }
     *     
     */
    public void setTemplateId(COCDTP146246GB01Component2 .TemplateId value) {
        this.templateId = value;
    }

    /**
     * Gets the value of the section6 property.
     * 
     * @return
     *     possible object is
     *     {@link COCDTP146246GB01Section6 }
     *     
     */
    public COCDTP146246GB01Section6 getSection6() {
        return section6;
    }

    /**
     * Sets the value of the section6 property.
     * 
     * @param value
     *     allowed object is
     *     {@link COCDTP146246GB01Section6 }
     *     
     */
    public void setSection6(COCDTP146246GB01Section6 value) {
        this.section6 = value;
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
            return "COMP";
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
     *     &lt;restriction base="{urn:hl7-org:v3}II">
     *       &lt;attribute name="root" use="required">
     *         &lt;simpleType>
     *           &lt;restriction base="{urn:hl7-org:v3}uid">
     *             &lt;enumeration value="2.16.840.1.113883.2.1.3.2.4.18.2"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *       &lt;attribute name="extension" use="required">
     *         &lt;simpleType>
     *           &lt;restriction base="{urn:hl7-org:v3}st">
     *             &lt;enumeration value="COCD_TP146246GB01#component5"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class TemplateId
        extends II
    {


    }

}
