package models;

import cliffy.data.*;
import cliffy.data.blogger.*;
import cliffy.data.mongo.*;

public final class Repositories {
	public static ICacheRepository getCacheRepository() {
		return null;
	}
	
	public static IBlogRepository getBlogRepository() {
		IBloggerProperties properties = new BloggerPropertiesForPlay();
		//return new BloggerBlogRepository(getCacheRepository(), properties);
		return new LocalBlogRepository(properties);
	}
	
	public static IPhotographRepository getPhotoRepository() {
		IMongoProperties properties = new MongoPropertiesForPlay();
		return new MongoPhotographRepository(properties);
	}
}