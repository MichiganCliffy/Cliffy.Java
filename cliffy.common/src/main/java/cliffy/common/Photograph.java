package cliffy.common;

import java.util.*;

public class Photograph {
    private Object id;
    private String photoId;
    private String secret;
    private String title;
    private String description;
    private String media;
    private Date dateSaved;
    private String photographer;
    private String uriSource;
    private List<PhotographUri> uriSizes;
    private List<String> tags;
    private String setId;
    
    public Object getId() {
		return id;
	}

	public void setId(Object id) {
		this.id = id;
	}

	public String getPhotoId() {
		return photoId;
	}

	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
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

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}

	public Date getDateSaved() {
		return dateSaved;
	}

	public void setDateSaved(Date dateSaved) {
		this.dateSaved = dateSaved;
	}

	public String getPhotographer() {
		return photographer;
	}

	public void setPhotographer(String photographer) {
		this.photographer = photographer;
	}

	public String getUriSource() {
		return uriSource;
	}

	public void setUriSource(String uriSource) {
		this.uriSource = uriSource;
	}

	public List<PhotographUri> getUriSizes() {
		return uriSizes;
	}

	public void setUriSizes(List<PhotographUri> uriSizes) {
		this.uriSizes = uriSizes;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public String getSetId() {
		return setId;
	}

	public void setSetId(String setId) {
		this.setId = setId;
	}

	public Photograph() {
    	this.uriSizes = new ArrayList<PhotographUri>();
    	this.tags = new ArrayList<String>();
    }
	
	public String getThumbnail() {
		return this.getUri(ImageSize.Thumbnail);
	}
	
	public String getUri(ImageSize size) {
		PhotographUri uri = PhotographList.firstOrDefault(this.uriSizes, size);
		if (uri != null) {
			return uri.getUri();
		}
		
		return "";
	}

    public Photograph clone()
    {
        Photograph output = new Photograph();
        output.setId(this.id);
        output.setPhotoId(this.photoId);
        output.setSecret(this.secret);
        output.setTitle(this.title);
        output.setDescription(this.description);
        output.setMedia(this.media);
        output.setDateSaved(this.dateSaved);
        output.setPhotographer(this.photographer);
        output.setUriSource(this.uriSource);
        output.setUriSizes(this.uriSizes);
        output.setTags(this.tags);
        output.setSetId(this.setId);

        return output;
    }
}