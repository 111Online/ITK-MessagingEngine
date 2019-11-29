package OctopusConsortium.Service.Models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import OctopusConsortium.Models.CDA.InformantType;

/***
 * 
 * @author stuart.yeates
 * Represents the fields to be sumbitted to adastra
 * 
 * no longer extends PatientDetials as the fields have different required attributes
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubmitPatient", propOrder = {
		"forename",
		"surname",
		"dateOfBirth",
		"ageGroup",
		"gender",
		"nhsNumber",
	    "informantType",
	    "informantContactName",
	    "currentAddress",
	    "homeAddress",		  
	    "gpPractice"
	})
public class SubmitPatient //extends PatientDetails {
{
	@XmlElement(name = "Forename", required = false)
	protected String forename;
	@XmlElement(name = "Surname", required = false)
	protected String surname;
	@XmlElement(name = "DateOfBirth", required = true)
	//@XmlSchemaType(name = "date")
	protected DateOfBirth dateOfBirth;	
	@XmlElement(name = "AgeGroup", required = false)
	protected String ageGroup;
	@XmlElement(name = "Gender", required = true)
	protected Gender gender;
	@XmlElement(name = "NhsNumber", required = false)
	protected String nhsNumber;
	
	@XmlElement(name = "InformantType",required = true)
	protected InformantType informantType;		
	@XmlElement(name = "InformantName", required = false)
	protected String informantContactName;
	
	@XmlElement(name = "CurrentAddress", required = false)
	protected Address currentAddress;
	
	@XmlElement(name = "HomeAddress", required = false)
	protected Address homeAddress;

		
	@XmlElement(name = "GpPractice", required = false)
	protected GPPractice gpPractice;
	
	
	public String getInformantContactName() {
		return informantContactName;
	}

	public void setInformantContactName(String informantContactName) {
		this.informantContactName = informantContactName;
	}

	public GPPractice getGpPractice() {
		return gpPractice;
	}

	public void setGpPractice(GPPractice gpPractice) {
		this.gpPractice = gpPractice;
	}

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
	
	public DateOfBirth getDateOfBirth() 
    {
        return this.dateOfBirth;
    }

	public void setDateOfBirth(DateOfBirth value) {
        this.dateOfBirth = value;
    }
	
	public void setDateOfBirth(XMLGregorianCalendar value) {
        this.dateOfBirth.setDob(value);
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
	
	public InformantType getInformantType()
	{
		return informantType;
	}

	public void setInformantType(InformantType value)
	{
		informantType = value;
	}
		
	public Address getCurrentAddress()
	{
		return currentAddress;
	}

	public void setCurrentAddress(Address value)
	{
		currentAddress = value;
	}

	public Address getHomeAddress()
	{
		return homeAddress;
	}

	public void setHomeAddress(Address value)
	{
		homeAddress = value;
	}
	public void setAgeGroup(String ageGroup){
		this.ageGroup = ageGroup;
	}
	public String getAgeGroup(){
		return ageGroup;
	}
}