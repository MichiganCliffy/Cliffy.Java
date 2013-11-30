package cliffy.web.cliffordcorner.controllers;

import cliffy.common.*;

public class HomeController extends BaseController {
	private static final long serialVersionUID = 1L;
	
	private Blog posts;
	
	public Blog getPosts() {
		return posts;
	}

	public void setPosts(Blog posts) {
		this.posts = posts;
	}

    public String execute() throws Exception {
    	this.posts = this.blogRepo.getPosts(null);
        return SUCCESS;
    }
}