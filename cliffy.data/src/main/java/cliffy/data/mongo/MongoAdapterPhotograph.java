package cliffy.data.mongo;

import cliffy.common.*;

import com.mongodb.*;

import java.util.*;

public class MongoAdapterPhotograph {
	private Photograph photograph;
	
	public Photograph getPhotograph() {
		return photograph;
	}
	
	public MongoAdapterPhotograph(DBObject source) {
		photograph = new Photograph();
		mapPhotograph(source);
	}
	
	private void mapPhotograph(DBObject source) {
		photograph.setDateSaved((Date)source.get("DateSaved"));
		photograph.setDescription((String)source.get("Description"));
		photograph.setId(source.get("_id"));
		photograph.setMedia((String)source.get("Media"));
		photograph.setPhotographer((String)source.get("Photographer"));
		photograph.setPhotoId((String)source.get("PhotoId"));
		photograph.setSecret((String)source.get("Secret"));
		photograph.setSetId((String)source.get("SetId"));
		photograph.setTitle((String)source.get("Title"));
		photograph.setUriSource((String)source.get("UriSource"));
		
		mapTags((BasicDBList)source.get("Tags"));
		mapUriSizes((BasicDBList)source.get("UriSizes"));
	}
	
	private void mapUriSizes(BasicDBList source) {
		ArrayList<PhotographUri> sizes = new ArrayList<PhotographUri>();
		for (int i = 0; i < source.size(); i++) {
			BasicDBObject size = (BasicDBObject)source.get(i);
			PhotographUri uri = new PhotographUri();
			uri.setUri(size.getString("Uri"));
			if (uri.getUri() != null && uri.getUri().length() > 0) {
				uri.setSize(size.getInt("Size"));
				sizes.add(uri);
			}
		}
		photograph.setUriSizes(sizes);
	}
	
	private void mapTags(BasicDBList source) {
		ArrayList<String> tags = new ArrayList<String>();
		for(int i = 0; i < source.size(); i++) {
			String tag = (String)source.get(i);
			tags.add(tag);
		}
		photograph.setTags(tags);
	}
}