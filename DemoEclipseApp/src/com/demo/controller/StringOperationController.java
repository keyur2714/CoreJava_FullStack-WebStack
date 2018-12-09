package com.demo.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.model.core.EnumConstant;

/**
 * Servlet implementation class StringOperationController
 */
@WebServlet("/StringOperation")
public class StringOperationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StringOperationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String requestHeader  = request
				.getHeader("Content-Length");
		
		PrintWriter out = response.getWriter();
		
		Enumeration<String> requestHeaders  = request.getHeaderNames();
		
		//InputStream inputStream = request.getInputStream();
		
//		Scanner scanner = new Scanner(inputStream);
//		out.println("Post Request Body :: via Input Stream:: "+scanner.nextLine());
		
		String str = request.getParameter("str");
		String revStr = new StringBuilder(str).reverse().toString();
		
				
		out.println("Request Header Length is: "+requestHeader);
		String headerKey = null; 
		while(requestHeaders.hasMoreElements()) {
			headerKey = requestHeaders.nextElement();
			out.println(headerKey+" == "+request.getHeader(headerKey));
		}
		
		
		out.println("Original String is: "+str);
		out.println("Reverse String is: "+str);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
