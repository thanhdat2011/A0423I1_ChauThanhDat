<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 12/27/2023
  Time: 8:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exchange Currency</title>
</head>
<body>
<h1>Exchange currency</h1>
<div>
    <form action="/convert" method="post">
<%--    <form action="/convert">--%>
        <label>USD</label>
        <input type="text" name="usd">
        <button type="submit">submit</button>
    </form>
</div>

<div>
    VND : ${vnd}
</div>


</body>
</html>
