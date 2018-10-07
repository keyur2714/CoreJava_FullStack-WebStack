package com.keyur.action;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentMap {

	public static void main(String[] args) {
		
		Map<String,String> days=new HashMap<>(32,0.75f);
		
		days.put("MON","Monday");
		days.put("TUE","Tuesday");
		days.put("WED","Wednesday");
		days.put("THUR","Thurseday");
		days.put("FRI","Friday");
		days.put("SAT","Saturday");
		days.put("SUN","Sunday");
		int k = 1;
		for(Map.Entry<String, String> entry : days.entrySet()) {
			System.out.println(entry.getKey()+" "+entry.getValue());
			if(k == 3) {
				//days.put("SAS", "Sasssss"); Not Allowed
			}
			k++;
		}
		
		System.out.println("Using Concurrent HashMap...");
		ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<>(32,0.75f,16);
		
		concurrentHashMap.put("MON","Monday");
		concurrentHashMap.put("TUE","Tuesday");
		concurrentHashMap.put("WED","Wednesday");
		concurrentHashMap.put("THUR","Thurseday");
		concurrentHashMap.put("FRI","Friday");
		concurrentHashMap.put("SAT","Saturday");
		concurrentHashMap.put("SUN","Sunday");
		k = 1;
		for(Map.Entry<String, String> entry : concurrentHashMap.entrySet()) {
			System.out.println(entry.getKey()+" "+entry.getValue());
			if(k == 3) {
				concurrentHashMap.put("SAS", "Sasssss"); // Allowed
			}
			k++;
		}
		
		System.out.println(concurrentHashMap.size());
		
		
		

	}

}
