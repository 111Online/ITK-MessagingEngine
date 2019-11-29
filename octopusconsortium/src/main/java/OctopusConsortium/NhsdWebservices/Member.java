
package OctopusConsortium.NhsdWebservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Member complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Member">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Partner" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PartnerPassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DOB" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="County" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Postcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Ethnicity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Gender" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PreferredContactMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EmailAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HomePhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BeInvolved" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="PatientPanels" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ReceiveSMS" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="PublicRegister" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ShareDetails3rdParty" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="NHSStaff" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Disability" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="HowDidYouHearAboutThis" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MobilePhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OfficePhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Fax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SpecificRequirements" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Member", propOrder = {
    "partner",
    "partnerPassword",
    "title",
    "firstName",
    "lastName",
    "dob",
    "address",
    "city",
    "county",
    "postcode",
    "ethnicity",
    "gender",
    "preferredContactMethod",
    "emailAddress",
    "homePhone",
    "beInvolved",
    "patientPanels",
    "receiveSMS",
    "publicRegister",
    "shareDetails3RdParty",
    "nhsStaff",
    "disability",
    "howDidYouHearAboutThis",
    "mobilePhone",
    "officePhone",
    "fax",
    "specificRequirements"
})
public class Member {

    @XmlElement(name = "Partner")
    protected String partner;
    @XmlElement(name = "PartnerPassword")
    protected String partnerPassword;
    @XmlElement(name = "Title")
    protected String title;
    @XmlElement(name = "FirstName")
    protected String firstName;
    @XmlElement(name = "LastName")
    protected String lastName;
    @XmlElement(name = "DOB", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dob;
    @XmlElement(name = "Address")
    protected String address;
    @XmlElement(name = "City")
    protected String city;
    @XmlElement(name = "County")
    protected String county;
    @XmlElement(name = "Postcode")
    protected String postcode;
    @XmlElement(name = "Ethnicity")
    protected String ethnicity;
    @XmlElement(name = "Gender")
    protected String gender;
    @XmlElement(name = "PreferredContactMethod")
    protected String preferredContactMethod;
    @XmlElement(name = "EmailAddress")
    protected String emailAddress;
    @XmlElement(name = "HomePhone")
    protected String homePhone;
    @XmlElement(name = "BeInvolved")
    protected boolean beInvolved;
    @XmlElement(name = "PatientPanels")
    protected boolean patientPanels;
    @XmlElement(name = "ReceiveSMS")
    protected boolean receiveSMS;
    @XmlElement(name = "PublicRegister")
    protected boolean publicRegister;
    @XmlElement(name = "ShareDetails3rdParty")
    protected boolean shareDetails3RdParty;
    @XmlElement(name = "NHSStaff")
    protected boolean nhsStaff;
    @XmlElement(name = "Disability")
    protected boolean disability;
    @XmlElement(name = "HowDidYouHearAboutThis")
    protected String howDidYouHearAboutThis;
    @XmlElement(name = "MobilePhone")
    protected String mobilePhone;
    @XmlElement(name = "OfficePhone")
    protected String officePhone;
    @XmlElement(name = "Fax")
    protected String fax;
    @XmlElement(name = "SpecificRequirements")
    protected String specificRequirements;

    /**
     * Gets the value of the partner property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartner() {
        return partner;
    }

    /**
     * Sets the value of the partner property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartner(String value) {
        this.partner = value;
    }

    /**
     * Gets the value of the partnerPassword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartnerPassword() {
        return partnerPassword;
    }

    /**
     * Sets the value of the partnerPassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartnerPassword(String value) {
        this.partnerPassword = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the dob property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDOB() {
        return dob;
    }

    /**
     * Sets the value of the dob property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDOB(XMLGregorianCalendar value) {
        this.dob = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * Gets the value of the county property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCounty() {
        return county;
    }

    /**
     * Sets the value of the county property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCounty(String value) {
        this.county = value;
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
     * Gets the value of the ethnicity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEthnicity() {
        return ethnicity;
    }

    /**
     * Sets the value of the ethnicity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEthnicity(String value) {
        this.ethnicity = value;
    }

    /**
     * Gets the value of the gender property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the value of the gender property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGender(String value) {
        this.gender = value;
    }

    /**
     * Gets the value of the preferredContactMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreferredContactMethod() {
        return preferredContactMethod;
    }

    /**
     * Sets the value of the preferredContactMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreferredContactMethod(String value) {
        this.preferredContactMethod = value;
    }

    /**
     * Gets the value of the emailAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets the value of the emailAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailAddress(String value) {
        this.emailAddress = value;
    }

    /**
     * Gets the value of the homePhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHomePhone() {
        return homePhone;
    }

    /**
     * Sets the value of the homePhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHomePhone(String value) {
        this.homePhone = value;
    }

    /**
     * Gets the value of the beInvolved property.
     * 
     */
    public boolean isBeInvolved() {
        return beInvolved;
    }

    /**
     * Sets the value of the beInvolved property.
     * 
     */
    public void setBeInvolved(boolean value) {
        this.beInvolved = value;
    }

    /**
     * Gets the value of the patientPanels property.
     * 
     */
    public boolean isPatientPanels() {
        return patientPanels;
    }

    /**
     * Sets the value of the patientPanels property.
     * 
     */
    public void setPatientPanels(boolean value) {
        this.patientPanels = value;
    }

    /**
     * Gets the value of the receiveSMS property.
     * 
     */
    public boolean isReceiveSMS() {
        return receiveSMS;
    }

    /**
     * Sets the value of the receiveSMS property.
     * 
     */
    public void setReceiveSMS(boolean value) {
        this.receiveSMS = value;
    }

    /**
     * Gets the value of the publicRegister property.
     * 
     */
    public boolean isPublicRegister() {
        return publicRegister;
    }

    /**
     * Sets the value of the publicRegister property.
     * 
     */
    public void setPublicRegister(boolean value) {
        this.publicRegister = value;
    }

    /**
     * Gets the value of the shareDetails3RdParty property.
     * 
     */
    public boolean isShareDetails3RdParty() {
        return shareDetails3RdParty;
    }

    /**
     * Sets the value of the shareDetails3RdParty property.
     * 
     */
    public void setShareDetails3RdParty(boolean value) {
        this.shareDetails3RdParty = value;
    }

    /**
     * Gets the value of the nhsStaff property.
     * 
     */
    public boolean isNHSStaff() {
        return nhsStaff;
    }

    /**
     * Sets the value of the nhsStaff property.
     * 
     */
    public void setNHSStaff(boolean value) {
        this.nhsStaff = value;
    }

    /**
     * Gets the value of the disability property.
     * 
     */
    public boolean isDisability() {
        return disability;
    }

    /**
     * Sets the value of the disability property.
     * 
     */
    public void setDisability(boolean value) {
        this.disability = value;
    }

    /**
     * Gets the value of the howDidYouHearAboutThis property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHowDidYouHearAboutThis() {
        return howDidYouHearAboutThis;
    }

    /**
     * Sets the value of the howDidYouHearAboutThis property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHowDidYouHearAboutThis(String value) {
        this.howDidYouHearAboutThis = value;
    }

    /**
     * Gets the value of the mobilePhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * Sets the value of the mobilePhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMobilePhone(String value) {
        this.mobilePhone = value;
    }

    /**
     * Gets the value of the officePhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOfficePhone() {
        return officePhone;
    }

    /**
     * Sets the value of the officePhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOfficePhone(String value) {
        this.officePhone = value;
    }

    /**
     * Gets the value of the fax property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFax() {
        return fax;
    }

    /**
     * Sets the value of the fax property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFax(String value) {
        this.fax = value;
    }

    /**
     * Gets the value of the specificRequirements property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecificRequirements() {
        return specificRequirements;
    }

    /**
     * Sets the value of the specificRequirements property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecificRequirements(String value) {
        this.specificRequirements = value;
    }

}
