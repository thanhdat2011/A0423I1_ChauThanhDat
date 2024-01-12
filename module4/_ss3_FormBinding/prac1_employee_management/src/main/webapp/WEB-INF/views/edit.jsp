<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 1/4/2024
  Time: 8:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Edit Employee</h1>

<%--<form:form modelAttribute="employee" name="employee" method="post">--%>
<%--    ID: <form:input type="text" path="id" value="${employee.id}" />--%>
<%--    Name: <form:input type="text" path="name" value="${employee.name}"/>--%>
<%--    Contact Number: <form:input type="text" path="contactNumber" value="${employee.contactNumber}"/>--%>
<%--    <button type="submit">Update</button>--%>
<%--</form:form>--%>

<form:form modelAttribute="employee" method="post">
    ID: <form:input type="text" path="id"/>
    Name: <form:input type="text" path="name"/>
    Contact Number: <form:input type="text" path="contactNumber"/>
    <button type="submit">Update</button>
</form:form>
</body>
</html>
