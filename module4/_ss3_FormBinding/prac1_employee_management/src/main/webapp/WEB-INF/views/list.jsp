<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 1/3/2024
  Time: 9:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h1 style="text-align: center">Employee List</h1>

<h4><a style="text-decoration: none" href="/employee/showCreateForm">Create Employee</a></h4>
<span>${msg}</span>


<table class="table">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Contact Number</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${employeeList}" var="employee">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.name}</td>
            <td>${employee.contactNumber}</td>
            <td>
                <button><a style="text-decoration: none" href="/employee/showFormEdit/${employee.id}">Edit</a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<c:forEach items="employeeList" var="employee">

</c:forEach>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</html>
