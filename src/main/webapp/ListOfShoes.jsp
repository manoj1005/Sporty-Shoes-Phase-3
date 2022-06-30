<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1 style="color:blue"><%out.print("Welcome "+request.getAttribute("Name")+" !");%></h1>
<table align="center" border="1">
<tr><td>
<form action="getall">
<input type="submit" value="All Available Shoes"> </td></tr><tr><td>
</form>

<a href="Runall.jsp">All Running Shoes</a></td></tr><tr><td>
<a href="CasAll.jsp">All Casual Shoes</a></td></tr><tr><td>
<a href="SportAll.jsp">All Sport Shoes</a></td></tr>
</table>
<table>
<tr><td>
<a href="Logout.jsp">Logout</a></td></tr><tr><td>
<a href="Changepwd.jsp">Change Password Here...</a></td></tr>
</table>
</body>
</html>