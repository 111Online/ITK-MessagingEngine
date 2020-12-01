package OctopusConsortium.Service.Models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IdentifyPatientRequest")
public class IdentifyPatientRequest extends PatientDetails {
	@XmlElement(name = "ExternalRef", required = false)
	protected String externalRef;
	@XmlElement(name = "Address", required = false)
	protected String address;
	@XmlElement(name = "Postcode", required = false)
	protected String postcode;

	public String getExternalRef() {
		return externalRef;
	}
	public void setExternalRef(String externalRef) {
		this.externalRef = externalRef;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPostcode() 
	{	
		return this.postcode;
	}
	public void setPostcode(String value)
	{
		this.postcode = value;
	}
}