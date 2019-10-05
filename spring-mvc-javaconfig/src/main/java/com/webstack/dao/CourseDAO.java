package com.webstack.dao;

import java.util.List;

import com.webstack.dto.CourseDTO;

public interface CourseDAO {

	List<CourseDTO> getCourseList();
	
	public int save(CourseDTO course);
	
	CourseDTO getById(Long id);
}
