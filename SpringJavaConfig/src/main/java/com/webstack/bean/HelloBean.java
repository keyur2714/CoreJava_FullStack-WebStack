package com.webstack.bean;

public class HelloBean {
	private String message;
	
	public HelloBean() {		
		System.out.println("Hello Bean Object Created...!");
	}
	
	public HelloBean(String message) {
		System.out.println("Hello Bean Object Created...!");
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

//	public void setMessage(String message) {
//		this.message = message;
//	}

}
