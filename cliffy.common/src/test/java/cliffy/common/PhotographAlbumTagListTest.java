package cliffy.common;


import java.util.*;
import junit.framework.TestCase;

public class PhotographAlbumTagListTest extends TestCase{
	public void testFind() {
		ArrayList<PhotographAlbumTag> tags = new ArrayList<PhotographAlbumTag>();
		
		PhotographAlbumTag a = new PhotographAlbumTag("cliffy");
		a.setCount(10);
		tags.add(a);
		
		PhotographAlbumTag b = new PhotographAlbumTag("somthin");
		b.setCount(5);
		tags.add(b);
		
		PhotographAlbumTag found = PhotographAlbumTagList.firstOrDefault(tags, "somthin");
		
		assertEquals(b.getTag(), found.getTag());
	}
}
