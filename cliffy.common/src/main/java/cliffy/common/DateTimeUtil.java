package cliffy.common;

import java.util.*;

public final class DateTimeUtil {
	public static Date toDate(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month, day);
		
		return cal.getTime();
	}
	
	public static Calendar toFirstOfTheMonth(Date source) {
		Calendar transform = Calendar.getInstance();
		transform.setTime(source);
		
		Calendar output = Calendar.getInstance();
		output.set(Calendar.YEAR, transform.get(Calendar.YEAR));
		output.set(Calendar.MONTH, transform.get(Calendar.MONTH));
		output.set(Calendar.DATE, 1);
		
		return output;
	}
}
