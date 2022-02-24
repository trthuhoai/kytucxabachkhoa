package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String getDatePresent() {
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}
	public static String convertDate(String date) {
		String[] arr = date.split("\\/");
		StringBuilder sb = new StringBuilder();
		sb.append(arr[2]).append("-").append(arr[1]).append("-").append(arr[0]);
		return sb.toString();
	}


}
