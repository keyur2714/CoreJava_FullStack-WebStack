package com.keyur.service.impl;

import java.util.List;

import com.keyur.dao.StudentDAO;
import com.keyur.dao.impl.StudentDAOImpl;
import com.keyur.dto.StudentDTO;
import com.keyur.service.StudentService;

public class StudentServiceImpl implements StudentService {

	StudentDAO studentDAO = new StudentDAOImpl();

	@Override
	public int save(StudentDTO studentDTO) {
		return studentDAO.save(studentDTO);
	}

	@Override
	public int update(StudentDTO studentDTO) {
		return studentDAO.update(studentDTO);
	}

	@Override
	public void delete(int id) {
		studentDAO.delete(id);
	}

	@Override
	public StudentDTO get(int id) {
		return studentDAO.get(id);
	}

	@Override
	public List<StudentDTO> list() {
		return studentDAO.list();
	}

	@Override
	public void displayStudentInfo(List<StudentDTO> studentList) {
		for(StudentDTO studentDTO : studentList) {
			System.out.println(studentDTO.getId()+" "+studentDTO.getName()+" "+studentDTO.getCity()+" "+studentDTO.getMobileNo());
		}
	}

}
