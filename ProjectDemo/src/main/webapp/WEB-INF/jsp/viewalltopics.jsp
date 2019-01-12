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
			<th>Topic Id</th>
			<th>Topic Name</th>
			<th>Course Id</th>
			<th>Edit</th>
			<th>Delete</th>
			<th>Add Sub-Topics</th>
		</tr>
		<c:forEach var="t" items="${topics}">
			<tr>
				<td>${t.getTopic_id()}</td>
				<td>${t.getTopic_name()}</td>
				<td>${t.getCourse_id()}</td>
				<td><a href="edit_topic/${t.getTopic_id()}">edit</a></td>
				<td><a href="delete_topic/${t.getTopic_id()}">delete</a>
				<td><a href="add_sub_topic/${t.getTopic_id()}">add_sub_topics</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>