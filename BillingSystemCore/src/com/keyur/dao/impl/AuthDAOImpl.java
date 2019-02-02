package com.keyur.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.keyur.dao.AuthDAO;
import com.keyur.dto.UserDTO;
import com.keyur.util.DbConnectionUti;

public class AuthDAOImpl implements AuthDAO {

	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	String query;
	long result = 0;

	@Override
	public UserDTO authenticate(String username, String password) throws SQLException {
		query = "select username,active_yn,role_cd from user_details where username = ? and password = ?";
		UserDTO userDTO = null;
		try {
			connection = DbConnectionUti.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.clearParameters();
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				userDTO = new UserDTO();
				userDTO.setUserName(resultSet.getString(1));
				userDTO.setActive(resultSet.getString(2).equalsIgnoreCase("Y") ? true : false);
				userDTO.setRoleCode(resultSet.getString(3));
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			closeResultSet();
			closePreparedStatement();
		}

		return userDTO;
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
