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


/**
 * <p>Java class for POCD_MT000002UK01.EncompassingEncounter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="POCD_MT000002UK01.EncompassingEncounter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="realmCode" type="{urn:hl7-org:v3}CS" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="typeId" type="{urn:hl7-org:v3}POCD_MT000002UK01.InfrastructureRoot.typeId" minOccurs="0"/>
 *         &lt;element name="templateId" type="{urn:hl7-org:v3}II" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{NPFIT:HL7:Localisation}contentId" minOccurs="0"/>
 *         &lt;element name="id" type="{urn:hl7-org:v3}II" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="code" type="{urn:hl7-org:v3}CE" minOccurs="0"/>
 *         &lt;element name="effectiveTime" type="{urn:hl7-org:v3}IVL_TS"/>
 *         &lt;element name="dischargeDispositionCode" type="{urn:hl7-org:v3}CE" minOccurs="0"/>
 *         &lt;element name="responsibleParty" type="{urn:hl7-org:v3}POCD_MT000002UK01.ResponsibleParty" minOccurs="0"/>
 *         &lt;element name="encounterParticipant" type="{urn:hl7-org:v3}POCD_MT000002UK01.EncounterParticipant" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="location" type="{urn:hl7-org:v3}POCD_MT000002UK01.Location" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="nullFlavor" type="{urn:hl7-org:v3}NullFlavor" />
 *       &lt;attribute name="classCode" type="{urn:hl7-org:v3}ActClass" fixed="ENC" />
 *       &lt;attribute name="moodCode" type="{urn:hl7-org:v3}ActMood" fixed="EVN" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "POCD_MT000002UK01.EncompassingEncounter", propOrder = {
    "realmCode",
    "typeId",
    "templateId",
    "contentId",
    "id",
    "code",
    "effectiveTime",
    "dischargeDispositionCode",
    "responsibleParty",
    "encounterParticipant",
    "location"
})
public class POCDMT000002UK01EncompassingEncounter {

    protected List<CS> realmCode;
    protected POCDMT000002UK01InfrastructureRootTypeId typeId;
    protected List<II> templateId;
    @XmlElement(namespace = "NPFIT:HL7:Localisation")
    protected TemplateContent contentId;
    protected List<II> id;
    protected CE code;
    @XmlElement(required = true)
    protected IVLTS effectiveTime;
    protected CE dischargeDispositionCode;
    protected POCDMT000002UK01ResponsibleParty responsibleParty;
    protected List<POCDMT000002UK01EncounterParticipant> encounterParticipant;
    protected POCDMT000002UK01Location location;
    @XmlAttribute
    protected List<String> nullFlavor;
    @XmlAttribute
    protected List<String> classCode;
    @XmlAttribute
    protected List<String> moodCode;

    /**
     * Gets the value of the realmCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the realmCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRealmCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CS }
     * 
     * 
     */
    public List<CS> getRealmCode() {
        if (realmCode == null) {
            realmCode = new ArrayList<CS>();
        }
        return this.realmCode;
    }

    /**
     * Gets the value of the typeId property.
     * 
     * @return
     *     possible object is
     *     {@link POCDMT000002UK01InfrastructureRootTypeId }
     *     
     */
    public POCDMT000002UK01InfrastructureRootTypeId getTypeId() {
        return typeId;
    }

    /**
     * Sets the value of the typeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link POCDMT000002UK01InfrastructureRootTypeId }
     *     
     */
    public void setTypeId(POCDMT000002UK01InfrastructureRootTypeId value) {
        this.typeId = value;
    }

    /**
     * Gets the value of the templateId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the templateId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTemplateId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link II }
     * 
     * 
     */
    public List<II> getTemplateId() {
        if (templateId == null) {
            templateId = new ArrayList<II>();
        }
        return this.templateId;
    }

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
     * Gets the value of the id property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the id property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link II }
     * 
     * 
     */
    public List<II> getId() {
        if (id == null) {
            id = new ArrayList<II>();
        }
        return this.id;
    }

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link CE }
     *     
     */
    public CE getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link CE }
     *     
     */
    public void setCode(CE value) {
        this.code = value;
    }

    /**
     * Gets the value of the effectiveTime property.
     * 
     * @return
     *     possible object is
     *     {@link IVLTS }
     *     
     */
    public IVLTS getEffectiveTime() {
        return effectiveTime;
    }

    /**
     * Sets the value of the effectiveTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link IVLTS }
     *     
     */
    public void setEffectiveTime(IVLTS value) {
        this.effectiveTime = value;
    }

    /**
     * Gets the value of the dischargeDispositionCode property.
     * 
     * @return
     *     possible object is
     *     {@link CE }
     *     
     */
    public CE getDischargeDispositionCode() {
        return dischargeDispositionCode;
    }

    /**
     * Sets the value of the dischargeDispositionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link CE }
     *     
     */
    public void setDischargeDispositionCode(CE value) {
        this.dischargeDispositionCode = value;
    }

    /**
     * Gets the value of the responsibleParty property.
     * 
     * @return
     *     possible object is
     *     {@link POCDMT000002UK01ResponsibleParty }
     *     
     */
    public POCDMT000002UK01ResponsibleParty getResponsibleParty() {
        return responsibleParty;
    }

    /**
     * Sets the value of the responsibleParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link POCDMT000002UK01ResponsibleParty }
     *     
     */
    public void setResponsibleParty(POCDMT000002UK01ResponsibleParty value) {
        this.responsibleParty = value;
    }

    /**
     * Gets the value of the encounterParticipant property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the encounterParticipant property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEncounterParticipant().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link POCDMT000002UK01EncounterParticipant }
     * 
     * 
     */
    public List<POCDMT000002UK01EncounterParticipant> getEncounterParticipant() {
        if (encounterParticipant == null) {
            encounterParticipant = new ArrayList<POCDMT000002UK01EncounterParticipant>();
        }
        return this.encounterParticipant;
    }

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link POCDMT000002UK01Location }
     *     
     */
    public POCDMT000002UK01Location getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link POCDMT000002UK01Location }
     *     
     */
    public void setLocation(POCDMT000002UK01Location value) {
        this.location = value;
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
     * Gets the value of the classCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the classCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClassCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getClassCode() {
        if (classCode == null) {
            classCode = new ArrayList<String>();
        }
        return this.classCode;
    }

    /**
     * Gets the value of the moodCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the moodCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMoodCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getMoodCode() {
        if (moodCode == null) {
            moodCode = new ArrayList<String>();
        }
        return this.moodCode;
    }

}
