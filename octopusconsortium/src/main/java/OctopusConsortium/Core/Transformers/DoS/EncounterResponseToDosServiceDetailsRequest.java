/**
 * 
 */
package OctopusConsortium.Core.Transformers.DoS;


import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;

import OctopusConsortium.Core.InvalidMessageException;
import OctopusConsortium.DosService1_5.ObjectFactory;
import OctopusConsortium.DosService1_5.ServiceDetailsById;
import OctopusConsortium.Service.Models.IdentifyPatientResponse;
import OctopusConsortium.Service.Models.SubmitEncounterToServiceRequest;


/**
 * @author stuart.yeates
 *
 */
public class EncounterResponseToDosServiceDetailsRequest extends
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
	public EncounterResponseToDosServiceDetailsRequest() {
		// TODO Auto-generated constructor stub
		super();
		
		this.registerSourceType(DataTypeFactory.create(OctopusConsortium.Service.Models.SubmitEncounterToServiceRequest.class));
		this.registerSourceType(DataTypeFactory.create(OctopusConsortium.Service.Models.IdentifyPatientResponse.class));	
		this.registerSourceType(DataTypeFactory.create(ServiceDetailsById.class));
		//Using the ServiceDetailsById wrapper object does not seem to work 
		this.setReturnDataType(DataTypeFactory.create(OctopusConsortium.DosService1_5.ServiceDetailsById.class));
		//this.setReturnDataType(DataTypeFactory.create(Object[].class));
	}

	
	/* (non-Javadoc)
	 * @see org.mule.transformer.AbstractMessageTransformer#transformMessage(org.mule.api.MuleMessage, java.lang.String)
	 */
	@Override
	public Object doTransform(Object payload, String outputEncoding)
			throws TransformerException {
		
		try{		
		
			ServiceDetailsById serviceDetails = null;
			ObjectFactory factory = new ObjectFactory();
			
			if(payload instanceof OctopusConsortium.DosService.ServiceDetailsById){
				serviceDetails = (ServiceDetailsById)payload;
			}else if(payload instanceof SubmitEncounterToServiceRequest)	{
				SubmitEncounterToServiceRequest encounterRequest = (SubmitEncounterToServiceRequest)payload;
				
				serviceDetails = factory.createServiceDetailsById();
				
				serviceDetails.setUserInfo(factory.createUserInfo());
				serviceDetails.getUserInfo().setUsername(_username);
				serviceDetails.getUserInfo().setPassword(_password);
				
				if(encounterRequest.getServiceDetails()!=null && encounterRequest.getServiceDetails().getId() > 0 )
					serviceDetails.setServiceId(""+encounterRequest.getServiceDetails().getId());				
				else if(encounterRequest.getServiceDetails()!=null && 
						encounterRequest.getServiceDetails().getOdsCode() != null &&
						!encounterRequest.getServiceDetails().getOdsCode().equals(""))
				{
					serviceDetails.setServiceId(encounterRequest.getServiceDetails().getOdsCode());
				}
				else{
					throw new InvalidMessageException("Missing ServiceDetail odsCode");				
				}
				
				return serviceDetails;
				
				/*Object[] objArr = new Object[2];
				objArr[0] = serviceDetails.getUserInfo();
				objArr[1] = serviceDetails.getServiceId();
				return objArr;	*/	
			}		
			else {
				IdentifyPatientResponse identifyPatientResponse = (IdentifyPatientResponse)payload;	
				
				if(identifyPatientResponse.getPatient().getGPPractice()!=null){
					serviceDetails = factory.createServiceDetailsById();
					serviceDetails.setServiceId(identifyPatientResponse.getPatient().getGPPractice().getODS());
				}else
					throw new InvalidMessageException("Missing ServiceDetail odsCode");
			}
			
			serviceDetails.setUserInfo(factory.createUserInfo());
			serviceDetails.getUserInfo().setUsername(_username);
			serviceDetails.getUserInfo().setPassword(_password);
			//return serviceDetails;
			Object[] objArr = new Object[2];
			objArr[0] = serviceDetails.getUserInfo();
			objArr[1] = serviceDetails.getServiceId();
			return objArr;
		}
		catch(Exception ex){
			throw new TransformerException(this,ex);
		}
	}
}