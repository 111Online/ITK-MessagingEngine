
package OctopusConsortium.DosService1_5;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ServiceCareSummaryDestination complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceCareSummaryDestination">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="capacity" type="{https://nww.pathwaysdos.nhs.uk/app/api/webservices}Capacity"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="publicName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contactDetails" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="postcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="northings" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="eastings" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="serviceType" type="{https://nww.pathwaysdos.nhs.uk/app/api/webservices}ServiceType"/>
 *         &lt;element name="odsCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nonPublicTelephoneNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="publicFacingInformation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="distance" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="referralInformation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="openAllHours" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="capacityAttributes" type="{https://nww.pathwaysdos.nhs.uk/app/api/webservices}ArrayOfCapacityAttributes" minOccurs="0"/>
 *         &lt;element name="serviceEndpoints" type="{https://nww.pathwaysdos.nhs.uk/app/api/webservices}ArrayOfServiceEndpoints"/>
 *         &lt;element name="rotaSessions" type="{https://nww.pathwaysdos.nhs.uk/app/api/webservices}ArrayOfServiceCareItemRotaSession" minOccurs="0"/>
 *         &lt;element name="openTimeSpecifiedSessions" type="{https://nww.pathwaysdos.nhs.uk/app/api/webservices}ArrayOfOpenTimeSpecified" minOccurs="0"/>
 *         &lt;element name="attributes" type="{https://nww.pathwaysdos.nhs.uk/app/api/webservices}ArrayOfAttributes" minOccurs="0"/>
 *         &lt;element name="serviceAgeRange" type="{https://nww.pathwaysdos.nhs.uk/app/api/webservices}ArrayOfServiceAgeRanges"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceCareSummaryDestination", propOrder = {
    "id",
    "capacity",
    "name",
    "publicName",
    "contactDetails",
    "address",
    "postcode",
    "northings",
    "eastings",
    "url",
    "serviceType",
    "odsCode",
    "nonPublicTelephoneNo",
    "fax",
    "publicFacingInformation",
    "distance",
    "referralInformation",
    "openAllHours",
    "capacityAttributes",
    "serviceEndpoints",
    "rotaSessions",
    "openTimeSpecifiedSessions",
    "attributes",
    "serviceAgeRange"
})
public class ServiceCareSummaryDestination {

    protected int id;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected Capacity capacity;
    protected String name;
    protected String publicName;
    protected String contactDetails;
    protected String address;
    protected String postcode;
    protected Integer northings;
    protected Integer eastings;
    protected String url;
    @XmlElement(required = true)
    protected ServiceType serviceType;
    protected String odsCode;
    protected String nonPublicTelephoneNo;
    protected String fax;
    protected String publicFacingInformation;
    protected String distance;
    protected String referralInformation;
    protected boolean openAllHours;
    protected ArrayOfCapacityAttributes capacityAttributes;
    @XmlElement(required = true)
    protected ArrayOfServiceEndpoints serviceEndpoints;
    protected ArrayOfServiceCareItemRotaSession rotaSessions;
    protected ArrayOfOpenTimeSpecified openTimeSpecifiedSessions;
    protected ArrayOfAttributes attributes;
    @XmlElement(required = true)
    protected ArrayOfServiceAgeRanges serviceAgeRange;

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the capacity property.
     * 
     * @return
     *     possible object is
     *     {@link Capacity }
     *     
     */
    public Capacity getCapacity() {
        return capacity;
    }

