<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 3/7/2023
  Time: 5:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1px">
    <thead>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>studentsAmount</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${group.id}</td>
        <td>${group.name}</td>
        <td>${group.studentsAmount}</td>
    </tr>
    </tbody>
</table>
<a href="/">Main</a>
</body>
</html>