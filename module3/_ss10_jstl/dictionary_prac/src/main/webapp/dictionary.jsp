<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="javafx.print.Printer" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 11/1/2023
  Time: 8:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple dictionary</title>
</head>
<body>
  <%
    Map<String, String> dic = new HashMap<>();
    dic.put("hello", "Xin chào");
    dic.put("how", "Thế nào");
    dic.put("book", "Quyển vở");
    dic.put("computer", "Máy tính");

    String search = request.getParameter("search");
    String res = dic.get(search);
    if (res != null){
      out.println("Word: " + search);
      out.println("Result: " + res);
    }
    else {
      out.println("Not found");
    }
  %>
</body>
</html>
