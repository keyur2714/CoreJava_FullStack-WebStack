package com.keyur.action;

import com.keyur.util.CalendarUtil;

public class Main {

	public static void main(String[] args) {
		String str[] = CalendarUtil.getAllDays();
		
		System.out.println(CalendarUtil.getThirdDay());
		
		str[2] = "Hello";
		
		System.out.println(CalendarUtil.getThirdDay());

	}

}
