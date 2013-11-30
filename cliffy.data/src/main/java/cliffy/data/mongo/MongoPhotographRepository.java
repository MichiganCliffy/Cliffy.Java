package cliffy.data.mongo;

import cliffy.common.*;
import cliffy.data.*;

import com.mongodb.*;

import java.net.UnknownHostException;
import java.util.*;

public class MongoPhotographRepository implements IPhotographRepository {
    private static final String TABLE_PHOTOGRAPHS = "photographs";
    private static final String TABLE_SETS = "sets";
    private IMongoProperties properties = null;

    public MongoPhotographRepository(IMongoProperties properties) {
    	this.properties = properties;
    }
    
	@Override
    public List<PhotographAlbum> getAlbums() {
        ArrayList<PhotographAlbum> output = new ArrayList<PhotographAlbum>();

        DB db = getDatabase();
        if (db != null) {
        	DBCollection table = db.getCollection(TABLE_SETS);
        	DBCursor cursor = table.find();
        	
        	while(cursor.hasNext()) {
        		DBObject item = cursor.next();
        		
        		MongoAdapterPhotographAlbum adapter = new MongoAdapterPhotographAlbum(item);
        		PhotographAlbum album = adapter.getAlbum();
        		
        		if (album != null) {
        			output.add(album);
        		}
        	}
        }
        
        return output;
    }
    
	@Override
	public PhotographAlbum getAlbum(List<String> tags, String setId) {
        if (setId.length() == 0) {
            setId = "Pool";
        }

        PhotographAlbum output = null;

        DB db = getDatabase();
        if (db != null) {
        	MongoAdapterPhotographAlbum adapter = getAlbumInfo(db, setId);
        	if (adapter != null) {
        		List<Photograph> photographs = getAlbumPhotographs(db, tags, setId);
	            adapter.addPhotographs(photographs);
	            
	            output = adapter.getAlbum();
	        }
        }
        
        return output;
	}

	@Override
	public Photograph getPhotograph(String id) {
		Photograph output = null;
		
        // split the id into it's parts
        String[] parts = id.split("/");

        DB db = getDatabase();
        DBCollection table = db.getCollection(TABLE_PHOTOGRAPHS);
    	BasicDBObject query = new BasicDBObject("PhotoId", parts[0]).append("Secret", parts[1]);
    	DBObject found = table.findOne(query);
    	if (found != null) {
    		MongoAdapterPhotograph adapter = new MongoAdapterPhotograph(found);
    		output = adapter.getPhotograph();
    	}

        return output;
	}

	@Override
	public PhotographAlbum getPhotographs(List<String> tags, int count, int page) {
		PhotographAlbum output = null;
        
        DB db = getDatabase();
        if (db != null) {
        	MongoAdapterPhotographAlbum adapter = getAlbumInfo(db, "Pool");
        	if (adapter != null) {
	            List<Photograph> photographs = getAlbumPhotographs(db, tags, "Pool");
	            adapter.addPhotographs(photographs, count, page);
	            output = adapter.getAlbum();
	        }
        }
        
        return output;
	}

    private MongoClient getClient() throws UnknownHostException
    {
    	MongoClient output = null;
    	
    	String server = this.properties.getServer();
    	if (server != null && server.length() > 0) {
    		output = new MongoClient(server);
    	} else {
    		output = new MongoClient();
    	}

    	return output;
    }

    private DB getDatabase()
    {
    	DB output = null;
        MongoClient server;
		try {
			server = getClient();
	        output = server.getDB(properties.getDatabase());
	        
	        String username = this.properties.getUsername();
	        String password = this.properties.getPassword();
	        
	        if (username != null && username.length() > 0) {
	        	boolean authed = output.authenticate(username, password.toCharArray());
	        	if (!authed) {
	        		throw new Exception("not authenticated");
	        	}
	        }
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return output;
    }

    private MongoAdapterPhotographAlbum getAlbumInfo(DB db, String setId)
    {
    	MongoAdapterPhotographAlbum output = null;
    	
    	DBCollection table = db.getCollection(TABLE_SETS);
    	BasicDBObject query = new BasicDBObject("_id", setId);
    	DBObject found = table.findOne(query);
    	
    	if (found != null) {
			output = new MongoAdapterPhotographAlbum(found);
    	}
    	
    	return output;
    }

    private List<Photograph> getAlbumPhotographs(DB db, List<String> tags, String setId)
    {
    	ArrayList<Photograph> all = new ArrayList<Photograph>();
    	
    	DBCollection table = db.getCollection(TABLE_PHOTOGRAPHS);
    	BasicDBObject query = new BasicDBObject("SetId", setId);
    	DBCursor cursor = table.find(query);
    	while(cursor.hasNext()) {
    		DBObject item = cursor.next();
    		
    		MongoAdapterPhotograph adapter = new MongoAdapterPhotograph(item);
    		Photograph photograph = adapter.getPhotograph();
    		
    		if (photograph != null) {
    			all.add(photograph);
    		}
    	}
    	
    	List<Photograph> matched = PhotographList.find(all, tags);
    	
    	PhotographSorter sorter = new PhotographSorter();
    	Collections.sort(matched, sorter);
    	
    	return matched;
    }
}