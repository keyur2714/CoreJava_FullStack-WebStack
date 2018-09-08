package com.keyur.bean;

public class JavaCourse extends Course {

	public JavaCourse() {
		super();
	}

	public JavaCourse(String courseName, String instituteName) {
		super(instituteName);
		this.courseName = courseName;
	}

	@Override
	public int fees() {
		return 14000;
	}

	public String getCourseName() {
		return this.courseName;
	}

}
