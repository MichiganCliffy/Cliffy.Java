package cliffy.common;

import java.util.*;
import junit.framework.TestCase;

public class PhotographAlbumBlahTest extends TestCase {
	public void testAdd() {
		PhotographAlbum items = new PhotographAlbum();

		ArrayList<String> itemAtags = new ArrayList<String>();
		itemAtags.add("Test1");
		itemAtags.add("Test2");
		Photograph itemA = new Photograph();
		itemA.setTitle("Cliffy!");
		itemA.setTags(itemAtags);
		items.add(itemA);
		
		Photograph itemB = new Photograph();
		ArrayList<String> itemBtags = new ArrayList<String>();
		itemBtags.add("Test2");
		itemBtags.add("Test3");
		itemB.setTitle("Woo Hoo!");
		itemB.setTags(itemBtags);
		items.add(itemB);
		
		Photograph itemC = new Photograph();
		ArrayList<String> itemCtags = new ArrayList<String>();
		itemCtags.add("teSt3");
		itemCtags.add("tesT2");
		itemC.setTitle("One More Time");
		itemC.setTags(itemCtags);
		items.add(itemC);
		
		List<String> tags = items.getTags();
		assertEquals(3, tags.size());
		for(int i = 0; i < tags.size(); i++) {
			String tag = tags.get(i);
			switch(i) {
			case 0:
				assertEquals("test2", tag);
				break;
				
			case 1:
				assertEquals("test3", tag);
				break;
				
			case 2:
				assertEquals("test1", tag);
				break;
			}
		}
	}
}