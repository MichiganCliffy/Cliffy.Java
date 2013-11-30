package cliffy.data.mongo;

import java.net.UnknownHostException;
import junit.framework.TestCase;

import com.mongodb.*;

public abstract class MongoBaseTest extends TestCase {
	protected MongoClient getClient() throws UnknownHostException
    {
    	return new MongoClient();
    }

	protected DB getDatabase()
    {
        MongoClient server;
		try {
			server = getClient();
	        return server.getDB("cliffy");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		return null;
    }
}