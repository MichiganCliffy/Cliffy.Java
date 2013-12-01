package cliffy.data.mongo;

import java.util.Properties;

public abstract class MongoPropertiesBase implements IMongoProperties {
    protected Properties properties = null;

	@Override
	public String getServer() {
		return this.properties.getProperty("server");
	}

	@Override
	public String getUsername() {
		return this.properties.getProperty("username");
	}

	@Override
	public String getPassword() {
		return this.properties.getProperty("password");
	}

	@Override
	public String getDatabase() {
		return this.properties.getProperty("database");
	}
	
	public MongoPropertiesBase() {
		properties = new Properties();
	}
}