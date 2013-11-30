package cliffy.common;

import java.util.*;

public class Blog extends ArrayList<BlogPost> {
	private static final long serialVersionUID = 1L;

    private List<BlogTag> tags;
    private List<Calendar> archives;

    public List<String> getTags()
    {
    	Collections.sort(this.tags, new BlogTagSorter());
    	ArrayList<String> output = new ArrayList<String>();
    	for(BlogTag tag : this.tags) {
    		output.add(tag.getTag());
    	}
    	
    	return output;
    }

    public List<Calendar> getArchives()
    {
    	Collections.sort(this.archives, new BlogArchiveSorter());
    	return this.archives;
    }
    
    public Blog() {
    	this.tags = new ArrayList<BlogTag>();
    	this.archives = new ArrayList<Calendar>();
    }

    public boolean add(BlogPost post)
    {
        this.addTags(post);
        this.addArchive(post);
        return super.add(post);
    }

    public boolean addAll(List<BlogPost> posts)
    {
        for (BlogPost post : posts)
        {
        	this.add(post);
        }

    	return true;
    }

    private void addArchive(BlogPost post)
    {
    	Date publishedOn = post.getDatePublished();
        if (publishedOn != null)
        {
            Calendar archive = DateTimeUtil.toFirstOfTheMonth(publishedOn);
        	if (!BlogList.exists(archives, archive)) {
        		this.archives.add(archive);
        	}
        }
    }

    private void addTags(BlogPost post)
    {
    	List<String> postTags = post.getTags();
        if (postTags != null)
        {
            for (String tag : postTags)
            {
                BlogTag blogTag = BlogList.firstOrDefault(this.tags, tag);
                if (blogTag != null)
                {
                	blogTag.setCount(blogTag.getCount() + 1);
                }
                else
                {
                    blogTag = new BlogTag(tag);
                    this.tags.add(blogTag);
                }
            }
        }
    }
}