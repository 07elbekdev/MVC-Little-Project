<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<body style="background: cornflowerblue"><br><br><br><br>
<table style= "background: gold ; color: blue; font-size: 20px" align="center" border="1px">
    <thead>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>locatedCountry</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${comp.id}</td>
        <td>${comp.name}</td>
        <td>${comp.locatedCountry}</td>
    </tr>
    </tbody>
</table>
<a href="/showAllRelations/${comp.id}">show All the Relations</a><br>
<a style="color: black" href="/">roll-back</a>
</body>
</html>