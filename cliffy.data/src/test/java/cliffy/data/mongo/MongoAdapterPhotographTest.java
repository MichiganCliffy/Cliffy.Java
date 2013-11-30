package cliffy.data.mongo;

import cliffy.common.*;

import com.mongodb.*;

public class MongoAdapterPhotographTest extends MongoBaseTest {
	public void testMap() {
		DB db = getDatabase();

    	DBCollection table = db.getCollection("photographs");
    	BasicDBObject query = new BasicDBObject("PhotoId", "9497519752");
    	DBObject found = table.findOne(query);

    	assertNotNull(found);
    	if (found != null) {
    		MongoAdapterPhotograph adapter = new MongoAdapterPhotograph(found);
    		Photograph photo = adapter.getPhotograph();
    		assertNotNull(photo);
    		assertEquals(photo.getTitle(), "Pump It Up Slide Time!");
    		assertEquals(photo.getSecret(), "64de9c281d");
    		assertNotNull(photo.getTags());
    		assertEquals(3, photo.getTags().size());
    		assertNotNull(photo.getUriSizes());
    		assertEquals(4, photo.getUriSizes().size());
    	}
	}
}
