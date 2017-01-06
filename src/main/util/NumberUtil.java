package main.util;

public class NumberUtil {
	
	//Parse Text to integers
	public static int parseInt(String text) {
		int ret = 0;
		
		try {
			ret = Integer.parseInt(text);
		} catch (NumberFormatException e) {
			ret = 0;
		}
		
		return ret;
	}
}
