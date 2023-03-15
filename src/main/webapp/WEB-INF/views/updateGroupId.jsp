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
<body style="background: slategrey">
<h2  style="background: white" align="center">Update Group</h2>
<form action="/realGroup/update/${update.id}" method="post">
    <label>Name:</label><input value="${update.name}" type="text" name="name">
    <label>studentsAmount:</label><input value="${update.studentsAmount}" type="text" name="studentsAmount">
    <input type="submit" value="update-group">
</form>
</body>
</html>