package com.keyur.factory;

import com.keyur.bean.AngularCourse;
import com.keyur.bean.Course;
import com.keyur.bean.JavaCourse;

public class CourseFactory implements Factory{

	public Course getCourseInstance(String courseType) {
		if("Angular".equalsIgnoreCase(courseType)) {
			return new AngularCourse("Angular", "FullStack@WebStack");
		}
		if("Java".equalsIgnoreCase(courseType)) {
			return new JavaCourse("Java", "FullStack@WebStack");
		}
		return null;
	}

	@Override
	public String factoryType() {
		return "CourseFactory";
	}
	
}
