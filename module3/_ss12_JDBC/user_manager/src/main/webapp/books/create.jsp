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

<%--<h1 style="text-align: center">Create User</h1>--%>

<form method="post" id="create-user">

    <h1 style="text-align: center">Rent Book</h1>

    <div class="row mb-3">
        <label for="inputCardCode" class="col-sm-2 col-form-label">Book Code</label>
        <div class="col-sm-10">
            <input type="text" pattern="^MS-[0-9]{4}$" title="Must start with MS- and follow by 4 digits" class="form-control is-invalid" name="cardID" id="inputCardCode" required>
        </div>
    </div>

    <div class="row mb-3">
        <label for="inputBookName" class="col-sm-2 col-form-label">Book Name</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" disabled name="bookName" id="inputBookName" value="${bookName}">
        </div>
    </div>

    <div class="row mb-3">
        <label for="inputStudentName" class="col-sm-2 col-form-label">Student Name</label>
        <div class="col-sm-10">
            <input type="text" class="form-control is-invalid" name="studentName" id="inputStudentName" required>
        </div>
    </div>

    <div class="row mb-3">
        <label for="inputStudentName" class="col-sm-2 col-form-label">Rent Date</label>
        <div class="col-sm-10">
            <input type="date" class="form-control" name="rentDate" id="inputRentDate" >
        </div>
    </div>

    <div class="row mb-3">
        <label for="inputReturnDate" class="col-sm-2 col-form-label">Rent Date</label>
        <div class="col-sm-10">
            <input type="date" class="form-control" name="returnDate" id="inputReturnDate" >
        </div>
    </div>

    <button type="submit" class="btn btn-primary">Rent</button>

</form>

<%--    java.util.Date date = new java.util.Date();
    java.sql.Date sqlDate = new java.sql.Date(date.getTime());  --%>

<%--    <input type="number" min="10" max="100" class="form-control is-invalid" name="name" id="inputName" required>    --%>

<%--    step: any -> double -> for price     --%>

<%--    pattern -> regex or maxlength
        <input type="text" pattern="^D.*$" class="form-control is-invalid" name="name" id="inputName" required>     --%>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</html>
