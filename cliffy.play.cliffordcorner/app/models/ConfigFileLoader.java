package models;

import java.net.URL;

import play.api.Play;

public final class ConfigFileLoader {
	public static URL getCliffordCornerConfigFile() {
		ClassLoader loader = Play.current().classloader();
		return loader.getResource("cliffordcorner.properties");
	}
	
	public static URL getBloggerConfigFile() {
		ClassLoader loader = Play.current().classloader();
		return loader.getResource("blogger.properties");
	}
	
	public static URL getMongoConfigFile() {
		ClassLoader loader = Play.current().classloader();
		return loader.getResource("mongo.properties");
	}
}