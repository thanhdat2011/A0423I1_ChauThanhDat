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

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        #create-user {
            width: 50%;
            border: 1px solid black;
            padding: 2%;
            margin: 50px auto auto auto;
        }
    </style>
</head>
<body>

<%--<h1>Edit User</h1>--%>

<form id="create-user" method="post">
    <h1 style="text-align: center">Edit User</h1>
    <div class="row mb-3">
        <label for="inputID" class="col-sm-2 col-form-label">Id</label>
        <div class="col-sm-10">
            <input type="text" disabled class="form-control" name="name" id="inputID" value="${user.id}">
        </div>
    </div>
    <div class="row mb-3">
        <label for="inputName" class="col-sm-2 col-form-label">Name</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="name" id="inputName" value="${user.name}">
        </div>
    </div>
    <div class="row mb-3">
        <label for="inputEmail" class="col-sm-2 col-form-label">Email</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="email" id="inputEmail" value="${user.email}">
        </div>
    </div>
    <div class="row mb-3">
        <label for="inputCountry" class="col-sm-2 col-form-label">Country</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="country" id="inputCountry" value="${user.country}">
        </div>
    </div>

    <button type="submit" class="btn btn-primary">Confirm Edit</button>
</form>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</html>
