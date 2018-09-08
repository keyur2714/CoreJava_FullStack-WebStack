package com.keyur.bean;

public abstract class Course {
	
	protected String courseName;
	private String instituteName;
	
	public Course(){
		this.instituteName = "";
	}
	public Course(String instituteName){
		this.instituteName = instituteName;
	}
	
	public abstract int fees();
	
	public String getInstituteName() {
		return this.instituteName;
	}
}
