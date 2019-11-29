
package OctopusConsortium.DosService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="contactDetails" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="postcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="northings" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="eastings" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="notes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="obsolete" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="updateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="openAllHours" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="rotaSessions" type="{https://nww.pathwaysdos.nhs.uk/app/api/webservices}ArrayOfServiceCareItemRotaSession" minOccurs="0"/>
 *         &lt;element name="serviceType" type="{https://nww.pathwaysdos.nhs.uk/app/api/webservices}serviceDetails"/>
 *         &lt;element name="odsCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rootParent" type="{https://nww.pathwaysdos.nhs.uk/app/api/webservices}serviceDetails" minOccurs="0"/>
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
    "contactDetails",
    "address",
    "postcode",
    "northings",
    "eastings",
    "url",
    "notes",
    "obsolete",
    "updateTime",
    "openAllHours",
    "rotaSessions",
    "serviceType",
    "odsCode",
    "rootParent"
})
public class ServiceCareSummaryDestination {

    protected int id;
    @XmlElement(required = true)
    protected Capacity capacity;
    protected String name;
    protected String contactDetails;
    protected String address;
    protected String postcode;
    protected Integer northings;
    protected Integer eastings;
    protected String url;
    protected String notes;
    protected boolean obsolete;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar updateTime;
    protected boolean openAllHours;
    protected ArrayOfServiceCareItemRotaSession rotaSessions;
    @XmlElement(required = true)
    protected ServiceDetails serviceType;
    protected String odsCode;
    protected ServiceDetails rootParent;

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
     * Gets the value of the notes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Sets the value of the notes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotes(String value) {
        this.notes = value;
    }

    /**
     * Gets the value of the obsolete property.
     * 
     */
    public boolean isObsolete() {
        return obsolete;
    }

    /**
     * Sets the value of the obsolete property.
     * 
     */
    public void setObsolete(boolean value) {
        this.obsolete = value;
    }

    /**
     * Gets the value of the updateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUpdateTime() {
        return updateTime;
    }

    /**
     * Sets the value of the updateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setUpdateTime(XMLGregorianCalendar value) {
        this.updateTime = value;
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
     * Gets the value of the serviceType property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceDetails }
     *     
     */
    public ServiceDetails getServiceType() {
        return serviceType;
    }

    /**
     * Sets the value of the serviceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceDetails }
     *     
     */
    public void setServiceType(ServiceDetails value) {
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
     * Gets the value of the rootParent property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceDetails }
     *     
     */
    public ServiceDetails getRootParent() {
        return rootParent;
    }

    /**
     * Sets the value of the rootParent property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceDetails }
     *     
     */
    public void setRootParent(ServiceDetails value) {
        this.rootParent = value;
    }

}
