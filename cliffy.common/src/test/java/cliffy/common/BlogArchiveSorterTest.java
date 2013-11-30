package cliffy.common;

import java.util.*;

import junit.framework.TestCase;

public class BlogArchiveSorterTest extends TestCase {
	public void test() {
		ArrayList<Calendar> archives = new ArrayList<Calendar>();
		
		Calendar a = Calendar.getInstance();
		a.set(2013, 1, 1);
		archives.add(a);
		
		Calendar b = Calendar.getInstance();
		b.set(2013, 8, 1);
		archives.add(b);
		
		Calendar c = Calendar.getInstance();
		c.set(2013, 6, 1);
		archives.add(c);
		
		Collections.sort(archives, new BlogArchiveSorter());
		
		for (int i = 0; i < archives.size(); i++) {
			Calendar archive = archives.get(i);
			switch(i) {
			case 0:
				assertEquals(b, archive);
				break;
				
			case 1:
				assertEquals(c, archive);
				break;
				
			case 2:
				assertEquals(a, archive);
				break;
			}
		}
	}
}