package OctopusConsortium.Service.Models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import OctopusConsortium.Models.OOHServiceStatus;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CheckOOHAvailabilityResponse")
public class CheckOOHAvailabilityResponse  {
	
	@XmlElement(name = "ServiceStatus", required = true)
	protected OOHServiceStatus oohServiceStatus;
	@XmlElement(name = "ServiceDetails")
	protected SubmitToServiceDetails serviceDetails;

	
	public OOHServiceStatus getOohServiceStatus() {
		return this.oohServiceStatus;
	}
	
	public void setOOHServiceStatus(OOHServiceStatus value) {
		this.oohServiceStatus = value;
	}
	
	public SubmitToServiceDetails getOohServiceDetails() {
		return this.serviceDetails;
	}
	
	public void setOOHServiceDetails(SubmitToServiceDetails value) {
		this.serviceDetails = value;
	}
}
