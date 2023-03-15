<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 3/7/2023
  Time: 5:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UPDATE COMPANY</title>
    <style>
        <%@include file="/WEB-INF/views/css/form.css" %>
    </style>
</head>
<body style="background: wheat">
<h2 style="color: #4CAF50" align="center">Update Company</h2>
<form action="/realTeacher/update/${update.id}" method="post">
    <label>Name:</label><input value="${update.name}" type="text" name="name">
    <label>age:</label><input value="${update.age}" type="text" name="age">
    <input type="submit" value="update-teacher">
</form>
</body>
</html>