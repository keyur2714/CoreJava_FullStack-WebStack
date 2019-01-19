package com.keyur.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.keyur.dao.OrderItemListDAO;
import com.keyur.dto.OrderItemDTO;
import com.keyur.util.DbConnectionUti;

public class OrderItemListDAOImpl implements OrderItemListDAO {

	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	String query;
	int result = 0;
	
	
	@Override
	public long save(OrderItemDTO orderItemDTO) throws SQLException {
		query = "insert into order_item_list (order_id,item_id,quantity,price) values (?,?,?,?)";
		int paramCnt = 1;
		try {
			connection = DbConnectionUti.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.clearParameters();
			preparedStatement.setInt(paramCnt++, orderItemDTO.getOrderId());
			preparedStatement.setInt(paramCnt++, orderItemDTO.getItemId());
			preparedStatement.setInt(paramCnt++, orderItemDTO.getQuantity());
			preparedStatement.setDouble(paramCnt++, orderItemDTO.getUnitPrice());
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw e;
		} finally {
			closePreparedStatement();
		}

		return result;		
	}

	@Override
	public int update(OrderItemDTO type) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OrderItemDTO get(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderItemDTO> list() throws SQLException {
		// TODO Auto-generated method stub
		return null;
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
