
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 11/8/2023
  Time: 8:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Product Management</h1>

<a href="/product?action=create">Create Product</a>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${products}" >
      <tr>
          <td>${product.id}</td>
          <td>${product.name}</td>
          <td>
              <button><a href="/product?action=edit&id=${product.id}">Edit</a></button>
          </td>
      </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>
