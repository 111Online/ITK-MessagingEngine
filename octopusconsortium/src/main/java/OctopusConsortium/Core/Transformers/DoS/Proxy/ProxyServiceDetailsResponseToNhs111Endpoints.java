/**
 * 
 */
package OctopusConsortium.Core.Transformers.DoS.Proxy;

import java.util.Collections;
import java.util.List;

import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;

import OctopusConsortium.Core.Transformers.DoS.Common.EndpointDetailsValidator;
import OctopusConsortium.DosService1_5.EndpointTransportType;
import OctopusConsortium.Models.Nhs111Endpoint;
import OctopusConsortium.Models.Nhs111Endpoints;
import OctopusConsortium.Models.DOS.Proxy.Response.*;

/**
 * @author adam.naylor
 *
 */
	public class ProxyServiceDetailsResponseToNhs111Endpoints extends
		AbstractTransformer{

	public ProxyServiceDetailsResponseToNhs111Endpoints() {
		// TODO Auto-generated constructor stub
		super();
		
		this.registerSourceType(DataTypeFactory.create(Services.class));
		this.setReturnDataType(DataTypeFactory.create(OctopusConsortium.Models.Nhs111Endpoints.class));
	}

	
	/* (non-Javadoc)
	 * @see org.mule.transformer.AbstractMessageTransformer#transformMessage(org.mule.api.MuleMessage, java.lang.String)
	 */
	@Override
	public Object doTransform(Object payload, String outputEncoding)
			throws TransformerException {
		Nhs111Endpoints targetEndpoints = new Nhs111Endpoints();
		final String delimiter = "\\\\\\|";
		Services services = (Services)payload;
		
		if (services != null && !services.getServices().isEmpty()) {
			Service service = services.getServices().get(0);	
			EndpointDetailsValidator endpointDetailsValidator = new EndpointDetailsValidator();
			
			List<ContactDetailsField> contactDetails =  service.getContactDetailsField();
			Collections.sort(contactDetails, new ContactFieldComparator());
			for (ContactDetailsField contactDetail : contactDetails) {
				if(endpointDetailsValidator.hasTypeDetails(contactDetail) 
						   && endpointDetailsValidator.isValidContactType(contactDetail)) {
					String value = contactDetail.getValueField();
					String[] values = value.split(delimiter);
					//expect 6 elements, "{address}\\|{interaction}\\|{format}\\|{businessScenario}\\|{comment}\\|{compression}"
					if(values.length < 4 || !values[3].equals("Primary"))
						continue; //we currently only support primary endpoints (in the future we may support 'copy', maybe for PEM)
					Nhs111Endpoint endpoint = new Nhs111Endpoint();
					endpoint.setUrl(values[0]);
					endpoint.setInteraction(values[1]);
					endpoint.setFormat(values[2]);
					endpoint.setTransport(EndpointTransportType.fromValue(contactDetail.getTagField().toString()));
					targetEndpoints.getEndpoints().add(endpoint);
					
					//ensure we only return one endpoint
					return targetEndpoints;
				}
			}
		}
		return targetEndpoints;

	}
}