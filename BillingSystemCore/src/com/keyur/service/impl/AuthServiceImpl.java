package com.keyur.service.impl;

import java.sql.SQLException;
import java.util.Base64;

import com.keyur.dao.AuthDAO;
import com.keyur.dao.impl.AuthDAOImpl;
import com.keyur.dto.UserDTO;
import com.keyur.service.AuthService;

public class AuthServiceImpl implements AuthService {

	AuthDAO authDAO = new AuthDAOImpl();

	@Override
	public UserDTO authenticate(String username, String password) throws SQLException {
		try {
			return authDAO.authenticate(username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw e;
		}
	}

	@Override
	public String encrypt(String str) {
		String encodedString = Base64.getEncoder().encodeToString(str.getBytes());
		return encodedString;
	}

}
