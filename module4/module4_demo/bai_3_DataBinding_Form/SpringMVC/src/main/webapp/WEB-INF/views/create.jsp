
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 29/12/2023
  Time: 6:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<form:form modelAttribute="student" action="/student/add" method="post">
    ID: <form:input type="number" path="id" />
    Name: <form:input type="text" path="name" />
    Gender:
    <form:radiobutton path="gender" value="1" /> Nam
    <form:radiobutton path="gender" value="0" /> Nữ
    Languages:
<%--    <form:checkboxes path="languages" items="${listLanguage}" />--%>
    <form:select path="languages" multiple="${false}">
        <form:options items="${listLanguage}"/>
    </form:select>
    <input type="submit" value="Submit">
</form:form>


</body>
</html>
