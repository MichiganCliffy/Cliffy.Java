package cliffy.web.cliffordcorner.config;

import java.util.*;

import org.apache.commons.configuration.ConfigurationException;

import junit.framework.TestCase;

public class CliffordCornerConfigPropertiesTest extends TestCase {
	public void testLoad() {
		try {
			CliffordCornerConfigProperties config = new CliffordCornerConfigProperties();
			List<CliffordCornerLink> navigation = config.getNavigation();
			assertNotNull(navigation);
			assertEquals(10, navigation.size());
			
			CliffordCornerLink first = navigation.get(0);
			assertEquals("Photographs", first.getTitle());
			
			CliffordCornerLink second = navigation.get(1);
			assertEquals("Sabbatical", second.getTitle());
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
	}
}