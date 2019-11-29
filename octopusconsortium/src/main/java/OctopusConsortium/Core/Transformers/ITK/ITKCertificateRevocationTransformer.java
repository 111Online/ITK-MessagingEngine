package OctopusConsortium.Core.Transformers.ITK;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.cert.CertificateFactory;
import java.security.cert.X509CRL;

import javax.security.cert.X509Certificate;

import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;

import OctopusConsortium.Core.CertificateRevocationHelper;
import OctopusConsortium.Core.ExternalServiceException;

public class ITKCertificateRevocationTransformer extends AbstractTransformer {

	public void setCRLURL(String crlURL) {
		_crlURL = crlURL;
	}
	
	@Override
	protected Object doTransform(Object src, String enc)
			throws TransformerException {
		
		if (!(src instanceof X509Certificate))
			throw new TransformerException(this, new ExternalServiceException("ITKCertificateRevocationTransformer expected a payload of type javax.security.cert.X509Certificate but recevied a " + src.getClass().getName() + "."));
		
		try {
			X509CRL crl = CertificateRevocationHelper.downloadCRL(_crlURL);
			CertificateFactory cf = CertificateFactory.getInstance("X.509");
			InputStream in = new ByteArrayInputStream(((X509Certificate)src).getEncoded());
	        if (crl.isRevoked(cf.generateCertificate(in)))
	        	throw new TransformerException(this, new ExternalServiceException("ITK certificate revoked."));
		} catch(Exception e) {
			throw new TransformerException(this, new ExternalServiceException("Unable to confirm ITK certificate revokation status. " + e.getMessage()));
		}
		
		return src;
	}
	

	private String _crlURL;

}
