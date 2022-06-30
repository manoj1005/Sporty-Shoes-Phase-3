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
<% List<User> ss=(List<User>)session.getAttribute("Users");%>
<table border="1" align="center">
<tr><th>S.No</th><th>First Name</th><th>Last Name</th><th>Mail Id</th><th>Password</th><th>Update</th><th>Delete</th></tr>
<% for(User s:ss){%>
<tr><td><%=s.getId()%></td><td><%=s.getFirstName()%></td><td><%=s.getLastName()%></td>
<td><%=s.getMailId()%></td><td><%=s.getPassword()%></td>
<td><a href="edituser.jsp">Update</a></td>
<td><a href="deleteuser.jsp">Delete</a></td></tr>
<%}%>
</table>

<a href="Logout.jsp">Logout</a>
</body>
</html>