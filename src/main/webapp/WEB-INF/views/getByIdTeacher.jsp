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
<table style="font-size: 30px" align="center" border="2px">
    <thead>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>age</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${get.id}</td>
        <td>${get.name}</td>
        <td>${get.age}</td>
    </tr>
    </tbody>
</table>
<a style="color: black" href="/c">roll back</a><br>
<a style="color: black" href="/">main</a>
</body>
</html>