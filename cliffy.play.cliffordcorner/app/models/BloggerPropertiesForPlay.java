package models;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import play.api.Play;
import cliffy.data.blogger.IBloggerProperties;

public class BloggerPropertiesForPlay implements IBloggerProperties {
    private Properties properties = null;

	@Override
	public String getBlogUrl() {
		return this.properties.getProperty("blogUrl");
	}
	
	@Override
	public int getCacheDuration() {
		return Integer.parseInt(this.properties.getProperty("cacheDuration"));
	}
	
	public BloggerPropertiesForPlay() {
		loadProperties();
	}
	
	private void loadProperties() {
		ClassLoader loader = Play.current().classloader();
		URL propertyFileURL = loader.getResource("blogger.properties");
		loadPropertiesFile(propertyFileURL);
	}
	
	private void loadPropertiesFile(URL propertyFileURL) {
		properties = new Properties();
		if (propertyFileURL != null) {
	    	try {
	    		properties.load(propertyFileURL.openStream());
	    	} catch (IOException ex) {
	    		ex.printStackTrace();
	        }
		}
	}
}