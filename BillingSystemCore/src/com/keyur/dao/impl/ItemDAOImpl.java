package com.keyur.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.keyur.dao.ItemDAO;
import com.keyur.dto.ItemDTO;
import com.keyur.util.DbConnectionUti;

public class ItemDAOImpl implements ItemDAO {

	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	String query;
	int result = 0;

	@Override
	public long save(ItemDTO itemDTO) throws SQLException {
		query = "insert into item_details (code,description,price) values (?,?,?)";
		int paramCnt = 1;
		try {
			connection = DbConnectionUti.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.clearParameters();
			preparedStatement.setString(paramCnt++, itemDTO.getCode());
			preparedStatement.setString(paramCnt++, itemDTO.getDescription());
			preparedStatement.setDouble(paramCnt++, itemDTO.getUnitPrice());
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw e;
		} finally {
			closePreparedStatement();
		}

		return result;
	}

	@Override
	public int update(ItemDTO itemDTO) throws SQLException {
		query = "update item_details set description = ?,price = ? where id = ?";
		int paramCnt = 1;
		try {
			connection = DbConnectionUti.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.clearParameters();
			preparedStatement.setString(paramCnt++, itemDTO.getDescription());
			preparedStatement.setDouble(paramCnt++, itemDTO.getUnitPrice());
			preparedStatement.setInt(paramCnt++, itemDTO.getId());			
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
		query = "delete from item_details where id = ?";
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
	public ItemDTO get(int id) throws SQLException {
		query = "select * from item_details where id = ?";
		int paramCnt = 1;
		ItemDTO itemDTO = null;
		try {
			connection = DbConnectionUti.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.clearParameters();
			preparedStatement.setInt(paramCnt++, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				itemDTO = new ItemDTO();
				itemDTO.setId(resultSet.getInt(1));
				itemDTO.setCode(resultSet.getString(2));
				itemDTO.setDescription(resultSet.getString(3));
				itemDTO.setUnitPrice(resultSet.getDouble(4));
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			closeResultSet();
			closePreparedStatement();
		}
		return itemDTO;
	}

	@Override
	public List<ItemDTO> list() throws SQLException {
		query = "select * from item_details";		
		List<ItemDTO> itemList = new ArrayList<>();
		ItemDTO itemDTO = null;
		try {
			connection = DbConnectionUti.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.clearParameters();
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				itemDTO = new ItemDTO();
				itemDTO.setId(resultSet.getInt(1));
				itemDTO.setCode(resultSet.getString(2));
				itemDTO.setDescription(resultSet.getString(3));
				itemDTO.setUnitPrice(resultSet.getDouble(4));
				itemList.add(itemDTO);
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			closeResultSet();
			closePreparedStatement();
		}
		return itemList;
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
