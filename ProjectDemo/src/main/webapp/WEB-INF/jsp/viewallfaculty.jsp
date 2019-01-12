<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
			<th>User id</th>
			<th>User Name</th>
			<th>Email</th>
			<th>Password</th>
			<th>Date Of Birth</th>
			<th>Gender</th>
			<th>Contact No</th>
			<th>roles_id</th>
			<th>Edit</th>
			<th>Delete</th>
			<th>view students</th>
		</tr>
		<c:forEach var="u" items="${user}">
			<tr>
				<td>${u.getUser_id()}</td>
				<td>${u.getName()}</td>
				<td>${u.getEmail()}</td>
				<td>${u.getPassword()}</td>
				<td>${u.getDob()}</td>
				<td>${u.getGender()}</td>
				<td>${u.getContact_no()}</td>
				<td>${u.getRoles_id()}</td>
				<td><a href="edituser/${u.getUser_id()}">edit</a></td>
				<td><a href="deleteuser/${u.getUser_id()}">delete</a></td>
				<td><a href="facultyandstudents/${u.getUser_id()}">view students</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
