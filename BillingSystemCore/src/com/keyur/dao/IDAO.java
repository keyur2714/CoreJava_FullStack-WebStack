package com.keyur.dao;

import java.sql.SQLException;
import java.util.List;

import com.keyur.dto.ItemDTO;

public interface IDAO<T> {
	int save(T type) throws SQLException;

	int update(T type) throws SQLException;

	void delete(int id) throws SQLException;

	ItemDTO get(int id) throws SQLException;

	List<T> list() throws SQLException;
}
