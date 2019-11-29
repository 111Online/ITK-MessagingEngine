/**
 * 
 */
package OctopusConsortium.Service.Models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import OctopusConsortium.Models.CDA.InformantType;

/**
 * @author stuart.yeates
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HaSC", propOrder = {
    "payload",
    "hascId",
    "dispositionDetails",
    "startDate",
    "informantType"
    /*"manufacturerModelName",
    "softwareName",
    "softwareVersion"*/
})
public class HaSC {
	@XmlElement(name = "Payload", required = true)
	protected String payload;
	@XmlElement(name = "Id", required = true)
	protected String hascId;
	@XmlElement(name = "DispositionDetails", required = true)
	protected DispositionDetails dispositionDetails;	
	@XmlElement(name = "StartDate", required = true)
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar startDate;
	@XmlElement(name = "InformantType",required = true)
	protected InformantType informantType;	
	/*@XmlElement(name = "ManufacturerModelName",required = true)
	protected String manufacturerModelName;
	@XmlElement(name = "SoftwareName",required = true)
	protected String softwareName;
	@XmlElement(name = "SoftwareVersion",required = true)
	protected String softwareVersion;*/
	@XmlTransient
	protected String hascCDANarrative;
	
	
	public String getHascCDANarrative() {
		return hascCDANarrative;
	}
	public void setHascCDANarrative(String hascCDANarrative) {
		this.hascCDANarrative = hascCDANarrative;
	}
	public DispositionDetails getDispositionDetails() {
		return dispositionDetails;
	}
	public void setDispositionDetails(DispositionDetails dispositionDetails) {
		this.dispositionDetails = dispositionDetails;
	}
	
	public String getValue()
	{
		return payload;
	}
	public void setValue(String value)
	{
		payload = value;
	}
	public String getId() {
		
		return hascId;
	}
	public void setId(String value) {
		
		hascId = value;
	}
	public XMLGregorianCalendar getStartDate() {		
		return startDate;
	}
	public void setStartDate(XMLGregorianCalendar value) {		
		startDate = value;
	}
	public InformantType getInformantType() {		
		return informantType;
	}
	public void setInformantType(InformantType value){
		this.informantType = value;
	}
	/*public String getManufacturerModelName() {		
		return manufacturerModelName==null?"":manufacturerModelName;
	}
	public void setManufacturerModelName(String value) {		
		manufacturerModelName = value;
	}
	public String getSoftwareName() {
		return softwareName;
	}
	public void setSoftwareName(String softwareName) {
		this.softwareName = softwareName;
	}
	public String getSoftwareVersion() {
		return softwareVersion;
	}
	public void setSoftwareVersion(String value) {
		this.softwareVersion = value;
	}*/
	
}
