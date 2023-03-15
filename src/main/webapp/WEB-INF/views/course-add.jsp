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
<body style="background: gold">
<h1 align="center" class="j">Save course</h1>
<form action="/saveCourse" method="post">
    <label>Name:</label><input type="text" name="name">
    <label>duration:</label><input type="text" name="duration">
    <input type="submit" value="save-course">
</form>
</body>
</html>