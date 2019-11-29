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
 * <p>Java class for PRPA_MT000001GB01.RepeatCallerResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PRPA_MT000001GB01.RepeatCallerResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{urn:hl7-org:v3}InfrastructureRootElements"/>
 *         &lt;element name="code">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{urn:hl7-org:v3}CV">
 *                 &lt;attribute name="code" use="required" type="{urn:hl7-org:v3}cs" fixed="02" />
 *                 &lt;attribute name="codeSystem" use="required" type="{urn:hl7-org:v3}uid" fixed="2.16.840.1.113883.2.1.3.2.4.17.420" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="effectiveTime">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{urn:hl7-org:v3}TS">
 *                 &lt;attribute name="value" use="required" type="{urn:hl7-org:v3}ts" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="id" type="{urn:hl7-org:v3}II.NPfIT.uuid.mandatory"/>
 *         &lt;element name="value">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{urn:hl7-org:v3}CV">
 *                 &lt;attribute name="code" use="required" type="{urn:hl7-org:v3}NHS111RepeatCallerServiceResponseType_code" />
 *                 &lt;attribute name="displayName" use="required" type="{urn:hl7-org:v3}NHS111RepeatCallerServiceResponseType_displayName" />
 *                 &lt;attribute name="codeSystem" use="required" type="{urn:hl7-org:v3}uid" fixed="2.16.840.1.113883.2.1.3.2.4.17.421" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="author" type="{urn:hl7-org:v3}PRPA_MT000001GB01.Author"/>
 *         &lt;element name="primaryInformationRecipient" type="{urn:hl7-org:v3}PRPA_MT000001GB01.PrimaryInformationRecipient"/>
 *         &lt;element name="reference" type="{urn:hl7-org:v3}PRPA_MT000001GB01.Reference"/>
 *         &lt;element name="subject" type="{urn:hl7-org:v3}PRPA_MT000001GB01.Subject" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{urn:hl7-org:v3}InfrastructureRootAttributes"/>
 *       &lt;attribute name="classCode" use="required" type="{urn:hl7-org:v3}cs" fixed="OBS" />
 *       &lt;attribute name="moodCode" use="required" type="{urn:hl7-org:v3}cs" fixed="EVN" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PRPA_MT000001GB01.RepeatCallerResponse", propOrder = {
    "code",
    "effectiveTime",
    "id",
    "value",
    "author",
    "primaryInformationRecipient",
    "reference",
    "subject"
})
public class PRPAMT000001GB01RepeatCallerResponse {

