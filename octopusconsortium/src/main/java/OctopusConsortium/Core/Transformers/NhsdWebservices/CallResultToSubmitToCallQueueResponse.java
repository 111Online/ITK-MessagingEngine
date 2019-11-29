package OctopusConsortium.Core.Transformers.NhsdWebservices;

import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;

import OctopusConsortium.NhsdWebservices.CallResult;
import OctopusConsortium.Service.Models.SubmitToCallQueueResponse;
import OctopusConsortium.Service.Models.SubmitToCallQueueResponseOverallStatus;

public class CallResultToSubmitToCallQueueResponse extends
//AbstractMessageTransformer
AbstractTransformer {

	/**
	 * 
	 */
	public CallResultToSubmitToCallQueueResponse() {
		// TODO Auto-generated constructor stub
		super();
		
		this.registerSourceType(DataTypeFactory.create(OctopusConsortium.NhsdWebservices.CallResult.class));
		this.setReturnDataType(DataTypeFactory.create(OctopusConsortium.Service.Models.SubmitToCallQueueResponse.class));
		
	}
	
	@Override
	protected Object doTransform(Object payload, String enc)
			throws TransformerException {
		SubmitToCallQueueResponse result = new SubmitToCallQueueResponse();
		CallResult callRequest = (CallResult)payload;
		
		if(callRequest.isStatus()){
			result.setOverallStatus(SubmitToCallQueueResponseOverallStatus.SUCCESSFUL_CALL_QUEUE_SUBMISSION);			
		}
		else{
			result.setOverallStatus(SubmitToCallQueueResponseOverallStatus.FAILED_CALL_QUEUE_SUBMISSION);			
			result.getErrors().add(callRequest.getDescription());			
		}
		//we have no reference to pass back
		result.setQueueReference("");
		
		return result;
	}

}
