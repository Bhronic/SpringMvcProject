<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="viewallusers">View Users</a>
	<h1>Registration</h1>
	<form action="saveuser" method="post">
		<table>
			<tr>
				<td>name</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>email</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>password</td>
				<td><input type="text" name="password"></td>
			</tr>
			<tr>
				<td>Date Of Birth</td>
				<td><input type="text" name="dob"></td>
			</tr>
			<tr>
				<td><label for="gender">Gender</label></td>
				<td><input type="radio" id="gender" name="gender" value="male" />Male   
				<input type="radio" id="gender" name="gender" value="female" />Female</td>
			</tr>
			<tr>
				<td>Contact No.</td>
				<td><input type="text" name="contact_no"></td>
			</tr>
			<tr>
				<td><label for="roles">roles</label></td>
				<td><input type="radio" id="roles" name="roles_id " value="1" />Admin
				<input type="radio" id="roles" name="roles_id" value="2" />Faculty
				<input type="radio" id="roles" name="roles_id" value="3" />Student</td>
			</tr>
			<tr>
			<td colspan="2" align="center"><input type="submit" value="save"></td>
			</tr>
		</table>
	</form>
	
</body>
</html>