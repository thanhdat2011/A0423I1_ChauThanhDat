
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 11/3/2023
  Time: 9:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Update</h1>

<p>
    <c:if test='${requestScope["message"] != null}'>
        <span>${requestScope["message"]}</span>
    </c:if>
</p>

<a href="/customers">Return to home</a>
<%-- niu ko co action thi se tro vao` URL hien tai --%>
<form method="post">
    <table>
        <tr>
            <td>Name :</td>
            <td><input type="text" name="name" value="${requestScope["customer"].name}"></td>
        </tr>
        <tr>
            <td>Email :</td>
            <td><input type="text" name="email" value="${requestScope["customer"].email}"></td>
        </tr>
        <tr>
            <td>Address :</td>
            <td><input type="text" name="address" value="${requestScope["customer"].address}"></td>
        </tr>
        <tr>
            <td><input type="submit" value="update"></td>
        </tr>
    </table>
</form>

</body>
</html>
