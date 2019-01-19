package com.keyur.dao;

import java.sql.SQLException;
import java.util.List;

import com.keyur.dto.ItemDTO;

public interface IDAO<T> {
	long save(T type) throws SQLException;

	int update(T type) throws SQLException;

	void delete(int id) throws SQLException;

	T get(int id) throws SQLException;

	List<T> list() throws SQLException;
}
