package com.keyur.service;

import java.util.List;

import com.keyur.dto.StudentDTO;

public interface StudentService {
	int save(StudentDTO studentDTO);
	int update(StudentDTO studentDTO);
	void delete(int id);
	StudentDTO get(int id);
	List<StudentDTO> list();
	void displayStudentInfo(List<StudentDTO> studentList);
}
