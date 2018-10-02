package com.keyur.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.keyur.object.PersonObject;

public class PersonController {

	public static void main(String[] args) {

		PersonObject personObject1 = new PersonObject();
		personObject1.setPid(32);
		personObject1.setName("Keyur");
		personObject1.setCity("surat");
		personObject1.setMobileNo("7387029671");

		PersonObject personObject2 = new PersonObject();
		personObject2.setPid(26);
		personObject2.setName("Denish");
		personObject2.setCity("surat");
		personObject2.setMobileNo("7387029111");

		PersonObject personObject3 = new PersonObject();
		personObject3.setPid(44);
		personObject3.setName("Vinit");
		personObject3.setCity("bardoli");
		personObject3.setMobileNo("7387029222");

		PersonObject personObject4 = new PersonObject();
		personObject4.setPid(24);
		personObject4.setName("Darshana");
		personObject4.setCity("Kamrej");
		personObject4.setMobileNo("7387029444");

		List<PersonObject> personList = new ArrayList<>();
		personList.add(personObject1);
		personList.add(personObject2);
		personList.add(personObject3);
		personList.add(personObject4);

		System.out.println("============Original List============");
		for (PersonObject personObject : personList) {
			System.out.println(personObject.getPid()+" "+personObject.getName()+" "+personObject.getCity()+" "+personObject.getMobileNo());
		}
		
		System.out.println("============Remove Duplicate Person Object based on city============");
		
		//Set<PersonObject> personSet = new HashSet<>(personList);//un ordered
		Set<PersonObject> personSet = new LinkedHashSet<>(personList);
		for (PersonObject personObject : personSet) {
			System.out.println(personObject.getPid()+" "+personObject.getName()+" "+personObject.getCity()+" "+personObject.getMobileNo());
		}
		
	}

}
