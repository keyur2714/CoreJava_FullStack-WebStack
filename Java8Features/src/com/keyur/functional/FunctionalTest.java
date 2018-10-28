package com.keyur.functional;

@FunctionalInterface
public interface FunctionalTest {
	void doWork();
	public default void display() {
		System.out.println("Functional Interface Display...!");
	}
}
