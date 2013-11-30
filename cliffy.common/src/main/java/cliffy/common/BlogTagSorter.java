package cliffy.common;

import java.util.Comparator;

public class BlogTagSorter implements Comparator<BlogTag> {
    public int compare(BlogTag a, BlogTag b) {

    	int output = 0;
    	if (a.getCount() < b.getCount()) {
    		output = 1;
    	} else if (a.getCount() > b.getCount()) {
    		output = -1;
    	}
    	
    	if (output == 0) {
    		output = a.getTag().compareToIgnoreCase(b.getTag());
    	}
    	
    	return output;
    }
}