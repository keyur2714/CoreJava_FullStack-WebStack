package com.keyurjava.client;


import com.keyurjava.object.Address;
import com.keyurjava.object.Bike;
import com.keyurjava.object.Car;
import com.keyurjava.object.Person;

public class ClientTest {

	public static void main(String[] args) {
		System.out.println("Hello From Eclipse...!");
		
		Car vehicle = new Car();
		
		vehicle.setColor("RED");
		vehicle.setNoOfTyres(4);
		vehicle.setFuelType("PETROL OR DISSEL");
		
//		System.out.println(vehicle.getColor()+" "+vehicle.getNoOfTyres()+" "+vehicle.getFuelType());
		
		vehicle.displayVlicleDetails();
		
		Bike bike = new Bike();
		
		bike.setColor("Yellow");
		bike.setNoOfTyres(2);
		
		
//		System.out.println(bike.getColor()+" "+bike.getNoOfTyres());
		bike.displayVlicleDetails();

		Person person = new Person();
		person.setName("keyur");
		person.setMobileNo("7387029671");
		
		Address address=  new Address();
		address.setAddress1("A-1106 Alcove Society");
		address.setAddress2("Pimple Saudagar");
		address.setCity("Pune");
		
		person.setAddress(address);
		
		
		System.out.println("\n"+person.getName()+" "+person.getFormattedAddress());
	}

}
