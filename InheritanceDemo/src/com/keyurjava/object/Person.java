package com.keyurjava.object;

public class Person {
	private String name;
	private String mobileNo;

	private Address address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getFormattedAddress() {
		return this.getAddress().getAddress1()+" , "+this.getAddress().getCity();
	}

}
