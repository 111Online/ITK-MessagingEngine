package OctopusConsortium.Core;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import org.w3c.dom.ls.LSInput;
import org.w3c.dom.ls.LSResourceResolver;

/**
 * Class to resolve all schemas to the same location
 * we no longer use this as we have recreated the schema location path in the resources structure
 * @author stuart.yeates
 *
 */
public class ResourceResolver implements LSResourceResolver 
{
    private Set<String> returnedResources = new HashSet<String>();
	private URL basePath;  
    

    public ResourceResolver(LSResourceResolver r,URL basePath)
    {	    	
    this.basePath = basePath;
    }

    public ResourceResolver(URL basePath) 
    {	   
    	this.basePath = basePath;
    }

    public LSInput resolveResource(String type, String namespaceURI, String publicId, String systemId, String baseURI) {
    
    	
    	LSInput input = new LSInputImpl();
    	input.setBaseURI(baseURI);
	    //logger.info("==== Resolving '" + type + "' '" + namespaceURI + "' '" + publicId + "' '" + systemId + "' '" + baseURI + "'");
	    
	    //check if 
	    URI uri;
		try {		
					
			int i = systemId.lastIndexOf("/");
			if(i>0)
				systemId = systemId.substring(i+1,systemId.length());
			if (returnedResources.contains(systemId)) 
		        return null;
			uri = basePath.toURI().resolve(systemId);
			
			try {
				InputStream is = uri.toURL().openStream();
				input.setByteStream(is);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
	    /*
	    if (returnedResources.contains(systemId)) {
	        return null;
	    } else if (systemId.equals("datatypes-2005.xsd")) {
	        input.setByteStream(this.getClass().getResourceAsStream("datatypes-2005.xsd"));	    
	    } else {
	    	if(parent!=null)
	    		return parent.resolveResource(type, namespaceURI, publicId, systemId, baseURI);
	    	else
	    		return null;
	    }*/
	    returnedResources.add(systemId);
	    return input;
    }

}