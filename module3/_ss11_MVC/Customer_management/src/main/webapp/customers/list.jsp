<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 11/3/2023
  Time: 6:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Customer Management</title>
    <style>
        table, td {
            border: 1px solid black;
            border-collapse: collapse;
            text-align: center;
            width: 40%;
        }
        button {
            border-radius: 10em;
        }
        td{
            width: fit-content;
        }
        a{
            text-decoration: none;
            color: blue;
        }
        a:hover{
            background: bisque;
        }

    </style>
</head>
<body>

<h1>Customer</h1>
<button><a href="/customers?action=create">Create new customer</a></button>
<br><br>
<table style="border: 1px solid black">
    <thead>
    <tr>
        <td>Name</td>
        <td>Email</td>
        <td>Address</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="customer" items="${customers}">
        <tr>
            <td><a href="/customers?action=view&id=${customer.getId()}">${customer.getName()}</a></td>
            <td>${customer.getEmail()}</td>
            <td>${customer.getAddress()}</td>
            <td><a href="/customers?action=edit&id=${customer.getId()}">edit</a></td>
            <td><a href="/customers?action=delete&id=${customer.getId()}">delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>


</body>
</html>