    @XmlElement(required = true)
    protected PRPAMT000001GB01RepeatCallerResponse.Code code;
    @XmlElement(required = true)
    protected PRPAMT000001GB01RepeatCallerResponse.EffectiveTime effectiveTime;
    @XmlElement(required = true)
    protected IINPfITUuidMandatory id;
    @XmlElement(required = true)
    protected PRPAMT000001GB01RepeatCallerResponse.Value value;
    @XmlElement(required = true)
    protected PRPAMT000001GB01Author author;
    @XmlElement(required = true)
    protected PRPAMT000001GB01PrimaryInformationRecipient primaryInformationRecipient;
    @XmlElement(required = true)
    protected PRPAMT000001GB01Reference reference;
    @XmlElement(nillable = true)
    protected List<PRPAMT000001GB01Subject> subject;
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String classCode;
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String moodCode;
    @XmlAttribute
    protected List<String> nullFlavor;
    @XmlAttribute
    protected CsUpdateMode updateMode;

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link PRPAMT000001GB01RepeatCallerResponse.Code }
     *     
     */
    public PRPAMT000001GB01RepeatCallerResponse.Code getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link PRPAMT000001GB01RepeatCallerResponse.Code }
     *     
     */
    public void setCode(PRPAMT000001GB01RepeatCallerResponse.Code value) {
        this.code = value;
    }

    /**
     * Gets the value of the effectiveTime property.
     * 
     * @return
     *     possible object is
     *     {@link PRPAMT000001GB01RepeatCallerResponse.EffectiveTime }
     *     
     */
    public PRPAMT000001GB01RepeatCallerResponse.EffectiveTime getEffectiveTime() {
        return effectiveTime;
    }

    /**
     * Sets the value of the effectiveTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link PRPAMT000001GB01RepeatCallerResponse.EffectiveTime }
     *     
     */
    public void setEffectiveTime(PRPAMT000001GB01RepeatCallerResponse.EffectiveTime value) {
        this.effectiveTime = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link IINPfITUuidMandatory }
     *     
     */
    public IINPfITUuidMandatory getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link IINPfITUuidMandatory }
     *     
     */
    public void setId(IINPfITUuidMandatory value) {
        this.id = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link PRPAMT000001GB01RepeatCallerResponse.Value }
     *     
     */
    public PRPAMT000001GB01RepeatCallerResponse.Value getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link PRPAMT000001GB01RepeatCallerResponse.Value }
     *     
     */
    public void setValue(PRPAMT000001GB01RepeatCallerResponse.Value value) {
        this.value = value;
    }

    /**
     * Gets the value of the author property.
     * 
     * @return
     *     possible object is
     *     {@link PRPAMT000001GB01Author }
     *     
     */
    public PRPAMT000001GB01Author getAuthor() {
        return author;
    }

    /**
     * Sets the value of the author property.
     * 
     * @param value
     *     allowed object is
     *     {@link PRPAMT000001GB01Author }
     *     
     */
    public void setAuthor(PRPAMT000001GB01Author value) {
        this.author = value;
    }

    /**
     * Gets the value of the primaryInformationRecipient property.
     * 
     * @return
     *     possible object is
     *     {@link PRPAMT000001GB01PrimaryInformationRecipient }
     *     
     */
    public PRPAMT000001GB01PrimaryInformationRecipient getPrimaryInformationRecipient() {
        return primaryInformationRecipient;
    }

    /**
     * Sets the value of the primaryInformationRecipient property.
     * 
     * @param value
     *     allowed object is
     *     {@link PRPAMT000001GB01PrimaryInformationRecipient }
     *     
     */
    public void setPrimaryInformationRecipient(PRPAMT000001GB01PrimaryInformationRecipient value) {
        this.primaryInformationRecipient = value;
    }

    /**
     * Gets the value of the reference property.
     * 
     * @return
     *     possible object is
     *     {@link PRPAMT000001GB01Reference }
     *     
     */
    public PRPAMT000001GB01Reference getReference() {
        return reference;
    }

    /**
     * Sets the value of the reference property.
     * 
     * @param value
     *     allowed object is
     *     {@link PRPAMT000001GB01Reference }
     *     
     */
    public void setReference(PRPAMT000001GB01Reference value) {
        this.reference = value;
    }

    /**
     * Gets the value of the subject property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subject property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubject().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PRPAMT000001GB01Subject }
     * 
     * 
     */
    public List<PRPAMT000001GB01Subject> getSubject() {
        if (subject == null) {
            subject = new ArrayList<PRPAMT000001GB01Subject>();
        }
        return this.subject;
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
            return "OBS";
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
     * Gets the value of the moodCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMoodCode() {
        if (moodCode == null) {
            return "EVN";
        } else {
            return moodCode;
        }
    }

    /**
     * Sets the value of the moodCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMoodCode(String value) {
        this.moodCode = value;
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
     *     &lt;restriction base="{urn:hl7-org:v3}CV">
     *       &lt;attribute name="code" use="required" type="{urn:hl7-org:v3}cs" fixed="02" />
     *       &lt;attribute name="codeSystem" use="required" type="{urn:hl7-org:v3}uid" fixed="2.16.840.1.113883.2.1.3.2.4.17.420" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Code
        extends CV
    {


    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{urn:hl7-org:v3}TS">
     *       &lt;attribute name="value" use="required" type="{urn:hl7-org:v3}ts" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class EffectiveTime
        extends TS
    {


    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{urn:hl7-org:v3}CV">
     *       &lt;attribute name="code" use="required" type="{urn:hl7-org:v3}NHS111RepeatCallerServiceResponseType_code" />
     *       &lt;attribute name="displayName" use="required" type="{urn:hl7-org:v3}NHS111RepeatCallerServiceResponseType_displayName" />
     *       &lt;attribute name="codeSystem" use="required" type="{urn:hl7-org:v3}uid" fixed="2.16.840.1.113883.2.1.3.2.4.17.421" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Value
        extends CV
    {


    }

}
