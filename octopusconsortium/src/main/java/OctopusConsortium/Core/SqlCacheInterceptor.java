package OctopusConsortium.Core;
import java.io.Serializable;
import org.mule.DefaultMuleEvent;
import org.mule.DefaultMuleMessage;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.MuleMessage;
import org.mule.api.interceptor.Interceptor;
import org.mule.api.processor.MessageProcessor;


public class SqlCacheInterceptor implements Interceptor {

	private MessageProcessor next; 
	private SqlObjectStore<Serializable> store;
	
	public void setStore(SqlObjectStore<Serializable> store){
		this.store = store;
	}
	
	@Override
	public void setListener(MessageProcessor listener) {
		 next = listener;  
	}

	@Override
	public MuleEvent process(MuleEvent event) throws MuleException {
		final MuleMessage currentMessage = event.getMessage();  
        final Object key = currentMessage.getPayload(); 
        //if(key instanceof OctopusConsortium.Models.FindServicesRequest){
        //	key = ((OctopusConsortium.Models.FindServicesRequest)key).getPostcode();
        //}
        final Serializable cachedElement = store.retrieve((Serializable) key);  
        if (cachedElement != null)  
        {  
          return new DefaultMuleEvent(new DefaultMuleMessage(cachedElement,  
            currentMessage, event.getMuleContext()), event);  
        }  
        final MuleEvent result = next.process(event);  
        if(result.getMessage().getExceptionPayload()==null){
        	store.store((Serializable)key, (Serializable)result.getMessage().getPayload()); 
        }
        return result; 
	}

}
