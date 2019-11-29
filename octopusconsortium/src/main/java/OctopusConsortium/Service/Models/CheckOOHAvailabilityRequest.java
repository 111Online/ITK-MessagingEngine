package OctopusConsortium.Service.Models;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;

import OctopusConsortium.Core.DateAdapterOoHTimeString;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CheckOOHAvailabilityRequest" , propOrder = { "postcode", "time", "searchDistance", "disposition" })
public class CheckOOHAvailabilityRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5022702189287501781L;

	@XmlElement(name = "PostCode",
			required = true)
	protected String postcode;
	
	@XmlElement(name="Time",
			required=false
			//,type=XMLGregorianCalendar.class
			)
	//@XmlSchemaType(name="dateTime")
	@XmlSchemaType(name="anySimpleType")//keep it the same as the previous released wsdl
	@XmlJavaTypeAdapter(DateAdapterOoHTimeString.class)
	protected XMLGregorianCalendar time;
	
	@XmlElement(name="SearchDistance",
			required = false,
			type = Integer.class)
	protected Integer searchDistance;
	
	@XmlElement(name = "Disposition", required = true)
	protected String disposition;
	
	//@XmlElement(name = "Source", required = false)
	@XmlTransient
	protected String source;
	
		
    public XMLGregorianCalendar getTime() {
    	return (XMLGregorianCalendar)this.time;
    }
    
    public void setTime(XMLGregorianCalendar value) {
    	this.time = value;
    }
    
    public Date getDate() {
    	return  OctopusConsortium.Core.XMLGregorianCalendarConversionUtil.asDate( this.time );
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
	
	public String getDisposition() {
		return disposition;
	}
	
	public void setDisposition(String value) {
		this.disposition = value;
	}
	
	public String getSource() {
		return source;
	}
	
	public void setSource(String value) {
		this.source = value;
	}
}