package cliffy.data.mongo;

import java.net.URL;
import java.util.*;

import cliffy.common.*;

import com.mongodb.*;

public class MongoPhotographRepositoryTest extends MongoBaseTest {
	public void testPhotographs() {
		DB db = getDatabase();
    	DBCollection table = db.getCollection("photographs");
    	BasicDBObject query = new BasicDBObject("SetId", "Pool");
    	DBCursor cursor = table.find(query);

    	ArrayList<Photograph> photosFromDB = new ArrayList<Photograph>();
    	while(cursor.hasNext()) {
    		MongoAdapterPhotograph adapter = new MongoAdapterPhotograph(cursor.next());
    		Photograph photoFromDB = adapter.getPhotograph();
    		photosFromDB.add(photoFromDB);
    	}
    	
    	Collections.sort(photosFromDB, new PhotographSorter());
    	assertNotSame(0, photosFromDB.size());
    	
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		URL propertyFile = loader.getResource("mongo.properties");
    	
		IMongoProperties props = new MongoProperties(propertyFile);
    	MongoPhotographRepository repo = new MongoPhotographRepository(props);
    	ArrayList<String> tags = new ArrayList<String>();
    	PhotographAlbum album = repo.getPhotographs(tags, 75, 0);
    	List<Photograph> photosFromRepo = album.getPhotographs();

    	//assertSame(photosFromDB.size(), photosFromRepo.size());
    	assertTrue(photosFromDB.get(0).getTitle().equals(photosFromRepo.get(0).getTitle()));
    	assertTrue(photosFromDB.get(23).getTitle().equals(photosFromRepo.get(23).getTitle()));
	}
	
	public void testGetAlbums() {
		int expectedCount = 0;
		
		DB db = getDatabase();
    	DBCollection table = db.getCollection("sets");
    	DBCursor cursor = table.find();
    	while(cursor.hasNext()) {
    		cursor.next();
    		expectedCount++;
    	}

		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		URL propertyFile = loader.getResource("mongo.properties");
    	IMongoProperties props = new MongoProperties(propertyFile);
		
    	MongoPhotographRepository repo = new MongoPhotographRepository(props);
    	List<PhotographAlbum> albums = repo.getAlbums();

    	assertNotNull(albums);
    	assertEquals(expectedCount, albums.size());
	}
}