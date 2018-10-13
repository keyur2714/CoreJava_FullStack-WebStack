package com.keyur.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile1Thread extends Thread {

	static List<String> allLines = new ArrayList();
	
	public ReadFile1Thread(String name){
		super(name);
	}

	public void run() {
		if (this.getName().equals("file1")) {
			try (FileInputStream fileInputStream = new FileInputStream("input/friends.txt")) {

				Scanner scanner = new Scanner(fileInputStream);
				while (scanner.hasNext()) {
					allLines.add(scanner.next());					
					Thread.currentThread().sleep(500);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (this.getName().equals("file2")) {
			try (FileInputStream fileInputStream = new FileInputStream("input/hobby.txt")) {

				Scanner scanner = new Scanner(fileInputStream);
				while (scanner.hasNext()) {
					allLines.add(scanner.next());
					Thread.currentThread().sleep(500);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	public static List<String> getAllLines(){
		return allLines;
	}

}
