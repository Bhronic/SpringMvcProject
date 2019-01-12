<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>Course Id</th>
			<th>Course Name</th>
			<th>Add Topics</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="course" items="${course}">
			<tr>
				<td>${course.getCourse_id()}</td>
				<td>${course.getCourse_name()}</td>
				<td><a href="addtopic/${course.getCourse_id()}">add_topics</a></td>
				<td><a href="editcoursename/${course.getCourse_id()}">edit</a></td>
				<td><a href="deletecourse/${course.getCourse_id()}">delete</a>
			</tr>
		</c:forEach>
	</table>
</body>
</html>