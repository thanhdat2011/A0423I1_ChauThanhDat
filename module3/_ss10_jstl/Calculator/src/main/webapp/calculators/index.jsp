<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 11/3/2023
  Time: 3:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Simple Calculator</h1>
<form method="post" action="/calculate">
    <label>First operand<input type="text" name="firstOp"></label><br>
    <label>Operator
    <select name="operator" id="calculateOptions">
        <option value="addition">addition</option>
        <option value="subtraction">subtraction</option>
        <option value="division">division</option>
        <option value="multiple">multiple</option>
    </select>
    </label><br>
    <label>Second operand<input type="text" name="secondOp"></label><br>
    <button>Calculate</button>
</form>

</body>
</html>
