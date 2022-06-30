<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="aregister">
<h1 style="color:red">Admin Registration</h1>
<table align="center">
<tr><td>
Admin_Name</td><td><input type="text" name="name"></td></tr>
<tr><td>
Admin_Mail_Id</td><td><input type="email" name="mail"></td></tr>
<tr><td>
Admin_Password</td><td><input type="password" name="pwd"></td></tr>
<tr><td>
<input type="submit" value="Admin Register"></td></tr>
</table>
<p> If Already registered-->Login Here   -  <p>
<a href="Alogin.jsp">Admin Login</a>
</form>
</body>
</html>