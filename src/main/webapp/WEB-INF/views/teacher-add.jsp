<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 3/7/2023
  Time: 9:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>INSERT INTO COMPANY</title>
    <style>
        <%@include file="/WEB-INF/views/css/form.css" %>
    </style>

</head>
<body style="background: aquamarine">
<h1 align="center" class="j">Save teacher</h1>
<form action="/saveTeacher" method="post">
    <label>Name:</label><input type="text" name="name">
    <label>age:</label><input type="text" name="age">
    <c:forEach items="${connection}" var="course">
        <input type="radio" id="${course.id}" name="id" value="${course.id}">
        <label for="${course.id}">${course.name}</label>
    </c:forEach>
    <input type="submit" value="save-teacher">
</form>
</body>
</html>