package controllers;

import java.util.*;

import play.mvc.*;
import views.html.*;
import cliffy.common.*;
import cliffy.data.*;
import models.*;

public class PhotoGroup extends Controller {

    public static Result index() {
    	ArrayList<String> tags = new ArrayList<String>();
    	PhotographAlbum photos = getAlbum(tags, 0);
    	CliffordCornerNav nav = getNav();
    	
    	return ok(photogroup.render(photos, nav));
    }

    public static Result filtered(String tag, int page) {
    	ArrayList<String> tags = new ArrayList<String>();
    	if (tag != null && tag.length() > 0) {
    		tags.add(tag);
    	}
    	
    	PhotographAlbum photos = getAlbum(tags, page);
    	CliffordCornerNav nav = getNav();
    	
    	return ok(photogroup.render(photos, nav));
    }
    
    public static Result photo(String secret, String id) {
    	Photograph photo = getPhotograph(secret, id);
		CliffordCornerNav nav = getNav();
		return ok(photogroupphoto.render(photo, nav));
    }
    
    public static Result video(String secret, String id) {
    	Photograph photo = getPhotograph(secret, id);
		CliffordCornerNav nav = getNav();
		return ok(photogroupvideo.render(photo, nav));
    }
    
    private static CliffordCornerNav getNav() {
    	return new CliffordCornerNav();
    }
    
    private static PhotographAlbum getAlbum(List<String> tags, int page) {
    	IPhotographRepository repo = Repositories.getPhotoRepository();
    	return repo.getPhotographs(tags, 75, page);
    }

    private static Photograph getPhotograph(String secret, String id) {
        IPhotographRepository repo = Repositories.getPhotoRepository();
	String photoId = id + "/" + secret;
	return repo.getPhotograph(photoId);
    }
}
