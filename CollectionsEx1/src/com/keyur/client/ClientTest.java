package com.keyur.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.TreeSet;

public class ClientTest {

	public static void main(String[] args) {
		
		List list = new ArrayList();
		
		list.add("keyur");
		list.add(27);
		list.add("Hiren");
		list.add(new Date());
		
		//old way
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get((i)));
		}
		
		System.out.println("============");
		//foreach loop
		int i = 0 ;
		for(Object object : list) {
			System.out.println(object);
			//not allowed it will trow concurrent modification exception
//			if(i==1) {
//				list.remove(object);
//			}
//			i++;
			if(i == 2) {
				list.set(i, "vicky");
			}
			i++;
		}
		System.out.println("============");
		//Iterator 
		Iterator iterator = list.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
			if(i==1) {
				//list.remove(i);//not valid
				iterator.remove();
			}			
			if(i == 2) {
				list.set(i, "vicky");
			}
			i++;
		}
		
		System.out.println(list.size() + " After Removed");	
		ListIterator listIterator = list.listIterator();
		i = 0;
		while(listIterator.hasNext()) {
			System.out.println(listIterator.next());
			if(i==1) {
				listIterator.add("sachin");
			}
			i++;
		}
		System.out.println(list.size() + " After Add");
		
		System.out.println("==========Set Ex ==================");
		
		//Set set = new HashSet();
		//Set set = new LinkedHashSet();
		Set set = new TreeSet();
		
		set.add("keyur");
		set.add("denish");
		set.add("vinit");
		set.add("keyur");
		set.add("pinkal");
		
		for(Object s : set) {
			System.out.println(s);
		}
	}
	
	

}
