package models;

import cliffy.data.mongo.*;

import java.util.Properties;
import java.io.IOException;
import java.net.URL;

import play.api.Play;

public class MongoPropertiesForPlay implements IMongoProperties {
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
	
	public MongoPropertiesForPlay() {
		properties = new Properties();
		loadProperties();
	}
	
	private void loadProperties() {
		ClassLoader loader = Play.current().classloader();
		URL propertyFileURL = loader.getResource("mongo.properties");
		loadPropertiesFile(propertyFileURL);
	}
	
	private void loadPropertiesFile(URL propertyFileURL) {
		if (propertyFileURL != null) {
	    	try {
	    		properties.load(propertyFileURL.openStream());
	    	} catch (IOException ex) {
	    		ex.printStackTrace();
	        }
		}
	}
}