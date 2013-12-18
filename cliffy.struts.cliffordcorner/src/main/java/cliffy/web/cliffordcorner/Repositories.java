package cliffy.web.cliffordcorner;

import cliffy.data.*;
import cliffy.data.mongo.*;
import cliffy.data.blogger.*;

public final class Repositories {
	public static ICacheRepository getCacheRepository() {
		return null;
	}
	
	public static IPhotographRepository getPhotographRepository() {
		return new MongoPhotographRepository(
				new MongoPropertiesWithDefaults(new MongoPropertiesFromFile())
				);
	}

	public static IBlogRepository getBlogRepository() {
		IBloggerProperties properties = new BloggerPropertiesFromFile();
		if (properties.getBlogUrl().endsWith("blog.xml")) {
			return new LocalBlogRepository(properties);
		} else {
			return new BloggerBlogRepository(Repositories.getCacheRepository(), properties);
		}
	}
}