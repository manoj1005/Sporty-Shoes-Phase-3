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
<%List<Purchase> p=(List<Purchase>)session.getAttribute("List"); %>
<table border="1" align="center">
<tr><th>Purchase Id</th><th>Shoe Id</th><th>Shoe Company</th><th>Shoe Category</th><th>Shoe Size</th>
<th>User Id</th><th>User Mail Id</th><th>Amount</th></tr>
<%for(Purchase pp:p){ 
User u=pp.getUser();
Shoe s=pp.getShoe();%>
<tr><td><%=pp.getPurchaseId()%></td><td><%=s.getId()%></td><td><%=s.getShoeComp()%></td>
<td><%=s.getCategory()%></td><td><%=s.getSize()%></td><td><%=u.getId()%></td><td><%=u.getMailId()%></td>
<td><%=pp.getPrice()%></td></tr>
<%} %>
</table>
<a href="Logout.jsp">Logout</a>
</body>
</html>