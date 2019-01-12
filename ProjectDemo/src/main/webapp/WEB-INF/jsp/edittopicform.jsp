<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="save_edit_topic" method="post">
		<table>
			<tr>
				<td></td>
				<td><input type="hidden" name="topic_id"
					value="${topic.getTopic_id()}"></td>

			</tr>
			<tr>
				<td>Course Name</td>
				<td><input type="text" name="topic_name"
					value="${topic.getTopic_name()}"></td>
			</tr>
			<tr>
			<td></td>
			<td><input type="hidden" name="course_id" value="${topic.getCourse_id()}"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="save-edit"></td>
			</tr>
		</table>
	</form>
</body>
</html>