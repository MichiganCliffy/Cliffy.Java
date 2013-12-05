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
    	PhotographAlbum photos = getAlbum("Pool", tags);
    	CliffordCornerNav nav = getNav();
    	
    	return ok(photogroup.render(photos, nav));
    }
    
    private static CliffordCornerNav getNav() {
    	return new CliffordCornerNav();
    }
    
    private static PhotographAlbum getAlbum(String setId, List<String> tags) {
    	IPhotographRepository repo = Repositories.getPhotoRepository();
    	return repo.getAlbum(tags, setId);
    }
}