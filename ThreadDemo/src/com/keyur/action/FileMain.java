package com.keyur.action;

import java.util.List;

import com.keyur.util.ReadFile1Thread;

public class FileMain {

	public static void main(String[] args) {

		ReadFile1Thread readFile1Thread = new ReadFile1Thread("file1");
		ReadFile1Thread readFile2Thread = new ReadFile1Thread("file2");
		
		Thread thread1 = new Thread(readFile1Thread);
		Thread thread2 = new Thread(readFile2Thread);
		
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Final Result::");
		List<String> allLines = ReadFile1Thread.getAllLines();
		
		allLines.forEach(line->System.out.println(line));
		
	}

}
