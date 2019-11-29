/**
 * 
 */
package OctopusConsortium.Core.Transformers.DoS;
import java.util.Calendar;

import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;

import OctopusConsortium.Core.InvalidMessageException;
import OctopusConsortium.Core.PostcodeHelper;
import OctopusConsortium.DosService.AgeFormatType;
import OctopusConsortium.DosService.ArrayOfInt;
import OctopusConsortium.DosService.Case;
import OctopusConsortium.DosService.GenderType;
import OctopusConsortium.DosService.ObjectFactory;
import OctopusConsortium.DosService.UserInfo;
import OctopusConsortium.Service.Models.CacheOOHAvailabilityRequest;
import OctopusConsortium.Service.Models.CheckOOHAvailabilityRequest;
import OctopusConsortium.Service.Models.FindServicesRequest;
import OctopusConsortium.Service.Models.Gender;
import OctopusConsortium.Service.Models.SubmitEncounterResponse;


/**
 * @author stuart.yeates
 *
 */
public class EncounterResponseToDosCheckCapacitySummary extends
		//AbstractMessageTransformer
		AbstractTransformer{

	protected String _username;
	public String getUsername() {
		return _username;
	}


	public void setUsername(String _username) {
		this._username = _username;
	}



	protected String _password;
	public String getPassword() {
		return _password;
	}


	public void setPassword(String _password) {
		this._password = _password;
	}


	//public static final String AssigningAuthorityName = "";
	/**
	 * 
	 */
	public EncounterResponseToDosCheckCapacitySummary() {
		// TODO Auto-generated constructor stub
		super();
		this.registerSourceType(DataTypeFactory.create(FindServicesRequest.class));
		this.registerSourceType(DataTypeFactory.create(SubmitEncounterResponse.class));		
		this.registerSourceType(DataTypeFactory.create(CacheOOHAvailabilityRequest.class));
		this.registerSourceType(DataTypeFactory.create(CheckOOHAvailabilityRequest.class));
		//this.setReturnDataType(DataTypeFactory.create(OctopusConsortium.DosService.CheckCapacitySummary.class));
		this.setReturnDataType(DataTypeFactory.create(Object[].class));
	}

	
	/* (non-Javadoc)
	 * @see org.mule.transformer.AbstractMessageTransformer#transformMessage(org.mule.api.MuleMessage, java.lang.String)
	 */
	@Override
	public Object doTransform(Object payload, String outputEncoding)
			throws TransformerException {
		
		ObjectFactory factory = new ObjectFactory();
		Case caseSummary = factory.createCase();
		try	
		{
			if(payload instanceof FindServicesRequest)
			{
				FindServicesRequest findServices = (FindServicesRequest)payload;
						
				if (findServices.getAge() != null)
				{
					caseSummary.setAge(findServices.getAge().shortValue());
					caseSummary.setAgeFormat(AgeFormatType.YEARS);
				}
				if(findServices.getGender() == Gender.MALE)
					caseSummary.setGender(GenderType.M);
				else if(findServices.getGender() == Gender.FEMALE)
					caseSummary.setGender(GenderType.F);
				else{
					caseSummary.setGender(GenderType.I);
				}
				caseSummary.setPostcode(findServices.getPostcode());
				if(findServices.getSearchDistance() != null && findServices.getSearchDistance() > 0)
					caseSummary.setSearchDistance(findServices.getSearchDistance());
				if(findServices.getSurgery()!=null)
					caseSummary.setSurgery(findServices.getSurgery());				
				caseSummary.setDisposition(findServices.getDispositionCode());
				caseSummary.setSymptomGroup(findServices.getSymptomGroup());
				if (findServices.getSymptomDiscriminatorList() != null) {
					ArrayOfInt ints = new ArrayOfInt();		
					ints.getInt().addAll(findServices.getSymptomDiscriminatorList());
					caseSummary.setSymptomDiscriminatorList(ints);
				}
				
			}else if(payload instanceof SubmitEncounterResponse)
			{		
				SubmitEncounterResponse responseEnvelope = (SubmitEncounterResponse)payload;				
				
				if(responseEnvelope.getHaSC()==null || responseEnvelope.getHaSC().getDispositionDetails() == null)
					throw new InvalidMessageException("hasc missing disposition infomation");
				
				//check disposition
				if(responseEnvelope.getHaSC().getDispositionDetails().getDispositionCode() <= 0)
					throw new InvalidMessageException("hasc missing disposition code");
				
				//check symptomGroup
				if(responseEnvelope.getHaSC().getDispositionDetails().getSymptomGroup() <= 0)
					throw new InvalidMessageException("hasc missing symptom group");
						
				int yearOfBirth = responseEnvelope.getPatient().getDOB().getYear();
				caseSummary.setAge((short)(Calendar.getInstance().get(Calendar.YEAR) - yearOfBirth));
				
				caseSummary.setAgeFormat(AgeFormatType.YEARS);
				if(responseEnvelope.getPatient().getGender() == Gender.MALE)
					caseSummary.setGender(GenderType.M);
				else if(responseEnvelope.getPatient().getGender() == Gender.FEMALE)
					caseSummary.setGender(GenderType.F);
				else{
					caseSummary.setGender(GenderType.I);
				}
				
				//ToDo Set search distance
				//caseSummary.setSearchDistance();
				
				caseSummary.setPostcode(responseEnvelope.getPatient().getAddress().getPostalCode());
				caseSummary.setDisposition(responseEnvelope.getHaSC().getDispositionDetails().getDispositionCode());
				caseSummary.setSymptomGroup(responseEnvelope.getHaSC().getDispositionDetails().getSymptomGroup());
				ArrayOfInt ints = new ArrayOfInt();
				ints.getInt().addAll(responseEnvelope.getHaSC().getDispositionDetails().getSymptomDiscriminatorList());
				caseSummary.setSymptomDiscriminatorList(ints);
			} else if(payload instanceof CacheOOHAvailabilityRequest) {
				CacheOOHAvailabilityRequest  availabilityRequest = (CacheOOHAvailabilityRequest)payload;
				
				caseSummary.setAge((short)21);
				caseSummary.setAgeFormat(AgeFormatType.YEARS);
				caseSummary.setGender(GenderType.I);
				caseSummary.setPostcode(PostcodeHelper.AddSpaceToPostcode(availabilityRequest.getPostcode()));				
				caseSummary.setDisposition(13);//Speak To GP Practice Within 6 hours				
				caseSummary.setSymptomGroup(1159); //Symptoms without specific Pathway
				if(availabilityRequest.getSearchDistance()!=null && availabilityRequest.getSearchDistance() > 0){
					caseSummary.setSearchDistance(availabilityRequest.getSearchDistance());
				}
				ArrayOfInt ints = new ArrayOfInt();
				ints.getInt().add(4003);//PC full Primary Care assessment and prescribing 
				caseSummary.setSymptomDiscriminatorList(ints);
				
			} else {
				CheckOOHAvailabilityRequest  availabilityRequest = (CheckOOHAvailabilityRequest)payload;
				
				caseSummary.setAge((short)21);
				caseSummary.setAgeFormat(AgeFormatType.YEARS);
				caseSummary.setGender(GenderType.I);
				caseSummary.setPostcode(PostcodeHelper.AddSpaceToPostcode(availabilityRequest.getPostcode()));				
				caseSummary.setDisposition(13);//Speak To GP Practice Within 6 hours				
				caseSummary.setSymptomGroup(1159); //Symptoms without specific Pathway
				if(availabilityRequest.getSearchDistance()!=null && availabilityRequest.getSearchDistance() > 0){
					caseSummary.setSearchDistance(availabilityRequest.getSearchDistance());
				}
				ArrayOfInt ints = new ArrayOfInt();
				ints.getInt().add(4003);//PC full Primary Care assessment and prescribing 
				caseSummary.setSymptomDiscriminatorList(ints);
				
			}
		}
		catch(Exception ex)
		{
			throw new TransformerException(this,ex);
		}
		
		UserInfo userInfo = factory.createUserInfo();
		userInfo.setUsername(_username);
		userInfo.setPassword(_password);
		
		//return serviceDetails;
		Object[] objArr = new Object[2];
		objArr[0] = userInfo;
		objArr[1] = caseSummary;
		
		return objArr;	
	}
	
}
