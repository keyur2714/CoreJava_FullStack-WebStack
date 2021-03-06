package com.webstack.service;

import java.util.List;

import com.webstack.dto.CourseDTO;

public interface CourseService {
	List<CourseDTO> list();
	CourseDTO getById(Long id);
	int save(CourseDTO courseDTO);
}
