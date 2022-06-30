<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="edituser">
<table align="center" border="1">
<tr><td>
User_Id</td><td><input type="number" name="id"></td></tr><tr><td>
Update User First Name</td><td><input type="text" name="first"></td></tr><tr><td>
Update User Last Name</td><td><input type="text" name="last"></td></tr><tr><td>
Update User Email</td><td><input type="email" name="email"></td></tr><tr><td>
Update User Password</td><td><input type="password" name="pwd"></td></tr><tr><td>
</table>
<table align="center">
<tr><td>
<input type="submit" value="Update User Details"></td></tr>
</table>
</form>
</body>
</html>