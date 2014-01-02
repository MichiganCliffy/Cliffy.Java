package models;

import cliffy.data.*;
import cliffy.data.blogger.*;
import cliffy.data.mongo.*;
import cliffy.web.cliffordcorner.*;

public final class Repositories {
	public static ICacheRepository getCacheRepository() {
		return null;
	}
	
	public static IBlogRepository getBlogRepository() {
		IBloggerProperties config = new BloggerProperties(ConfigFileLoader.getBloggerConfigFile());
		//return new BloggerBlogRepository(getCacheRepository(), config);
		return new LocalBlogRepository(config);
	}
	
	public static IPhotographRepository getPhotoRepository() {
		IMongoProperties properties = new MongoProperties(ConfigFileLoader.getMongoConfigFile());
		return new MongoPhotographRepository(properties);
	}
	
	public static CliffordCornerNav getNav() {
		CliffordCornerConfigProperties config = new CliffordCornerConfigProperties(ConfigFileLoader.getCliffordCornerConfigFile());
		return new CliffordCornerNav(config);
	}
}