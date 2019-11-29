package OctopusConsortium.Core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

public class SqlBatchExecutor implements java.lang.AutoCloseable {
	
	public static final int DEFAULT_BATCHSIZE = 1000;
	
	public boolean getIsTransaction() {
		return this._isTransaction;
	}
	public void setIsTransaction(boolean value) {
		this._isTransaction = value;
	}
	
	public SqlBatchExecutor(DataSource dataSource, String statement)
	{
		this(dataSource, statement, DEFAULT_BATCHSIZE);
	}
	
	public SqlBatchExecutor(DataSource dataSource, String statement, int batchSize)
	{
		//could check the statement here for parameter indices
		
		if (dataSource == null)
			throw new NullPointerException("dataSource");
		
		if (batchSize > 0) _batchSize = batchSize;
			
		_dataSource = dataSource;
		_statement = statement;
	}
	
	public void open() throws SQLException
	{
		if (_isOpen) return;
		
		_connection = this._dataSource.getConnection();
		_connection.setAutoCommit(!this._isTransaction);
		
		_ps = _connection.prepareStatement(_statement);
		
		_isOpen = true;
	}
	
	public void execute(String statement) throws SQLException {
		PreparedStatement ps = _connection.prepareStatement(statement);
		ps.execute();
		ps.close();
	}
	
	public void setParameter(int index, String value) throws SQLException
	{
		if (!_isOpen) return;
		_ps.setString(index, value);
	}
	
	public void update() throws SQLException
	{
		if (!_isOpen) return;
			
		_ps.addBatch();
		
	    if(++_processedSoFar % _batchSize == 0) {
	        _ps.executeBatch();
	    }
	}
	
	@Override
	public void close() throws SQLException
	{
		if (!_isOpen) return;
				
		_ps.executeBatch(); // insert remaining records

		if (!_connection.getAutoCommit())
			_connection.commit(); //commit transaction

		_ps.close();
		
		_connection.close();
		
		_isOpen = false;
	}

	private DataSource _dataSource = null;
	private String _statement = null;
	private PreparedStatement _ps = null;
	private Connection _connection = null;
	
	private int _processedSoFar = 0;
	private int _batchSize = DEFAULT_BATCHSIZE;
	
	private boolean _isOpen = false;
	private boolean _isTransaction;
}
