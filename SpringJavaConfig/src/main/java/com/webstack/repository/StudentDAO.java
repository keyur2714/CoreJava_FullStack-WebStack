package com.webstack.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webstack.bean.Student;

@Repository
public class StudentDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Transactional
	public List<Student> list() {
		String sql="select * from student";
		return this.jdbcTemplate.query(sql, new BeanPropertyRowMapper(Student.class));
	}
	
	@Transactional
	public int save(Student student) {
		String sql="insert into student (name,city,mobileNo) values (?,?,?)";
		return this.jdbcTemplate.update(sql, student.getName(),student.getCity(),student.getMobileNo());
	}
	
	

	
}
