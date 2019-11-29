package OctopusConsortium;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	
	public void load() throws IOException {
		load("config.properties");
	}
	
	public void load(String filePath) throws IOException {

	    InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath);
	    _prop.load(inputStream);

	}
	
	public String readString(String key) {
		return _prop.getProperty(key);
	}
	
	private Properties _prop = new Properties();
}
