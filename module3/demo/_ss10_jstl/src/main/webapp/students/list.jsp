<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 10/30/2023
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<button><a href="/student?action=create">Create</a></button>
<h1>Danh sách học sinh <%= request.getAttribute("name")%>></h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Giới tính</th>
        <th>Điểm</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <c:if test="${student.gender == true}">
                <td>Nam</td>
            </c:if>
            <c:if test="${student.gender == false}">
                <td>Nữ</td>
            </c:if>
            <c:if test="${student.gender == null}">
                <td>Khác</td>
            </c:if>
            <c:choose>
                <c:when test="${student.point >8}">
                    <td>Giỏi</td>
                </c:when>
                <c:when test="${student.point > 6.5}">
                    <td>Khá</td>
                </c:when>
                <c:when test="${student.point > 5}">
                    <td>Trung bình</td>
                </c:when>
                <c:otherwise>
                    <td>Yếu</td>
                </c:otherwise>
            </c:choose>
        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>
