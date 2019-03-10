<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<h1>Login Page</h1>
	<p>${errorMessage}</p>
	<form action="loginUser" method="post">
		<div>
			<label>Username:</label>
			<input name="userName">
		</div>
		<div>
			<label>Password:</label>
			<input type="password" name="password">
		</div>
		<div>
			<input type="submit" value="Submit">
		</div>
	</form>
	<br></br>
	<a href="showRegisterUser">Register new user</a>
	
</body>
</html>