package cliffy.common;

import java.util.*;

import junit.framework.TestCase;

public class PhotographSorterTest extends TestCase {
	public void test() {
		ArrayList<Photograph> photos = new ArrayList<Photograph>();
		
		Photograph a = new Photograph();
		a.setTitle("A");
		a.setDateSaved(DateTimeUtil.toDate(2013, 11, 10));
		photos.add(a);
		
		Photograph b = new Photograph();
		b.setTitle("B");
		b.setDateSaved(DateTimeUtil.toDate(2013, 11, 8));
		photos.add(b);
		
		Photograph c = new Photograph();
		c.setTitle("C");
		c.setDateSaved(DateTimeUtil.toDate(2013, 11, 14));
		photos.add(c);
		
		Collections.sort(photos, new PhotographSorter());
		
		for (int i = 0; i < photos.size(); i++) {
			Photograph item = photos.get(i);
			switch(i) {
			case 0:
				assertEquals(c.getTitle(), item.getTitle());
				break;
				
			case 1:
				assertEquals(a.getTitle(), item.getTitle());
				break;
				
			case 2:
				assertEquals(b.getTitle(), item.getTitle());
				break;
			}
		}
	}
}