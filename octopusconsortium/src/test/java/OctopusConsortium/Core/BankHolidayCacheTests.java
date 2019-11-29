package OctopusConsortium.Core;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Test;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mule.api.transformer.TransformerException;
import org.mule.module.json.JsonData;
import org.mule.tck.junit4.AbstractMuleContextTestCase;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BankHolidayCacheTests extends AbstractMuleContextTestCase {
	
	@Test
	public void doTransform_WithJson_InsertsIntoStore()	{
		
		//Arrange
		SqlBatchExecutor batch = mock(SqlBatchExecutor.class);
		
		BankHolidayCache cache = new BankHolidayCache();
		cache.setSqlBatchExecutor(batch);
		
		JsonData json = null;
		try {
			json = new JsonData("{\"england-and-wales\":{\"division\":\"england-and-wales\",\"events\":[{\"title\":\"New Year’s Day\",\"date\":\"2012-01-02\",\"notes\":\"Substitute day\",\"bunting\":\"true\"}]}}");
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		
		//Act
		try {
			cache.doTransform(json, null);
		} catch (TransformerException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		
		//Assert
		try {
			verify(batch, VerificationModeFactory.times(1)).open();
			//verify(batch, VerificationModeFactory.times(1)).setIsTransaction(true);
			
			verify(batch, VerificationModeFactory.times(1)).setParameter(1, "england-and-wales");
			verify(batch, VerificationModeFactory.times(1)).setParameter(2, "New Year’s Day");
			verify(batch, VerificationModeFactory.times(1)).setParameter(3, "2012-01-02");
			verify(batch, VerificationModeFactory.times(1)).setParameter(4, "Substitute day");
			verify(batch, VerificationModeFactory.times(1)).setParameter(5, "true");
			
			verify(batch, VerificationModeFactory.times(1)).update();
			verify(batch, VerificationModeFactory.times(1)).close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
