package cliffy.common;

import java.util.*;

public final class PhotographList {
	public static PhotographUri firstOrDefault(List<PhotographUri> source, ImageSize size) {
		PhotographUri output = null;
		
		for (PhotographUri item : source) {
			if (item.getSize() == size) {
				output = item;
				break;
			}
		}
		
		return output;
	}
	
	public static Photograph firstOrDefault(List<Photograph> source, String photoId) {
		Photograph output = null;
		
		for (Photograph item : source) {
			if (item.getPhotoId().equals(photoId)) {
				output = item;
				break;
			}
		}
		
		return output;
	}
	
	public static List<Photograph> page(List<Photograph> source, int count, int page) {
		Collections.sort(source, new PhotographSorter());
		ArrayList<Photograph> output = new ArrayList<Photograph>();
		
        int startAt = page * count;
        int endAt = startAt + count;
        if (endAt > source.size()) {
        	endAt = source.size();
        }

//		int startAt = 0;
//		int endAt = source.size();

        for (int i = startAt; i < endAt; i++) {
        	output.add(source.get(i));
        }
		
		Collections.sort(output, new PhotographSorter());
		return output;
	}
	
	public static List<Photograph> find(List<Photograph> source, List<String> tags) {
		ArrayList<Photograph> output = new ArrayList<Photograph>();

		if (tags != null && tags.size() > 0) {
			for(Photograph photo : source) {
				List<String> photoTags = photo.getTags();
				if (photoTags.containsAll(tags)) {
					output.add(photo);
				}
			}
		} else {
			output.addAll(source);
		}
		
		return output;
	}
}