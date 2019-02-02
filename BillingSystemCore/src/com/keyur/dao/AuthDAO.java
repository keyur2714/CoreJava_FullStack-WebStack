package com.keyur.dao;

import java.sql.SQLException;

import com.keyur.dto.UserDTO;

public interface AuthDAO {
	UserDTO authenticate(String username,String password) throws SQLException;	
}
