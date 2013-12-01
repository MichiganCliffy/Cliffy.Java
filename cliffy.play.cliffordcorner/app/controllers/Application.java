package controllers;

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

}
