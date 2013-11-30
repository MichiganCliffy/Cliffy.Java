package cliffy.common;

import java.util.Comparator;

public class PhotographSorter implements Comparator<Photograph> {
    public int compare(Photograph a, Photograph b) {
    	return a.getDateSaved().compareTo(b.getDateSaved());
    }
}