package cliffy.web.cliffordcorner;

import java.util.*;

public class CliffordCornerMenu {
	private List<CliffordCornerLink> links;
	private String title;
	private String description;

	public List<CliffordCornerLink> getLinks() {
		return links;
	}

	public void setLinks(List<CliffordCornerLink> value) {
		this.links = value;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String value) {
		this.title = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String value) {
		this.description = value;
	}
}
