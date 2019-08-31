package com.webstack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.webstack.dto.CourseDTO;
import com.webstack.service.CourseService;

@Controller
public class CourseController {

	@Autowired
	CourseService courseService;
	
	@GetMapping("/courseList")
	public String list(Model model) {
		List<CourseDTO> courseList = courseService.list();
		model.addAttribute("courseList",courseList);
		return "course/managecourse";
	}
}
