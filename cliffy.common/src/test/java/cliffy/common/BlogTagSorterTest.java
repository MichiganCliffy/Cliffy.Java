package cliffy.common;

import java.util.*;

import junit.framework.TestCase;

public class BlogTagSorterTest extends TestCase {
	public void test() {
		ArrayList<BlogTag> tags = new ArrayList<BlogTag>();
		
		BlogTag a = new BlogTag("B");
		a.setCount(10);
		tags.add(a);
		
		BlogTag b = new BlogTag("A");
		b.setCount(10);
		tags.add(b);
		
		BlogTag c = new BlogTag("C");
		c.setCount(20);
		tags.add(c);
		
		Collections.sort(tags, new BlogTagSorter());
		
		for (int i = 0; i < tags.size(); i++) {
			BlogTag tag = tags.get(i);
			switch(i) {
			case 0:
				assertEquals(c.getTag(), tag.getTag());
				break;
				
			case 1:
				assertEquals(b.getTag(), tag.getTag());
				break;
				
			case 2:
				assertEquals(a.getTag(), tag.getTag());
				break;
			}
		}
	}
}