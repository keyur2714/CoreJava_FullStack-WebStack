package com.keyur.action;

import com.keyur.util.StudentRunnableThread;
import com.keyur.util.StudentThread;

public class Main {

	public static void main(String[] args) {

		System.out.println("Thread Demo Application...!");
		StudentThread studentThread = new StudentThread();
		studentThread.setStudentName("Denish");
		
		StudentRunnableThread studentRunnableThread = new StudentRunnableThread();
		studentRunnableThread.setName("Keyur");
		
		Thread t1 = new Thread(studentThread);
		t1.setName("Thread 1");
		t1.setPriority(Thread.MAX_PRIORITY);
		t1.start();
		Thread t2 = new Thread(studentRunnableThread);
		t2.setName("Thread 2");
		t2.setPriority(Thread.MAX_PRIORITY);
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		StudentRunnableThread studentRunnableThread1 = new StudentRunnableThread();
		studentRunnableThread1.setName("Hiren");
		
		System.out.println("====================");
		
		Thread t3 = new Thread(studentRunnableThread1);
		t3.setName("Thread 3");
		t3.setPriority(Thread.NORM_PRIORITY);
		t3.start();

	}

}
