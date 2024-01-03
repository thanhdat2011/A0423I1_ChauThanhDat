<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 12/29/2023
  Time: 7:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<form method="post">
    <div>
        <input type="number" step="any" required name="num1">
        <input type="number" step="any" required name="num2">
        <input type="hidden" name="operator" id="operator">
    </div>

    <br>

    <div>
        <button type="submit" onclick="document.getElementById('operator').value = '+'"> Addition (+) </button>
        <button type="submit" onclick="document.getElementById('operator').value = '-'"> Subtraction (-)</button>
        <button type="submit" onclick="document.getElementById('operator').value = 'x'"> Multiplication (x)</button>
        <button type="submit" onclick="document.getElementById('operator').value = '/'"> Division (/) </button>
    </div>
</form>

<div>
<%--    Result : ${result}--%>
    ${result}
</div>
</body>
</html>
