/**
 * 
 */
package OctopusConsortium;

import com.sun.xml.bind.marshaller.NamespacePrefixMapper;



/**
 * @author stuart.yeates
 * This class is used during the serialising of objects to customise the namespace prefix
 */
public class ITKNamespacePrefixMapper extends NamespacePrefixMapper {
	private static final String ITK_PREFIX = "ns2"; 
    private static final String ITK_URI = "urn:nhs-itk:ns:201005";
  
    private static final String HLSEVEN_PREFIX=""; // DEFAULT NAMESPACE
    private static final String HLSEVEN_URI = "urn:hl7-org:v3";   
 
	/* (non-Javadoc)
	 * @see com.sun.xml.bind.marshaller.NamespacePrefixMapper#getPreferredPrefix(java.lang.String, java.lang.String, boolean)
	 */
	@Override
	public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix) {
		if(namespaceUri == ITK_URI)
		{
			return ITK_PREFIX;
		}
		
		if(namespaceUri==HLSEVEN_URI)
		{
			return HLSEVEN_PREFIX;
		}
		
		return suggestion;
	}
	@Override
    public String[] getPreDeclaredNamespaceUris() {
        return new String[] { HLSEVEN_URI, ITK_URI };
    }
}
