<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.util.*" %>
    <%@ page import="com.example.demo.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%Shoe s=(Shoe)session.getAttribute("List");%>
<table align="center" border="1">
<tr><th>Shoe Id</th><th>Shoe Company</th><th>Shoe Category</th><th>Shoe Size</th><th>Shoe Price</th><th>Action</th></tr>
<tr><td><%=s.getId()%><td><%=s.getShoeComp()%></td><td><%=s.getCategory() %></td><td><%=s.getSize()%></td><td><%=s.getPrice() %></td>
<td><a href="checkOut?price=<%=s.getPrice()%>">Check Out</a></td>
</table>
</body>
</html>