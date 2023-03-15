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
    <title>INSERT INTO Group</title>
    <style>
        <%@include file="/WEB-INF/views/css/form.css" %>
    </style>
</head>
<body style="background: sandybrown">
<h1 style="color: black" align="center" class="j">Save group</h1>
<form action="/saveGroup" method="post">
    <label>Name:</label><input type="text" name="name">
    <label>studentsAmount:</label><input type="text" name="StudentsAmount">
    <input type="submit" value="save-group">
</form>
</body>
</html>