package com.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.dto.ProductDTO;
import com.demo.service.ProductService;
import com.demo.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/Product")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductService productService = new ProductServiceImpl();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		
		try {
			List<ProductDTO> productList = productService.list();
			productList.stream().forEach( p ->{ out.println(p); });
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	} 

}
