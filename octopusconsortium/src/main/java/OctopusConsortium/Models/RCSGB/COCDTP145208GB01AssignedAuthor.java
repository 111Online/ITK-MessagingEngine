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
 * <p>Java class for COCD_TP145208GB01.AssignedAuthor complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="COCD_TP145208GB01.AssignedAuthor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{urn:hl7-org:v3}InfrastructureRootElements"/>
 *         &lt;element name="code" type="{urn:hl7-org:v3}CV.NPfIT.Codedplain.required"/>
 *         &lt;element name="id" type="{urn:hl7-org:v3}II.NPfIT.oid.required.assigningAuthorityName"/>
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
 *                       &lt;enumeration value="COCD_TP145208GB01#AssignedAuthor"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="representedOrganization" type="{urn:hl7-org:v3}COCD_TP145208GB01.Organization"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{urn:hl7-org:v3}InfrastructureRootAttributes"/>
 *       &lt;attribute name="classCode" use="required" type="{urn:hl7-org:v3}cs" fixed="ASSIGNED" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COCD_TP145208GB01.AssignedAuthor", propOrder = {
    "code",
    "id",
    "templateId",
    "representedOrganization"
})
public class COCDTP145208GB01AssignedAuthor {

    @XmlElement(required = true)
    protected CVNPfITCodedplainRequired code;
    @XmlElement(required = true)
    protected IINPfITOidRequiredAssigningAuthorityName id;
    @XmlElement(required = true)
    protected COCDTP145208GB01AssignedAuthor.TemplateId templateId;
    @XmlElement(required = true)
    protected COCDTP145208GB01Organization representedOrganization;
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String classCode;
    @XmlAttribute
    protected List<String> nullFlavor;
    @XmlAttribute
    protected CsUpdateMode updateMode;

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link CVNPfITCodedplainRequired }
     *     
     */
    public CVNPfITCodedplainRequired getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link CVNPfITCodedplainRequired }
     *     
     */
    public void setCode(CVNPfITCodedplainRequired value) {
        this.code = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link IINPfITOidRequiredAssigningAuthorityName }
     *     
     */
    public IINPfITOidRequiredAssigningAuthorityName getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link IINPfITOidRequiredAssigningAuthorityName }
     *     
     */
    public void setId(IINPfITOidRequiredAssigningAuthorityName value) {
        this.id = value;
    }

    /**
     * Gets the value of the templateId property.
     * 
     * @return
     *     possible object is
     *     {@link COCDTP145208GB01AssignedAuthor.TemplateId }
     *     
     */
    public COCDTP145208GB01AssignedAuthor.TemplateId getTemplateId() {
        return templateId;
    }

    /**
     * Sets the value of the templateId property.
     * 
     * @param value
     *     allowed object is
     *     {@link COCDTP145208GB01AssignedAuthor.TemplateId }
     *     
     */
    public void setTemplateId(COCDTP145208GB01AssignedAuthor.TemplateId value) {
        this.templateId = value;
    }

    /**
     * Gets the value of the representedOrganization property.
     * 
     * @return
     *     possible object is
     *     {@link COCDTP145208GB01Organization }
     *     
     */
    public COCDTP145208GB01Organization getRepresentedOrganization() {
        return representedOrganization;
    }

    /**
     * Sets the value of the representedOrganization property.
     * 
     * @param value
     *     allowed object is
     *     {@link COCDTP145208GB01Organization }
     *     
     */
    public void setRepresentedOrganization(COCDTP145208GB01Organization value) {
        this.representedOrganization = value;
    }

    /**
     * Gets the value of the classCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClassCode() {
        if (classCode == null) {
            return "ASSIGNED";
        } else {
            return classCode;
        }
    }

    /**
     * Sets the value of the classCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClassCode(String value) {
        this.classCode = value;
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
     *             &lt;enumeration value="COCD_TP145208GB01#AssignedAuthor"/>
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
