package cliffy.data.blogger;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class BloggerProperties implements IBloggerProperties {
    private Properties properties = null;

	@Override
	public String getBlogUrl() {
		return this.properties.getProperty("blogUrl");
	}
	
	@Override
	public int getCacheDuration() {
		return Integer.parseInt(this.properties.getProperty("cacheDuration"));
	}
	
	public BloggerProperties(URL propertyFile) {
		loadProperties(propertyFile);
	}
	
//	protected void loadProperties() {
//		ClassLoader loader = Thread.currentThread().getContextClassLoader();
//		URL propertyFileURL = loader.getResource("blogger.properties");
//		loadPropertiesFile(propertyFileURL);
//	}
	
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