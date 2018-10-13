package com.keyur.util;

public class StudentRunnableThread implements Runnable {

	private String name;

	public void run() {
		
		for (int i=0;i<this.name.length();i++) {
			try {
				System.out.println(Thread.currentThread().getName()+" "+this.name.charAt(i));				
				//Thread.sleep(500);
				Thread.yield();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
