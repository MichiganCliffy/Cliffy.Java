package cliffy.data.mongo;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class MongoPropertiesFromFile implements IMongoProperties {
    private Properties properties = null;

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
		return this.properties.getProperty("database");
	}
	
	public MongoPropertiesFromFile() {
		loadProperties();
	}
	
	private void loadProperties() {
		properties = new Properties();
		
		//URL propertyFileURL = getClass().getClassLoader().getResource("mongoConfig.properties");
		URL propertyFileURL = Thread.currentThread().getContextClassLoader().getResource("mongo.properties");

		if (propertyFileURL != null) {
	    	try {
	    		properties.load(propertyFileURL.openStream());
	    	} catch (IOException ex) {
	    		ex.printStackTrace();
	        }
		}
	}
}