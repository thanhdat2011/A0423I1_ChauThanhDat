<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 1/4/2024
  Time: 12:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Create Employee</h1>

<form:form modelAttribute="employee" action="/employee/add" method="post">
    ID: <form:input type="text" path="id"/>
    Name: <form:input type="text" path="name"/>
    Contact Number: <form:input type="text" path="contactNumber"/>
    <button type="submit">Submit</button>
</form:form>

</body>
</html>