    /**
     * Sets the value of the capacity property.
     * 
     * @param value
     *     allowed object is
     *     {@link Capacity }
     *     
     */
    public void setCapacity(Capacity value) {
        this.capacity = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the publicName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublicName() {
        return publicName;
    }

    /**
     * Sets the value of the publicName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublicName(String value) {
        this.publicName = value;
    }

    /**
     * Gets the value of the contactDetails property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactDetails() {
        return contactDetails;
    }

    /**
     * Sets the value of the contactDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactDetails(String value) {
        this.contactDetails = value;
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
     * Gets the value of the northings property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNorthings() {
        return northings;
    }

    /**
     * Sets the value of the northings property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNorthings(Integer value) {
        this.northings = value;
    }

    /**
     * Gets the value of the eastings property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getEastings() {
        return eastings;
    }

    /**
     * Sets the value of the eastings property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setEastings(Integer value) {
        this.eastings = value;
    }

    /**
     * Gets the value of the url property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the value of the url property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrl(String value) {
        this.url = value;
    }

    /**
     * Gets the value of the serviceType property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceType }
     *     
     */
    public ServiceType getServiceType() {
        return serviceType;
    }

    /**
     * Sets the value of the serviceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceType }
     *     
     */
    public void setServiceType(ServiceType value) {
        this.serviceType = value;
    }

    /**
     * Gets the value of the odsCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOdsCode() {
        return odsCode;
    }

    /**
     * Sets the value of the odsCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOdsCode(String value) {
        this.odsCode = value;
    }

    /**
     * Gets the value of the nonPublicTelephoneNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNonPublicTelephoneNo() {
        return nonPublicTelephoneNo;
    }

    /**
     * Sets the value of the nonPublicTelephoneNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNonPublicTelephoneNo(String value) {
        this.nonPublicTelephoneNo = value;
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
     * Gets the value of the publicFacingInformation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublicFacingInformation() {
        return publicFacingInformation;
    }

    /**
     * Sets the value of the publicFacingInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublicFacingInformation(String value) {
        this.publicFacingInformation = value;
    }

    /**
     * Gets the value of the distance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDistance() {
        return distance;
    }

    /**
     * Sets the value of the distance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDistance(String value) {
        this.distance = value;
    }

    /**
     * Gets the value of the referralInformation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferralInformation() {
        return referralInformation;
    }

    /**
     * Sets the value of the referralInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferralInformation(String value) {
        this.referralInformation = value;
    }

    /**
     * Gets the value of the openAllHours property.
     * 
     */
    public boolean isOpenAllHours() {
        return openAllHours;
    }

    /**
     * Sets the value of the openAllHours property.
     * 
     */
    public void setOpenAllHours(boolean value) {
        this.openAllHours = value;
    }

    /**
     * Gets the value of the capacityAttributes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCapacityAttributes }
     *     
     */
    public ArrayOfCapacityAttributes getCapacityAttributes() {
        return capacityAttributes;
    }

    /**
     * Sets the value of the capacityAttributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCapacityAttributes }
     *     
     */
    public void setCapacityAttributes(ArrayOfCapacityAttributes value) {
        this.capacityAttributes = value;
    }

    /**
     * Gets the value of the serviceEndpoints property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfServiceEndpoints }
     *     
     */
    public ArrayOfServiceEndpoints getServiceEndpoints() {
        return serviceEndpoints;
    }

    /**
     * Sets the value of the serviceEndpoints property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfServiceEndpoints }
     *     
     */
    public void setServiceEndpoints(ArrayOfServiceEndpoints value) {
        this.serviceEndpoints = value;
    }

    /**
     * Gets the value of the rotaSessions property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfServiceCareItemRotaSession }
     *     
     */
    public ArrayOfServiceCareItemRotaSession getRotaSessions() {
        return rotaSessions;
    }

    /**
     * Sets the value of the rotaSessions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfServiceCareItemRotaSession }
     *     
     */
    public void setRotaSessions(ArrayOfServiceCareItemRotaSession value) {
        this.rotaSessions = value;
    }

    /**
     * Gets the value of the openTimeSpecifiedSessions property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfOpenTimeSpecified }
     *     
     */
    public ArrayOfOpenTimeSpecified getOpenTimeSpecifiedSessions() {
        return openTimeSpecifiedSessions;
    }

    /**
     * Sets the value of the openTimeSpecifiedSessions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfOpenTimeSpecified }
     *     
     */
    public void setOpenTimeSpecifiedSessions(ArrayOfOpenTimeSpecified value) {
        this.openTimeSpecifiedSessions = value;
    }

    /**
     * Gets the value of the attributes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfAttributes }
     *     
     */
    public ArrayOfAttributes getAttributes() {
        return attributes;
    }

    /**
     * Sets the value of the attributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfAttributes }
     *     
     */
    public void setAttributes(ArrayOfAttributes value) {
        this.attributes = value;
    }

    /**
     * Gets the value of the serviceAgeRange property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfServiceAgeRanges }
     *     
     */
    public ArrayOfServiceAgeRanges getServiceAgeRange() {
        return serviceAgeRange;
    }

    /**
     * Sets the value of the serviceAgeRange property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfServiceAgeRanges }
     *     
     */
    public void setServiceAgeRange(ArrayOfServiceAgeRanges value) {
        this.serviceAgeRange = value;
    }

}
