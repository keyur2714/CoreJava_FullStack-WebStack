package com.keyur.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.keyur.dao.OrderDAO;
import com.keyur.dto.OrderDTO;
import com.keyur.util.DbConnectionUti;

public class OrderDAOImpl implements OrderDAO{

	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	String query;
	long result = 0;
		
	@Override
	public long save(OrderDTO orderDTO) throws SQLException {
		query = "insert into order_details (order_date,total_price) values (?,?)";
		int paramCnt = 1;
		try {
			connection = DbConnectionUti.getConnection();
			preparedStatement = connection.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.clearParameters();
			preparedStatement.setDate(paramCnt++, orderDTO.getOrderDate());
			preparedStatement.setDouble(paramCnt++, 0);
			result = preparedStatement.executeUpdate();
			ResultSet rs = preparedStatement.getGeneratedKeys();
			if (rs.next()) {
				result = rs.getLong(1);
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			closePreparedStatement();
		}

		return result;		
	}

	@Override
	public int update(OrderDTO orderDTO) throws SQLException {
		query = "update order_details set total_price = ? where order_id = ?";
		int paramCnt = 1;
		int result = 0;
		try {
			connection = DbConnectionUti.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.clearParameters();
			preparedStatement.setDouble(paramCnt++, orderDTO.getTotalPrice());
			preparedStatement.setInt(paramCnt++, orderDTO.getOrderId());
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public OrderDTO get(int id) throws SQLException {
		query = "select * from order_details where order_id = ?";
		int paramCnt = 1;
		OrderDTO orderDTO = null;
		try {
			connection = DbConnectionUti.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.clearParameters();
			preparedStatement.setInt(paramCnt++, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				orderDTO = new OrderDTO();
				orderDTO.setOrderId(resultSet.getInt(1));
				orderDTO.setOrderDate(resultSet.getDate(2));
				orderDTO.setTotalPrice(resultSet.getDouble(3));				
			}			
		} catch (SQLException e) {
			throw e;
		} finally {
			closeResultSet();
			closePreparedStatement();
		}
		return orderDTO;
	}

	@Override
	public List<OrderDTO> list() throws SQLException {
		query = "select order_id,order_date,total_price from order_details";		
		List<OrderDTO> orderList = new ArrayList<OrderDTO>();
		OrderDTO orderDTO = null;
		try {
			connection = DbConnectionUti.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.clearParameters();			
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				orderDTO = new OrderDTO();
				orderDTO.setOrderId(resultSet.getInt(1));
				orderDTO.setOrderDate(resultSet.getDate(2));
				orderDTO.setTotalPrice(resultSet.getDouble(3));
				orderList.add(orderDTO);
			}			
		} catch (SQLException e) {
			throw e;
		} finally {
			closeResultSet();
			closePreparedStatement();
		}
		return orderList;
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
