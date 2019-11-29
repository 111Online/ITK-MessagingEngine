package OctopusConsortium.Core.Transformers.DoS;

import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;

import OctopusConsortium.Models.Nhs111Endpoint;
import OctopusConsortium.Models.Nhs111Endpoints;

import java.util.Arrays;
import java.util.List;

public class Test extends AbstractTransformer { 


	@Override
	protected Object doTransform(Object payload, String enc)
			throws TransformerException {
		// 
		String t = "abc.com;def.co.uk";
		List<Nhs111Endpoint> endpoints = ((Nhs111Endpoints)payload).getEndpoints();
		String[] str_array = t.split(";");
	
		for (Nhs111Endpoint ep : endpoints){
			if(!Arrays.asList(str_array).contains(ep.getUrl())){
				//log.error "endpoint address not authorised: " + ep.getUrl()
				
				//ep.setUrl("");		
			}
		}
		
		return null;
	}
}