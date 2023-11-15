<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 11/8/2023
  Time: 9:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Create Product Form</h1>

<form action="/product?action=create" method="post"></form>
<table>
    <tr>
        <td>Id</td>
        <td><input type="text" placeholder="Id"></td>
    </tr>

    <tr>
      <td>Name</td>
      <td><input type="text" placeholder="name"></td>
    </tr>

    <tr>
      <td>Manufacture</td>
      <td><input type="text" placeholder="manufacture"></td>
    </tr>

    <tr>
      <td>Price</td>
      <td><input type="text" placeholder="price"></td>
    </tr>

    <tr>
      <td>Amount</td>
      <td><input type="text" placeholder="amount"></td>
    </tr>

</table>
</body>
</html>
