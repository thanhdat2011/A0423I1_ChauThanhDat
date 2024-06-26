<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 11/26/2023
  Time: 12:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        h1,h2 {
            text-align: center;
        }
        a{
            color: white;
            text-decoration: none;
        }
    </style>
</head>
<body>

<h1>Library</h1>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">

        <%--        <a class="navbar-brand" href="#">Navbar</a>--%>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                <li class="nav-item">
                    <a class="nav-link" href="/books">Home</a>
                </li>

<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link" href="/books?action=create">Add User</a>--%>
<%--                </li>--%>

                <li class="nav-item">
                    <a class="nav-link" href="/books?action=studentList">Rent List</a>
                </li>

            </ul>

            <form class="d-flex" action="/users?action=search" method="post">
                <input class="form-control me-2" type="search" name="country" placeholder="Search By Country" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>

        </div>
    </div>
</nav>

<h2><a href="/books"></a>Rent list</h2>
<table class="table table-hover">
    <thead>
    <tr>
        <th>Card Id</th>
        <th>Book Name</th>
        <th>Book Author</th>
        <th>Student Name</th>
        <th>Student Class</th>
        <th>Rent Date</th>
        <th>Return Date</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.bookId}</td>
            <td>${student.bookName}</td>
            <td>${student.bookAuthor}</td>
            <td>${student.studentName}</td>
            <td>${student.studentClass}</td>
            <td>${student.rentDate}</td>
            <td>${student.returnDate}</td>
        </tr>
    </c:forEach>
    </tbody>

</table>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</html>
