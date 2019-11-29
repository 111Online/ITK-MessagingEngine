package OctopusConsortium.Service.Models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CacheOOHAvailabilityResponse", propOrder = {    
	"success"})
public class CacheOOHAvailabilityResponse {

	@XmlElement(name = "Success", required = true)
	protected boolean success;
	
	public CacheOOHAvailabilityResponse(){
		success = true;
	}
	public boolean getSuccess() {
		return this.success;
	}
	
	public void setSuccess(boolean value) {
		this.success = value;
	}
}
