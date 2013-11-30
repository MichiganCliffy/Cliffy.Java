package cliffy.data.blogger;

import junit.framework.TestCase;

import java.net.URL;

import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

public abstract class BloggerBaseTest extends TestCase {
	protected SyndFeed data;
	
	public BloggerBaseTest() {
		try {
			readTestData();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void readTestData() throws Exception {
		URL file = getClass().getClassLoader().getResource("blog.xml");
		XmlReader reader = new XmlReader(file);
		data = new SyndFeedInput().build(reader);
	}
}