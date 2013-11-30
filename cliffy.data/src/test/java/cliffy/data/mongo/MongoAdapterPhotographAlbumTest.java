package cliffy.data.mongo;

import cliffy.common.*;

import com.mongodb.*;

public class MongoAdapterPhotographAlbumTest extends MongoBaseTest {
	public void testGetSet() {
		DB db = getDatabase();

    	DBCollection table = db.getCollection("sets");
    	BasicDBObject query = new BasicDBObject("_id", "Pool");
    	DBObject found = table.findOne(query);

    	assertNotNull(found);
    	if (found != null) {
    		MongoAdapterPhotographAlbum adapter = new MongoAdapterPhotographAlbum(found);
    		PhotographAlbum set = adapter.getAlbum();
    		assertNotNull(set);
    		assertEquals(set.getTitle(), "Shared Group Pool");
    		assertEquals(set.getDescription(), "Shared Group Pool");
    		assertEquals(set.getId(), "Pool");
    	}
	}
}