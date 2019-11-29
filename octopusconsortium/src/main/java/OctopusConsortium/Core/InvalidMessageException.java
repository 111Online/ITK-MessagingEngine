/**
 * 
 */
package OctopusConsortium.Core;

/**
 * @author stuart.yeates
 *
 */
public class InvalidMessageException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9189024312828850059L;
	protected String _serviceMessage = "";
	
	public InvalidMessageException()
	{
		
	}
	public InvalidMessageException(String message)
	{
		this(message, "");
	}
	public InvalidMessageException(String message ,String serviceMessage)
	{
		super(message);
		_serviceMessage = serviceMessage;
	}
	
	public String getServiceMessage()
	{
		return _serviceMessage;
	}
	
}
