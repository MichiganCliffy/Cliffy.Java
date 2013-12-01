package cliffy.data.mongo;

import java.io.IOException;
import java.net.URL;

public class MongoPropertiesFromFile extends MongoPropertiesBase implements IMongoProperties {
	public MongoPropertiesFromFile() {
		loadProperties();
	}
	
	private void loadProperties() {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
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