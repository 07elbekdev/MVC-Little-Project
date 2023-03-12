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
<h1 style="color: slategrey" align="center">Hello Welcome to my Company !!!</h1>
<h1 style="color: gold" align="center">Here you add a company --> </h1>
<table>
    <thead>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>locatedCountry</th>
        <th>Course</th>
        <th>Group</th>
        <th>delete</th>
        <th>update</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${all}" var="company">
        <tr>
            <td>${company.id}</td>
            <td>
                <a href="/get/by/${company.id}">,${company.name}</a>
            </td>
            <td>${company.locatedCountry}</td>
            <td>
                <form action="/c" method="get">
                    <button type="submit">Course</button>
                </form>
            </td>
            <td>
                <form action="/g" method="get">
                    <button type="submit">Groups</button>
                </form>
            </td>
            <td>
                <form action="/delete/Company/${company.id}" method="get">
                    <button type="submit">DELETE</button>
                </form>
            </td>
            <td>
                <form action="/update/${company.id}" method="get">
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