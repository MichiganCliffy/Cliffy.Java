package cliffy.data.mongo;

import java.util.*;

import cliffy.common.*;

import com.mongodb.*;

public class MongoPhotographRepositoryTest extends MongoBaseTest {
	public void testGetAlbums() {
		int expectedCount = 0;
		
		DB db = getDatabase();
    	DBCollection table = db.getCollection("sets");
    	DBCursor cursor = table.find();
    	while(cursor.hasNext()) {
    		cursor.next();
    		expectedCount++;
    	}

		IMongoProperties props = new MongoPropertiesWithDefaults(new MongoPropertiesFromFile());
    	MongoPhotographRepository repo = new MongoPhotographRepository(props);
    	List<PhotographAlbum> albums = repo.getAlbums();

    	assertNotNull(albums);
    	assertEquals(expectedCount, albums.size());
	}
}