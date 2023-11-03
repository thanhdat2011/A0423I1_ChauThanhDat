<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 10/30/2023
  Time: 8:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Display time</h1>
    <%
        Date today = new Date();
    %>
    <h2><%=today%></h2>
</body>
</html>
