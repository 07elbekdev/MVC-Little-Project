<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 3/7/2023
  Time: 5:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style><%@include file="/WEB-INF/views/css/table.css"%></style>
</head>
<body>
<h1>My list</h1>
<table >
    <thead>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>age</th>
        <th>delete</th>
        <th>update</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${all}" var="company">
        <tr>
            <td>${comp.id}</td>
            <td>
                <a href="/get/by/${comp.id}">${comp.name}</a>
            </td>
            <td>${comp.age}</td>
            <td>
                <form action="/deleteStudent/${comp.id}" method="get">
                    <button type="submit">DELETE</button>
                </form>
            </td>
            <td>
                <form action="/update/${comp.id}" method="get">
                    <button type="submit">UPDATE</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/saveCompanyForm">add-company</a>
<br>
<a href="/clear">delete</a>
</body>
</html>