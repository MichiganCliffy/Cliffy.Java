package cliffy.web.cliffordcorner;

import java.net.URL;
import java.util.*;
import org.apache.commons.configuration.*;

public class CliffordCornerConfigProperties {
	private ArrayList<CliffordCornerLink> navigation;

	public List<CliffordCornerLink> getNavigation() {
		return navigation;
	}
	
	public CliffordCornerConfigProperties(URL propertyFile) {
		navigation = new ArrayList<CliffordCornerLink>();
		loadFromConfig(propertyFile);
		
		Collections.sort(this.navigation, new CliffordCornerLinkSorter());
	}
	
	private void loadFromConfig(URL propertyFile) {
		if (propertyFile != null) {
			XMLConfiguration config = new XMLConfiguration();
			config.setURL(propertyFile);

			try {
				config.load();
			} catch(org.apache.commons.configuration.ConfigurationException x) {
				x.printStackTrace();
			}
			
			List<HierarchicalConfiguration> links = config.configurationsAt("navigation.link");
			if (links != null) {
				loadFromConfig(links);
			}
		}
	}
	
	private void loadFromConfig(List<HierarchicalConfiguration> links) {
		for(HierarchicalConfiguration link : links) {
			loadFromConfig(link);
		}
	}
	
	private void loadFromConfig(HierarchicalConfiguration link) {
		CliffordCornerLink page = new CliffordCornerLink();
		page.setId(link.getString("[@id]", ""));
		page.setTitle(link.getString("[@title]", ""));
		page.setSortOrder(link.getInt("[@sortOrder]", 9999));
		page.setDescription(link.getString("description", ""));
		
		String action = link.getString("[@action]", "").replaceAll(":id", page.getId());
		page.setAction(action);
		
		navigation.add(page);
	}
}