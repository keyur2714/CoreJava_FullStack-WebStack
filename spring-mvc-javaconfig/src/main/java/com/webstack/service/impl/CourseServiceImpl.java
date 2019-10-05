package com.webstack.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webstack.dao.CourseDAO;
import com.webstack.dto.CourseDTO;
import com.webstack.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDAO courseDAO;

	public List<CourseDTO> list() {
		List<CourseDTO> list = courseDAO.getCourseList();

		return list;
	}
	
	

	public int save(CourseDTO courseDTO) {
		int result = courseDAO.save(courseDTO);
		return result;
	}



	public CourseDTO getById(Long id) {
		CourseDTO courseDTO = courseDAO.getById(id);
		return courseDTO;
	}

}
