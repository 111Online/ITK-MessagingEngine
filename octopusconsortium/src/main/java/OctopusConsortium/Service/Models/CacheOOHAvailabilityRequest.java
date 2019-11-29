package OctopusConsortium.Service.Models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CacheOOHAvailabilityRequest" , propOrder = { "postcode", "time", "searchDistance" })
public class CacheOOHAvailabilityRequest   {


	@XmlElement(name = "PostCode",
			required = true)
	protected String postcode;
	
	@XmlElement(name="Time",
			required=false,
			type=XMLGregorianCalendar.class)
	protected XMLGregorianCalendar time;
	
	@XmlElement(name="SearchDistance",
			required = false,
			type = Integer.class)
	protected Integer searchDistance;
	
	//@XmlElement(name = "Source", required = false)
	@XmlTransient
	protected String source;
	
    public XMLGregorianCalendar getTime() {
    	return (XMLGregorianCalendar)this.time;
    }
    
    public void setTime(XMLGregorianCalendar value) {
    	this.time = value;
    }
	
	/**
	 * @return the postcode
	 */
	public String getPostcode() {
		return postcode;
	}
	/**
	 * @param postcode the postcode to set
	 */
	public void setPostcode(String value) {
		this.postcode = value.toUpperCase();
	}
	
	public Integer getSearchDistance() {
		return searchDistance;
	}
	
	public void setSearchDistance(Integer value) {
		this.searchDistance = value;
	}
	
	public String getSource() {
		return source;
	}
	
	public void setSource(String value) {
		this.source = value;
	}
}