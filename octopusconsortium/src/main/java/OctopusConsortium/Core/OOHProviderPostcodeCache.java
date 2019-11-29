package OctopusConsortium.Core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.List;

import OctopusConsortium.Core.Transformers.ITK.OOHPostcodeMapper;
import OctopusConsortium.Models.PostCodes.OOHPreferredProvider;
import OctopusConsortium.Models.PostCodes.Records.Row;

public class OOHProviderPostcodeCache {
	
	public OOHProviderPostcodeCache()
	{		
	}
	
	public OOHPreferredProvider searchForService(String provider, String postcode) {

		postcode = postcode.replaceAll("\\s+", "").toLowerCase();
		
		Row row = getPostcodeDetails(postcode);
		
		if (row == null)
			return null;

		OOHPreferredProvider result = new OOHPreferredProvider();
		result.setServiceId(row.getServiceId());
		result.setOdsCode(row.getOdsCode());
		result.setName(row.getName());
		result.setAddress(row.getAddress());
		result.setServicePostcode(row.getServicePostcode());
		result.setIsDoSAllowed(row.getPathwaysDoSAllowed());
		return result;
	}
	
	private Row getPostcodeDetails(String postcode){
		
		OOHPostcodeMapper<Row> resultSetMapper = new OOHPostcodeMapper<Row>();
		ResultSet resultSet = null;
		
		Properties properties = new Properties();
		try {
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties"));
			String url = properties.getProperty("application.db.url");
			String username = properties.getProperty("application.db.username");
			String password = properties.getProperty("application.db.password");
					    
			Connection connection = DriverManager.getConnection(url, username, password);
			
			PreparedStatement statement = connection.prepareStatement("EXEC ProviderForPostCode N'" + postcode + "'");
			resultSet = statement.executeQuery();
			
			List<Row> rows = resultSetMapper.mapResultSetToObject(resultSet, Row.class);
			
			connection.close();
			
			if(rows != null){
				return rows.get(0);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return null;
}

	
	
}
