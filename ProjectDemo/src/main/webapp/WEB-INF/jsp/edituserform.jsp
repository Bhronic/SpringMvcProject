<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="editsave" method="post">
		<table>
		<tr>
		<td></td>
		<td><input type="hidden" name="user_id" value="${u.getUser_id()}" > </td>
		
		</tr>
			<tr>
				<td>name</td>
				<td><input type="text" name="name" value="${u.getName()}"></td>
			</tr>
			<tr>
				<td>email</td>
				<td><input type="text" name="email" value="${u.getEmail()}"></td>
			</tr>
			<tr>
				<td>password</td>
				<td><input type="text" name="password" value="${u.getPassword()}"></td>
			</tr>
			<tr>
				<td>Date Of Birth</td>
				<td><input type="text" name="dob" value="${u.getDob()}"></td>
			</tr>
			
			
			<c:set var="gender" value="${u.getGender()}"></c:set>
			<c:set var="male" value="male"></c:set>
			<c:set var="female" value="female"></c:set>
			
			<c:if test="${gender == male}">
			<tr>
				<td><label for="gender">Gender</label></td>
				<td><input type="radio" id="gender" name="gender" value="male" checked="checked"/>Male
				<input type="radio" id="gender" name="gender" value="female" />Female</td>
			</tr>
			</c:if>
			
			<c:if test="${gender == female}">
			<tr>
				<td><label for="gender">Gender</label></td>
				<td><input type="radio" id="gender" name="gender" value="male"/>Male
				<input type="radio" id="gender" name="gender" value="female" checked="checked"/>Female</td>
			</tr>
			</c:if>
			
			<tr>
				<td>Contact No.</td>
				<td><input type="text" name="contact_no" value="${u.getContact_no()}"></td>
			</tr>
			
			<c:set var="role" value="${u.getRoles_id()}"></c:set>
			<c:if test="${role == 1 }">
			<tr>
				<td><label for="roles">roles</label></td>
				<td><input type="radio" id="roles" name="roles_id " value="1" checked="checked"/>Admin
				<input type="radio" id="roles" name="roles_id" value="2" />Faculty
				<input type="radio" id="roles" name="roles_id" value="3" />Student</td>
			</tr>
			</c:if>
			
			<c:if test="${role == 2 }">
			<tr>
				<td><label for="roles">roles</label></td>
				<td><input type="radio" id="roles" name="roles_id " value="1" />Admin
				<input type="radio" id="roles" name="roles_id" value="2" checked="checked"/>Faculty
				<input type="radio" id="roles" name="roles_id" value="3" />Student</td>
			</tr>
			</c:if>
			
			<c:if test="${role == 3 }">
			<tr>
				<td><label for="roles">roles</label></td>
				<td><input type="radio" id="roles" name="roles_id " value="1" />Admin
				<input type="radio" id="roles" name="roles_id" value="2" />Faculty
				<input type="radio" id="roles" name="roles_id" value="3" checked="checked"/>Student</td>
			</tr>
			</c:if>
			
			<tr>
			<td colspan="2"><input type="submit" value="save-edit"></td>
			</tr>
		</table>
	</form>
</body>
</html>