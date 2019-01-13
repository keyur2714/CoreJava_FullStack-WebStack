package com.bs.action;

import java.io.IOException;
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
import com.keyur.service.ItemService;
import com.keyur.service.impl.ItemServiceImpl;


@WebServlet("/ManageItemController")
public class ManageItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ItemService itemService = new ItemServiceImpl();
	List<ItemDTO> itemList = new ArrayList<ItemDTO>();
	ItemDTO itemDTO = new ItemDTO();
	String errorMsg = "";
	RequestDispatcher requestDispatcher = null;
	HttpSession session = null;
       
    public ManageItemController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String successPage = "";
		session = request.getSession();
		if("list".equalsIgnoreCase(action)) {
			successPage = processListRequest(request, successPage);
		}else if("detail".equalsIgnoreCase(action)) {			
			successPage = processDetailRequest(request, successPage);			
		}
		requestDispatcher = request.getRequestDispatcher(successPage);
		requestDispatcher.forward(request, response);
	}

	private String processDetailRequest(HttpServletRequest request, String successPage) {
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			itemDTO = itemService.get(id);
			session.setAttribute("item", itemDTO);
			successPage = "item/list_jstl.jsp";
		} catch (SQLException e) {
			errorMsg = "Error in Get Item By Id:"+ e.getMessage();
			request.setAttribute("errorMsg", errorMsg);
		}
		return successPage;
	}

	private String processListRequest(HttpServletRequest request, String successPage) {
		try {
			itemList = itemService.list();
			session.setAttribute("itemList", itemList);
			successPage = "item/list_jstl.jsp";
		} catch (SQLException e) {
			errorMsg = "Error in Get Item List:"+ e.getMessage();
			request.setAttribute("errorMsg", errorMsg);
		}
		return successPage;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
