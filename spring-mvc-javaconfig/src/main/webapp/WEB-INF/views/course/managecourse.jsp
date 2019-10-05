<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ page isELIgnored="false" %>
<link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css"
        rel="stylesheet">
<title>Manage Course</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-4">
				<a href="/spring-mvc-javaconfig/courseCreate">Add</a>
			</div>
		</div>
		<table class="table table-bordered bg-warning text-white">
			<tr>
				<th>Id</th>
				<th>Course Name</th>
				<th>Fees</th>
				<th>Trainer Name</th>
				<th>Action</th>			
			</tr>
			<c:forEach var="course" items="${courseList}">
				<tr>
					<td>${course.courseId}</td>
					<td>${course.courseName}</td>
					<td>${course.fees}</td>
					<td>${course.trainerName}</td>
					<td><a href="/spring-mvc-javaconfig/courseEdit/${course.courseId}">Edit</a></td>
				</tr>
			</c:forEach>		
		</table>		
	</div>
	
</body>
</html>