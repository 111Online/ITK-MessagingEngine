package OctopusConsortium.Core;

public class ExternalServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 569442375626316093L;

	public ExternalServiceException(String message){
		super(message);
	}

	public ExternalServiceException(String string, Exception e)	{
		super(string, e);
	}
}
