package com.keyur.service;

import java.util.List;

import com.keyur.dto.StudentDTO;

public interface StudentService extends IService<StudentDTO> {

	void displayStudentInfo(List<StudentDTO> studentList);
}
