package OctopusConsortium.Core;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.CRLException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509CRL;

import javax.naming.NamingException;


public class CertificateRevocationHelper {
	
	public static X509CRL downloadCRL(String crlURL) throws Exception,
	CertificateException, CRLException,
	CertificateEncodingException, NamingException {
		if (crlURL.startsWith("http://") || crlURL.startsWith("https://")
				|| crlURL.startsWith("ftp://")) {
			X509CRL crl = downloadCRLFromWeb(crlURL);
			return crl;
		}  else {
			throw new CertificateVerificationException(
					"Can not download CRL from certificate " +
					"distribution point: " + crlURL);
		}
	}
	
	private static X509CRL downloadCRLFromWeb(String crlURL)
			throws MalformedURLException, IOException, CertificateException,
			CRLException {
		URL url = new URL(crlURL);
		InputStream crlStream = url.openStream();
		try {
			CertificateFactory cf = CertificateFactory.getInstance("X.509");
			X509CRL crl = (X509CRL) cf.generateCRL(crlStream);
			return crl;
		} finally {
			crlStream.close();
		}
	}
}
