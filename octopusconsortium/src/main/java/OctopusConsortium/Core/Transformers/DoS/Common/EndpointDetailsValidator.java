package OctopusConsortium.Core.Transformers.DoS.Common;

import OctopusConsortium.DosService1_5.Endpoint;
import OctopusConsortium.DosService1_5.EndpointTransportType;
import OctopusConsortium.Models.DOS.Proxy.Response.ContactDetailsField;

public class EndpointDetailsValidator {
	public boolean isValidContactType(Endpoint endpoint) {
		//we currently only support primary endpoints (in the future we may support 'copy', maybe for PEM)
		return	(EndpointTransportType.ITK.equalsValue((endpoint.getTransport())) && endpoint.getBusinessScenario().equals("Primary")) 
				||
				(EndpointTransportType.EMAIL.equalsValue((endpoint.getTransport())) && endpoint.getBusinessScenario().equals("Primary")); 
	}

	public boolean hasTypeDetails(Endpoint endpoint) {
		return endpoint.getTransport() != null && !endpoint.getTransport().isEmpty()
				&& endpoint.getBusinessScenario() != null && !endpoint.getBusinessScenario().isEmpty();
	}
	
	public boolean isValidContactType(ContactDetailsField contactDetail) {
		//we currently only support primary endpoints (in the future we may support 'copy', maybe for PEM)
		return	(EndpointTransportType.ITK.equalsValue(contactDetail.getTagField().toString())) ||
				(EndpointTransportType.EMAIL.equalsValue(contactDetail.getTagField().toString())); 
	}

	public boolean hasTypeDetails(ContactDetailsField contactDetail) {
		return contactDetail.getTagField() != null && contactDetail.getValueField() != null;
	}
}

