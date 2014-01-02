package cliffy.data.mongo;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class MongoProperties implements IMongoProperties {
    protected Properties properties = null;

	@Override
	public String getServer() {
		return this.properties.getProperty("server");
	}

	@Override
	public String getUsername() {
		return this.properties.getProperty("username");
	}

	@Override
	public String getPassword() {
		return this.properties.getProperty("password");
	}

	@Override
	public String getDatabase() {
		String output = this.properties.getProperty("database");
		if (output == null || output.length() == 0) {
			output = "cliffy";
		}
		return output;
	}
	
	public MongoProperties(URL propertyFile) {
		loadProperties(propertyFile);
	}
	
	private void loadProperties(URL propertyFile) {
		properties = new Properties();
		if (propertyFile != null) {
	    	try {
	    		properties.load(propertyFile.openStream());
	    	} catch (IOException ex) {
	    		ex.printStackTrace();
	        }
		}
	}
}