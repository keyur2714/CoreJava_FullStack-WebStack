package com.keyur.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		System.out.println("Concurrent Collections...!");
		
		List<String> stringList = new ArrayList<>();
		stringList.add("keyur");
		stringList.add("denish");
		stringList.add("vinit");
		
		System.out.println("Normal Array List...");
		int i = 1;
		for (String string : stringList) {
			System.out.println(string);
			if(i == 2) {
				//stringList.add("sachin"); // not Allowed Here
			}
			i++;
		}
		
		System.out.println("Synchronized Array List...");
		
		Collections.synchronizedCollection(stringList);
		i = 1;
		for (String string : stringList) {
			System.out.println(string);
			if(i == 2) {
				//stringList.add("sachin"); //Not Allowed in case of Collections.synchronized
			}
			i++;
		}
		
		System.out.println("After Add Size is: "+stringList.size());
		System.out.println("Concurrent Array List...");
		
		CopyOnWriteArrayList<String> concurrentList = new CopyOnWriteArrayList<>();
		concurrentList.add("denish");
		concurrentList.add("keyur");
		concurrentList.add("ketan");
		concurrentList.add("kevin");
		concurrentList.add("hiren");
		i = 1;
		for (String string : concurrentList) {			
			System.out.println(string);
			if(i == 2) {
				concurrentList.add("sachin"); //Allowed Here
			}
			i++;
		}
		
		System.out.println("After Add Size is: "+concurrentList.size());
		
		System.out.println("Print using Lamda Expression:...");
		
		concurrentList.forEach((name)->{			
			if(! name.equalsIgnoreCase("keyur"))
				System.out.println(name);
		});
		//concurrentList.clear();
		Optional<String> firstName = concurrentList.stream().findFirst();
		
		System.out.println("===="+firstName.orElse("hiren"));
		System.out.println("====");
		firstName.ifPresent((name)->System.out.println(name));
		
		Predicate<String> predicate = new Predicate<String>() {
			
			@Override
			public boolean test(String t) {
				return t.startsWith("k");
			}
		};
		List<String> startsWithK = concurrentList.stream().filter(predicate)
				.collect(Collectors.toList());
		
		
		startsWithK.stream().forEach(name->System.out.println(name));
				
		
	}
	
	

}
