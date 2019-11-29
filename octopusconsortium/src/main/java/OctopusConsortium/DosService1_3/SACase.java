
package OctopusConsortium.DosService1_3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SACase complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SACase"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="caseRef" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="caseId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="postcode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="surgery" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="age" type="{http://www.w3.org/2001/XMLSchema}short"/&gt;
 *         &lt;element name="ageFormat" type="{https://nww.pathwaysdos.nhs.uk/app/api/webservices}ageFormatType"/&gt;
 *         &lt;element name="disposition" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="symptomGroup" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="symptomDiscriminator" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="searchDistance" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="gender" type="{https://nww.pathwaysdos.nhs.uk/app/api/webservices}genderType"/&gt;
 *         &lt;element name="searchRole" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SACase", propOrder = {
    "caseRef",
    "caseId",
    "postcode",
    "surgery",
    "age",
    "ageFormat",
    "disposition",
    "symptomGroup",
    "symptomDiscriminator",
    "searchDistance",
    "gender",
    "searchRole"
})
public class SACase {

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
    protected int symptomDiscriminator;
    protected Integer searchDistance;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected GenderType gender;
    protected Integer searchRole;

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
     * Gets the value of the symptomDiscriminator property.
     * 
     */
    public int getSymptomDiscriminator() {
        return symptomDiscriminator;
    }

    /**
     * Sets the value of the symptomDiscriminator property.
     * 
     */
    public void setSymptomDiscriminator(int value) {
        this.symptomDiscriminator = value;
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
     * Gets the value of the searchRole property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSearchRole() {
        return searchRole;
    }

    /**
     * Sets the value of the searchRole property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSearchRole(Integer value) {
        this.searchRole = value;
    }

}
