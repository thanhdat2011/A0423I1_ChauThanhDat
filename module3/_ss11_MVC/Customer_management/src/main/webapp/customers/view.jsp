<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 11/6/2023
  Time: 8:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <style>
    table{
      border: 1px solid black;
    }
  </style>
</head>
<body>

<h1>Customer View</h1>
<table>
    <thead>
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Email</td>
        <td>Address</td>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${requestScope["customer"].id}</td>
        <td>${requestScope["customer"].name}</td>
        <td>${requestScope["customer"].email}</td>
        <td>${requestScope["customer"].address}</td>
    </tr>
    </tbody>
</table>
</body>
</html>
