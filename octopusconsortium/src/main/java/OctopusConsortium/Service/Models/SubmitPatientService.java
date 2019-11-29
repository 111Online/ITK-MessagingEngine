package OctopusConsortium.Service.Models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import OctopusConsortium.Models.IITKPatient;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubmitPatientService")
public class SubmitPatientService extends SubmitPatient implements IITKPatient {
	@XmlElement(name = "EmailAddress")
	protected String emailAddress;
	@XmlElement(name = "TelephoneNumber")
	protected String telephoneNumber;
		
	public String getEmailAddress()
	{
		return emailAddress;
	}
	public void setEmailAddress(String value)
	{
		emailAddress = value;
	}
	public String getTelephoneNumber()
	{
		return telephoneNumber;
	}
	public void setTelephoneNumber(String value)
	{
		telephoneNumber = value;
	}
}