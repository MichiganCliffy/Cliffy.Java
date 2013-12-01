package controllers;

import java.util.ArrayList;

import play.mvc.*;
import views.html.*;
import cliffy.common.*;
import cliffy.data.*;
import models.*;

public class Application extends Controller {

    public static Result index() {
		IBlogRepository repo = Repositories.getBlogRepository();
		String[] tags = {};
		Blog posts = repo.getPosts(tags);
		
        return ok(index.render(posts));
    }

    public static Result album() {
    	IPhotographRepository repo = Repositories.getPhotoRepository();
    	ArrayList<String> tags = new ArrayList<String>();
    	String setId = "Pool";
    	PhotographAlbum photos = repo.getAlbum(tags, setId);
    	
    	return ok(album.render(photos));
    }
}