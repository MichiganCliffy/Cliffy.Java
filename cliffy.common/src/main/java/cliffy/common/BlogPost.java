package cliffy.common;

import java.util.*;

public class BlogPost {
    private String id;
    private Date datePublished;
    private Date dateUpdated;
    private String title;
    private String description;
    private String uriSource;
    private String author;
    private List<String> tags;
    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDatePublished() {
		return datePublished;
	}

	public void setDatePublished(Date datePublished) {
		this.datePublished = datePublished;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUriSource() {
		return uriSource;
	}

	public void setUriSource(String uriSource) {
		this.uriSource = uriSource;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public BlogPost() {
    	this.tags = new ArrayList<String>();
    }
	
	public boolean addTag(String tag) {
		if (!this.tags.contains(tag)) {
			return this.tags.add(tag);
		} else {
			return false;
		}
	}
}