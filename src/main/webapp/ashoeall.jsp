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
<% List<Shoe> ss=(List<Shoe>)session.getAttribute("Shoes");%>
<table border="1" align="center">
<tr><th>S.No</th><th>Shoe Company</th><th>Shoe Category</th><th>Shoe Size</th><th>Shoe Price</th><th>Update</th><th>Delete</th></tr>
<% for(Shoe s:ss){%>
<tr><td><%= s.getId()%></td><td><%=s.getShoeComp()%></td><td><%=s.getCategory()%></td>
<td><%=s.getSize()%></td><td><%=s.getPrice()%></td>
<td><a href="editshoe.jsp">Update</a></td>
<td><a href="deleteshoe.jsp">Delete</a></td></tr>
<%}%>
</table>
<br><br>
<table align="center">
<tr><td>
<a href="Shoe.jsp">Insert More shoes</a></td></tr><tr><td>
<a href="Logout.jsp">Logout</a></td></tr>
</table>
</body>
</html>