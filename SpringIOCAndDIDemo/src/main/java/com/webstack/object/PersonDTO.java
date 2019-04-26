package com.webstack.object;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PersonDTO {

	private long pid;
	private String name;
	private int age;
	private String gender;
	
	@Autowired
	private ContactDTO contactDTO;

	public long getPid() {
		return pid;
	}

	@Value("10")
	public void setPid(long pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	@Value("keyur")
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	@Value("32")
	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	@Value("Male")
	public void setGender(String gender) {
		this.gender = gender;
	}

	public ContactDTO getContactDTO() {
		return contactDTO;
	}

	public void setContactDTO(ContactDTO contactDTO) {
		this.contactDTO = contactDTO;
	}

	
}
