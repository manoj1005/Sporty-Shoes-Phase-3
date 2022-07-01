<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ page import="com.example.demo.entity.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% List<Shoe> ss=(List<Shoe>)session.getAttribute("List");%>
<%String m=(String)session.getAttribute("mail");%>
<table border="1" align="center">
<tr><th>Shoe Id</th><th>Shoe Company</th><th>Shoe Category</th><th>Shoe Size</th><th>Shoe Price</th><th>Buy Now</th></tr>
<% for(Shoe s:ss){%>
<tr><td><%= s.getId()%></td><td><%=s.getShoeComp()%></td><td><%=s.getCategory()%></td>
<td><%=s.getSize()%></td><td><%=s.getPrice()%></td><td>
<a href="addtocart?id=<%= s.getId()%>">Buy Now</a>
</td></tr>
<%}%>
</table>
<table>
<tr><td>
<a href="Logout.jsp">Logout</a></td></tr><tr><td>
<a href="Changepwd.jsp">Change Password Here...</a></td></tr>
</table>
</body>
</html>