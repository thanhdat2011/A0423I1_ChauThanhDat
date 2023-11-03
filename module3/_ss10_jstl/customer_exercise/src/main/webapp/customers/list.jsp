<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 11/3/2023
  Time: 2:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>Title</title>
  </head>
  <body>

  <h1>Customer List<%request.getAttribute("admin");%></h1>
  <button><a href="/customer">Display List</a></button>
  <table>
      <thead>
      <tr>
          <th>Name</th>
          <th>Date of birth</th>
          <th>Address</th>
      </tr>
      </thead>

      <tbody>
      <c:forEach var="customer" items="${customers}">
          <tr>
              <td>${customer.name}</td>
              <td>${customer.dob}</td>
              <td>${customer.address}</td>
          </tr>
      </c:forEach>
      </tbody>
  </table>
  </body>
</html>

