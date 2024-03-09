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
<form action="/student?action=create" method="post">
    <label>Tên</label><input name="name" required>
    <label>Giới tính</label>
    <select name="gender">
        <option value="1">Nam</option>
        <option value="0">Nữ</option>
        <option value="null">Khác</option>
    </select>
    <label>Điểm</label><input name="point">
    <button type="submit">Create</button>

</form>
</body>
</html>
