/**
 * 
 */
package OctopusConsortium.Core;


import java.util.List;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.binding.soap.interceptor.SoapOutInterceptor;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;
import org.apache.xerces.dom.ElementNSImpl;

/**
 * @author stuart.yeates
 * TODO Not used - was going to be used to modify wsaddressing soap properties kept for a reference
 */
public  class WSAddressingInterceptor extends AbstractSoapInterceptor {

	
	public WSAddressingInterceptor()
	{
		super(Phase.INVOKE);		
		this.addAfter(SoapOutInterceptor.class.getName());
	}
	/* (non-Javadoc)
	 * @see org.apache.cxf.interceptor.Interceptor#handleMessage(org.apache.cxf.message.Message)
	 */
	@Override
	public void handleMessage(SoapMessage message) throws Fault {
		//SoapMessage soapMessage = (SoapMessage) message;
        List<Header> list = message.getHeaders();
        //XPath xpath = XPathFactory.newInstance().newXPath();  
        //XPathExpression expr = xpath.compile("//person/*/text()");
                
        for (Header header : list) {        	
			if(header.getName().getNamespaceURI().equals("http://www.w3.org/2005/08/addressing") && header.getName().getLocalPart() == "To")
			{
				ElementNSImpl elm =  (ElementNSImpl)header.getObject();
				elm.getFirstChild().setTextContent("http://localhost:80/RepeatCallersServiceV2/RepeatCallers.svc");
			}
		}
        
        //message.getHeaders().add(arg0)
        
        //QName q = new QName("http://www.w3.org/2005/08/addressing", "Addressing");
        //String person = "Test";
        

        //SoapHeader header = new SoapHeader(q,person);
        //list.add(header); 
	}

}
