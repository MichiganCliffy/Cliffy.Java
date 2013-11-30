package cliffy.common;

import java.util.*;

import junit.framework.TestCase;

public class PhotographAlbumTagSorterTest extends TestCase {
	public void testSort() {
		ArrayList<PhotographAlbumTag> tags = new ArrayList<PhotographAlbumTag>();
		
		PhotographAlbumTag a = new PhotographAlbumTag("cliffy");
		a.setCount(5);
		tags.add(a);
		
		PhotographAlbumTag b = new PhotographAlbumTag("somthin");
		b.setCount(10);
		tags.add(b);
		
		PhotographAlbumTagSorter sorter = new PhotographAlbumTagSorter();
		Collections.sort(tags, sorter);
		
		for (int i = 0; i < tags.size(); i++) {
			PhotographAlbumTag tag = tags.get(i);
			switch(i) {
			case 0:
				assertEquals(b.getTag(), tag.getTag());
				break;
				
			case 1:
				assertEquals(a.getTag(), tag.getTag());
				break;
			}
		}
	}
}
