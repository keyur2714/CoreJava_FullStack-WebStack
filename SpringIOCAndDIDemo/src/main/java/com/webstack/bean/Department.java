package com.webstack.bean;

public class Department {
	private String deptCode;
	private String deptName;

	private Employee employee1;
//	private Employee employee2;

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public void setEmployee1(Employee employee1) {
		this.employee1 = employee1;
	}

//	public void setEmployee2(Employee employee2) {
//		this.employee2 = employee2;
//	}

	public Employee getEmployee1() {
		return employee1;
	}

//	public Employee getEmployee2() {
//		return employee2;
//	}

}
