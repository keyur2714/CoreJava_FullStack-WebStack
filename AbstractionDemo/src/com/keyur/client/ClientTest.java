package com.keyur.client;

import com.keyur.bean.AngularCourse;
import com.keyur.bean.Course;
import com.keyur.bean.JavaCourse;
import com.keyur.bean.Person;
import com.keyur.factory.CourseFactory;
import com.keyur.factory.Factory;
import com.keyur.factory.PersonCourseAbstractFactory;
import com.keyur.factory.PersonFactory;

public class ClientTest {

	public static void main(String[] args) {

		
		
		
//		Course angularCourse = new AngularCourse("Angular 6", "FullStack@WebStack");
//		
//		Course javaCourse = new JavaCourse("Java", "FullStack@WebStack");
		
		CourseFactory courseFactory =  (CourseFactory)PersonCourseAbstractFactory.getFactory("CourseFactory");
		PersonFactory personFactory =  (PersonFactory)PersonCourseAbstractFactory.getFactory("PersonFactory");
		
		
//		Course angularCourse = CourseFactory.getCourseInstance("Angular");
//		Course javaCourse = CourseFactory.getCourseInstance("JAVA");
		
		Course angularCourse = courseFactory.getCourseInstance("Angular");
		Course javaCourse = courseFactory.getCourseInstance("JAVA");
		
		AngularCourse course1 = (AngularCourse) angularCourse;
		JavaCourse course2 = (JavaCourse) javaCourse;
		System.out.println(course1.getInstituteName()+ " " + course1.getCourseName()+" "+course1.fees());
		System.out.println(course2.getInstituteName()+ " " + course2.getCourseName()+" "+course2.fees());
		
		
		//Person student = PersonFactory.getPersonInstance("Student");
		Person student = personFactory.getPersonInstance("Student");
		student.setName("Keyur");
		
		Person faculty = personFactory.getPersonInstance("Faculty");
		faculty.setName("Vinit");
		
		System.out.println(student.getName()+" "+faculty.getName());
	}

}
