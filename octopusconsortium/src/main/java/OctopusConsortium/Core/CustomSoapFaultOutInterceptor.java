package OctopusConsortium.Core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.binding.soap.interceptor.Soap11FaultOutInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;
import org.mule.config.ExceptionHelper;
/***
 * 
 * @author stuart.yeates
 * 
 * Used in the Message Engine cxf component to catch errors message and set custom soap fault.
 *
 */
public class CustomSoapFaultOutInterceptor extends AbstractSoapInterceptor {

	public Object error;
	
	public void setError(Object value)
	{
		error = value;
	}
	public Object getError()
	{
		return error;
	}
	
	private static final Log logger = LogFactory.getLog(CustomSoapFaultOutInterceptor.class);
	
	public CustomSoapFaultOutInterceptor() {
		super(Phase.MARSHAL);
		getAfter().add(Soap11FaultOutInterceptor.class.getName());
	}
	
	@Override
	public void handleMessage(SoapMessage message) throws Fault {
		Fault fault = (Fault) message.getContent(Exception.class);
		
		logger.error(fault.getMessage(), fault);
		//delete the Mule Exception to have the one thrown by the component in the SoapMessage
		Throwable t = ExceptionHelper.getRootException(fault);
		
		if (t instanceof java.lang.SecurityException) {
			fault.setMessage("Invalid Username or password. " + t.getMessage());
        	fault.setFaultCode(new javax.xml.namespace.QName("Client"));
        }else if(t instanceof InvalidMessageException){
			fault.setMessage("Invalid Message Exception: " + t.getMessage());
			fault.setFaultCode(new javax.xml.namespace.QName("Client"));
		}else if(t instanceof org.xml.sax.SAXParseException){
			fault.setMessage("Invalid Message Exception: " + t.getMessage());
			fault.setFaultCode(new javax.xml.namespace.QName("Client"));
		}else if(t instanceof OctopusConsortium.Core.ExternalServiceException){
			fault.setMessage("ExternalServiceException");		
		}else if(t instanceof javax.xml.soap.SOAPException){
			fault.setMessage("ExternalServiceException ");
		}else if(t instanceof java.lang.IllegalArgumentException && fault.getCause() instanceof javax.xml.bind.UnmarshalException ){
			fault.setMessage("Invalid Message Exception: content '" + t.getMessage() + "'");
		}
        else
			fault.setMessage("An error has occured processing the request.");
		
	}
}
