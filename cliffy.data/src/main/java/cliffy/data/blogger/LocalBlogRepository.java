package cliffy.data.blogger;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.IOException;
import java.net.*;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

import cliffy.common.*;
import cliffy.data.IBlogRepository;

public class LocalBlogRepository implements IBlogRepository {
	private IBloggerProperties properties;
	
	public LocalBlogRepository(IBloggerProperties properties) {
		this.properties = properties;
	}

	private List<SyndEntry> getBlogPostsFromSource() {
		try {
			URL feedUrl = new URL(this.properties.getBlogUrl());
			return this.getBlogPostsFromSource(feedUrl);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	private List<SyndEntry> getBlogPostsFromSource(URL url) {
		ArrayList<SyndEntry> output = new ArrayList<SyndEntry>();
		
		XmlReader reader = null;
		try {
			reader = new XmlReader(url);
			SyndFeed rss = new SyndFeedInput().build(reader);

		     for (Iterator i = rss.getEntries().iterator(); i.hasNext();) {
		         SyndEntry entry = (SyndEntry) i.next();
		         output.add(entry);
		     }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FeedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
            if (reader != null) {
                try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
		}
		
		return output;
	}
	
	@Override
	public Blog getPosts(String[] tags) {
		BloggerAdapterBlog adapter = new BloggerAdapterBlog(this.getBlogPostsFromSource());
		Blog output = adapter.getBlog();

		return output;
	}

	@Override
	public BlogPost getPost(String id) {
		return null;
	}

	@Override
	public String getUriSource(String tag) {
		return this.properties.getBlogUrl();
	}

	@Override
	public String getUriSource(Date archive) {
        if (archive != null)
        {
        	Format formatter = new SimpleDateFormat("yyyy_MM_01_archive.html");
        	return this.properties.getBlogUrl() + formatter.format(archive);
        }
        else
        {
            return this.properties.getBlogUrl();
        }
	}
}