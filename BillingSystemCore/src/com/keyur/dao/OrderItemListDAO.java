package com.keyur.dao;

import java.sql.SQLException;
import java.util.List;

import com.keyur.dto.OrderItemDTO;

public interface OrderItemListDAO extends IDAO<OrderItemDTO> {
	List<OrderItemDTO> getOrderItemListByOrderId(int orderId) throws SQLException;
}
