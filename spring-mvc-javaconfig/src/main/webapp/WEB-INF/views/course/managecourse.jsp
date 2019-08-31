<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ page isELIgnored="false" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Manage Course</title>
</head>
<body>
	<div class="container">
		<table class="table table-bordered text-white">
		<tr>
			<th>Id</th>
			<th>Course Name</th>
			<th>Fees</th>
			<th>Trainer Name</th>
		</tr>
		<c:forEach var="course" items="${courseList}">
			<tr>
				<td>${course.id}</td>
				<td>${course.courseName}</td>
				<td>${course.fees}</td>
				<td>${course.trainerName}</td>
			</tr>
		</c:forEach>		
	</table>
		
	</div>
	
</body>
</html>