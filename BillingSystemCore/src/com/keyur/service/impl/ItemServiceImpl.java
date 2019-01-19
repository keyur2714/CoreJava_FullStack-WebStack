package com.keyur.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.keyur.dao.ItemDAO;
import com.keyur.dao.impl.ItemDAOImpl;
import com.keyur.dto.ItemDTO;
import com.keyur.service.ItemService;

public class ItemServiceImpl implements ItemService {

	ItemDAO studentDAO = new ItemDAOImpl();
	int result = 0;

	@Override
	public int save(ItemDTO studentDTO) throws SQLException {
		try {
			result = (int) studentDAO.save(studentDTO);
		} catch (SQLException e) {
			throw e;
		}
		return result;
	}

	@Override
	public int update(ItemDTO studentDTO) throws SQLException {
		try {
			result = studentDAO.update(studentDTO);
		} catch (SQLException e) {
			throw e;
		}
		return result;
	}

	@Override
	public void delete(int id) {
		try {
			studentDAO.delete(id);
		} catch (SQLException e) {
			try {
				throw e;
			} catch (SQLException e1) {
			}
		}
	}

	@Override
	public ItemDTO get(int id) throws SQLException {
		try {
			return studentDAO.get(id);
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<ItemDTO> list() throws SQLException {
		try {
			return studentDAO.list();
		} catch (SQLException e) {
			throw e;
		}
	}
}
