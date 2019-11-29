package OctopusConsortium.Core;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyStore;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import javax.security.cert.X509Certificate;

public class SSLConnection {
	
	public void connect(String address) throws SSLConnectionException {
		URL url;
		try {
			url = new URL(address);
		} catch (MalformedURLException e) {
	         throw new SSLConnectionException(e);
		}
		connect(url);
	}
	
	public void connect(URL url) throws SSLConnectionException {
		connect(url.getHost(), url.getPort());
	}
	
	public void connect(String host, int port) throws SSLConnectionException {		
		//if the address has no port specified, URL will default to -1
		//see http://docs.oracle.com/javase/7/docs/api/java/net/URL.html#getPort()
		if (port == -1)
			port = 443;
		
		try {
			
			KeyManagerFactory kmf = loadKeystore();
			TrustManagerFactory tmf = loadTrustStore();
	        
			_socket = createSocket(kmf, tmf, host, port);

			_socket.startHandshake();
			_sslSession = _socket.getSession();
	      } catch (Exception e) {
	         throw new SSLConnectionException(e);
	      }
	}
	
	public void close() throws SSLConnectionException {
		try {
			_socket.close();
		} catch (IOException e) {
	         throw new SSLConnectionException(e);
		}
	}
	
	public X509Certificate getCertificate() throws SSLConnectionException {
		//are we connected?
		if (_socket.isConnected() && _sslSession != null && _sslSession.isValid()) {
			//is there a certificate to return?
			try {
				if (_sslSession.getPeerCertificateChain() != null && _sslSession.getPeerCertificateChain().length > 0)
					return _sslSession.getPeerCertificateChain()[0];
			} catch (SSLPeerUnverifiedException e) {
		         throw new SSLConnectionException(e);
			}
		}
		
		return null;
	}
	
	public String getKeystorePath() {
		return _keystorePath;
	}
	
	public void setKeystorePath(String keystorePath) {
		_keystorePath = keystorePath;
	}
	
	public String getKeystorePassword() {
		return _keystorePassword;
	}
	
	public void setKeystorePassword(String keystorePassword) {
		_keystorePassword = keystorePassword;
	}
	
	
	public String getTruststorePath() {
		return _truststorePath;
	}
	
	public void setTruststorePath(String truststorePath) {
		_truststorePath = truststorePath;
	}
	
	public String getTruststorePassword() {
		return _truststorePassword;
	}
	
	public void setTruststorePassword(String truststorePassword) {
		_truststorePassword = truststorePassword;
	}

	private SSLSocket _socket;
	private SSLSession _sslSession;
	
	private String _keystorePath;
	private String _keystorePassword;
	private String _truststorePath;
	private String _truststorePassword;
	
	private KeyManagerFactory loadKeystore() throws SSLConnectionException {

		KeyStore keystore;
		try {
			keystore = KeyStore.getInstance("JKS");

			//keystore.load(SSLConnection.class.getResourceAsStream(_keystorePath), _keystorePassword.toCharArray());
			keystore.load(new FileInputStream(_keystorePath), _keystorePassword.toCharArray());
			KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
	        kmf.init(keystore, _keystorePassword.toCharArray());
	        
	        return kmf;
	        
		} catch (Exception e) {
			throw new SSLConnectionException(e);
		}
	}
	
	private TrustManagerFactory loadTrustStore() throws SSLConnectionException {
		
		KeyStore truststore;
		try {
			truststore = KeyStore.getInstance("JKS");

			//truststore.load(SSLConnection.class.getResourceAsStream(_truststorePath), _truststorePassword.toCharArray());
			truststore.load(new FileInputStream(_truststorePath), _truststorePassword.toCharArray());
			TrustManagerFactory trustManager = TrustManagerFactory.getInstance("SunX509");
			trustManager.init(truststore);
			
			return trustManager;
		} catch (Exception e) {
			throw new SSLConnectionException(e);
		}
	}
	
	private SSLSocket createSocket(KeyManagerFactory kmf, TrustManagerFactory tmf, String host, int port) throws SSLConnectionException {
        SSLContext sc;
		try {
			sc = SSLContext.getInstance("TLS");
	        sc.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null); //SecureRandom.getInstance("SHA1PRNG")
	        SSLSocketFactory f = (SSLSocketFactory) sc.getSocketFactory();
	        return (SSLSocket) f.createSocket(host, port);
		} catch (Exception e) {
			throw new SSLConnectionException(e);
		}
	}
}
