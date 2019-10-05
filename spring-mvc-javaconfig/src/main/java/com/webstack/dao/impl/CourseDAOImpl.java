package com.webstack.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webstack.dao.CourseDAO;
import com.webstack.dto.CourseDTO;

@Repository
public class CourseDAOImpl implements CourseDAO{

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Transactional
	public List<CourseDTO> getCourseList() {
		String sql="select * from course_master";
		return this.jdbcTemplate.query(sql, new BeanPropertyRowMapper(CourseDTO.class));
	}

	@Transactional
	public int save(CourseDTO course) {
		String sql="insert into course_master (course_name,fees,trainer_name) values (?,?,?)";
		return this.jdbcTemplate.update(sql, course.getCourseName(),course.getFees(),course.getTrainerName());
	}

	public CourseDTO getById(Long id) {
		String sql="select * from course_master where course_id = ?";
		
		Object params[] = new Object[1];
		params[0] = id;
		return this.jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(CourseDTO.class), params);
	}
}
