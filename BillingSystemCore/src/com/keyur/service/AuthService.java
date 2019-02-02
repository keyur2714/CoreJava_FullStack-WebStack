package com.keyur.service;

import java.sql.SQLException;

import com.keyur.dto.UserDTO;

public interface AuthService {
	UserDTO authenticate(String username,String password) throws SQLException;
	String encrypt(String str);
}
