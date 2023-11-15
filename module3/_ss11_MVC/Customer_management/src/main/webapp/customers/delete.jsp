<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 11/3/2023
  Time: 8:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Delete</h1>
<%-- niu ko co action thi se tro vao` URL hien tai --%>
<form method="post">
    <table>
        <tr>
            <td>Name :</td>
            <td>${requestScope["customer"].name}</td>
        </tr>
        <tr>
            <td>Email :</td>
            <td>${requestScope["customer"].email}</td>
        </tr>
        <tr>
            <td>Address :</td>
            <td>${requestScope["customer"].address}</td>
        </tr>
        <tr>
            <td><input type="submit" value="delete"></td>
        </tr>
    </table>
</form>
</body>
</html>
