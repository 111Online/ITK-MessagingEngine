package OctopusConsortium;

import java.util.ArrayList;
import java.util.List;

import OctopusConsortium.Service.Models.Authentication;
import OctopusConsortium.Service.Models.FindServicesRequest;
import OctopusConsortium.Service.Models.Gender;

public class FindServicesRequestBuilder {
	
	private Object _role;
	private int _age;
	private Gender _gender;
	private String _postcode;
	private int _searchDistance;
	private int _dispositionCode;
	private int _symptomGroup;
	private List<Integer> _symptomDiscriminatorList;

	public FindServicesRequestBuilder withAuthenticationRole(String role) {
		_role = role;
		return this;
	}
	
	public FindServicesRequestBuilder withGender(Gender gender) {
		_gender = gender;
		return this;
	}
	
	public FindServicesRequestBuilder withAge(int age) {
		_age = age;
		return this;
	}
	
	public FindServicesRequestBuilder withPostcode(String postcode) {
		_postcode = postcode;
		return this;
	}

	public FindServicesRequestBuilder withDistance(int distance) {
		_searchDistance = distance;
		return this;
	}

	public FindServicesRequestBuilder withDispositionCode(int code) {
		_dispositionCode = code;
		return this;
	}

	public FindServicesRequestBuilder withSymptomGroup(int group) {
		_symptomGroup = group;
		return this;
	}
	
	public FindServicesRequestBuilder withSymptomDiscriminatorList(List<Integer> symptomDiscriminatorList) {
		_symptomDiscriminatorList = symptomDiscriminatorList;
		return this;
	}
	
	public FindServicesRequestBuilder withSymptomDiscriminatorList(Integer value) {
		_symptomDiscriminatorList = new ArrayList<Integer>();
		_symptomDiscriminatorList.add(value);
		return this;
	}
	
	public Object[] build() {
		
		OctopusConsortium.Service.Models.Authentication auth = new Authentication();
		auth.setRoles(new ArrayList<String>());
		auth.getRoles().add(_role);		
		
		FindServicesRequest result = new FindServicesRequest();
		
		result.setAge(_age);
		result.setGender(_gender);
		result.setPostcode(_postcode);
		result.setSearchDistance(_searchDistance);
		result.setDispositionCode(_dispositionCode);
		result.setSymptomGroup(_symptomGroup);
		result.setSymptomDiscriminatorList(_symptomDiscriminatorList);
		
		return new Object[] { auth, result };
	}
	
}
