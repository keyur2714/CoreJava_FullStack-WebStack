package com.keyur.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.keyur.dao.StudentDAO;
import com.keyur.dao.impl.StudentDAOImpl;
import com.keyur.dto.StudentDTO;
import com.keyur.service.StudentService;

public class StudentServiceImpl implements StudentService {

	StudentDAO studentDAO = new StudentDAOImpl();
	int result = 0;
	@Override
	public int save(StudentDTO studentDTO) throws SQLException {
		try {
			result = studentDAO.save(studentDTO);
		} catch (SQLException e) {
			throw e;
		}
		return result;
	}

	@Override
	public int update(StudentDTO studentDTO) throws SQLException {
		try {
			result = studentDAO.update(studentDTO);
		} catch (SQLException e) {
			throw e;
		}
		return result;
	}

	@Override
	public void delete(int id) {
		try {
			studentDAO.delete(id);
		} catch (SQLException e) {
			try {
				throw e;
			} catch (SQLException e1) {				
			}
		}
	}

	@Override
	public StudentDTO get(int id) throws SQLException {
		try {
			return studentDAO.get(id);
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<StudentDTO> list() throws SQLException {
		try {
			return studentDAO.list();
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public void displayStudentInfo(List<StudentDTO> studentList) {
		for(StudentDTO studentDTO : studentList) {
			System.out.println(studentDTO.getId()+" "+studentDTO.getName()+" "+studentDTO.getCity()+" "+studentDTO.getMobileNo());
		}
	}

}
