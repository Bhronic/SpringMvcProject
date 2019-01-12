<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript">
			function selectAll(){
				var items=document.getElementsByName('student');
				for(var i=0; i<items.length; i++){
					if(items[i].type=='checkbox')
						items[i].checked=true;
				}
			}
			
			function UnSelectAll(){
				var items=document.getElementsByName('student');
				for(var i=0; i<items.length; i++){
					if(items[i].type=='checkbox')
						items[i].checked=false;
				}
			}			
		</script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Students under ${faculty.getName()}</h1>
	<table>
		<tr>
			<th>User id</th>
			<th>User Name</th>
			<th>Email</th>
			<th>Password</th>
			<th>Date Of Birth</th>
			<th>Gender</th>
			<th>Contact No</th>
			<th>roles_id</th>
		</tr>
		<c:forEach var="u" items="${students}">
			<tr>
				<td>${u.getUser_id()}</td>
				<td>${u.getName()}</td>
				<td>${u.getEmail()}</td>
				<td>${u.getPassword()}</td>
				<td>${u.getDob()}</td>
				<td>${u.getGender()}</td>
				<td>${u.getContact_no()}</td>
				<td>${u.getRoles_id()}</td>
			</tr>
		</c:forEach>
	</table>

	<form action="submitattendence" method="post">

		<c:forEach var="x" items="${students}">
			<input type="checkbox" name="student" value="${x.getUser_id()}">${x.getName()}<br>
		</c:forEach>
		
		<input type="button" onclick='selectAll()' value="Select All"/>
		<input type="button" onclick='UnSelectAll()' value="Unselect All"/><br>
		<input type="submit" value="submit">

	</form>
</body>
</html>
