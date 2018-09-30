package com.keyur.util;

import java.util.Comparator;

import com.keyur.dto.EmployeeDTO;

public class NameComparator implements Comparator<EmployeeDTO> {

	private String order;

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	@Override
	public int compare(EmployeeDTO o1, EmployeeDTO o2) {
		if(this.getOrder().equals("ASC"))
			return o1.getName().compareTo(o2.getName());
		else if(this.getOrder().equals("DESC"))
			return o2.getName().compareTo(o1.getName());
		return 0;
	}

}
