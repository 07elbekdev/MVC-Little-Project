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
<body style="background: navajowhite">
<h1 style="color: darkorange" align="center">Course</h1>
<table>
    <thead>
    <tr>
        <th style="color: white">id</th>
        <th style="color: white">name</th>
        <th style="color: white">duration</th>
        <th style="color: white">Teacher</th>
        <th style="color: white">delete</th>
        <th style="color: white">update</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${findAll}" var="course">
        <tr>
            <td>${course.id}</td>
            <td>
                <a href="/getCourse/by/${course.id}">,${course.name}</a>
            </td>
            <td>${course.duration}</td>
            <td>
                <form action="/t" method="get">
                    <button type="submit">Teacher</button>
                </form>
            </td>
            <td>
                <form action="/delete/Course/${course.id}" method="get">
                    <button type="submit">DELETE</button>
                </form>
            </td>
            <td>
                <form action="/updateCourseBy/${course.id}" method="get">
                    <button type="submit">UPDATE</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/saveCourseForm">add-course</a>
<br>
<a href="/clearCourse">delete-all</a>
<br>
<a href="/">roll back</a>
</body>
</html>