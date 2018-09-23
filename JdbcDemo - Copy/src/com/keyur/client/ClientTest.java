package com.keyur.client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.keyur.util.DbConnectionUti;

public class ClientTest {

	public static void main(String[] args) {
		Connection connection = DbConnectionUti.getConnection();
		if(connection != null) {
			System.out.println("Connection Done Successfully...!");
		}
		
		String sql = "select * from student where name = ?";
		String insQuery = "insert into student (name,city,mobileNo) values (?,?,?)";
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "keyur");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.print(resultSet.getInt(1)+" ");
				System.out.print(resultSet.getString("name")+" ");
				System.out.print(resultSet.getString(3)+" ");
				System.out.println(resultSet.getString(4)+" ");
			}
			resultSet.close();
			preparedStatement.close();
			preparedStatement = connection.prepareStatement(insQuery);
			preparedStatement.setString(1, "Ami");
			preparedStatement.setString(2, "Bharuch");
			preparedStatement.setString(3, "8600712124");
			int result = preparedStatement.executeUpdate();
			if(result > 0) {
				System.out.println("Record Inserted Successfully...");
			}
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
 	}

}
