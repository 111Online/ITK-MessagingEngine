package OctopusConsortium.Core;

import java.sql.SQLException;
import java.util.Iterator;

import javax.sql.DataSource;

import org.codehaus.jackson.JsonNode;
import org.mule.api.transformer.TransformerException;
import org.mule.module.json.JsonData;
import org.mule.transformer.AbstractTransformer;

public class BankHolidayCache extends AbstractTransformer {

	public void setJdbcConnection(DataSource jdbcConnection) {
		this._jdbcConnection = jdbcConnection;
	}
	
	public void setSqlBatchExecutor(SqlBatchExecutor batchExecutor)	{
		this._sqlBatchExecutor = batchExecutor;
	}

	@Override
	protected Object doTransform(Object src, String enc)
			throws TransformerException {

		setJsonData(src);
		
		JsonNode[] divisions = _json.toArray();
		
		try {
			
			ensureSqlBatchExecutor();
			
			_sqlBatchExecutor.open();
			
			_sqlBatchExecutor.execute("DELETE FROM [BankHolidays]");
			
			for (int d = 0; d < divisions.length; ++d) {
				
				JsonNode events = divisions[d].get("events");
				Iterator<JsonNode> it = events.getElements();
				
				while (it.hasNext()) {
					
					JsonNode node = it.next();
	
					_sqlBatchExecutor.setParameter(1, divisions[d].get("division").asText());
					_sqlBatchExecutor.setParameter(2, node.get("title").asText());
					_sqlBatchExecutor.setParameter(3, node.get("date").asText());
					_sqlBatchExecutor.setParameter(4, node.get("notes").asText());
					_sqlBatchExecutor.setParameter(5, node.get("bunting").asText());

					//un-comment to test the transaction
					//if (d == 0) _sqlBatchExecutor.setParameter(3, "baddate");
					
					_sqlBatchExecutor.update();
				}
			}
		
		} catch (SQLException e) {
			throw new TransformerException(this, e);
		}
		finally {
			
			try {
				_sqlBatchExecutor.close();
			}
			catch (Exception ex) {
				throw new TransformerException(this, ex);
			}
		}
		
		return null;
	}

	private void ensureSqlBatchExecutor() {
		if (this._sqlBatchExecutor == null) {
			this._sqlBatchExecutor = new SqlBatchExecutor(_jdbcConnection, _statement);
			this._sqlBatchExecutor.setIsTransaction(true);
		}
	}

	private JsonData _json;
	private void setJsonData(Object src) throws TransformerException {
		if (!(src instanceof JsonData))
			throw new TransformerException(this, new Exception("src needs to be of type org.mule.module.json.JsonData"));
		
		_json = (JsonData)src;
	}
	
	private DataSource _jdbcConnection;
	private SqlBatchExecutor _sqlBatchExecutor;
	private static final String _statement = "INSERT INTO BankHolidays ([Division], [Title], [Date], [Notes], [Bunting]) values (?, ?, ?, ?, ?)";

}
