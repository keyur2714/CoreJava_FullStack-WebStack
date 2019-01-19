package com.bs.action;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.keyur.dto.ItemDTO;
import com.keyur.dto.OrderDTO;
import com.keyur.dto.OrderItemDTO;
import com.keyur.service.ItemService;
import com.keyur.service.OrderService;
import com.keyur.service.impl.ItemServiceImpl;
import com.keyur.service.impl.OrderServiceImpl;
@WebServlet("/OrderController")
public class OrderController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	HttpSession session = null;
	ItemDTO itemDTO = null;
	OrderItemDTO orderItemDTO = null;
	RequestDispatcher requestDispatcher = null;
	
	List<OrderItemDTO> orderItemList = null;
	List<ItemDTO> itemList = new ArrayList<ItemDTO>();
	ItemService itemService = new ItemServiceImpl();
	OrderService orderService = new OrderServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();
		String successPage = "item/list_jstl.jsp";
		String action = request.getParameter("action");
		
		if("addItemToOrder".equalsIgnoreCase(action)) {
			System.out.println("OOOOOOOOOOOOOOOO");
			int itemId = Integer.parseInt(request.getParameter("itemId"));
			int qty = Integer.parseInt(request.getParameter("qty"));
			try {
				itemDTO = itemService.get(itemId);
				orderItemDTO = new OrderItemDTO();
				orderItemDTO.setItemId(itemId);
				orderItemDTO.setQuantity(qty);
				orderItemDTO.setUnitPrice(itemDTO.getUnitPrice());
				orderItemDTO.setItemCode(itemDTO.getCode());
				orderItemDTO.setItemDesc(itemDTO.getDescription());
				if(((ArrayList)session.getAttribute("orderItemList")) == null) {
					orderItemList = new ArrayList<>();
					orderItemList.add(orderItemDTO);	
				}else {
					orderItemList = (ArrayList)session.getAttribute("orderItemList");
					if(orderItemList != null) {
						orderItemList.add(orderItemDTO);						
					}	
				}
				session.setAttribute("orderItemList", orderItemList);														
			} catch (SQLException e) {
				e.printStackTrace();
			}						
		}else if("placeOrder".equalsIgnoreCase(action)) {
			orderItemList = (ArrayList)session.getAttribute("orderItemList");
			OrderDTO orderDTO = new OrderDTO();
			orderDTO.setOrderDate(new Date(System.currentTimeMillis()));
			int result = orderService.placeOrder(orderDTO, orderItemList);
			if(result == 0) {
				request.setAttribute("msg", "Order Placed Successfully.");
			}
		}
		requestDispatcher = request.getRequestDispatcher(successPage);
		requestDispatcher.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
}
