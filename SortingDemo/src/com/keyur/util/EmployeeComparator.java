package com.keyur.util;

import java.util.Comparator;

import com.keyur.dto.EmployeeDTO;

public class EmployeeComparator implements Comparator<EmployeeDTO> {

	private String order;
	private String fieldName;

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	@Override
	public int compare(EmployeeDTO o1, EmployeeDTO o2) {
		if ("ASC".equals(this.order)) {
			if ("name".equalsIgnoreCase(fieldName)) {
				return o1.getName().compareTo(o2.getName());
			} else if ("salary".equalsIgnoreCase(fieldName)) {
				return (int) (o1.getSalary() - o2.getSalary());
			} else if ("empId".equalsIgnoreCase(fieldName)) {
				return o1.getEmpId() - o2.getEmpId();
			} else if ("department".equalsIgnoreCase(fieldName)) {
				return o1.getDepartment().compareTo(o2.getDepartment());
			} else if ("designation".equalsIgnoreCase(fieldName)) {
				return o1.getDesignation().compareTo(o2.getDesignation());
			}

		} else if (this.order.equals("DESC")) {
			if ("name".equalsIgnoreCase(fieldName)) {
				return o2.getName().compareTo(o1.getName());
			} else if ("salary".equalsIgnoreCase(fieldName)) {
				return (int) (o2.getSalary() - o1.getSalary());
			} else if ("empId".equalsIgnoreCase(fieldName)) {
				return o2.getEmpId() - o1.getEmpId();
			} else if ("department".equalsIgnoreCase(fieldName)) {
				return o2.getDepartment().compareTo(o1.getDepartment());
			} else if ("designation".equalsIgnoreCase(fieldName)) {
				return o2.getDesignation().compareTo(o1.getDesignation());
			}
		}
		return 0;
	}

}
