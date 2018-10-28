package com.keyur.action;

import java.util.ArrayList;
import java.util.List;

import com.keyur.functional.FunctionalReturnTest;
import com.keyur.functional.FunctionalTest;
import com.keyur.functional.impl.FunctionalTestImpl;

public class ClientTest {

	public static void main(String[] args) {
		
		//Traditional Way
		FunctionalTest functionalTest = new FunctionalTestImpl();
		doWorkImpl(functionalTest);
		
		//Anonymus Class
		doWorkImpl(new FunctionalTest() {
			
			@Override
			public void doWork() {
				// TODO Auto-generated method stub				
				System.out.println("Functional Test Using Annonymus Inner Class...:");
			}
		});
		
		System.out.println("=================");
		FunctionalTest functionalTest1 = ()->{System.out.println("Hello...I am Good.!");};
		functionalTest1.doWork();
		functionalTest1.display();
		System.out.println("=================");
		
		//Using Lamda Expressions.		
		doWorkImpl(() -> System.out.println("Functional Test Using lambda exp impl..."));
		
		doWorkImpl(()->{
			System.out.println("Hello...");
			System.out.println("How Are You...");
		});
		
		List<String> list=new ArrayList();
		list.add("keyur");
		list.add("denish");
		list.add("vinit");
		
		list.stream().forEach((l)->System.out.println(l));
		
		System.out.println("=================Functional Test Return========");
		
		FunctionalReturnTest functionalReturnTest = (a,b,c)->{			
			return a+b;
		};
		functionalReturnTest.doOperation(5, 6, "Hello");
		System.out.println(functionalReturnTest.doOperation(5, 6, "Hello"));
		functionalReturnTest.display();

	}
	
	public static void doWorkImpl(FunctionalTest functionalTest) {
		functionalTest.doWork();
		functionalTest.display();
	}

}
