package cliffy.data.blogger;

import cliffy.common.*;

import java.util.*;

import com.sun.syndication.feed.synd.*;

public class BloggerAdapterBlogPost {
	private BlogPost post;
	
	public BlogPost getPost() {
		return this.post;
	}
	
	public BloggerAdapterBlogPost(SyndEntry source) {
		post = new BlogPost();
		mapPost(source);
	}

	private void mapPost(SyndEntry source) {
		post.setAuthor(source.getAuthor());
		post.setDatePublished(source.getPublishedDate());
		post.setDateUpdated(source.getUpdatedDate());
		post.setDescription(source.getDescription().getValue());
		post.setId(source.getUri());
		post.setTitle(source.getTitle());
		post.setUriSource(source.getUri());
		
		this.mapPostTags(source.getCategories());
	}
	
	@SuppressWarnings("rawtypes")
	private void mapPostTags(List categories) {
		for(int i = 0; i < categories.size(); i++) {
			SyndCategory category = (SyndCategory)categories.get(i);
			String tag = category.getName();
			this.post.addTag(tag);
		}
	}
}