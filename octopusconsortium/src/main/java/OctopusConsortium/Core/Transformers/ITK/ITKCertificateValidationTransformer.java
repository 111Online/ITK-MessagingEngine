package OctopusConsortium.Core.Transformers.ITK;

import javax.security.cert.X509Certificate;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;
import OctopusConsortium.DNSResolver;
import OctopusConsortium.Core.ExternalServiceException;
import OctopusConsortium.Core.SSLConnection;
import OctopusConsortium.Core.SSLConnectionException;

public class ITKCertificateValidationTransformer extends AbstractMessageTransformer {
	
	public void setDNSProviderHostName(String dnsProviderHostName) {
		_dnsProviderHostName = dnsProviderHostName;
	}
	
	public void setKeystorePath(String keystorePath) {
		_keystorePath = keystorePath;
	}
	
	public void setKeystorePassword(String keystorePassword) {
		_keystorePassword = keystorePassword;
	}
	
	public void setTruststorePath(String truststorePath) {
		_truststorePath = truststorePath;
	}
	
	public void setTruststorePassword(String truststorePassword) {
		_truststorePassword = truststorePassword;
	}
	
	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding)
			throws TransformerException {
		
		//Establish an SSL connection and pull out the certificate
		SSLConnection conn = new SSLConnection();
		conn.setKeystorePath(_keystorePath);
		conn.setKeystorePassword(_keystorePassword);
		conn.setTruststorePath(_truststorePath);
		conn.setTruststorePassword(_truststorePassword);
		
		X509Certificate cert;
		try {
			if (!message.getOutboundPropertyNames().contains("EndpointUrl"))
				throw new TransformerException(this, new Exception("Couldn't read outbound property 'EndpointUrl'"));
			
			conn.connect(message.getOutboundProperty("EndpointUrl").toString());
			cert = conn.getCertificate();
		} catch (SSLConnectionException e) {
			throw new TransformerException(this, new ExternalServiceException(e.getMessage()));
		}
		        
		//Perform n3 DNS lookup against certificate subject domain
		if (_dnsProviderHostName.isEmpty()){
			//Certificate checks not to be performed. Move along, nothing to see here...
			return cert;
		}
		
		DNSResolver dns = new DNSResolver(_dnsProviderHostName);
		String subject = cert.getSubjectDN().getName().replace("CN=", "").split(",")[0];
		if (subject.contains(".oneoneone.nhs.uk") && !dns.canResolve(subject))
			throw new TransformerException(this, new ExternalServiceException("The N3 DNS lookup failed for domain " + subject + "."));
		
		//All checks out. Carry on.
		return cert;
	}
	

	private String _dnsProviderHostName;
	
	private String _keystorePath;
	private String _keystorePassword;
	private String _truststorePath;
	private String _truststorePassword;

}
