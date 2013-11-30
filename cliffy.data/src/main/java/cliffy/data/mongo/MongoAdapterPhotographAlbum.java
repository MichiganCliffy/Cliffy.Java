package cliffy.data.mongo;

import java.util.List;

import cliffy.common.*;

import com.mongodb.*;

public class MongoAdapterPhotographAlbum {
	private String defaultPhotoId;
	private PhotographAlbum album;
	
	public PhotographAlbum getAlbum() {
		return album;
	}
	
	public MongoAdapterPhotographAlbum(DBObject source) {
		album = new PhotographAlbum();
		album.setId((String)source.get("_id"));
        album.setTotal((Long)source.get("Total"));
        album.setTitle((String)source.get("Title"));
        album.setDescription((String)source.get("Description"));
        defaultPhotoId = (String)source.get("DefaultPhotoId");
	}
	
	public void addPhotographs(List<Photograph> source) {
		for(Photograph item : source) {
			addPhotograph(item);
		}
	}
	
	public void addPhotographs(List<Photograph> source, int count, int page) {
		List<Photograph> list = PhotographList.page(source, count, page);
		addPhotographs(list);
		
		if (album.getDefaultPhotograph() == null) {
			album.setDefaultPhotograph(PhotographList.firstOrDefault(source, defaultPhotoId));
		}
	}
	
	public void addPhotograph(Photograph source) {
		if (source.getPhotoId().equals(defaultPhotoId)) {
			album.setDefaultPhotograph(source);
		}
		
		album.add(source);
	}
}