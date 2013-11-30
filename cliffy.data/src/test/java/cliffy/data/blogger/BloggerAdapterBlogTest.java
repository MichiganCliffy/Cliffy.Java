package cliffy.data.blogger;

import java.util.*;

import org.junit.Assert;

import com.sun.syndication.feed.synd.SyndEntry;

import cliffy.common.*;

public class BloggerAdapterBlogTest extends BloggerBaseTest {
	@SuppressWarnings("rawtypes")
	public void testMap() {
		Assert.assertNotNull(data);
		
		List list = data.getEntries();
		
		ArrayList<SyndEntry> posts = new ArrayList<SyndEntry>();
		for (Iterator i = list.iterator(); i.hasNext();) {
		    SyndEntry entry = (SyndEntry) i.next();
		    posts.add(entry);
		}
		
		BloggerAdapterBlog adapter = new BloggerAdapterBlog(posts);
		Blog blog = adapter.getBlog();
		
		Assert.assertNotNull(blog);
		Assert.assertNotSame(0, blog.size());

		List<String> tags = blog.getTags();
		Assert.assertNotNull(tags);
		Assert.assertNotSame(0, tags);
		Assert.assertTrue(tags.contains("Tommy"));
		
		List<Calendar> archives = blog.getArchives();
		Assert.assertNotNull(archives);
		Assert.assertNotSame(0, archives);
		
		Assert.assertEquals("2012 Year in Review", blog.get(0).getTitle());
	}
}