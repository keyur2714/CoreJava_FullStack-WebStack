package com.webstack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import com.webstack.dto.CourseDTO;
import com.webstack.service.CourseService;

@Controller
public class CourseController {

	@Autowired
	CourseService courseService;
	
	@GetMapping("/courseCreate")
	public String create() {		
		return "course/create";
	}
	
	@GetMapping("/courseList")
	public String list(Model model) {
		List<CourseDTO> courseList = courseService.list();
		model.addAttribute("courseList",courseList);
		return "course/managecourse";
	}
	
	@PostMapping("/courseSave")    
    public String save(@ModelAttribute("course") CourseDTO course){    
        System.out.println(course.getCourseName());
        courseService.save(course);
        return "redirect:/courseList";    
    }
	
	
	
	@PutMapping("/courseUpdate")    
    public String update(@ModelAttribute("course") CourseDTO course){    
        System.out.println(course.getCourseName());
        courseService.save(course);
        return "redirect:/courseList";    
    }
	
	@GetMapping("/courseEdit/{courseId}")
	public String edit(@PathVariable("courseId") Long courseId,Model model) {
		System.out.println(courseId);
		CourseDTO courseDTO = courseService.getById(courseId);
		System.out.println(courseDTO.getCourseName());
		model.addAttribute("course", courseDTO);
		return "course/edit";
	}
}
