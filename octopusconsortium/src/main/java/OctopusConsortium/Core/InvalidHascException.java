/**
 * 
 */
package OctopusConsortium.Core;

/**
 * @author stuart.yeates
 *
 */
public class InvalidHascException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8189124312828850059L;
	protected String _serviceMessage = "";
	
	public InvalidHascException()
	{
		
	}
	public InvalidHascException(String message)
	{
		this(message, "");
	}
	public InvalidHascException(String message ,String serviceMessage)
	{
		super(message);
		_serviceMessage = serviceMessage;
	}
	
	public String getServiceMessage()
	{
		return _serviceMessage;
	}
	
}
