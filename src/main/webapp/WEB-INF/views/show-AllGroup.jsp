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
    <style>
        <%@include file="/WEB-INF/views/css/table.css" %>
    </style>
</head>
<body style="background: cyan">
<h1  style="color: black" align="center">Group</h1>
<table>
    <thead>
    <tr>
        <th style="color: white">id</th>
        <th style="color: white">name</th>
        <th style="color: white">studentsAmount</th>
        <th style="color: white">Student</th>
        <th style="color: white">delete</th>
        <th style="color: white">update</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${G}" var="group">
        <tr>
            <td>${group.id}</td>
            <td>
                <a href="/getGroupBy/${group.id}">,${group.name}</a>
            </td>
            <td>${group.studentsAmount}</td>
            <td>
                <form action="/s" method="get">
                    <button type="submit">Student</button>
                </form>
            </td>
            <td>
                <form action="/delete/Group/${group.id}" method="get">
                    <button type="submit">DELETE</button>
                </form>
            </td>
            <td>
                <form action="/updateGroupBy/${group.id}" method="get">
                    <button type="submit">UPDATE</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/saveGroupForm">add Groups</a>
<br>
<a href="/clearGroup">delete-all</a>
<br>
<a href="/">roll back</a>
</body>
</html>