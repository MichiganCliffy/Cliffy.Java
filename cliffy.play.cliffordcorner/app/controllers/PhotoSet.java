package controllers;

import java.util.*;

import play.mvc.*;
import views.html.*;
import cliffy.common.*;
import cliffy.data.*;
import models.*;

public class PhotoSet extends Controller {
    public static Result index() {
    	String setId = "Pool";
    	ArrayList<String> tags = new ArrayList<String>();
    	
    	PhotographAlbum photos = getAlbum(setId, tags);
    	CliffordCornerNav nav = getNav();
		
        return ok(photoset.render(photos, nav));
    }

    public static Result photoset(String setId) {
    	ArrayList<String> tags = new ArrayList<String>();
    	PhotographAlbum photos = getAlbum(setId, tags);
    	CliffordCornerNav nav = getNav();
    	
        return ok(photoset.render(photos, nav));
    }
    
    public static Result photosetWithTag(String setId, String tag) {
    	ArrayList<String> tags = new ArrayList<String>();
    	tags.add(tag);
    	PhotographAlbum photos = getAlbum(setId, tags);
    	CliffordCornerNav nav = getNav();
    	
        return ok(photoset.render(photos, nav));
    }
    
    public static Result photo(String setId, String secret, String id) {
    	return TODO;
    }
    
    public static Result video(String setId, String secret, String id) {
    	return TODO;
    }
    
    private static CliffordCornerNav getNav() {
    	return new CliffordCornerNav();
    }
    
    private static PhotographAlbum getAlbum(String setId, List<String> tags) {
    	IPhotographRepository repo = Repositories.getPhotoRepository();
    	return repo.getAlbum(tags, setId);
    }
}