<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Course Name : ${course.getCourse_name()}</h1>
	<form action="save_topic" method="post">
		<table>
			<tr>
				<td></td>
				<td><input type="hidden" name="course_id"
					value="${course.getCourse_id()}"></td>
			</tr>
			<tr>
				<td>Add Topic</td>
				<td><input type="text" name="topic_name"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="save"></td>

			</tr>


		</table>
	</form>

	<jsp:include page="viewalltopics.jsp"></jsp:include>
</body>
</html>
