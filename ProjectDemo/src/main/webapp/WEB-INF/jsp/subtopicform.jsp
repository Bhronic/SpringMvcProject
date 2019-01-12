<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
<h1>Topic Name : ${topic.getTopic_name()}</h1>
	<form action="save_sub_topic" method="post">
		<table>
			<tr>
				<td></td>
				<td><input type="hidden" name="topic_id"
					value="${topic.getTopic_id()}"></td>
			</tr>
			<tr>
				<td>Add Sub Topic</td>
				<td><input type="text" name="sub_topic_name"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="save"></td>

			</tr>


		</table>
	</form>

	<jsp:include page="viewallsubtopics.jsp"></jsp:include>

</body>
</html>