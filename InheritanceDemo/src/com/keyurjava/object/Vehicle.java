package com.keyurjava.object;

public class Vehicle {
	protected int noOfTyres;
	protected String colors;

	public int getNoOfTyres() {
		return noOfTyres;
	}

	public void setNoOfTyres(int noOfTyres) {
		this.noOfTyres = noOfTyres;
	}

	public String getColor() {
		return colors;
	}

	public void setColor(String color) {
		this.colors = color;
	}
	
	public void displayVlicleDetails() {
		System.out.print(noOfTyres+" "+colors);
	}

}
