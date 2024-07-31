<%@ page import="com.example.shopapp.enitty.Book" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/26/2024
  Time: 8:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% List<Book> books = (List<Book>) request.getAttribute("books");%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>DESCRIPTION</td>
        <td>PRICE</td>
        <td>CATEGORY</td>
    </tr>
    <c:set></c:set>
    <c:forEach items="${books}" var="book">
        <tr>
            <td><c:out value="${book.id}"></c:out></td
            <td><c:out value="${book.name}"></c:out></td
            <td><c:out value="${book.description}"></c:out></td
            <td><c:out value="${book.price}"></c:out></td
            <td><c:out value="${book.categoryId}"></c:out></td
        </tr>
    </c:forEach>
</table>
</body>
</html>
