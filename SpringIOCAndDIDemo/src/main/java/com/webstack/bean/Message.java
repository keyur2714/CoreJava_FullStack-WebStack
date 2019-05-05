package com.webstack.bean;

public class Message {

	private String message;
	
	public Message() {
		System.out.println("Message Bean Created...");
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void initMessage() { 
		System.out.println("Message Bean Init...");
	}
	
	public void destroyMessage() {
		System.out.println("Message Bean Destroy...");
	}
	
}
