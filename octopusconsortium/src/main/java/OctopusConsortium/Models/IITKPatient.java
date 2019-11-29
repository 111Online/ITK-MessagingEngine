package OctopusConsortium.Models;

import javax.xml.bind.annotation.XmlTransient;
import javax.xml.datatype.XMLGregorianCalendar;

import OctopusConsortium.Models.CDA.InformantType;
import OctopusConsortium.Service.Models.Address;
import OctopusConsortium.Service.Models.DateOfBirth;
import OctopusConsortium.Service.Models.GPPractice;
import OctopusConsortium.Service.Models.Gender;


@XmlTransient
public interface IITKPatient {

	public abstract String getInformantContactName();

	public abstract void setInformantContactName(String informantContactName);

	public abstract GPPractice getGpPractice();

	public abstract void setGpPractice(GPPractice gpPractice);

	public abstract String getForename();

	public abstract void setForename(String value);

	public abstract String getSurname();

	public abstract void setSurname(String value);

	public abstract DateOfBirth getDateOfBirth();

	public abstract void setDateOfBirth(DateOfBirth value);
	public abstract void setDateOfBirth(XMLGregorianCalendar value);

	public abstract Gender getGender();

	public abstract void setGender(Gender value);

	public abstract String getNhsNumber();

	public abstract void setNhsNumber(String value);

	public abstract InformantType getInformantType();

	public abstract void setInformantType(InformantType value);

	public abstract Address getCurrentAddress();

	public abstract void setCurrentAddress(Address value);

	public abstract Address getHomeAddress();

	public abstract void setHomeAddress(Address value);
	
	public abstract String getEmailAddress();
	
	public abstract void setEmailAddress(String value);
	
	public abstract String getTelephoneNumber();
	
	public abstract void setTelephoneNumber(String value);

}