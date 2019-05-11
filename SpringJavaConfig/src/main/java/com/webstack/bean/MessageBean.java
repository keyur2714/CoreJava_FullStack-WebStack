package com.webstack.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = "prototype")
public class MessageBean {
	
	public MessageBean() {
		System.out.println("Message Bean Object Created...");
	}

	private String message;

	public String getMessage() {
		return message;
	}

	@Value("Hello")
	public void setMessage(String message) {
		this.message = message;
	}

}
