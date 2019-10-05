<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>	
	<link rel='stylesheet' href='<c:url value="/resources/css/style.css" />' type='text/css' media='all' />
	<link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css"
        rel="stylesheet"> 
</head>
<div class="container bg-dark text-white">
	<h2>Hello World, Spring MVC</h2>
	
	<p>Welcome, ${name}</p>
	
	<p>
		<a href="/spring-mvc-javaconfig/courseList">Manage Course</a>
	</p>
</div>
</html>