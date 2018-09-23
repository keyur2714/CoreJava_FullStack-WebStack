package com.keyur.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.keyur.dto.StudentDTO;
import com.keyur.service.StudentService;
import com.keyur.service.impl.StudentServiceImpl;

public class StudentController {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String choice = "";
		int id = 0;
		String name = "";
		String city = "";
		String mobileNo = "";
		int result = 0;
		StudentService service = new StudentServiceImpl();
		StudentDTO studentDTO = null;
		List<StudentDTO> studentList = null;

		do {
			System.out.print("Enter Your Choice:::(add/delete/update/get/list : exit for stop ");
			choice = scanner.next();
			switch (choice) {
			case "add":
				System.out.print("Enter Student Name: ");
				name = scanner.next();
				System.out.print("Enter Student City: ");
				city = scanner.next();
				System.out.print("Enter Student MobileNo: ");
				mobileNo = scanner.next();
				studentDTO = new StudentDTO();
				studentDTO.setName(name);
				studentDTO.setCity(city);
				studentDTO.setMobileNo(mobileNo);
				result = service.save(studentDTO);
				if (result > 0) {
					System.out.println("Student Details Saved Successfully...!");
				} else {
					System.out.println("Problem in Save Student Details...!");
				}
				break;
			case "delete":
				System.out.print("Enter Student Id which you want to delete: ");
				id = scanner.nextInt();
				service.delete(id);
				System.out.println("Student with Id: "+ id +" Deleted Successfully...!");
				break;
			case "update":
				System.out.print("Enter Student Id which you want to update: ");
				id = scanner.nextInt();
				studentDTO = service.get(id);
				System.out.print("Enter Student Name: ");
				name = scanner.next();
				if(name != null && name.length() > 0)
					studentDTO.setName(name);
				System.out.print("Enter Student City: ");
				city = scanner.next();
				if(city != null && city.length() > 0)
					studentDTO.setCity(city);
				System.out.print("Enter Student MobileNo: ");
				mobileNo = scanner.next();
				if(mobileNo != null && mobileNo.length() > 0)
					studentDTO.setMobileNo(mobileNo);
				
				result = service.update(studentDTO);
				if (result > 0) {
					System.out.println("Student Details Updated Successfully...!");
				} else {
					System.out.println("Problem in Update Student Details...!");
				}
				break;
			case "list":
				studentList = service.list();
				service.displayStudentInfo(studentList);
				break;
			case "get":
				System.out.print("Enter Student Id which you want display: ");
				id = scanner.nextInt();
				studentDTO = service.get(id); 
				studentList = new ArrayList<>();
				studentList.add(studentDTO);
				service.displayStudentInfo(studentList);
				break;
			}
		} while (!choice.equals("exit"));

	}

}
