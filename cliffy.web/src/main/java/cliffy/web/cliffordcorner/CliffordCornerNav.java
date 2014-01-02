package cliffy.web.cliffordcorner;

import java.util.*;

public class CliffordCornerNav {
	private ArrayList<CliffordCornerLink> featured;
	private ArrayList<CliffordCornerLink> more;
	
	public ArrayList<CliffordCornerLink> getFeatured() {
		return featured;
	}
	
	public void setFeatured(ArrayList<CliffordCornerLink> featured) {
		this.featured = featured;
	}
	
	public ArrayList<CliffordCornerLink> getMore() {
		return more;
	}
	
	public void setMore(ArrayList<CliffordCornerLink> more) {
		this.more = more;
	}
	
	public CliffordCornerNav(CliffordCornerConfigProperties config) {
		this.featured = new ArrayList<CliffordCornerLink>();
		this.more = new ArrayList<CliffordCornerLink>();
		
		List<CliffordCornerLink> navigation = config.getNavigation(); 
		this.featured.addAll(navigation.subList(0, 3));
		this.more.addAll(navigation.subList(3, navigation.size() - 1));
	}
}