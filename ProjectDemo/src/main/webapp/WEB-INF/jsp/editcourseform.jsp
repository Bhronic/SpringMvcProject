<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="saveeditcourse" method="post">
		<table>
			<tr>
				<td></td>
				<td><input type="hidden" name="user_id"
					value="${course.getCourse_id()}"></td>

			</tr>
			<tr>
				<td>Course Name</td>
				<td><input type="text" name="name"
					value="${course.getCourse_name()}"></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="save-edit"></td>
			</tr>
		</table>
	</form>
</body>
</html>