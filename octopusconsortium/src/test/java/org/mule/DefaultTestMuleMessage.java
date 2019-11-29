
package org.mule;
 
import java.util.HashMap;
import java.util.Map;
import javax.activation.DataHandler;
import org.mule.api.MuleContext;
import org.mule.api.MuleMessage;
import org.mule.transformer.types.TypedValue;
 
/**
 * Mule message that sets regular maps for session and invocation scope
 * property storage.
 * Only to be used when unit testing transformers without starting a
 * Mule instance.
 * Note that this class need to be in the org.mule package to be able
 * to access the methods with which the invocation and session property
 * maps are set.
 *
 * @author Ivan Krizsan
 */
public class DefaultTestMuleMessage extends DefaultMuleMessage {
    /* Constant(s): */
    private static final long serialVersionUID = -5337792698311698732L;
 
    public DefaultTestMuleMessage(final MuleMessage inMessage) {
        super(inMessage);
 
        initializePropertiesMaps();
    }
 
    public DefaultTestMuleMessage(final Object inMessage,
        final MuleContext inMuleContext) {
        super(inMessage, inMuleContext);
        initializePropertiesMaps();
    }
 
    public DefaultTestMuleMessage(final Object inMessage,
        final Map<String, Object> inOutboundProperties,
        final MuleContext inMuleContext) {
        super(inMessage, inOutboundProperties, inMuleContext);
        initializePropertiesMaps();
    }
 
    public DefaultTestMuleMessage(final Object inMessage,
        final MuleMessage inPrevious, final MuleContext inMuleContext) {
        super(inMessage, inPrevious, inMuleContext);
        initializePropertiesMaps();
    }
 
    public DefaultTestMuleMessage(final Object inMessage,
        final Map<String, Object> inOutboundProperties,
        final Map<String, DataHandler> inAttachments,
        final MuleContext inMuleContext) {
        super(inMessage, inOutboundProperties, inAttachments, inMuleContext);
        initializePropertiesMaps();
    }
 
    public DefaultTestMuleMessage(final Object inMessage,
        final Map<String, Object> inInboundProperties,
        final Map<String, Object> inOutboundProperties,
        final Map<String, DataHandler> inAttachments,
        final MuleContext inMuleContext) {
        super(inMessage, inInboundProperties, inOutboundProperties,
            inAttachments, inMuleContext);
        initializePropertiesMaps();
    }
 
    /**
     * Creates and sets maps holding invocation and session scope
     * message properties on this message.
     */
    private void initializePropertiesMaps() {
        /* Create and set a map holding invocation properties. */
        final Map<String, TypedValue> theInvocationPropertiesMap =
            new HashMap<String, TypedValue>();
        
        setInvocationProperties(theInvocationPropertiesMap);
        
        /* Create and set a map holding session properties. */
        final Map<String, TypedValue> theSessionPropertiesMap =
            new HashMap<String, TypedValue>();
        setSessionProperties(theSessionPropertiesMap);
    }
}
