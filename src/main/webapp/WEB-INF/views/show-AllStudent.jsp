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
<body>
<h1 style="color: aqua" align="center">Student</h1>
<table>
    <thead>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>age</th>
        <th>studyFormat</th>
        <th>delete</th>
        <th>update</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${findAll}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>
                <a href="/get/by/${student.id}">,${student.name}</a>
            </td>
            <td>${student.age}</td>
            <td>${student.studyFormat}</td>
            <td>
                <form action="/delete/Student/${student.id}" method="get">
                    <button type="submit">DELETE</button>
                </form>
            </td>
            <td>
                <form action="/updateStudentBy/${student.id}" method="get">
                    <button type="submit">UPDATE</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/saveStudentForm">add-student</a>
<br>
<a href="/clearStudent">delete-all</a>
<br>
<a href="/g">roll back</a>
</body>
</html>