package com.keyur.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionUti {

	static Connection connection = null;
	
	static {
		if(connection == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/1SepJava","root","admin");
			} catch (ClassNotFoundException | SQLException e) {				//
				//if(e instanceof SQLException)
				e.printStackTrace();
			}			
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}
	
}
