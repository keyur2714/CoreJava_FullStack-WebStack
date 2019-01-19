package com.keyur.service.impl;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.keyur.dao.OrderDAO;
import com.keyur.dao.OrderItemListDAO;
import com.keyur.dao.impl.OrderDAOImpl;
import com.keyur.dao.impl.OrderItemListDAOImpl;
import com.keyur.dto.ItemDTO;
import com.keyur.dto.OrderDTO;
import com.keyur.dto.OrderItemDTO;
import com.keyur.service.OrderService;

public class OrderServiceImpl implements OrderService {

	OrderDAO orderDAO = new OrderDAOImpl();
	OrderItemListDAO orderItemListDAO = new OrderItemListDAOImpl();
	
	
	
	@Override
	public int save(OrderDTO type) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(OrderDTO type) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public OrderDTO get(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDTO> list() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int placeOrder(OrderDTO orderDTO,List<OrderItemDTO> orderItemList) {
		int success = 0;
		try {
			long orderId = orderDAO.save(orderDTO);
			
			for(OrderItemDTO orderItem : orderItemList) {
				orderItem.setOrderId((int)orderId);
				orderItemListDAO.save(orderItem);
			}
		}catch(Exception e) {
			success = -1;
		}
		return success;
	}

}
