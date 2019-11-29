package OctopusConsortium;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.xml.datatype.XMLGregorianCalendar;

import OctopusConsortium.Service.Models.Authentication;
import OctopusConsortium.Service.Models.Gender;
import OctopusConsortium.Service.Models.IdentifyPatientRequest;

public class IdentifyPatientRequestBuilder {
	
	private String _forename;
	private String _surname;
	private String _role;
	private XMLGregorianCalendar _dob;
	private Gender _gender;
	private String _postcode;

	public IdentifyPatientRequestBuilder() {
		reset();
	}
	
	public IdentifyPatientRequestBuilder reset() {
		_forename = "tforename";
		_surname = "tsurname";
		_role = "ROLE_ADMIN";		
		_gender = Gender.MALE;
		_postcode = "LA12 7HG";
		
		withDateOfBirth(1980, 10, 15, 10, 01);

		return this;
	}
	
	public IdentifyPatientRequestBuilder withForename(String forename) {
		_forename = forename;
		return this;
	}
	
	public IdentifyPatientRequestBuilder withSurname(String surname) {
		_surname = surname;
		return this;
	}
	
	public IdentifyPatientRequestBuilder withAuthenticationRole(String role) {
		_role = role;
		return this;
	}
	
	public IdentifyPatientRequestBuilder withDateOfBirth(Calendar dob) {
		
	    _dob = OctopusConsortium.Core.XMLGregorianCalendarConversionUtil.asXMLGregorianCalendar(dob.getTime());

	    return this;
	}
	
	public IdentifyPatientRequestBuilder withDateOfBirth(int year, int month, int day, int hour, int minute) {
	    Calendar dob = GregorianCalendar.getInstance();
		dob.set(year, month, day, hour, minute);
		
		withDateOfBirth(dob);

	    return this;
	}
	
	
	
	public Object[] build() {
		OctopusConsortium.Service.Models.Authentication auth = new Authentication();
		auth.setRoles(new ArrayList<String>());
		auth.getRoles().add(_role);		
		
		IdentifyPatientRequest request = new IdentifyPatientRequest();
		request.setForename(_forename);
		request.setSurname(_surname);
		request.setGender(_gender);
		request.setPostcode(_postcode);
		
		request.setDateOfBirth(_dob);
		
		return new Object[] { auth, request };
	}

	public IdentifyPatientRequestBuilder withGender(Gender gender) {
		_gender = gender;
		
		return this;
	}

	public IdentifyPatientRequestBuilder withPostcode(String postcode) {
		_postcode = postcode;

		return this;
	}
	
	
}
