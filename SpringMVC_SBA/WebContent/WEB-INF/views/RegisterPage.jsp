<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
</head>
<body>
	<h1>Register Page</h1>
	<form action="registerUser" method="post">
		<div>
			<label for="userName">Username:</label>
			<input name="userName">
		</div>
		<div>
			<label>Password:</label>
			<input type="password" name="password">
		</div>
		<div>
			<input type="submit" value="Submit" name="Submit">
			<input type="reset" value="Reset" name="Reset">
		</div>
	</form>
</body>
</html>