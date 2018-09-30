package com.keyur.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import com.keyur.dto.EmployeeDTO;
import com.keyur.util.EmployeeComparator;
import com.keyur.util.NameComparator;

public class EmployeeAction {

	public static void main(String[] args) {
		List<EmployeeDTO> empList = getEmployeeList();
		
		Iterator<EmployeeDTO> empListIterator = empList.iterator();
		
		System.out.println("...Before Sorting...!");
		while(empListIterator.hasNext()) {
			System.out.println(empListIterator.next());
		}
		System.out.println("After Sorting with Comparable...!");
		Collections.sort(empList);
		
		displayEmplList(empList);
		
		System.out.println("After Sorting with Name Comparator...!");
		NameComparator nameComparator = new NameComparator();
		nameComparator.setOrder("DESC");
		
		Collections.sort(empList, nameComparator);
		
		displayEmplList(empList);
		
		System.out.println("After Sorting with Employee Comparator on salary field...!");
		EmployeeComparator employeeComparator = new EmployeeComparator();
		employeeComparator.setOrder("DESC");
		employeeComparator.setFieldName("salary");
		
		Collections.sort(empList, employeeComparator);
		
		displayEmplList(empList);
		
		System.out.println("After Sorting with Employee Comparator on Designation field...!");
		EmployeeComparator employeeDComparator = new EmployeeComparator();
		employeeDComparator.setOrder("DESC");
		employeeDComparator.setFieldName("designation");
		
		Set<EmployeeDTO> hasSet = new HashSet<>(empList);
		Collections.sort(empList, employeeDComparator);
		
		SortedSet<EmployeeDTO> sortedSet = new TreeSet<>(empList);
		//sortedSet.addAll(hasSet);
		
		
		System.out.println(empList.size());
		System.out.println(sortedSet.size());
		
		for (EmployeeDTO employeeDTO : hasSet) {
			System.out.println(employeeDTO);
		}
		
		
		
		
	}

	private static void displayEmplList(List<EmployeeDTO> empList) {
		for(EmployeeDTO employeeDTO : empList) {
			System.out.println(employeeDTO);
		}
	}
	
	static List<EmployeeDTO> getEmployeeList(){
		
		EmployeeDTO employeeDTO1 = new EmployeeDTO();
		employeeDTO1.setEmpId(26);
		employeeDTO1.setName("denish");
		employeeDTO1.setDepartment("IT");
		employeeDTO1.setDesignation("Tech Lead");
		employeeDTO1.setSalary(11111);
		
		EmployeeDTO employeeDTO2 = new EmployeeDTO();
		employeeDTO2.setEmpId(44);
		employeeDTO2.setName("vinit");
		employeeDTO2.setDepartment("Sales");
		employeeDTO2.setDesignation("Sales Executive");
		employeeDTO2.setSalary(22111);
		
		EmployeeDTO employeeDTO3 = new EmployeeDTO();
		employeeDTO3.setEmpId(27);
		employeeDTO3.setName("darsh");
		employeeDTO3.setDepartment("IT");
		employeeDTO3.setDesignation("Tech Lead");
		employeeDTO3.setSalary(13111);
		
		List<EmployeeDTO> empList = new ArrayList<>();
		empList.add(employeeDTO1);
		empList.add(employeeDTO2);
		empList.add(employeeDTO3);
		
		return empList;
	}

}
