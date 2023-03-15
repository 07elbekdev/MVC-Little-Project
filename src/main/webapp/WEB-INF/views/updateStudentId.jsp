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
<body style="background: silver">
<h2 style="color: dodgerblue" align="center">Update Student</h2>
<form action="/realStudent/update/${student.id}" method="post">
    <label>Name:</label><input value="${student.name}" type="text" name="name">
    <label>age:</label><input value="${student.age}" type="text" name="age">
    <label>studyFormat:</label><input value="${student.studyFormat}" type="text" name="studyFormat">
    <input type="submit" value="update-student">
</form>
</body>
</html>