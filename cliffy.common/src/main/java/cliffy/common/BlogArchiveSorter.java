package cliffy.common;

import java.util.*;

public class BlogArchiveSorter implements Comparator<Calendar> {
    public int compare(Calendar a, Calendar b) {
    	return b.compareTo(a);
    }
}