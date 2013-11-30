package cliffy.data.blogger;

import java.util.*;

import org.junit.Assert;

import com.sun.syndication.feed.synd.SyndEntry;

import cliffy.common.*;

public class BloggerAdapterBlogPostTest extends BloggerBaseTest {
	@SuppressWarnings("rawtypes")
	public void testMap() {
		Assert.assertNotNull(data);
		
		List posts = data.getEntries();
		SyndEntry post = (SyndEntry)posts.get(0);
		
		BloggerAdapterBlogPost adapter = new BloggerAdapterBlogPost(post);
		BlogPost blogPost = adapter.getPost();
		
		Assert.assertNotNull(blogPost);
		Assert.assertNotNull(blogPost.getTitle());
		Assert.assertEquals("2012 Year in Review", blogPost.getTitle());
		Assert.assertTrue(blogPost.getDescription().startsWith("<p>Holy smokes, what a year!"));
		
		List<String> tags = blogPost.getTags();
		Assert.assertNotNull(tags);
		Assert.assertNotSame(0, tags.size());
		Assert.assertTrue(tags.contains("Family"));
		Assert.assertTrue(tags.contains("2012"));
	}
}