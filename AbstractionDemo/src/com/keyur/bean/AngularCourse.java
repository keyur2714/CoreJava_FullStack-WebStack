package com.keyur.bean;

public class AngularCourse extends Course{

	public AngularCourse(String courseName,String instituteName) {
		super(instituteName);
		this.courseName = courseName;
	}
	
	@Override
	public int fees() {
		return 12000;				
	}
	
	public String getCourseName() {
		return this.courseName;
	}

}
