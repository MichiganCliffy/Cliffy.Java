package controllers;

import java.util.*;
import play.mvc.*;
import views.html.*;
import cliffy.common.*;
import cliffy.data.*;
import cliffy.web.cliffordcorner.*;
import models.*;

public class Application extends Controller {

    public static Result index() {
		IBlogRepository repo = Repositories.getBlogRepository();
		String[] tags = {};
		Blog posts = repo.getPosts(tags);
		
		CliffordCornerNav nav = Repositories.getNav();
        return ok(index.render(posts, nav));
    }
}