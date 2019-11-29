/**
 * 
 */
package OctopusConsortium.Core.Transformers.DoS;

import java.util.Collections;
import java.util.List;

import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;

import OctopusConsortium.DosService1_5.ServiceDetail;
import OctopusConsortium.Core.Transformers.DoS.Common.EndpointDetailsValidator;
import OctopusConsortium.DosService1_5.ArrayOfServiceEndpoints;
import OctopusConsortium.DosService1_5.ArrayOfServices;
import OctopusConsortium.DosService1_5.Endpoint;
import OctopusConsortium.DosService1_5.EndpointTransportType;
import OctopusConsortium.DosService1_5.ServiceDetailsByIdResponse;
import OctopusConsortium.Models.Nhs111Endpoint;
import OctopusConsortium.Models.Nhs111Endpoints;

public class ServiceDetailsResponseToNhs111Endpoints extends AbstractTransformer{

	public ServiceDetailsResponseToNhs111Endpoints() {
		super();
		
		this.registerSourceType(DataTypeFactory.create(OctopusConsortium.DosService1_5.ServiceDetailsByIdResponse.class));
		this.setReturnDataType(DataTypeFactory.create(OctopusConsortium.Models.Nhs111Endpoints.class));
	}

	/* (non-Javadoc)
	 * @see org.mule.transformer.AbstractMessageTransformer#transformMessage(org.mule.api.MuleMessage, java.lang.String)
	 */
	@Override
	public Object doTransform(Object payload, String outputEncoding)
			throws TransformerException {
		Nhs111Endpoints targetEndpoints = new Nhs111Endpoints();

		ServiceDetailsByIdResponse serviceDetailsResponse = (ServiceDetailsByIdResponse)payload;
		ArrayOfServices encounterResponse = serviceDetailsResponse.getServices();
		List<ServiceDetail> serviceDetails = encounterResponse.getService();
		ServiceDetail service = serviceDetails.get(0);
		ArrayOfServiceEndpoints arrayServiceEndpoint = service.getServiceEndpoints();
		List<Endpoint> serviceEndpoints = arrayServiceEndpoint.getEndpoint();

		Collections.sort(serviceEndpoints, new EndpointComparator());

		EndpointDetailsValidator endpointValidator = new EndpointDetailsValidator();
		
		for (Endpoint endpoint : serviceEndpoints){
			if (endpointValidator.hasTypeDetails(endpoint) && endpointValidator.isValidContactType(endpoint)){
				Nhs111Endpoint oneOneOneEndpoint = new Nhs111Endpoint();
				oneOneOneEndpoint.setFormat(endpoint.getFormat());
				oneOneOneEndpoint.setInteraction(endpoint.getInteraction());
				oneOneOneEndpoint.setUrl(endpoint.getAddress());
				oneOneOneEndpoint.setTransport(EndpointTransportType.fromValue(endpoint.getTransport()));
				
				targetEndpoints.getEndpoints().add(oneOneOneEndpoint);
				//ensure we only return the top ordered endpoint
				return targetEndpoints;
			}
		}
		
		return targetEndpoints;
	}	
}
