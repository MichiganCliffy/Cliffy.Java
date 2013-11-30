package cliffy.common;

import java.util.*;

public final class BlogList {
	public static boolean exists(List<Calendar> archives, Calendar archive) {
		for (Calendar item : archives) {
			if (item.compareTo(archive) == 0) {
				return true;
			}
		}
		
		return false;
	}
	
	public static BlogTag firstOrDefault(List<BlogTag> tags, String tag) {
		for (BlogTag item : tags) {
			if (item.getTag().equalsIgnoreCase(tag)) {
				return item;
			}
		}
		
		return null;
	}
	
	public static boolean match(BlogPost post, String[] tags) {
		List<String> postTags = post.getTags();
		if ((tags != null) && (tags.length > 0)) {
			for (String tag : tags) {
				if (postTags.contains(tag)) {
					return true;
				}
			}
			
			return false;
		}
		
		return true;
	}
}