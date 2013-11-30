package cliffy.data.blogger;

import cliffy.common.*;
import java.util.*;
import com.sun.syndication.feed.synd.*;

public class BloggerAdapterBlog {
	private Blog blog;
	
	public Blog getBlog() {
		return this.blog;
	}
	
	public BloggerAdapterBlog(List<SyndEntry> posts) {
		this.blog = new Blog();
		this.mapPosts(posts);
	}
	
	private void mapPosts(List<SyndEntry> posts) {
		for(SyndEntry post : posts) {
			BloggerAdapterBlogPost adapter = new BloggerAdapterBlogPost(post);
			this.blog.add(adapter.getPost());
		}
	}
}