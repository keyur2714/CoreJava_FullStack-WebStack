package com.keyur.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ClientTest {

	public static void main(String[] args) {
		
		List<String> names = new ArrayList<>();
		names.add("keyur");
		names.add("denish");
		names.add("vinit");
		names.add("denish");
		names.add("vinit");
		
		System.out.println("Without sorting..");
		for (String string : names) {
			System.out.println(string);
		}
		
		Collections.sort(names);
		
		System.out.println("After sorting..");
		for (String string : names) {
			System.out.println(string);
		}
		
		//Set<String> uniqueNames = new HashSet<>(names);// Un Ordered
		Set<String> uniqueNames = new LinkedHashSet<>(names);
		System.out.println("Unique Names..");
		for (String string : uniqueNames) {
			System.out.println(string);
		}
		

	}

}
