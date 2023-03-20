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
        <th>age</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${s.id}</td>
        <td>${s.name}</td>
        <td>${s.age}</td>
    </tr>
    </tbody>
</table>
<a href="/g">roll back</a>
</body>
</html>