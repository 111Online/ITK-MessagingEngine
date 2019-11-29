package OctopusConsortium.Core;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mule.api.MuleContext;
import org.mule.api.context.MuleContextAware;
import org.mule.api.store.ExpirableObjectStore;
import org.mule.api.store.ObjectStoreException;
import org.mule.util.SerializationUtils;


public class SqlObjectStore<T extends Serializable> implements ExpirableObjectStore<T>, MuleContextAware{

	private String tableName;
	private String keyName;
	private String valueName; //set default value
	private String dateTouchedName;

	private MuleContext context;


	public SqlObjectStore(){
		
	}
	
	public String getTableName() {
		return this.tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	public String getKeyName() {
		return keyName;
	}
	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public String getValueName() {
		return valueName;
	}
	public void setValueName(String valueName) {
		this.valueName = valueName;
	}

	public String getDateTouchedName() {
		return dateTouchedName;
	}
	public void setDateTouchedName(String dateTouchedName) {
		this.dateTouchedName = dateTouchedName;
	}

	
	private javax.sql.DataSource JdbcConnection;
	public void setJdbcConnection(javax.sql.DataSource value){
		JdbcConnection = value;
	}

	@Override
	public boolean contains(Serializable key) throws ObjectStoreException {
		Connection conn = null;
		boolean found = false;
		try {
			
			String strKey = getObjectIdFromKey(key);
			
			conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(String.format("SELECT [%s] FROM [%s] WHERE [%s] = ?",this.keyName,this.tableName,this.keyName));
			ps.setNString(1, strKey);
			ResultSet rs = ps.executeQuery();
						
			while (rs.next()) {
				found = true;				
			}
			
			rs.close();
		    ps.close(); 
			
		} catch (SQLException e) {			
			e.printStackTrace();
			throw new ObjectStoreException(e);
		}
		finally {
			try {
				if(conn!=null && !conn.isClosed())
					conn.close();
			} catch (SQLException e) {
				//do nothing
			}
        }
				
		return found;
	}

	@Override
	public void store(Serializable key, T value) throws ObjectStoreException {
		Connection conn = null;
		try {			 
			String strKey = getObjectIdFromKey(key);			 
			byte[] bytesOfValue = SerializationUtils.serialize(value);
			conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(String.format("INSERT INTO [%s] ([%s],[%s]) VALUES (?,?)",this.tableName,this.keyName,this.valueName));
	        ps.setNString(1, strKey);	        
	        ps.setBytes(2, bytesOfValue);
	        //ps.setString(2, strValue);
	        ps.executeUpdate();
	        ps.close();
        } catch (SQLException e) {		
			e.printStackTrace();
			throw new ObjectStoreException(e);
		} finally {
			try {
				if(conn!=null && !conn.isClosed())
					conn.close();
			} catch (SQLException e) {
				//do nothing
			}
        }
	}

	@SuppressWarnings("unchecked")
	@Override
	public T retrieve(Serializable key) throws ObjectStoreException {

		Connection conn = null;
		T found = null;
		try {
			
			String strKey = getObjectIdFromKey(key);			
			conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(String.format("SELECT [%s], [%s] FROM [%s] WHERE [%s] = ?",this.keyName,this.valueName,this.tableName,this.keyName));
			ps.setNString(1, strKey);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {				
				Blob blob1 = rs.getBlob(this.valueName);
				found = (T) SerializationUtils.deserialize(blob1.getBytes(1, (int)blob1.length()),context);
			}
			
			rs.close();
		    ps.close(); 
			
		} catch (SQLException e) {			
			e.printStackTrace();
			throw new ObjectStoreException(e);
		}
		finally {
			try {
				if(conn!=null && !conn.isClosed())
					conn.close();
			} catch (SQLException e) {
				//do nothing
			}
        }
		
		return found;
	}

	@Override
	public T remove(Serializable key) throws ObjectStoreException {
		T value = retrieve(key);
		
		if(value!=null){
			Connection conn = null;		
			try {				
				String strKey = getObjectIdFromKey(key);				
				conn = getConnection();
				PreparedStatement ps = conn.prepareStatement(String.format("DELETE [%s] WHERE [%s] = ?",this.tableName,this.keyName));
				ps.setNString(1, strKey);
				ResultSet rs = ps.executeQuery();								
				rs.close();
			    ps.close(); 
				
			} catch (SQLException e) {			
				e.printStackTrace();
				throw new ObjectStoreException(e);
			}
			finally {
				try {
					if(conn!=null && !conn.isClosed())
						conn.close();
				} catch (SQLException e) {
					//do nothing
				}
	        }
		}
		return value;
	}

	@Override
	public boolean isPersistent() {		
		return true;
	}

	@Override
	public void expire(int entryTTL, int maxEntries)
			throws ObjectStoreException {
				
		Connection conn = null;		
		try {
			
			long expireAt = System.currentTimeMillis() - entryTTL;
			java.sql.Timestamp sqldate = new java.sql.Timestamp(expireAt);			
			
			conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(String.format("DELETE [%s] WHERE [%s] < ?",this.tableName,this.dateTouchedName));
			ps.setTimestamp(1, sqldate);

			ps.executeUpdate();
		    ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ObjectStoreException(e);
		}
		finally {
			try {
				if(conn!=null && !conn.isClosed())
					conn.close();
			} catch (SQLException e) {
				//do nothing
			}
        }
	}
	
	@Override
	public void setMuleContext(MuleContext context) {		
		this.context = context;
	}
	
	private Connection getConnection() throws SQLException {

		if(this.JdbcConnection !=null){			
			return this.JdbcConnection.getConnection();		    
		}else{
			throw new NullPointerException("JdbcConnection");
		}	   
	}

	public String getObjectIdFromKey(Serializable key){
		
		MessageDigest md =null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {			
			e.printStackTrace();
		}	
		byte[] bytesOfMessage = SerializationUtils.serialize(key);
		byte[] thedigest = md.digest(bytesOfMessage);
		String strKey = new String(thedigest);		
		return strKey;
	}

	//@Override
	public void clear() throws ObjectStoreException {
		Connection conn = null;		
		try {						
			conn = getConnection();
			//I don't normally use a delete statement with no where clause....it's supposed to be like this, honest :o)
			PreparedStatement ps = conn.prepareStatement(String.format("DELETE FROM [%s]", this.tableName));
			ResultSet rs = ps.executeQuery();								
			rs.close();
		    ps.close();
			
		} catch (SQLException e) {			
			e.printStackTrace();
			throw new ObjectStoreException(e);
		}
		finally {
			try {
				if(conn!=null && !conn.isClosed())
					conn.close();
			} catch (SQLException e) {
				//do nothing
			}
        }
	}
}
