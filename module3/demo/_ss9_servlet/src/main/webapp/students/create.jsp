<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 10/30/2023
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Thêm mới học sinh</h1>
<form action="/create" method="post">
    <label>Name</label><input name="name">
    <label>Age</label><input name="age">
    <label>Address</label><input name="address">
    <button type="submit">Create</button>

</form>
</body>
</html>
