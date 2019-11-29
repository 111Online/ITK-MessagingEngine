package OctopusConsortium;

import java.util.Hashtable;

import javax.naming.NameNotFoundException;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.*;

public class DNSResolver {

	public DNSResolver(String dnsProviderHostName) {
		_dnsProviderHostName = dnsProviderHostName;
	}
	
	//Adapted from:
	//http://stackoverflow.com/questions/12405654/check-the-dns-lookup-of-a-nameserver-in-java
	public String resolve(String domain) {
		
		Hashtable<String, Object> env = new Hashtable<String, Object>();
		env.put("java.naming.factory.initial", "com.sun.jndi.dns.DnsContextFactory");
		env.put("java.naming.provider.url",    "dns://" + _dnsProviderHostName);

		DirContext ictx;
		try {
			ictx = new InitialDirContext(env);

			Attributes attrs = ictx.getAttributes(domain, new String[] {"A"});

			NamingEnumeration<? extends Attribute> e = attrs.getAll();
			if (e.hasMoreElements()) {
			    Attribute a = e.next();
			    return a.get().toString();
			}
		} catch (NameNotFoundException e) {
			return null;
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public boolean canResolve(String domain) {
		return resolve(domain) != null;
	}
	
	private String _dnsProviderHostName;
}
