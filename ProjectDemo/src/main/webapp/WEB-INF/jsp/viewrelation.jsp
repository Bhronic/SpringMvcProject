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
			<th>sr_no</th>
			<th>Student Id</th>
			<th>Faculty Id</th>
			<th>Course Id</th>
		</tr>
		<c:forEach var="af" items="${faculty}">
			<tr>
				<td>${af.getSr_no()}</td>
				<td>${af.getStudent_id()}</td>
				<td>${af.getFaculty_id()}</td>
				<td>${af.getCourse_id()}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>