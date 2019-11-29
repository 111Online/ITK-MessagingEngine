package OctopusConsortium.Service.Models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;

import OctopusConsortium.Core.DateAdapterOoHTimeString;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IsOOHRequest" , propOrder = { "time", "disposition" })
public class IsOOHRequest {
	
	@XmlElement(name="Time", required=false
			//, type=XMLGregorianCalendar.class
			)
	//@XmlSchemaType(name="dateTime")	
	@XmlSchemaType(name="anySimpleType")//keep it the same as the previous released wsdl
	@XmlJavaTypeAdapter(DateAdapterOoHTimeString.class)
	protected XMLGregorianCalendar time;
	
	@XmlElement(name = "Disposition", required = true)
	protected String disposition;
	
    public XMLGregorianCalendar getTime() {
    	return (XMLGregorianCalendar)this.time;
    }    
    public void setTime(XMLGregorianCalendar value) {
    	this.time = value;
    }
    
    public String getDisposition() {
		return disposition;
	}	
	public void setDisposition(String value) {
		this.disposition = value;
	}
	
	
}
