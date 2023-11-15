<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 11/9/2023
  Time: 11:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Edit User</h1>
<form method="post">
    <table>
    <tr>
        <td>
            <lable>Id</lable>
            <input type="text" disabled="disabled" value="${user.id}">
        </td>
    </tr>

    <tr>
        <td>
            <label>Name</label>
            <input type="text" name="name" value="${user.name}">
        </td>
    </tr>

    <tr>
        <td>
            <label>Email</label>
            <input type="text" name="email" value="${user.email}">
        </td>
    </tr>


    <tr>
        <td>
            <label>Country</label>
            <input type="text" name="country" value="${user.country}">
        </td>
    </tr>

    <tr>
        <td><button type="submit">Update</button></td>
    </tr>
    </table>
</form>
</body>
</html>
