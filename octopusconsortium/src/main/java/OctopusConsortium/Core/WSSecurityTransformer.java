package OctopusConsortium.Core;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.ws.security.WSConstants;
import org.apache.ws.security.WSEncryptionPart;
import org.apache.ws.security.components.crypto.Crypto;
import org.apache.ws.security.components.crypto.CryptoFactory;
import org.apache.ws.security.message.WSSecHeader;
import org.apache.ws.security.message.WSSecSignature;
import org.apache.ws.security.message.WSSecTimestamp;
import org.apache.ws.security.message.WSSecUsernameToken;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;
import org.mule.transport.http.HttpsConnector;
import org.w3c.dom.Document;

public class WSSecurityTransformer
	extends AbstractTransformer {
  
	private HttpsConnector _connector;
	private String _alias;
	private String _username;
	
	public void setHTTPS(HttpsConnector value) {
	       _connector = value;
	}
	
	public void setAlias(String value) {
	       _alias = value;
	}
	
	public String getAlias() {
	       return _alias;
	}

	public void setUsername(String value){
		this._username = value;
	}
	public String getUsername() {
		// TODO Auto-generated method stub
		return this._username;
	}
	
	
	public WSSecurityTransformer() {			
		super();
		this.registerSourceType(DataTypeFactory.create(String.class));	
		this.setReturnDataType(DataTypeFactory.create(String.class));
	}
	
	
	
	@Override
	public Object doTransform(Object messagePayload, String outputEncoding)
			throws TransformerException {

        try {   
        	
        	String payload = (String) messagePayload;
        	//get the cert and the private key
        	KeyStore store = loadKeystore();
        	Key signingKey = getPrivateKey(store);
        	X509Certificate cert = getKeyStoreCert(store);
		
            Document doc = SoapUtil.toSOAPPart(payload);
            
            WSSecHeader secHeader = new WSSecHeader();
    		secHeader.insertSecurityHeader(doc);			
			
			WSSecUsernameToken usernameToken = createUsernameToken(this.getUsername());
			doc = usernameToken.build(doc, secHeader);
			
			WSSecTimestamp timestamp = new WSSecTimestamp();
    		timestamp.setTimeToLive(600);
			doc = timestamp.build(doc, secHeader);
    		
    		WSSecSignature signature = createSignature(cert);
			Crypto crypto = createCryptoWithCertificate(signingKey, cert);			
			doc = signature.build(doc, crypto, secHeader);
			
			payload = SoapUtil.toString(SoapUtil.toSOAPMessage(doc));
			
			return payload;
			
		} catch (Exception e) {
			throw new TransformerException(this, e);
		}		
		
	}
	
	

	private X509Certificate getKeyStoreCert(KeyStore store) throws WSSecurityTransformerException {
        
		try {
			
			java.security.cert.Certificate cert = store.getCertificate(_alias);
        
			ByteArrayInputStream is = new ByteArrayInputStream(cert.getEncoded());
			CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
			return (X509Certificate)certFactory.generateCertificate(is);
			
        } catch (Exception e) {
			throw new WSSecurityTransformerException(e);
		}
	}

	private Key getPrivateKey(KeyStore store) throws WSSecurityTransformerException {
		try { 
			String keyPassword = _connector.getKeyPassword();
			return store.getKey(_alias, keyPassword.toCharArray());
		} catch (Exception e) {
			throw new WSSecurityTransformerException(e);
		}
	}	
	
	private WSSecUsernameToken createUsernameToken(String username)
			throws WSSecurityTransformerException {		
		
		try {
			
			WSSecUsernameToken builder = new WSSecUsernameToken();
			builder.setPasswordType(null);
			builder.setUserInfo(username,null);
	
			return builder;
			
		} catch (Exception e) {
			throw new WSSecurityTransformerException(e);
		}

	}
	
	private KeyStore loadKeystore()
			throws WSSecurityTransformerException {
		
		try {
			
			KeyStore ks = KeyStore.getInstance("JKS");
        	FileInputStream fis = new FileInputStream(_connector.getClientKeyStore());
        	ks.load(fis, _connector.getClientKeyStorePassword().toCharArray());
        
        	return ks;
        	
        } catch (Exception e) {
			throw new WSSecurityTransformerException(e);
		}
	}
	
	private WSSecSignature createSignature(X509Certificate signingCert)
			throws WSSecurityTransformerException {
		
		try {
			
			WSSecSignature builder = new WSSecSignature();
	
		    builder.setX509Certificate(signingCert);
		    builder.setUserInfo(_alias, _connector.getKeyPassword());
		    builder.setUseSingleCertificate(true);
		    builder.setKeyIdentifierType(WSConstants.BST_DIRECT_REFERENCE);
		    
		    builder.setSignatureAlgorithm(WSConstants.RSA_SHA1);
		    builder.setSigCanonicalization(WSConstants.C14N_EXCL_OMIT_COMMENTS);
		    
		    builder.setDigestAlgo(WSConstants.SHA1); 
		    
		    //tell it we will be signing the timestamp
		    List<WSEncryptionPart> parts = new ArrayList<WSEncryptionPart>();
	        WSEncryptionPart timestampPart = new WSEncryptionPart("Timestamp", WSConstants.WSU_NS, "");
	        parts.add(timestampPart);
	        builder.setParts(parts);
	        
		    return builder;
	    
        } catch (Exception e) {
			throw new WSSecurityTransformerException(e);
		}
	}
	
	private Crypto createCryptoWithCertificate(Key signingKey, X509Certificate signingCert)
			throws WSSecurityTransformerException {
		
		try {
			
			Properties properties = new Properties();
			properties.setProperty("org.apache.ws.security.crypto.provider", "org.apache.ws.security.components.crypto.Merlin");
			
			Crypto crypto = CryptoFactory.getInstance(properties);
			
			KeyStore keystore = KeyStore.getInstance("JKS");
			keystore.load(null, _connector.getKeyPassword().toCharArray());
			keystore.setKeyEntry(_alias, signingKey, _connector.getKeyPassword().toCharArray(), new Certificate[] { signingCert });
			((org.apache.ws.security.components.crypto.Merlin)crypto).setKeyStore(keystore);
			
			crypto.loadCertificate(new ByteArrayInputStream(signingCert.getEncoded()));
			
			return crypto;
			
	    } catch (Exception e) {
			throw new WSSecurityTransformerException(e);
		}
	}



	
}
