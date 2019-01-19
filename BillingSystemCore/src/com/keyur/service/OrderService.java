package com.keyur.service;

import java.util.List;

import com.keyur.dto.OrderDTO;
import com.keyur.dto.OrderItemDTO;

public interface OrderService extends IService<OrderDTO>{	
	int placeOrder(OrderDTO orderDTO,List<OrderItemDTO> orderItemList);
}
