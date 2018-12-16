<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Billing System</title>
</head>
<body>
	<%
		String msg = (String)request.getAttribute("msg");
		Long currentTime = (Long)application.getAttribute("currentTime");
		String currentUser = (String)session.getAttribute("loggedInUser");
	%>
	<%= msg %>
	<%= new Date(currentTime) %>
	<%= currentUser %>
	
</body>
</html>