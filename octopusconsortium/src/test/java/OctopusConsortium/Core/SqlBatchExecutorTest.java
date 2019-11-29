package OctopusConsortium.Core;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

import java.sql.SQLException;

import org.junit.Test;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mule.tck.junit4.AbstractMuleContextTestCase;

public class SqlBatchExecutorTest extends AbstractMuleContextTestCase {
	
	@Test
	public void Close_WithUnfinishedBatch_ExecutesBatch() {
		
		try {
			javax.sql.DataSource sds = mock(javax.sql.DataSource.class);
			java.sql.Connection conn = mock(java.sql.Connection.class);
			java.sql.PreparedStatement ps = mock(java.sql.PreparedStatement.class);
			java.sql.ResultSet rs = mock(java.sql.ResultSet.class);	

			when( sds.getConnection() ).thenReturn(conn);
			when( conn.prepareStatement(anyString()) ).thenReturn(ps);
			when( ps.executeQuery() ).thenReturn( rs );		
		
			SqlBatchExecutor sut = new SqlBatchExecutor(sds, "", 2);

			sut.open();
			sut.update();
			sut.update();
			sut.update(); //3 updates should mean 2 batches
			sut.close();

			verify(ps, VerificationModeFactory.times(2)).executeBatch();
			
		} catch (SQLException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void Open_WithTransactionTrue_SetsAutoCommitToFalse() {
		try {
			javax.sql.DataSource sds = mock(javax.sql.DataSource.class);
			java.sql.Connection conn = mock(java.sql.Connection.class);
			java.sql.PreparedStatement ps = mock(java.sql.PreparedStatement.class);
			java.sql.ResultSet rs = mock(java.sql.ResultSet.class);	

			when( sds.getConnection() ).thenReturn(conn);
			when( conn.prepareStatement(anyString()) ).thenReturn(ps);
			when( ps.executeQuery() ).thenReturn( rs );
		
			SqlBatchExecutor sut = new SqlBatchExecutor(sds, "", 2);

			sut.setIsTransaction(true);
			sut.open();

			sut.close();
			
			verify(conn, VerificationModeFactory.times(1)).setAutoCommit(false);
			
		} catch (SQLException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void Close_WithAutoCommitFalse_CallsCommit() {
		try {
			javax.sql.DataSource sds = mock(javax.sql.DataSource.class);
			java.sql.Connection conn = mock(java.sql.Connection.class);
			java.sql.PreparedStatement ps = mock(java.sql.PreparedStatement.class);
			java.sql.ResultSet rs = mock(java.sql.ResultSet.class);	

			when( sds.getConnection() ).thenReturn(conn);
			when( conn.prepareStatement(anyString()) ).thenReturn(ps);
			when( ps.executeQuery() ).thenReturn( rs );
		
			SqlBatchExecutor sut = new SqlBatchExecutor(sds, "", 2);

			sut.setIsTransaction(true);
			sut.open();

			sut.close();
			
			verify(conn, VerificationModeFactory.times(1)).commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
