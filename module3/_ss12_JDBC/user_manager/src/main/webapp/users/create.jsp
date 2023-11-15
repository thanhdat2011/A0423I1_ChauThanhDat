<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 11/9/2023
  Time: 9:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Create User</h1>
<form method="post">
    <table>
<%--        <tr>--%>
<%--            <td>--%>
<%--            <label>Id</label>--%>
<%--            <input type="text" name="id" placeholder="Id">--%>
<%--            </td>--%>
<%--        </tr>--%>

        <tr>
            <td>
                <label>Name</label>
                <input type="text" name="name" placeholder="Name">
            </td>
        </tr>

        <tr>
            <td>
            <label>Email</label>
            <input type="text" name="email" placeholder="Email">
            </td>
        </tr>


        <tr>
            <td>
            <label>Country</label>
            <input type="text" name="country" placeholder="Country">
            </td>
        </tr>

        <tr>
            <td><button type="submit">Create</button></td>
        </tr>
    </table>
</form>
</body>
</html>
