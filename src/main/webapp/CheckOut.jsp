<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% int price=(Integer)session.getAttribute("Price"); %>
<c:set var="price" value="${price}"></c:set>
<form action="confirm">
<table>
<tr><td>Enter User Email</td><td><input type="email" name="mail"></td></tr>
<tr><td>Enter Product Id</td><td><input type="text" name="id"></td></tr>
<tr><td>Enter Shipping Address</td><td><textarea name="add" rows="10" cols="50"></textarea></td></tr>
<tr><td>
<p>Total Price is = </P></td><td><input type="number" value=<%=price%> name="price"></td></tr>
</table><br>
<input type="submit" value="confirm">
</form>
</body>
</html>