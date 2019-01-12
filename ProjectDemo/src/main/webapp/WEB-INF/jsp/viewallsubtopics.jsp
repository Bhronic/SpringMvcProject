<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
		<tr>
			<th>Sub-Topic Id</th>
			<th>Sub-Topic Name</th>
			<th>Topic Id</th>
			<th>Edit</th>
			<th>Delete</th>
			
		</tr>
		<c:forEach var="st" items="${subtopic}">
			<tr>
				<td>${st.getSub_topic_id()}</td>
				<td>${st.getSub_topic_name()}</td>
				<td>${st.getTopic_id()}</td>
				<td><a href="edit_sub_topic/${st.getSub_topic_id()}">edit</a></td>
				<td><a href="delete_sub_topic/${st.getSub_topic_id()}">delete</a>
			</tr>
		</c:forEach>
	</table>
</body>
</html>