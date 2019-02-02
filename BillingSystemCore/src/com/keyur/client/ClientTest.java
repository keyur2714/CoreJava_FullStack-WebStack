package com.keyur.client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import com.keyur.util.DbConnectionUti;

public class ClientTest {

	public static void main(String[] args) {
		Connection connection = DbConnectionUti.getConnection();
		if(connection != null) {
			System.out.println("Connection Done Successfully...!");
		}
		
		String sql = "select * from item_details";
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		try {
			preparedStatement = connection.prepareStatement(sql);			
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.print(resultSet.getInt(1)+" ");
				System.out.print(resultSet.getString("code")+" ");
				System.out.print(resultSet.getString(3)+" ");
				System.out.println(resultSet.getDouble(4)+" ");
			}
			resultSet.close();
			preparedStatement.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Bharat@26
		String originalInput = "India@27";
		String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
		System.out.println(encodedString);
		
		byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
		String decodedString = new String(decodedBytes);
		
		System.out.println(decodedString);
 	}

}
