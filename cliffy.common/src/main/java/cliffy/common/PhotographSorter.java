package cliffy.common;

import java.util.*;

public class PhotographSorter implements Comparator<Photograph> {
    public int compare(Photograph a, Photograph b) {
    	long aDate = a.getDateSaved().getTime();
    	long bDate = b.getDateSaved().getTime();
    	
    	if (aDate > bDate) {
    		return -1;
    	} else if (aDate < bDate) {
    		return 1;
    	} else {
    		return 0;
    	}
    }
}