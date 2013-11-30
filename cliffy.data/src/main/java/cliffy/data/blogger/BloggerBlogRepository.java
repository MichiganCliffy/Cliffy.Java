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
import cliffy.data.ICacheRepository;

public class BloggerBlogRepository implements IBlogRepository {
	private ICacheRepository cache;
	private IBloggerProperties properties;
    
	public ICacheRepository getCache() {
		return cache;
	}

	public void setCache(ICacheRepository cache) {
		this.cache = cache;
	}

	public IBloggerProperties getProperties() {
		return this.properties;
	}

	public void setProperties(IBloggerProperties properties) {
		this.properties = properties;
	}

	public BloggerBlogRepository(ICacheRepository cache, IBloggerProperties properties) {
		this.cache = cache;
		this.properties = properties;
	}

    private String getBlogPostsKey(String tag) {
        String output = "BloggerPosts";

        if (tag != null && tag.length() > 0)
        {
        	output += "|" + tag;
        }

        return output;
    }

    private Blog getBlogPostsFromCache(String tag)
    {
        Blog output = null;

        if (this.cache != null)
        {
            String key = getBlogPostsKey(tag);
            output = (Blog)this.cache.getFromCache(key);
        }

        return output;
    }
    
    private void putBlogPostsInCache(String tag, Blog posts) {
    	if (this.cache != null) {
    		String key = this.getBlogPostsKey(tag);
    		this.cache.putInCache(key, properties.getCacheDuration(), posts);
    	}
    }
	
	private List<SyndEntry> getBlogPostsFromSource(String tag) {
        String url = properties.getBlogUrl().concat("feeds/posts/default?alt=rss");

        if (tag != null && tag.length() > 0)
        {
        	url += "&category=" + tag;
        }
		
		try {
			URL feedUrl = new URL(url);
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
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (FeedException e) {
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
		Blog output = null;

		if (tags != null && tags.length > 0) {
			output = new Blog();
			
			for(String tag : tags) {
				Blog posts = this.getBlogPostsFromCache(tag);
				if (posts == null) {
					BloggerAdapterBlog adapter = new BloggerAdapterBlog(this.getBlogPostsFromSource(tag));
					posts = adapter.getBlog();
				}
				output.addAll(posts);
				this.putBlogPostsInCache(tag, posts);
			}
		} else {
			output = this.getBlogPostsFromCache("");
			if (output == null) {
				BloggerAdapterBlog adapter = new BloggerAdapterBlog(this.getBlogPostsFromSource(""));
				output = adapter.getBlog();
				this.putBlogPostsInCache("", output);
			}
		}

		return output;
	}

	@Override
	public BlogPost getPost(String id) {
		return null;
	}

	@Override
	public String getUriSource(String tag) {
        if (tag != null && tag.length() > 0)
        {
            return this.properties.getBlogUrl() + "search/label/" + tag;
        }
        else
        {
            return this.properties.getBlogUrl();
        }
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