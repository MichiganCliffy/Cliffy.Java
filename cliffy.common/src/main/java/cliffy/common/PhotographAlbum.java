package cliffy.common;

import java.util.*;

public class PhotographAlbum {
	private String id;
	private String title;
	private String description;
	private Photograph defaultPhotograph;
	private long total;
    private List<PhotographAlbumTag> tags;
    private List<Photograph> photographs;
    
    public List<String> getTags() {
    	Collections.sort(this.tags, new PhotographAlbumTagSorter());
    	ArrayList<String> output = new ArrayList<String>();
    	for (PhotographAlbumTag tag : this.tags) {
    		output.add(tag.getTag().toLowerCase());
    	}
    	return output;
    }
    
    public List<Photograph> getPhotographs() {
    	Collections.sort(this.photographs, new PhotographSorter());
		return this.photographs;
	}
    
    public String getId() {
    	return this.id;
    }
    
    public void setId(String id) {
    	this.id = id;
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

	public Photograph getDefaultPhotograph() {
		return defaultPhotograph;
	}

	public void setDefaultPhotograph(Photograph defaultPhotograph) {
		this.defaultPhotograph = defaultPhotograph;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public PhotographAlbum() {
		this.title = "";
		this.description = "";
		this.defaultPhotograph = null;
		this.total = 0;
    	this.tags = new ArrayList<PhotographAlbumTag>();
    	this.photographs = new ArrayList<Photograph>();
    }

    public boolean add(Photograph arg0)
    {
        addTags(arg0);
        return this.photographs.add(arg0);
    }
    
    public boolean addAll(Collection<? extends Photograph> arg0) {
    	for (Photograph item : arg0) {
    		addTags(item);
    	}
    	return this.photographs.addAll(arg0);
    }
    
    public void addTags(List<PhotographAlbumTag> tags)
    {
        if ((tags != null) && (tags.size() > 0))
        {
            tags.clear();
        }
        else if (tags == null)
        {
        	tags = new ArrayList<PhotographAlbumTag>();
        }

        tags.addAll(tags);
    }

    private void addTags(Photograph item)
    {
    	List<String> photoTags = item.getTags();
        if (photoTags != null)
        {
            for (String tag : photoTags)
            {
                PhotographAlbumTag photoTag = PhotographAlbumTagList.firstOrDefault(this.tags, tag);
                if (photoTag != null)
                {
                    photoTag.setCount(photoTag.getCount() + 1);
                }
                else
                {
                    photoTag = new PhotographAlbumTag(tag);
                    tags.add(photoTag);
                }
            }
        }
    }
}