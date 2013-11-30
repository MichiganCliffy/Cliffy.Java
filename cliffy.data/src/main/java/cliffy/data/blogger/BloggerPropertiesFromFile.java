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
	
	private void loadProperties() {
		properties = new Properties();
		
		URL propertyFileURL = Thread.currentThread().getContextClassLoader().getResource("blogger.properties");

		if (propertyFileURL != null) {
	    	try {
	    		properties.load(propertyFileURL.openStream());
	    	} catch (IOException ex) {
	    		ex.printStackTrace();
	        }
		}
	}
}