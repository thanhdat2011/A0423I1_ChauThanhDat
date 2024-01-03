<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 12/29/2023
  Time: 12:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<h1>Dictionary</h1>
<div>
    <form method="post">
        <label>Search</label>
        <input type="text" name="search">
        <button>Submit</button>
    </form>
</div>

<div>
    Result : ${result}
</div>
</body>
</html>
