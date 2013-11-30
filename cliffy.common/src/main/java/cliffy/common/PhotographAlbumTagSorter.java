package cliffy.common;

import java.util.Comparator;

public class PhotographAlbumTagSorter implements Comparator<PhotographAlbumTag> {
    public int compare(PhotographAlbumTag a, PhotographAlbumTag b) {
    	if (a.getCount() > b.getCount()) {
    		return -1;
    	}
    	else if (a.getCount() < b.getCount()) {
    		return 1;
    	}
    	
    	return 0;
    }
}