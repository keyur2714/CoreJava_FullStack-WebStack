package com.bs.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.keyur.dto.UserDTO;
import com.keyur.service.AuthService;
import com.keyur.service.impl.AuthServiceImpl;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    RequestDispatcher requestDispatcher = null;
    AuthService authService = new AuthServiceImpl();
    HttpSession session = null;
    
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String successPage = "auth/login.jsp";
		if("auth".equalsIgnoreCase(action)) {
			String userName = request.getParameter("username");
			String password = request.getParameter("password");
			String encodedPass = authService.encrypt(password);
			String errorMsg = "";
			try {
				UserDTO userDTO = authService.authenticate(userName, encodedPass);
				if(userDTO != null) {
					successPage = "home.jsp";
					session = request.getSession();
					session.setAttribute("user", userDTO);
				}else {
					errorMsg = "Invalid Username or password";
				}
			} catch (SQLException e) {
				e.printStackTrace();
				errorMsg = "Invalid Username or password";					
			}
			request.setAttribute("errorMsg", errorMsg);									
		}
		requestDispatcher = request.getRequestDispatcher(successPage);
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
