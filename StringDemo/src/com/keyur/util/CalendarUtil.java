package com.keyur.util;

public class CalendarUtil {

	private static final String days[] = {"Mon","Thue","Wed","Thurse","Fri","Sat","Sun"};
	
	public static String[] getAllDays() {
		String newDays[] = new String[7];
		for(int i=0;i<7;i++)
			newDays[i] = days[i];
		return newDays;
	}
	
	public static String getThirdDay() {
		return days[2];
	}
	
}
