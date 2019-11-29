/**
 * 
 */
package OctopusConsortium.Core.Transformers.DoS.Proxy;

import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;

import OctopusConsortium.Core.InvalidMessageException;
import OctopusConsortium.Service.Models.IdentifyPatientResponse;
import OctopusConsortium.Service.Models.SubmitEncounterToServiceRequest;
import OctopusConsortium.Models.DOS.Proxy.Request.*;

/**
 * @author tom.axworthy
 *
 */
public class EncounterResponseToDosProxyServiceDetailsRequest extends
		AbstractTransformer{

	protected String _username;
	public String getUsername() {
		return _username;
	}

	public void setUsername(String username) {
		this._username = username;
	}

	protected String _password;
	public String getPassword() {
		return _password;
	}

	public void setPassword(String password) {
		this._password = password;
	}

	protected String _serviceVersion;
	public String getServiceVersion() {
		return _serviceVersion;
	}

	public void setServiceVersion(String serviceVersion) {
		this._serviceVersion = serviceVersion;
	}
		
	public EncounterResponseToDosProxyServiceDetailsRequest() {
		super();
		
		this.registerSourceType(DataTypeFactory.create(OctopusConsortium.Service.Models.SubmitEncounterToServiceRequest.class));
		this.registerSourceType(DataTypeFactory.create(OctopusConsortium.Service.Models.IdentifyPatientResponse.class));	
		this.setReturnDataType(DataTypeFactory.create(OctopusConsortium.Models.DOS.Proxy.Request.Services.class));
	}

	
	/* (non-Javadoc)
	 * @see org.mule.transformer.AbstractMessageTransformer#transformMessage(org.mule.api.MuleMessage, java.lang.String)
	 */
	@Override
	public Object doTransform(Object payload, String outputEncoding)
			throws TransformerException {
		
		try{		
			Services serviceDetails = new Services();
			
			if (payload instanceof SubmitEncounterToServiceRequest)	{
				SubmitEncounterToServiceRequest encounterRequest = (SubmitEncounterToServiceRequest)payload;
							
				serviceDetails.setUserInfo(new UserInfo());
				serviceDetails.getUserInfo().setUsername(_username);
				serviceDetails.getUserInfo().setPassword(_password);
				serviceDetails.setServiceVersion(_serviceVersion);

				if(encounterRequest.getServiceDetails()!=null && encounterRequest.getServiceDetails().getId() > 0 )
					serviceDetails.setServiceId(""+encounterRequest.getServiceDetails().getId());				
				else if(encounterRequest.getServiceDetails()!=null && 
						encounterRequest.getServiceDetails().getOdsCode() != null &&
						!encounterRequest.getServiceDetails().getOdsCode().equals(""))
				{
					serviceDetails.setServiceId(encounterRequest.getServiceDetails().getOdsCode());
				}
				else{
					throw new InvalidMessageException("Missing ServiceDetail id");				
				}
				
				return serviceDetails;
			}		
			else {
				IdentifyPatientResponse identifyPatientResponse = (IdentifyPatientResponse)payload;	
				
				if(identifyPatientResponse.getPatient().getGPPractice()!=null){
					serviceDetails.setServiceId(identifyPatientResponse.getPatient().getGPPractice().getODS());
				}else
					throw new InvalidMessageException("Missing ServiceDetail odsCode");
				
				serviceDetails.setUserInfo(new UserInfo());
				serviceDetails.getUserInfo().setUsername(_username);
				serviceDetails.getUserInfo().setPassword(_password);
				serviceDetails.setServiceVersion(_serviceVersion);
				
				return serviceDetails;
			}
		}
		catch(Exception ex){
			throw new TransformerException(this,ex);
		}
	}
}