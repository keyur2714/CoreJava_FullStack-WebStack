package com.keyur.factory;

public class PersonCourseAbstractFactory {

	public static Factory getFactory(String factoryType){
		if("PersonFactory".equalsIgnoreCase(factoryType)){
			return new PersonFactory();
		}
		if("CourseFactory".equalsIgnoreCase(factoryType)){
			return new CourseFactory();
		}
		return null;
	}

}
