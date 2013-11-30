package cliffy.common;

public class BlogTag {
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
	
	public BlogTag() {
		this.count = 0;
	}
	
	public BlogTag(String tag) {
		this.count = 1;
		this.tag = tag;
	}
}
