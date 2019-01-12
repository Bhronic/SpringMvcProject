<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="viewassignfaculty">view assign details</a>
	<form action="saveassignfaculty" method="post">
		<table>
			<tr>
				<td></td>
				<td><input type="hidden" value="${user.getUser_id()}" name="student_id"></td>
			</tr>
			<tr>
				<td>Student Name:</td>
				<td>${user.getName()}</td>
			</tr>
			<tr>
				<td>Select Faculty</td>
				<td><select name="faculty_id">
						<c:forEach var="f" items="${faculty}">
							<option value="${f.getUser_id()}">${f.getName()}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Select Course</td>
				<td><select name="course_id">
				<c:forEach var="crs" items="${course}">
				<option value="${crs.getCourse_id()}">${crs.getCourse_name()}</option>
				</c:forEach>
						
				</select></td>
			</tr>
			<tr><td colspan="2"><input type="submit" value="save"></td></tr>

		</table>
	</form>
</body>
</html>