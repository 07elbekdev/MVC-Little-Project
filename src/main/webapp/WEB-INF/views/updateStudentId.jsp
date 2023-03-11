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
    <title>Student update</title>
    <style>
        <%@include file="/WEB-INF/views/css/form.css" %>
    </style>
</head>
<body>
<h2>Update Student</h2>
<form action="/realStudent/update/${updates.id}" method="post">
    <label>Name:</label><input value="${updates.name}" type="text" name="name">
    <label>age:</label><input value="${updates.age}" type="text" name="age">
    <input type="submit" value="update-student">
</form>
</body>
</html>