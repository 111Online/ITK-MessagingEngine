package OctopusConsortium.Service.Models;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubmitToServiceDetails", propOrder = {
    "id",
    "name",
    "odsCode",
    "contactDetails",
    "address",
    "postcode",
    "stp",
    "ccg"
})
public class SubmitToServiceDetails implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3627577199155113766L;
	@XmlElement(required = true)
	protected int id;
    @XmlElement(required = true)
    protected String name;
    protected String odsCode;
    protected String contactDetails;
    protected String address;
    protected String postcode;
    @XmlElement(required = false)
    protected String stp;
    @XmlElement(required = false)
    protected String ccg;
    
    
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
	 * @return the odsCode
	 */
	public String getOdsCode() {
		return odsCode;
	}

	/**
	 * @param odsCode the odsCode to set
	 */
	public void setOdsCode(String odsCode) {
		this.odsCode = odsCode;
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

	public String getStp() {
		return stp;
	}

	public void setStp(String stp) {
		this.stp = stp;
	}

	public String getCcg() {
		return ccg;
	}

	public void setCcg(String ccg) {
		this.ccg = ccg;
	}
}