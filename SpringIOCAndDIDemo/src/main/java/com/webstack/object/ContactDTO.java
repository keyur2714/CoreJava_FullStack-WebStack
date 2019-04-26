package com.webstack.object;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ContactDTO {

	private String mobileNo;
	private String email;

	public String getMobileNo() {
		return mobileNo;
	}

	@Value("${contact1.mobileNo}")
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	//@Value("keyurjava27@gmail.com")
	@Value("${contact2.email}")
	public void setEmail(String email) {
		this.email = email;
	}

}
