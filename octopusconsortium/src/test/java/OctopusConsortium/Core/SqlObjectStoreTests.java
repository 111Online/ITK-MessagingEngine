package OctopusConsortium.Core;

import static org.junit.Assert.*;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.SQLException;
import java.sql.Timestamp;


import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mule.api.store.ObjectStoreException;
import org.mule.tck.junit4.AbstractMuleContextTestCase;
import org.springframework.util.SerializationUtils;

import static org.mockito.Mockito.*;

public class SqlObjectStoreTests extends AbstractMuleContextTestCase  {

	final String TableName = "CacheBlobs";
	final String KeyName = "Key";
	final String ValueName = "Value";
	final String DateTouchedName = "DateTouched";
	
	SqlObjectStore<Serializable> target;
	
	@Before
	public void BeforeTest() throws Exception{
		target = new SqlObjectStore<Serializable>();
		target.setTableName(TableName);
		target.setKeyName(KeyName);
		target.setValueName(ValueName);
		target.setDateTouchedName(DateTouchedName);
		target.setMuleContext(this.createMuleContext());
	}
	
	
	/**
	 * @throws SQLException 
	 * 
	 **/
	@Test
	public void testContains() throws SQLException {		
		
		//Arrange
		//############
		javax.sql.DataSource sds = mock(javax.sql.DataSource.class);
		java.sql.Connection conn = mock(java.sql.Connection.class);
		java.sql.PreparedStatement ps = mock(java.sql.PreparedStatement.class);
		java.sql.ResultSet rs = mock(java.sql.ResultSet.class);
				
		when( sds.getConnection() ).thenReturn(conn);
		when( conn.prepareStatement(anyString()) ).thenReturn(ps);
		when( ps.executeQuery() ).thenReturn( rs );		
		target.setJdbcConnection( sds );		
		ArgumentCaptor<String> arg = ArgumentCaptor.forClass(String.class);
		
		//Act
		//############
		try {			
			assertFalse( target.contains("test") );				
		} catch (ObjectStoreException e) {		
			e.printStackTrace();
			fail("ObjectStoreException");
		}
		
		//Assert
		//############		
		verify( sds ).getConnection();
		verify( conn ).prepareStatement( arg.capture() );
		verify( conn ).close();
		verify( ps ).setNString( eq(1), anyString() );
		verify( ps ).executeQuery();
		verify( ps ).close();
		assertEquals( String.format("SELECT [%s] FROM [%s] WHERE [%s] = ?",this.KeyName,this.TableName,this.KeyName), arg.getValue() );
		
	}

	
	@Test
	public void testStore() throws SQLException {		
		
		//Arrange
		//############
		javax.sql.DataSource sds = mock(javax.sql.DataSource.class);
		java.sql.Connection conn = mock(java.sql.Connection.class);
		java.sql.PreparedStatement ps = mock(java.sql.PreparedStatement.class);
		java.sql.ResultSet rs = mock(java.sql.ResultSet.class);
				
		when( sds.getConnection() ).thenReturn( conn );
		when( conn.prepareStatement( anyString()) ).thenReturn(ps);
		when( ps.executeQuery() ).thenReturn( rs );		
		target.setJdbcConnection( sds );		
		ArgumentCaptor<String> arg = ArgumentCaptor.forClass(String.class);
		
		//Act
		//############
		try {			
			target.store("test", "testValue");				
		} catch (ObjectStoreException e) {		
			e.printStackTrace();
			fail("ObjectStoreException");
		}
		
		//Assert
		//############		
		verify( sds ).getConnection();
		verify( conn ).prepareStatement( arg.capture() );
		verify( conn ).close();
		verify( ps ).executeUpdate();
		verify( ps ).setNString( eq(1), anyString() );
		verify( ps ).setBytes( eq(2) , any(byte[].class) );
		verify( ps ).close();
		assertEquals( String.format("INSERT INTO [%s] ([%s],[%s]) VALUES (?,?)",this.TableName,this.KeyName,this.ValueName), arg.getValue() );
		
	}
	
