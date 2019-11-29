package org.mule;


 
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.mule.api.MuleMessage;
import org.mule.tck.junit4.AbstractMuleContextTestCase;
 
/**
 * Implements a test case for unit testing Mule transformers
 * that require access to the session and/or invocation message
 * property scopes.
 *
 * @author Ivan Krizsan
 */
public abstract class MuleTransformerUnitTestCase extends
    AbstractMuleContextTestCase {
    /* Constant(s): */
 
    /* Instance variable(s): */
    /**
     * Test message to be sent to the transformer under test.
     * A new instance is created before each test method.
     */
    protected MuleMessage mTestMessage;
 
    /**
     * Default constructor.
     */
    public MuleTransformerUnitTestCase() {
        /* Use the same Mule context for all test methods in the test. */
        setDisposeContextPerClass(true);
    }
 
    /**
     * Creates a Mule test message and sets common message properties
     * in preparation for a test method.
     * 
     * @throws Exception If error occurs creating test message or
     * setting common message properties.
     */
    @Before
    public final void createTestMessageBeforeEachTest() throws Exception {
        mTestMessage = createTestMessage();
        prepareTestMessage(mTestMessage);
    }
 
    /**
     * Creates a test message to be sent to the transformer under test.
     * Sets a null payload and no message properties on the message.
     * Setting of message payload and/or message properties is done in
     * the <code>prepareTestMessage</code> method.
     * Subclasses should usually not override this method.
     *
     * @return Mule message.
     */
    protected MuleMessage createTestMessage() {
        final Map<String, Object> theMessageProperties =
            new HashMap<String, Object>();
 
        /*
         * Creates a special Mule message which allow for setting and
         * retrieval of session and invocation message properties.
         */
        final MuleMessage theTestMessage =
            new DefaultTestMuleMessage(null, theMessageProperties, muleContext);
        return theTestMessage;
    }
 
    /**
     * Prepares supplied Mule test message before it is being sent to
     * the transformer under test.
     * Message preparation typically consist of setting a message payload
     * and/or setting message properties.
     * Called once in preparation for each test method, so this method
     * should contain preparation common to all test methods of a class.
     *
     * @param inTestMessage Mule message to prepare.
     * @throws Exception If error occurs during message preparation.
     */
    protected void prepareTestMessage(final MuleMessage inTestMessage)
        throws Exception {
 
    }
}
