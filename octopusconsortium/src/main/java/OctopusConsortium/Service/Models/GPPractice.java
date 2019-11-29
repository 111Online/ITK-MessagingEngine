package OctopusConsortium.Service.Models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GPPractice", propOrder = {
	"name",
    "address",
    "telephone",
    "ods"
})
public class GPPractice {
	@XmlElement(name = "Name")
	protected String name;	
	@XmlElement(name = "Address")
	protected Address address;
	@XmlElement(name = "Telephone")
	protected String telephone;
	@XmlElement(name="ODS")
	protected String ods;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = org.apache.commons.lang.WordUtils.capitalizeFully(name);
	}	
	public Address getAddress()
	{
		return address;
	}
	public void setAddress(Address value)
	{
		address = value;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public void setODS(String value)
	{
		ods = value;
	}
	
	public String getODS()
	{
		return ods;
	}
}
