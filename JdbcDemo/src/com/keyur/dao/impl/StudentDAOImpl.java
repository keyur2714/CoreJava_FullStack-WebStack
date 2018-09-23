package com.keyur.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.keyur.dao.StudentDAO;
import com.keyur.dto.StudentDTO;
import com.keyur.util.DbConnectionUti;

public class StudentDAOImpl implements StudentDAO {

	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	String query;
	int result = 0;

	@Override
	public int save(StudentDTO studentDTO) throws SQLException {
		query = "insert into student (name,city,mobileNo) values (?,?,?)";
		int paramCnt = 1;
		try {
			connection = DbConnectionUti.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.clearParameters();
			preparedStatement.setString(paramCnt++, studentDTO.getName());
			preparedStatement.setString(paramCnt++, studentDTO.getCity());
			preparedStatement.setString(paramCnt++, studentDTO.getMobileNo());
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw e;
		} finally {
			closePreparedStatement();
		}

		return result;
	}

	@Override
	public int update(StudentDTO studentDTO) throws SQLException {
		query = "update student set name = ?,city = ?,mobileNo = ? where id = ?";
		int paramCnt = 1;
		try {
			connection = DbConnectionUti.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.clearParameters();
			preparedStatement.setString(paramCnt++, studentDTO.getName());
			preparedStatement.setString(paramCnt++, studentDTO.getCity());
			preparedStatement.setString(paramCnt++, studentDTO.getMobileNo());
			preparedStatement.setInt(paramCnt++, studentDTO.getId());
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw e;
		} finally {
			closePreparedStatement();
		}

		return result;
	}

	@Override
	public void delete(int id) throws SQLException {
		query = "delete from student where id = ?";
		int paramCnt = 1;
		try {
			connection = DbConnectionUti.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.clearParameters();
			preparedStatement.setInt(paramCnt++, id);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw e;
		} finally {
			closePreparedStatement();
		}
	}

	@Override
	public StudentDTO get(int id) throws SQLException {
		query = "select * from student where id = ?";
		int paramCnt = 1;
		StudentDTO studentDTO = null;
		try {
			connection = DbConnectionUti.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.clearParameters();
			preparedStatement.setInt(paramCnt++, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				studentDTO = new StudentDTO();
				studentDTO.setId(resultSet.getInt(1));
				studentDTO.setName(resultSet.getString(2));
				studentDTO.setCity(resultSet.getString(3));
				studentDTO.setMobileNo(resultSet.getString(4));
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			closeResultSet();
			closePreparedStatement();
		}
		return studentDTO;
	}

	@Override
	public List<StudentDTO> list() throws SQLException {
		query = "select * from student";		
		List<StudentDTO> studentList = new ArrayList<>();
		StudentDTO studentDTO = null;
		try {
			connection = DbConnectionUti.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.clearParameters();
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				studentDTO = new StudentDTO();
				studentDTO.setId(resultSet.getInt(1));
				studentDTO.setName(resultSet.getString(2));
				studentDTO.setCity(resultSet.getString(3));
				studentDTO.setMobileNo(resultSet.getString(4));
				studentList.add(studentDTO);
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			closeResultSet();
			closePreparedStatement();
		}
		return studentList;
	}

	private void closePreparedStatement() {
		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private void closeResultSet() {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
