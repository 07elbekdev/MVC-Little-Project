<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 3/15/2023
  Time: 9:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body style="background: yellow">
<h2 align="center" style="color: black">Company</h2>
<table style="background: gold ; color: blue; font-size: 20px" align="center" border="1px">
    <thead>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>locatedCountry</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${company.id}</td>
        <td>${company.name}</td>
        <td>${company.locatedCountry}</td>
    </tr>
    </tbody>
</table>
<h2 align="center" style="color: #f06060">Courses</h2>
<table style="color: black; background: palegreen" align="center" border="2px">
    <thead>
    <tr>
        <th>courseId</th>
        <th>courseName</th>
        <th>courseDuration</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${course}" var="courses">
        <tr>
            <td>${courses.id}</td>
            <td>${courses.name}</td>
            <td>${courses.duration}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<h2 style="color: black" align="center">Groups</h2>
<table style="color :black" align="center" border="2px">
    <thead>
    <tr>
        <th>groupId</th>
        <th>groupName</th>
        <th>StudentsAmount</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${groups}" var="gr">
        <tr>
            <td>${gr.id}</td>
            <td>${gr.name}</td>
            <td>${gr.studentsAmount}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<h2 style="color: sandybrown" align="center">Students</h2>
<table style="color: black" align="center" border="2px">
    <thead>
    <tr>
        <th>studentId</th>
        <th>studentName</th>
        <th>studentAge</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${student}" var="st">
        <tr>
            <td>${st.id}</td>
            <td>${st.name}</td>
            <td>${st.age}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<h2 style="color: lime" align="center">Teachers</h2>
<table style="color: black" align="center" border="2px">
    <thead>
    <tr>
        <th>teacherId</th>
        <th>teacherName</th>
        <th>teacherAge</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${teacher}" var="teach">
        <tr>
            <td>${teach.id}</td>
            <td>${teach.name}</td>
            <td>${teach.age}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</tr>
</tbody>
<a href="/get/by/${company.id}">roll back</a>
</body>
</html>