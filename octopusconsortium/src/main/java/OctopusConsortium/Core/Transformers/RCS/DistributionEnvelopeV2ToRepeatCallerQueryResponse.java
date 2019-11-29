package OctopusConsortium.Core.Transformers.RCS;


import java.util.List;

import javax.xml.bind.JAXBElement;

import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;

import OctopusConsortium.Core.InvalidMessageException;
import OctopusConsortium.Models.RCS.PRPAMT000001GB01RepeatCallerResponse;
import OctopusConsortium.RepeatCallerServiceV1.DistributionEnvelopeType;
import OctopusConsortium.RepeatCallerServiceV1.PayloadType;

public class DistributionEnvelopeV2ToRepeatCallerQueryResponse  extends
		AbstractTransformer {


	public DistributionEnvelopeV2ToRepeatCallerQueryResponse()
	{
		super();
		this.registerSourceType(DataTypeFactory.create(DistributionEnvelopeType.class));	
		this.setReturnDataType(DataTypeFactory.create(PRPAMT000001GB01RepeatCallerResponse.class));
	}		
	
	@Override
	protected Object doTransform(Object src, String enc)
			throws TransformerException  {		
		DistributionEnvelopeType message = (DistributionEnvelopeType) src;
		
		try {			
			List<PayloadType> payloads = message.getPayloads().getPayload();			
			if(payloads.size()!=1){				
				throw new InvalidMessageException("Invalid payload","DistributionEnvelopeType");		
			}		
			PayloadType payloadType = (PayloadType)payloads.get(0);
			List<Object> content = payloadType.getAny();
			
			for (Object object : content) {
				if(object instanceof JAXBElement<?>)
				{
					JAXBElement<?> elm = (JAXBElement<?>)object;
					if(elm.getValue() instanceof PRPAMT000001GB01RepeatCallerResponse)
						return (PRPAMT000001GB01RepeatCallerResponse)elm.getValue();
				}
			}			
			//we did not find what we wanted 
			throw new InvalidMessageException("Invalid payload","missing PRPAMT000001GB01RepeatCallerResponse");
			
		} catch (Exception  e) {			
			e.printStackTrace();
			
			throw new TransformerException(this,e);
		}
	}
	

}
