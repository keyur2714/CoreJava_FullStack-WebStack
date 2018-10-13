package com.keyur.util;

public class StudentThread extends Thread{
	private String studentName;

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public void run() {
		for (int i = 0; i < this.studentName.length(); i++) {
			try {
				System.out.println(Thread.currentThread().getName()+" "+this.studentName.charAt(i));
				//Thread.sleep(1000);
				Thread.yield();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
