<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.shopapp.enitty.User" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/24/2024
  Time: 8:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<User> users = (List<User>) request.getAttribute("users");%>
<html>
<head>
    <title>User List</title>
</head>
<body>
<h1>User List</h1>
<a href="/users/create">Add new User</a>
<table>
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Email</td>
    </tr>
<%--    <% for (User user : users) { %>--%>
<%--    <td><%= user.getId() %></td>--%>
<%--    <td><%= user.getName() %></td>--%>
<%--    <td><%= user.getEmail() %></td>--%>
<%--    <%}%>--%>
   <c:forEach items="${user}" var="user">
       <tr>
            <td><c:out value="${user.id}"></c:out></td
            <td><c:out value="${user.name}"></c:out></td
            <td><c:out value="${user.email}"></c:out></td
            <td><c:out value="${user.role}"></c:out></td
            <td>
                <c:if test="${user.role} == 1">
                    <c:out value="Admin"/>
                </c:if>
                <c:if test="${user.role} == 2">
                    <c:out value="Customer"/>
                </c:if>
                <c:if test="${user.role} == 3">
                    <c:out value="End user"/>
                </c:if>
            </td
       </tr>
   </c:forEach>
</table>
</body>
</html>
