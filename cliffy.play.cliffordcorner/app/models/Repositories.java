package models;

import cliffy.data.*;
import cliffy.data.blogger.*;

public final class Repositories {
	public static ICacheRepository getCacheRepository() {
		return null;
	}
	
	public static IBlogRepository getBlogRepository() {
		IBloggerProperties properties = new BloggerPropertiesFromPlay();
		return new BloggerBlogRepository(getCacheRepository(), properties);
	}
}