	@Test
	public void testRetrieve() throws SQLException {		
		
		//Arrange
		//############
		javax.sql.DataSource sds = mock(javax.sql.DataSource.class);
		java.sql.Connection conn = mock(java.sql.Connection.class);
		java.sql.PreparedStatement ps = mock(java.sql.PreparedStatement.class);
		java.sql.ResultSet rs = mock(java.sql.ResultSet.class);
		String testVal  = "testval";
		Blob b = mock(Blob.class);	
		
		when( sds.getConnection() ).thenReturn(conn);
		when( conn.prepareStatement(anyString()) ).thenReturn(ps);
		when( ps.executeQuery() ).thenReturn( rs );
		when( rs.next() ).thenReturn(true).thenReturn(false);
		when( b.getBytes(anyInt(), anyInt()) ).thenReturn(SerializationUtils.serialize(testVal));
		when( rs.getBlob(this.ValueName) ).thenReturn(b);
		target.setJdbcConnection( sds );		
		ArgumentCaptor<String> arg = ArgumentCaptor.forClass(String.class);
		Serializable result = "";
		//Act
		//############
		try {			
			result = target.retrieve("test");				
		} catch (ObjectStoreException e) {		
			e.printStackTrace();
			fail("ObjectStoreException");
		}
		
		//Assert
		//############		
		verify( sds ).getConnection();
		verify( conn ).prepareStatement( arg.capture() ); 
		verify( conn ).close();
		verify( ps ).executeQuery();
		verify( ps ).setNString( eq(1), anyString() );
		verify( ps ).close();

		assertEquals(testVal , (String) result );
		assertEquals( String.format("SELECT [%s], [%s] FROM [%s] WHERE [%s] = ?",this.KeyName,this.ValueName,this.TableName,this.KeyName), arg.getValue() );
		
	}
	
	@Test
	public void testRemove() throws SQLException {		
		
		//Arrange
		//############
		javax.sql.DataSource sds = mock(javax.sql.DataSource.class);
		java.sql.Connection conn = mock(java.sql.Connection.class);
		java.sql.PreparedStatement ps = mock(java.sql.PreparedStatement.class);
		java.sql.ResultSet rs = mock(java.sql.ResultSet.class);
		String testVal  = "testval";
		Blob b = mock(Blob.class);	
				
		when( sds.getConnection() ).thenReturn(conn);
		when( conn.prepareStatement(anyString()) ).thenReturn(ps);
		when( ps.executeQuery() ).thenReturn( rs );		
		when( rs.next() ).thenReturn(true).thenReturn(false);
		when( b.getBytes(anyInt(), anyInt()) ).thenReturn(SerializationUtils.serialize(testVal));
		when( rs.getBlob(this.ValueName) ).thenReturn(b);
		target.setJdbcConnection( sds );		
		ArgumentCaptor<String> arg = ArgumentCaptor.forClass(String.class);
		
		//Act
		//############
		try {			
			target.remove("test");				
		} catch (ObjectStoreException e) {		
			e.printStackTrace();
			fail("ObjectStoreException");
		}
		
		//Assert
		//############		
		verify( sds, atLeast(2) ).getConnection();
		verify( conn, atLeast(2) ).prepareStatement( arg.capture() );
		verify( conn, atLeast(2) ).close();
		verify( ps, atLeast(2) ).executeQuery();
		verify( ps, atLeast(2) ).setNString( eq(1), anyString() );
		verify( ps, atLeast(2)).close();
	        
		assertEquals( String.format("DELETE [%s] WHERE [%s] = ?",this.TableName, this.KeyName), arg.getValue() );
		
	}
	
	@Test
	public void testExpire() throws SQLException {		
		
		//Arrange
		//############
		javax.sql.DataSource sds = mock(javax.sql.DataSource.class);
		java.sql.Connection conn = mock(java.sql.Connection.class);
		java.sql.PreparedStatement ps = mock(java.sql.PreparedStatement.class);
		java.sql.ResultSet rs = mock(java.sql.ResultSet.class);
						
		when( sds.getConnection() ).thenReturn(conn);
		when( conn.prepareStatement(anyString()) ).thenReturn(ps);
		when( ps.executeQuery() ).thenReturn( rs );		
		
		target.setJdbcConnection( sds );		
		ArgumentCaptor<String> arg = ArgumentCaptor.forClass(String.class);
		
		//Act
		//############
		try {			
			target.expire(10, -1);				
		} catch (ObjectStoreException e) {		
			e.printStackTrace();
			fail("ObjectStoreException");
		}
		
		//Assert
		//############		
		verify( sds ).getConnection();
		verify( conn ).prepareStatement( arg.capture() );
		verify( conn ).close();
		verify( ps ).executeUpdate();
		verify( ps ).setTimestamp( eq(1), any(Timestamp.class) );	
		verify( ps ).close();
	        
		assertEquals( String.format("DELETE [%s] WHERE [%s] < ?",this.TableName,this.DateTouchedName), arg.getValue() );		
	}
}
