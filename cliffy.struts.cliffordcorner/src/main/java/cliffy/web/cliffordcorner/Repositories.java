package cliffy.web.cliffordcorner;

import cliffy.data.*;
import cliffy.data.mongo.*;
import cliffy.data.blogger.*;

import java.net.URL;

public final class Repositories {
	public static ICacheRepository getCacheRepository() {
		return null;
	}
	
	public static IPhotographRepository getPhotographRepository() {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		URL propertyFile = loader.getResource("mongo.properties");
		MongoProperties config = new MongoProperties(propertyFile);
		return new MongoPhotographRepository(config);
	}

	public static IBlogRepository getBlogRepository() {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		URL propertyFile = loader.getResource("blogger.properties");
		IBloggerProperties properties = new BloggerProperties(propertyFile);
		
		if (properties.getBlogUrl().endsWith("blog.xml")) {
			return new LocalBlogRepository(properties);
		} else {
			return new BloggerBlogRepository(Repositories.getCacheRepository(), properties);
		}
	}
}