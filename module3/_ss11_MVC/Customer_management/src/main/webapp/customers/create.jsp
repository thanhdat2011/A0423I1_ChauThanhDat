<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 11/3/2023
  Time: 6:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create Customer</title>
</head>
<body>
<p>
<c:if test='${requestScope["message"] != null}'>
    <span>${requestScope["message"]}</span>
</c:if>
</p>
<a href="/customers">Turn to home</a>
<form method="post" action="/customers?action=create">
    <table>
        <thead>
        <tr>
            <td>Name : </td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>Email : </td>
            <td><input type="text" name="email"></td>
        </tr>
        <tr>
            <td>Address : </td>
            <td><input type="text" name="address"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Create"></td>
        </tr>
        </thead>
    </table>
</form>
</body>
</html>
