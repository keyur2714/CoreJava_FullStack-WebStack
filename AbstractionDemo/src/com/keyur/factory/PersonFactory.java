package com.keyur.factory;

import com.keyur.bean.Faculty;
import com.keyur.bean.Person;
import com.keyur.bean.Student;

public class PersonFactory implements Factory{

	public Person getPersonInstance(String personType) {
		if("Student".equalsIgnoreCase(personType)) {
			return new Student();
		}
		if("Faculty".equalsIgnoreCase(personType)) {
			return new Faculty();
		}
		return null;
	}

	@Override
	public String factoryType() {
		// TODO Auto-generated method stub
		return "PersonFactory";
	}
	
}
