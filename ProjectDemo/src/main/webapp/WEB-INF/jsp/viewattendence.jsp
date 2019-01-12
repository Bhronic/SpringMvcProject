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
			<th>Attendence Id</th>
			<th>Student Id</th>
			<th>Date</th>
		</tr>
		<c:forEach var="x" items="${attendence}">
			<tr>
				<td>${x.getAtd_id()}</td>
				<td>${x.getStudent_id()}</td>
				<td>${x.getDate()}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>