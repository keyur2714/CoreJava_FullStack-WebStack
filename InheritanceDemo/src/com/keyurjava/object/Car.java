package com.keyurjava.object;

public class Car extends Vehicle {

	private String fuelType;

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	@Override
	public void displayVlicleDetails() {
		super.displayVlicleDetails();
		System.out.println(" "+fuelType);
	}

	
}
