<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 12/29/2023
  Time: 8:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich</title>
</head>
<body>
<h1>Sandwich Condiment</h1>

<form action="/sandwich/list" method="post">
    <input type="checkbox" name="condiments" value="lettuce"> Lettuce
    <input type="checkbox" name="condiments" value="tomato"> Tomato
    <input type="checkbox" name="condiments" value="mustard"> Mustard
    <input type="checkbox" name="condiments" value="sprouts"> Sprouts
    <hr>
    <button type="submit">Save</button>
</form>


</body>
</html>
