package com.keyur.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapBasics {

	public static void main(String[] args) {

		Map<Integer, String> studentsMap = new HashMap<>();
		
		studentsMap.put(32, "keyur");
		studentsMap.put(27, "denish");
		studentsMap.put(45, "SACHIN");
		studentsMap.put(46, "SACHIN");
		studentsMap.put(44, "SACHIN");
		studentsMap.put(null, null);
		
		Set<Integer> keys = studentsMap.keySet();
		System.out.println("print with keyset");
		for (Integer key : keys) {
			System.out.println(key+" "+studentsMap.get(key));
		}
		System.out.println("print with entryset");
		for(Map.Entry<Integer, String> entry : studentsMap.entrySet()) {
			System.out.println(entry.getKey()+" "+entry.getValue()+" "+entry.hashCode());
		}
		
		List<String> names = new ArrayList<String>();
		names.add("keyur:surat");
		names.add("denish:surat");
		names.add("vinit:bardoli");
		names.add("darsh:bardoli");
		names.add("ami:bharuch");
		
		
		
		
		Map<String,List<String>> cityFriends = new HashMap<String,List<String>>();
		
		String key = null;
		String value = null;
		List<String> nameList = new ArrayList();
		for (String string : names) {
			key = string.split(":")[1];
			value = string.split(":")[0];
						
			if(cityFriends.containsKey(key)) {
				cityFriends.get(key).add(value);			
			}else{
				nameList.add(value);
				cityFriends.put(key,nameList);
				nameList = new ArrayList<>();
			}
			
		}
		
		for(Map.Entry<String, List<String>> entry : cityFriends.entrySet()) {
			System.out.println(entry.getKey()+" "+entry.getValue()+" "+entry.getValue().size());
			for (String string : entry.getValue()) {
				System.out.println(string+" ===");
			}
		}
		
	}

}
