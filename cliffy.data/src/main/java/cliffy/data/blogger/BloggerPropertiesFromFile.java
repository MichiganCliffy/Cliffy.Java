package cliffy.data.blogger;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class BloggerPropertiesFromFile implements IBloggerProperties {
    private Properties properties = null;

	@Override
	public String getBlogUrl() {
		return this.properties.getProperty("blogUrl");
	}
	
	@Override
	public int getCacheDuration() {
		return Integer.parseInt(this.properties.getProperty("cacheDuration"));
	}
	
	public BloggerPropertiesFromFile() {
		loadProperties();
	}
	
	protected void loadProperties() {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		URL propertyFileURL = loader.getResource("blogger.properties");
		loadPropertiesFile(propertyFileURL);
	}
	
	protected void loadPropertiesFile(URL propertyFileURL) {
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