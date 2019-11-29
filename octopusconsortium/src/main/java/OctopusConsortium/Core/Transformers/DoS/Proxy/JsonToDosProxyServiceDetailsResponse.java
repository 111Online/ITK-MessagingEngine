/**
 * Alternative to built in Mule - Json to Object Transformer
 */
package OctopusConsortium.Core.Transformers.DoS.Proxy;

import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;

import OctopusConsortium.Core.InvalidMessageException;
import OctopusConsortium.Models.DOS.Proxy.Response.*;

import org.codehaus.jackson.map.*;

/**
 * @author tom.axworthy
 *
 */
public class JsonToDosProxyServiceDetailsResponse extends
		AbstractTransformer{
		
	public JsonToDosProxyServiceDetailsResponse() {
		super();
		
		this.registerSourceType(DataTypeFactory.create(String.class));
		this.setReturnDataType(DataTypeFactory.create(OctopusConsortium.Models.DOS.Proxy.Response.Services.class));
	}
	
	/* (non-Javadoc)
	 * @see org.mule.transformer.AbstractMessageTransformer#transformMessage(org.mule.api.MuleMessage, java.lang.String)
	 */
	@Override
	public Object doTransform(Object payload, String outputEncoding)
			throws TransformerException {
		
		try{
			if (payload instanceof String)
			{
				Services convertedJson = new Services();
				ObjectMapper om = new ObjectMapper();
				
				convertedJson = om.readValue((String) payload, OctopusConsortium.Models.DOS.Proxy.Response.Services.class);
				
				return convertedJson;
			}
			throw new InvalidMessageException("Incorrect input type for transformer");				
		}
		catch(Exception ex){
			throw new TransformerException(this,ex);
		}
	}
}