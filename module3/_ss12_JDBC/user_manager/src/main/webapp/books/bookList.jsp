<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 11/8/2023
  Time: 7:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<h1>User Manager</h1>


<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">

<%--        <a class="navbar-brand" href="#">Navbar</a>--%>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                <li class="nav-item">
                    <a class="nav-link" href="/users">Home</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="/users?action=create">Add User</a>
                </li>


            </ul>

            <form class="d-flex" action="/users?action=search" method="post">
                <input class="form-control me-2" type="search" name="country" placeholder="Search By Country" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>

        </div>
    </div>
</nav>



<h2><a href="/books"></a>List all book</h2>
<table class="table table-hover">
    <thead>
    <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Author</th>
            <th>Amount</th>
            <th>Description</th>
            <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.id}</td>
            <td>${book.name}</td>
            <td>${book.author}</td>
            <td>${book.amount}</td>
            <td>${book.description}</td>
            <td>
                <button type="button" class="btn btn-danger"><a href="/books?action=create&id=${book.id}">Rent</a></button>

<%--                <button type="button" class="btn btn-danger" data-bs-toggle="modal"--%>
<%--                        data-bs-target="#delete${book.id}">--%>
<%--                    Rent--%>
<%--                </button>--%>

<%--                <form action="/users?action=create&id=${book.id}" method="post">--%>
<%--                    <div class="modal" id="delete${book.id}" tabindex="-1">--%>
<%--                        <div class="modal-dialog">--%>
<%--                            <div class="modal-content">--%>
<%--                                <div class="modal-header">--%>
<%--                                    <h5 class="modal-title">Delete</h5>--%>
<%--                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>--%>
<%--                                </div>--%>
<%--                                <div class="modal-body">--%>
<%--                                    <p>You want to delete user ${book.name}.</p>--%>
<%--                                </div>--%>
<%--                                <div class="modal-footer">--%>
<%--                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>--%>
<%--                                    <button type="submit" class="btn btn-primary">Delete</button>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </form>--%>

            </td>
        </tr>
    </c:forEach>
    </tbody>

</table>
</body>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</html>
