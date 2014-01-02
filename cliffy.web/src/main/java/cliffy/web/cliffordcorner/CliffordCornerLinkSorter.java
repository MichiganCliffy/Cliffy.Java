package cliffy.web.cliffordcorner;

import java.util.Comparator;

public class CliffordCornerLinkSorter implements Comparator<CliffordCornerLink> {
	@Override
	public int compare(CliffordCornerLink arg0, CliffordCornerLink arg1) {
		int arg0SortOrder = arg0.getSortOrder();
		int arg1SortOrder = arg1.getSortOrder();
		
		if (arg0SortOrder == arg1SortOrder) {
			return 0;
		} else if (arg0SortOrder > arg1SortOrder) {
			return 1;
		} else {
			return -1;
		}
	}
}