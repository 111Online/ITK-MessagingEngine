/**
 * 
 */
package OctopusConsortium.Core;

/**
 * @author stuart.yeates
 *
 */
public class MessageSizeLimitException extends Exception {

	private static final long serialVersionUID = -2250595849110571605L;
	protected String _serviceMessage = "";
	
	public MessageSizeLimitException()
	{
		
	}
	
	public MessageSizeLimitException(String message)
	{
		this(message, "");
	}
	public MessageSizeLimitException(String message ,String serviceMessage)
	{
		super(message);
		_serviceMessage = serviceMessage;
	}
	
	public String getServiceMessage()
	{
		return _serviceMessage;
	}
	
}
