
package OctopusConsortium.DosService1_5;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Case complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Case">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="caseRef" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="caseId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="postcode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="surgery" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="age" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="ageFormat" type="{https://nww.pathwaysdos.nhs.uk/app/api/webservices}AgeFormatType"/>
 *         &lt;element name="disposition" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="symptomGroup" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="symptomDiscriminatorList" type="{https://nww.pathwaysdos.nhs.uk/app/api/webservices}ArrayOfInt"/>
 *         &lt;element name="searchDistance" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="forceSearchDistance" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="gender" type="{https://nww.pathwaysdos.nhs.uk/app/api/webservices}GenderType"/>
 *         &lt;element name="searchDateTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Case", propOrder = {
    "caseRef",
    "caseId",
    "postcode",
    "surgery",
    "age",
    "ageFormat",
    "disposition",
    "symptomGroup",
    "symptomDiscriminatorList",
    "searchDistance",
    "forceSearchDistance",
    "gender",
    "searchDateTime"
})
public class Case {

    protected String caseRef;
    protected String caseId;
    @XmlElement(required = true)
    protected String postcode;
    protected String surgery;
    protected short age;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected AgeFormatType ageFormat;
    protected int disposition;
    protected int symptomGroup;
    @XmlElement(required = true)
    protected ArrayOfInt symptomDiscriminatorList;
    protected Integer searchDistance;
    protected boolean forceSearchDistance;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected GenderType gender;
    protected String searchDateTime;

    /**
     * Gets the value of the caseRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaseRef() {
        return caseRef;
    }

    /**
     * Sets the value of the caseRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaseRef(String value) {
        this.caseRef = value;
    }

    /**
     * Gets the value of the caseId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaseId() {
        return caseId;
    }

    /**
     * Sets the value of the caseId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaseId(String value) {
        this.caseId = value;
    }

    /**
     * Gets the value of the postcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * Sets the value of the postcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostcode(String value) {
        this.postcode = value;
    }

    /**
     * Gets the value of the surgery property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSurgery() {
        return surgery;
    }

    /**
     * Sets the value of the surgery property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSurgery(String value) {
        this.surgery = value;
    }

    /**
     * Gets the value of the age property.
     * 
     */
    public short getAge() {
        return age;
    }

    /**
     * Sets the value of the age property.
     * 
     */
    public void setAge(short value) {
        this.age = value;
    }

    /**
     * Gets the value of the ageFormat property.
     * 
     * @return
     *     possible object is
     *     {@link AgeFormatType }
     *     
     */
    public AgeFormatType getAgeFormat() {
        return ageFormat;
    }

    /**
     * Sets the value of the ageFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link AgeFormatType }
     *     
     */
    public void setAgeFormat(AgeFormatType value) {
        this.ageFormat = value;
    }

    /**
     * Gets the value of the disposition property.
     * 
     */
    public int getDisposition() {
        return disposition;
    }

    /**
     * Sets the value of the disposition property.
     * 
     */
    public void setDisposition(int value) {
        this.disposition = value;
    }

    /**
     * Gets the value of the symptomGroup property.
     * 
     */
    public int getSymptomGroup() {
        return symptomGroup;
    }

    /**
     * Sets the value of the symptomGroup property.
     * 
     */
    public void setSymptomGroup(int value) {
        this.symptomGroup = value;
    }

    /**
     * Gets the value of the symptomDiscriminatorList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfInt }
     *     
     */
    public ArrayOfInt getSymptomDiscriminatorList() {
        return symptomDiscriminatorList;
    }

    /**
     * Sets the value of the symptomDiscriminatorList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfInt }
     *     
     */
    public void setSymptomDiscriminatorList(ArrayOfInt value) {
        this.symptomDiscriminatorList = value;
    }

    /**
     * Gets the value of the searchDistance property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSearchDistance() {
        return searchDistance;
    }

    /**
     * Sets the value of the searchDistance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSearchDistance(Integer value) {
        this.searchDistance = value;
    }

    /**
     * Gets the value of the forceSearchDistance property.
     * 
     */
    public boolean isForceSearchDistance() {
        return forceSearchDistance;
    }

    /**
     * Sets the value of the forceSearchDistance property.
     * 
     */
    public void setForceSearchDistance(boolean value) {
        this.forceSearchDistance = value;
    }

    /**
     * Gets the value of the gender property.
     * 
     * @return
     *     possible object is
     *     {@link GenderType }
     *     
     */
    public GenderType getGender() {
        return gender;
    }

    /**
     * Sets the value of the gender property.
     * 
     * @param value
     *     allowed object is
     *     {@link GenderType }
     *     
     */
    public void setGender(GenderType value) {
        this.gender = value;
    }

    /**
     * Gets the value of the searchDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSearchDateTime() {
        return searchDateTime;
    }

    /**
     * Sets the value of the searchDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSearchDateTime(String value) {
        this.searchDateTime = value;
    }

}
