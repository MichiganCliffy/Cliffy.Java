package cliffy.data.mongo;

public class MongoPropertiesWithDefaults implements IMongoProperties {
	private IMongoProperties source;
	
	@Override
	public String getServer() {
		return source.getServer();
	}

	@Override
	public String getUsername() {
		return source.getUsername();
	}

	@Override
	public String getPassword() {
		return source.getPassword();
	}

	@Override
	public String getDatabase() {
		String output = source.getDatabase();
		if (output == null || output.length() == 0) {
			output = "cliffy";
		}
		return output;
	}

	public MongoPropertiesWithDefaults(IMongoProperties source) {
		this.source = source;
	}
}