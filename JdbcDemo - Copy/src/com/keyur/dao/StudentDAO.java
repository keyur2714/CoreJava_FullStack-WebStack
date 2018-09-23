package com.keyur.dao;

import java.util.List;

import com.keyur.dto.StudentDTO;

public interface StudentDAO {
	int save(StudentDTO studentDTO);
	int update(StudentDTO studentDTO);
	void delete(int id);
	StudentDTO get(int id);
	List<StudentDTO> list();
}
