package models;

import cliffy.common.*;

public final class HtmlHelpers {
	public static String getFlashVars(Photograph video) {
        String output = "";

        if (video.getMedia().equalsIgnoreCase("video"))
        {
        	output += "intl_lang=en-us&amp;photo_secret=";
        	output += video.getSecret();
        	output += "&amp;photo_id=";
        	output += video.getPhotoId();
        }

        return output;
	}
}
