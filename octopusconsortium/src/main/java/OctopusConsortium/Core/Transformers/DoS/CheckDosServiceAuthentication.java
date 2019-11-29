package OctopusConsortium.Core.Transformers.DoS;


import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
import OctopusConsortium.Core.OOHProviderPostcodeCache;

public class CheckDosServiceAuthentication extends AbstractTransformer {

	public void setProviderPostCodeCache(OOHProviderPostcodeCache oohProviderPostcodeCache) {
		_oohProviderPostcodeCache = oohProviderPostcodeCache;
	}
	
	@Override
	protected Object doTransform(Object src, String enc)
			throws TransformerException {

		if (_oohProviderPostcodeCache == null)
			return false; //postcode override is disabled
		
		//CheckOOHAvailabilityRequest payload = ExtractPayload(src);
		
		return false; //_oohProviderPostcodeCache.isAllowedDos(payload.getSource());
	}

	private OOHProviderPostcodeCache _oohProviderPostcodeCache;
}
