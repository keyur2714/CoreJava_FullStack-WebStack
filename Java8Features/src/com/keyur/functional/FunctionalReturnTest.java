package com.keyur.functional;

@FunctionalInterface
public interface FunctionalReturnTest {

	int doOperation(int a,int b,String type);
	default void display() {
		System.out.println("FunctionalReturnTest: FunctionalReturnTest");
	}
	
	
}
