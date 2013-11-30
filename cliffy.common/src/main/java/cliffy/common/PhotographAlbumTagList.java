package cliffy.common;

import java.util.*;

public final class PhotographAlbumTagList {
	public static PhotographAlbumTag firstOrDefault(List<PhotographAlbumTag> source, String tag) {
		PhotographAlbumTag output = null;
		
		for (PhotographAlbumTag item : source) {
			if (item.getTag().equalsIgnoreCase(tag)) {
				output = item;
				break;
			}
		}
		
		return output;
	}
}
