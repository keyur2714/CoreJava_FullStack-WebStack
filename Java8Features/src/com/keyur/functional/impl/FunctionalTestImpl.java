package com.keyur.functional.impl;

import com.keyur.functional.FunctionalReturnTest;
import com.keyur.functional.FunctionalTest;

public class FunctionalTestImpl implements FunctionalTest,FunctionalReturnTest{

	@Override
	public void doWork() {
		System.out.println("Functional Test Impl Using JAVA Object Oriented Way...: ");
	}

	@Override
	public int doOperation(int a, int b, String type) {
		// TODO Auto-generated method stub
		System.out.println("-----------"+a+" ============= "+b+"-------------");
		return 0;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		FunctionalReturnTest.super.display();
	}

}
