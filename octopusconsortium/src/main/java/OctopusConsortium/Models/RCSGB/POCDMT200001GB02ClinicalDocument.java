//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-257 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.10.24 at 11:01:41 AM BST 
//


package OctopusConsortium.Models.RCSGB;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for POCD_MT200001GB02.ClinicalDocument complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="POCD_MT200001GB02.ClinicalDocument">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{urn:hl7-org:v3}InfrastructureRootElements"/>
 *         &lt;element name="code" type="{urn:hl7-org:v3}CV"/>
 *         &lt;element name="confidentialityCode">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{urn:hl7-org:v3}CV">
 *                 &lt;attribute name="code" use="required" type="{urn:hl7-org:v3}x_BasicConfidentialityKind_code" />
 *                 &lt;attribute name="displayName" type="{urn:hl7-org:v3}st" />
 *                 &lt;attribute name="codeSystem" type="{urn:hl7-org:v3}uid" />
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
 *         &lt;element ref="{NPFIT:HL7:Localisation}messageType"/>
 *         &lt;element name="setId" type="{urn:hl7-org:v3}II.NPfIT.uuid.mandatory"/>
 *         &lt;element name="title" type="{urn:hl7-org:v3}ST.Title"/>
 *         &lt;element name="typeId" type="{urn:hl7-org:v3}POCD_MT200001GB02.ClinicalDocument.typeId"/>
 *         &lt;element name="versionNumber">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{urn:hl7-org:v3}INT">
 *                 &lt;attribute name="value" use="required" type="{urn:hl7-org:v3}int" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="author" type="{urn:hl7-org:v3}POCD_MT200001GB02.Author" maxOccurs="unbounded"/>
 *         &lt;element name="authorization" type="{urn:hl7-org:v3}POCD_MT200001GB02.Authorization" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="component" type="{urn:hl7-org:v3}POCD_MT200001GB02.Component5"/>
 *         &lt;element name="componentOf" type="{urn:hl7-org:v3}POCD_MT200001GB02.Component"/>
 *         &lt;element name="custodian" type="{urn:hl7-org:v3}POCD_MT200001GB02.Custodian"/>
 *         &lt;element name="documentationOf" type="{urn:hl7-org:v3}POCD_MT200001GB02.DocumentationOf" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="informant" type="{urn:hl7-org:v3}POCD_MT200001GB02.Informant" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="informationRecipient" type="{urn:hl7-org:v3}POCD_MT200001GB02.PrimaryInformationRecipient" maxOccurs="unbounded"/>
 *         &lt;element name="participant" type="{urn:hl7-org:v3}POCD_MT200001GB02.Participant" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="recordTarget" type="{urn:hl7-org:v3}POCD_MT200001GB02.RecordTarget"/>
 *         &lt;element name="relatedDocument" type="{urn:hl7-org:v3}POCD_MT200001GB02.ReplacementOf" minOccurs="0"/>
 *         &lt;element name="tracker" type="{urn:hl7-org:v3}POCD_MT200001GB02.Tracker" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{urn:hl7-org:v3}InfrastructureRootAttributes"/>
 *       &lt;attribute name="classCode" use="required" type="{urn:hl7-org:v3}cs" fixed="DOCCLIN" />
 *       &lt;attribute name="moodCode" use="required" type="{urn:hl7-org:v3}cs" fixed="EVN" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "POCD_MT200001GB02.ClinicalDocument", propOrder = {
    "code",
    "confidentialityCode",
    "effectiveTime",
    "id",
    "messageType",
    "setId",
    "title",
    "typeId",
    "versionNumber",
    "author",
    "authorization",
    "component",
    "componentOf",
    "custodian",
    "documentationOf",
    "informant",
    "informationRecipient",
    "participant",
    "recordTarget",
    "relatedDocument",
    "tracker"
})
public class POCDMT200001GB02ClinicalDocument {

