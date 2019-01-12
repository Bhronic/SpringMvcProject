<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="viewallcourse">view all courses</a>
<form action="save_course" method="post">
<table>
<tr>
<td>Enter Course Name </td>
<td><input type="text" name="course_name"></td>
</tr>
<tr><td colspan="2"><input type="submit" value="Save & add Topics"> </td></tr>
</table>
</form>
<jsp:include page="viewallcourse.jsp"></jsp:include>
</body>
</html>