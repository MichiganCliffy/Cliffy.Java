package cliffy.common;

public class PhotographUri {
    private ImageSize size;
    private String uri;
    
    public ImageSize getSize() {
		return size;
	}

	public void setSize(ImageSize size) {
		this.size = size;
	}
    
    public void setSize(int sizeId) {
    	switch(sizeId) {
    	case 0:
    		this.size = ImageSize.Thumbnail;
    		break;

    	case 1:
    		this.size = ImageSize.Small;
    		break;
    		
    	case 2:
    		this.size = ImageSize.Medium;
    		break;
    		
    	case 3:
    		this.size = ImageSize.Large;
    		break;
    		
    	case 4:
    		this.size = ImageSize.Original;
    		break;
    	}
    }

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public PhotographUri() {
    	this.size = ImageSize.Undefined;
    	this.uri = null;
    }
}