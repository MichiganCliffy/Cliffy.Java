package cliffy.common;

public class PhotographAlbumTag  {
    private String tag;
    private int count;

    public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public PhotographAlbumTag() {
    	this.tag = null;
		this.count = 0;
    }
	
	public PhotographAlbumTag(String tag) {
		this.tag = tag;
		this.count = 1;
	}
}
