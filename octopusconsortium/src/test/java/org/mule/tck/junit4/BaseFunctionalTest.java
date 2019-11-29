package org.mule.tck.junit4;

import org.mule.api.MuleException;
import org.mule.module.client.MuleClient;
import org.mule.tck.junit4.FunctionalTestCase;

public class BaseFunctionalTest extends FunctionalTestCase {

	@Override
	protected String getConfigResources() {
		return 	"testendpoints.xml," +
				"main.xml," +				
				"bankholiday.xml," +
				"callqueue.xml," +
				"itk_submission.xml," +
				"outofhours.xml," +
				"query_dos_nhsuk.xml," +				
				"query_dos.xml," +
				"queryspine.xml," +
				"repeat_caller_service.xml," +
				"cxfConfig.xml,"+
				"diagnostics.xml";
	}
	
	protected MuleClient getClient()
	{
		if(_client==null)
			try {
				_client = new MuleClient(muleContext);
			} catch (MuleException e) {			
				e.printStackTrace();
			}
		return _client;
	}
	
	private MuleClient _client;
}
