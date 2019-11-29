package OctopusConsortium.Service.Models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PatientDetails")
public class PatientDetails {
	@XmlElement(name = "Forename", required = true)
	protected String forename;
	@XmlElement(name = "Surname", required = true)
	protected String surname;
	@XmlElement(name = "DateOfBirth", required = false)
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar dateOfBirth;	
	//@XmlElement(name = "Gender", required = false, nillable=true)
	//protected int gender;
	@XmlElement(name = "Gender", required = false)
	protected Gender gender; 
	@XmlElement(name = "NhsNumber", required = false)
	protected String nhsNumber;
		
	public String getForename()
	{
		return forename;
	}
	public void setForename(String value)
	{
		forename = value;
	}
	
	public String getSurname()
	{
		return surname;
	}
	public void setSurname(String value)
	{
		surname = value;
	}
	
	
    public XMLGregorianCalendar getDateOfBirth() 
    {
        return this.dateOfBirth;
    }
    public void setDateOfBirth(XMLGregorianCalendar value) {
        this.dateOfBirth = value;
    }

	public Gender getGender() 
	{	
		//return Gender.values()[ this.gender];
		return this.gender;
	}
	public void setGender(Gender value)
	{		
		//this.gender = Integer.parseInt(value.value());
		this.gender = value;
	}

	public String getNhsNumber() 
	{		
		return this.nhsNumber;
	}
	public void setNhsNumber(String value)
	{
		this.nhsNumber=value;
	}

	
}