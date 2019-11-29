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
 * <p>Java class for QUPA_MT000001GB01.Author complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="QUPA_MT000001GB01.Author">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{urn:hl7-org:v3}InfrastructureRootElements"/>
 *         &lt;element ref="{NPFIT:HL7:Localisation}contentId"/>
 *         &lt;choice>
 *           &lt;group ref="{urn:hl7-org:v3}NPFIT-100033_Role"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{urn:hl7-org:v3}InfrastructureRootAttributes"/>
 *       &lt;attribute name="typeCode" use="required" type="{urn:hl7-org:v3}cs" fixed="AUT" />
 *       &lt;attribute name="contextControlCode" use="required" type="{urn:hl7-org:v3}ContextControl" fixed="OP" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QUPA_MT000001GB01.Author", propOrder = {
    "contentId",
    "cocdtp145200GB01AssignedAuthor"
})
public class QUPAMT000001GB01Author {

    @XmlElement(namespace = "NPFIT:HL7:Localisation", required = true)
    protected TemplateContent contentId;
    @XmlElement(name = "COCD_TP145200GB01.AssignedAuthor")
    protected COCDTP145200GB01AssignedAuthor cocdtp145200GB01AssignedAuthor;
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String typeCode;
    @XmlAttribute(required = true)
    protected List<String> contextControlCode;
    @XmlAttribute
    protected List<String> nullFlavor;
    @XmlAttribute
    protected CsUpdateMode updateMode;

    /**
     * Gets the value of the contentId property.
     * 
     * @return
     *     possible object is
     *     {@link TemplateContent }
     *     
     */
    public TemplateContent getContentId() {
        return contentId;
    }

    /**
     * Sets the value of the contentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link TemplateContent }
     *     
     */
    public void setContentId(TemplateContent value) {
        this.contentId = value;
    }

    /**
     * Gets the value of the cocdtp145200GB01AssignedAuthor property.
     * 
     * @return
     *     possible object is
     *     {@link COCDTP145200GB01AssignedAuthor }
     *     
     */
    public COCDTP145200GB01AssignedAuthor getCOCDTP145200GB01AssignedAuthor() {
        return cocdtp145200GB01AssignedAuthor;
    }

    /**
     * Sets the value of the cocdtp145200GB01AssignedAuthor property.
     * 
     * @param value
     *     allowed object is
     *     {@link COCDTP145200GB01AssignedAuthor }
     *     
     */
    public void setCOCDTP145200GB01AssignedAuthor(COCDTP145200GB01AssignedAuthor value) {
        this.cocdtp145200GB01AssignedAuthor = value;
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
            return "AUT";
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
     * Gets the value of the contextControlCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contextControlCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContextControlCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getContextControlCode() {
        if (contextControlCode == null) {
            contextControlCode = new ArrayList<String>();
        }
        return this.contextControlCode;
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

}
