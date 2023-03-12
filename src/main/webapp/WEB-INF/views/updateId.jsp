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
<body>
<h2>Update Company</h2>
<form  action="/real/update/${company.id}" method="post" >
    <label>Name:</label><input value="${company.name}" type="text" name="name">
    <label>locatedCountry:</label><input value="${company.locatedCountry}" type="text" name="locatedCountry">
    <input type="submit" value="update-company">
</form>
</body>
</html>