    @XmlElement(required = true)
    protected CV code;
    @XmlElement(required = true)
    protected POCDMT200001GB02ClinicalDocument.ConfidentialityCode confidentialityCode;
    @XmlElement(required = true)
    protected POCDMT200001GB02ClinicalDocument.EffectiveTime effectiveTime;
    @XmlElement(required = true)
    protected IINPfITUuidMandatory id;
    @XmlElement(namespace = "NPFIT:HL7:Localisation", required = true)
    protected MessageType messageType;
    @XmlElement(required = true)
    protected IINPfITUuidMandatory setId;
    @XmlElement(required = true)
    protected STTitle title;
    @XmlElement(required = true)
    protected POCDMT200001GB02ClinicalDocumentTypeId typeId;
    @XmlElement(required = true)
    protected POCDMT200001GB02ClinicalDocument.VersionNumber versionNumber;
    @XmlElement(required = true)
    protected List<POCDMT200001GB02Author> author;
    @XmlElement(nillable = true)
    protected List<POCDMT200001GB02Authorization> authorization;
    @XmlElement(required = true)
    protected POCDMT200001GB02Component5 component;
    @XmlElement(required = true)
    protected POCDMT200001GB02Component componentOf;
    @XmlElement(required = true)
    protected POCDMT200001GB02Custodian custodian;
    @XmlElement(nillable = true)
    protected List<POCDMT200001GB02DocumentationOf> documentationOf;
    @XmlElement(nillable = true)
    protected List<POCDMT200001GB02Informant> informant;
    @XmlElement(required = true)
    protected List<POCDMT200001GB02PrimaryInformationRecipient> informationRecipient;
    @XmlElement(nillable = true)
    protected List<POCDMT200001GB02Participant> participant;
    @XmlElement(required = true)
    protected POCDMT200001GB02RecordTarget recordTarget;
    @XmlElementRef(name = "relatedDocument", namespace = "urn:hl7-org:v3", type = JAXBElement.class)
    protected JAXBElement<POCDMT200001GB02ReplacementOf> relatedDocument;
    @XmlElement(nillable = true)
    protected List<POCDMT200001GB02Tracker> tracker;
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
     *     {@link CV }
     *     
     */
    public CV getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link CV }
     *     
     */
    public void setCode(CV value) {
        this.code = value;
    }

    /**
     * Gets the value of the confidentialityCode property.
     * 
     * @return
     *     possible object is
     *     {@link POCDMT200001GB02ClinicalDocument.ConfidentialityCode }
     *     
     */
    public POCDMT200001GB02ClinicalDocument.ConfidentialityCode getConfidentialityCode() {
        return confidentialityCode;
    }

    /**
     * Sets the value of the confidentialityCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link POCDMT200001GB02ClinicalDocument.ConfidentialityCode }
     *     
     */
    public void setConfidentialityCode(POCDMT200001GB02ClinicalDocument.ConfidentialityCode value) {
        this.confidentialityCode = value;
    }

    /**
     * Gets the value of the effectiveTime property.
     * 
     * @return
     *     possible object is
     *     {@link POCDMT200001GB02ClinicalDocument.EffectiveTime }
     *     
     */
    public POCDMT200001GB02ClinicalDocument.EffectiveTime getEffectiveTime() {
        return effectiveTime;
    }

    /**
     * Sets the value of the effectiveTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link POCDMT200001GB02ClinicalDocument.EffectiveTime }
     *     
     */
    public void setEffectiveTime(POCDMT200001GB02ClinicalDocument.EffectiveTime value) {
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
     * Gets the value of the messageType property.
     * 
     * @return
     *     possible object is
     *     {@link MessageType }
     *     
     */
    public MessageType getMessageType() {
        return messageType;
    }

    /**
     * Sets the value of the messageType property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageType }
     *     
     */
    public void setMessageType(MessageType value) {
        this.messageType = value;
    }

    /**
     * Gets the value of the setId property.
     * 
     * @return
     *     possible object is
     *     {@link IINPfITUuidMandatory }
     *     
     */
    public IINPfITUuidMandatory getSetId() {
        return setId;
    }

    /**
     * Sets the value of the setId property.
     * 
     * @param value
     *     allowed object is
     *     {@link IINPfITUuidMandatory }
     *     
     */
    public void setSetId(IINPfITUuidMandatory value) {
        this.setId = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link STTitle }
     *     
     */
    public STTitle getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link STTitle }
     *     
     */
    public void setTitle(STTitle value) {
        this.title = value;
    }

    /**
     * Gets the value of the typeId property.
     * 
     * @return
     *     possible object is
     *     {@link POCDMT200001GB02ClinicalDocumentTypeId }
     *     
     */
    public POCDMT200001GB02ClinicalDocumentTypeId getTypeId() {
        return typeId;
    }

    /**
     * Sets the value of the typeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link POCDMT200001GB02ClinicalDocumentTypeId }
     *     
     */
    public void setTypeId(POCDMT200001GB02ClinicalDocumentTypeId value) {
        this.typeId = value;
    }

    /**
     * Gets the value of the versionNumber property.
     * 
     * @return
     *     possible object is
     *     {@link POCDMT200001GB02ClinicalDocument.VersionNumber }
     *     
     */
    public POCDMT200001GB02ClinicalDocument.VersionNumber getVersionNumber() {
        return versionNumber;
    }

    /**
     * Sets the value of the versionNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link POCDMT200001GB02ClinicalDocument.VersionNumber }
     *     
     */
    public void setVersionNumber(POCDMT200001GB02ClinicalDocument.VersionNumber value) {
        this.versionNumber = value;
    }

    /**
     * Gets the value of the author property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the author property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAuthor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link POCDMT200001GB02Author }
     * 
     * 
     */
    public List<POCDMT200001GB02Author> getAuthor() {
        if (author == null) {
            author = new ArrayList<POCDMT200001GB02Author>();
        }
        return this.author;
    }

    /**
     * Gets the value of the authorization property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the authorization property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAuthorization().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link POCDMT200001GB02Authorization }
     * 
     * 
     */
    public List<POCDMT200001GB02Authorization> getAuthorization() {
        if (authorization == null) {
            authorization = new ArrayList<POCDMT200001GB02Authorization>();
        }
        return this.authorization;
    }

    /**
     * Gets the value of the component property.
     * 
     * @return
     *     possible object is
     *     {@link POCDMT200001GB02Component5 }
     *     
     */
    public POCDMT200001GB02Component5 getComponent() {
        return component;
    }

    /**
     * Sets the value of the component property.
     * 
     * @param value
     *     allowed object is
     *     {@link POCDMT200001GB02Component5 }
     *     
     */
    public void setComponent(POCDMT200001GB02Component5 value) {
        this.component = value;
    }

    /**
     * Gets the value of the componentOf property.
     * 
     * @return
     *     possible object is
     *     {@link POCDMT200001GB02Component }
     *     
     */
    public POCDMT200001GB02Component getComponentOf() {
        return componentOf;
    }

    /**
     * Sets the value of the componentOf property.
     * 
     * @param value
     *     allowed object is
     *     {@link POCDMT200001GB02Component }
     *     
     */
    public void setComponentOf(POCDMT200001GB02Component value) {
        this.componentOf = value;
    }

    /**
     * Gets the value of the custodian property.
     * 
     * @return
     *     possible object is
     *     {@link POCDMT200001GB02Custodian }
     *     
     */
    public POCDMT200001GB02Custodian getCustodian() {
        return custodian;
    }

    /**
     * Sets the value of the custodian property.
     * 
     * @param value
     *     allowed object is
     *     {@link POCDMT200001GB02Custodian }
     *     
     */
    public void setCustodian(POCDMT200001GB02Custodian value) {
        this.custodian = value;
    }

    /**
     * Gets the value of the documentationOf property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the documentationOf property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocumentationOf().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link POCDMT200001GB02DocumentationOf }
     * 
     * 
     */
    public List<POCDMT200001GB02DocumentationOf> getDocumentationOf() {
        if (documentationOf == null) {
            documentationOf = new ArrayList<POCDMT200001GB02DocumentationOf>();
        }
        return this.documentationOf;
    }

    /**
     * Gets the value of the informant property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the informant property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInformant().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link POCDMT200001GB02Informant }
     * 
     * 
     */
    public List<POCDMT200001GB02Informant> getInformant() {
        if (informant == null) {
            informant = new ArrayList<POCDMT200001GB02Informant>();
        }
        return this.informant;
    }

    /**
     * Gets the value of the informationRecipient property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the informationRecipient property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInformationRecipient().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link POCDMT200001GB02PrimaryInformationRecipient }
     * 
     * 
     */
    public List<POCDMT200001GB02PrimaryInformationRecipient> getInformationRecipient() {
        if (informationRecipient == null) {
            informationRecipient = new ArrayList<POCDMT200001GB02PrimaryInformationRecipient>();
        }
        return this.informationRecipient;
    }

    /**
     * Gets the value of the participant property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the participant property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParticipant().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link POCDMT200001GB02Participant }
     * 
     * 
     */
    public List<POCDMT200001GB02Participant> getParticipant() {
        if (participant == null) {
            participant = new ArrayList<POCDMT200001GB02Participant>();
        }
        return this.participant;
    }

    /**
     * Gets the value of the recordTarget property.
     * 
     * @return
     *     possible object is
     *     {@link POCDMT200001GB02RecordTarget }
     *     
     */
    public POCDMT200001GB02RecordTarget getRecordTarget() {
        return recordTarget;
    }

    /**
     * Sets the value of the recordTarget property.
     * 
     * @param value
     *     allowed object is
     *     {@link POCDMT200001GB02RecordTarget }
     *     
     */
    public void setRecordTarget(POCDMT200001GB02RecordTarget value) {
        this.recordTarget = value;
    }

    /**
     * Gets the value of the relatedDocument property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link POCDMT200001GB02ReplacementOf }{@code >}
     *     
     */
    public JAXBElement<POCDMT200001GB02ReplacementOf> getRelatedDocument() {
        return relatedDocument;
    }

    /**
     * Sets the value of the relatedDocument property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link POCDMT200001GB02ReplacementOf }{@code >}
     *     
     */
    public void setRelatedDocument(JAXBElement<POCDMT200001GB02ReplacementOf> value) {
        this.relatedDocument = ((JAXBElement<POCDMT200001GB02ReplacementOf> ) value);
    }

    /**
     * Gets the value of the tracker property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tracker property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTracker().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link POCDMT200001GB02Tracker }
     * 
     * 
     */
    public List<POCDMT200001GB02Tracker> getTracker() {
        if (tracker == null) {
            tracker = new ArrayList<POCDMT200001GB02Tracker>();
        }
        return this.tracker;
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
            return "DOCCLIN";
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
     *       &lt;attribute name="code" use="required" type="{urn:hl7-org:v3}x_BasicConfidentialityKind_code" />
     *       &lt;attribute name="displayName" type="{urn:hl7-org:v3}st" />
     *       &lt;attribute name="codeSystem" type="{urn:hl7-org:v3}uid" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class ConfidentialityCode
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
     *     &lt;restriction base="{urn:hl7-org:v3}INT">
     *       &lt;attribute name="value" use="required" type="{urn:hl7-org:v3}int" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class VersionNumber
        extends INT
    {


    }

}