<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
<title>!...Billing System...!</title>
	<%
		String str="keyur";
		out.println(str);
		String msg = (String)request.getAttribute("msg");
		Long currentTime = (Long)application.getAttribute("currentTime");
		String currentUser = (String)session.getAttribute("loggedInUser");
	%>

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col">
				<div class="card ">
		  			<div class="card-header bg-primary">Header</div>
		  			<div class="card-body bg-success">Content</div> 
		  			<div class="card-footer bg-danger">Footer</div>
				</div>
			</div>			
		</div>		
		<div class="row">
			<div class="col-md-6">
				<div class="alert alert-success">Request Msg: <%= msg %></div>		
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<div class="alert alert-warning">Application Msg: <%= new Date(currentTime) %></div>		
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<div class="alert alert-info">Session Msg: <%= currentUser %></div>		
			</div>
		</div>	
	</div>	
</body>
</html>