package OctopusConsortium.Core.Transformers.DoS;


import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
import OctopusConsortium.Core.OOHProviderPostcodeCache;
import OctopusConsortium.Service.Models.CheckOOHAvailabilityRequest;

public class CheckDosServicePostcodes extends AbstractTransformer {

	public void setProviderPostCodeCache(OOHProviderPostcodeCache oohProviderPostcodeCache) {
		_oohProviderPostcodeCache = oohProviderPostcodeCache;
	}
	
	@Override
	protected Object doTransform(Object src, String enc)
			throws TransformerException {

		if (_oohProviderPostcodeCache == null)
			return null; //postcode override is disabled
		
		CheckOOHAvailabilityRequest payload = ExtractPayload(src);
		
		return _oohProviderPostcodeCache.searchForService(payload.getSource(),payload.getPostcode());
	}
	
	private CheckOOHAvailabilityRequest ExtractPayload(Object src)
			throws TransformerException {
		
		if (src == null) {
			throw Exception("Cannot perform a postcode lookup. Payload received was null.");
		}
		
		if (!(src instanceof CheckOOHAvailabilityRequest))
			throw Exception("Cannot perform a postcode lookup. Expected a " + CheckOOHAvailabilityRequest.class.getName() + ", received " + src.getClass().getName());
		
		return (CheckOOHAvailabilityRequest)src;
	}
	
	private TransformerException Exception(String message) {
		return new TransformerException(this, new Exception(message));
	}

	private OOHProviderPostcodeCache _oohProviderPostcodeCache;
}
