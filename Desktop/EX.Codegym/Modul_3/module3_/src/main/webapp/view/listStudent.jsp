<%@ page import="java.util.Objects" %><%--
  Created by IntelliJ IDEA.
  User: ad
  Date: 29/11/2023
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/css/listStudent.css" />" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
</head>
<body>

<div id="update-s" class="container">

    <div class="title"><h2>Danh Sách Học Viên</h2></div>

    <ul class="nav nav-pills">
        <li class="nav-item">
            <a type="button" class="btn btn-success"  href="/student?action=addStudent" >Add Student</a>
        </li>
    </ul>
    <div class="col-md-6">
        <form action="/student?action=search" method="get">
            <div class="input-group">
                <input id="ip-search" type="text" name="keyword" value="<c:out value="${keyword}"/>" class="form-control rounded" placeholder="Search" aria-label="Search" aria-describedby="search-addon" />
                <button id="btn-search" type="submit" class="btn btn-outline-primary" data-mdb-ripple-init>Search</button>
            </div>
        </form>
    </div>
</div>

<div class="container">
    <table class="table table-dark table-striped">
        <thead>
        <tr>
            <th>#</th>
            <th>Name</th>
            <th>DateOfBirth</th>
            <th>Email</th>
            <th>Address</th>
            <th>Phone</th>
            <th >Classroom</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${students}" var="student">
            <tr>
                <td>${student.getId()}</td>
                <td>${student.getName()}</td>
                <td>${student.getDateOfBirth()}</td>
                <td>${student.getEmail()}</td>
                <td>${student.getAddress()}</td>
                <td>${student.getPhoneNumber()}</td>
                <td>${student.getClassroom()}</td>
                <td><a onclick="return confirm('Are you sure?')" href="${pageContext.request.contextPath}/student?action=delete&id=<c:out value="${student.getId()}"/>" class="btn btn-danger">Delete</a></td>
                <td><a href="${pageContext.request.contextPath}/student?action=update&id=<c:out value="${student.getId()}"/>" type="button" class="btn btn-warning">Update</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
</body>
</html>