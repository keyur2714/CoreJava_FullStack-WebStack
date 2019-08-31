package com.webstack.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.webstack.dto.CourseDTO;
import com.webstack.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{

	public List<CourseDTO> list() {
		List<CourseDTO> list = new ArrayList();
		
		CourseDTO course1 = new CourseDTO();
		
		course1.setId(10L);
		course1.setCourseName("Angular");
		course1.setFees(12000.0);
		course1.setTrainerName("Keyur");
		
		CourseDTO course2 = new CourseDTO();
		
		course2.setId(20L);
		course2.setCourseName("Java");
		course2.setFees(10000.0);
		course2.setTrainerName("Denish");
		
		CourseDTO course3 = new CourseDTO();
		
		course3.setId(30L);
		course3.setCourseName("Hadoop");
		course3.setFees(15000.0);
		course3.setTrainerName("Vinit");
		
		list.add(course1);
		list.add(course2);
		list.add(course3);
		
		
		return list;
	}
	
	

}
