package OctopusConsortium.Core.Transformers.ITK;

import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;

import OctopusConsortium.Service.Models.SubmitToCallQueueResponse;
import OctopusConsortium.Service.Models.SubmitToCallQueueResponseOverallStatus;

public class CDAToCallQueueResponse extends AbstractTransformer{

	public CDAToCallQueueResponse()
	{
		super();
		
		this.registerSourceType(DataTypeFactory.create(String.class));
		this.setReturnDataType(DataTypeFactory.create(OctopusConsortium.Service.Models.SubmitToCallQueueResponse.class));
	}

	@Override
	protected Object doTransform(Object src, String enc)
			throws TransformerException {
		
		//if we get to this transformer, the call queue ITK endpoint has not thrown a SOAP fault-
		//but we need to ensure that a reference has been passed back.
		
		SubmitToCallQueueResponse response = new SubmitToCallQueueResponse();
		//set defaults
		response.setQueueReference("");
		response.setOverallStatus(SubmitToCallQueueResponseOverallStatus.FAILED_CALL_QUEUE_SUBMISSION);

		if (src instanceof String)
		{
			String reference = (String)src;
		
			if (reference != null && !reference.isEmpty()) {
				response.setQueueReference(reference);
				response.setOverallStatus(SubmitToCallQueueResponseOverallStatus.SUCCESSFUL_CALL_QUEUE_SUBMISSION);
			}
		}
		
		return response;
	}
}