<%--
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
  <title>Update</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</head>
<body>

<div class="container">
  <div class="col-12 col-md-12">
    <div class="card">
      <div class="card-header">
        Update Student
      </div>
      <div class="card-body">
        <form  method="post">
          <div class="mb-3">
            <input type="text" name="id" class="form-control" id="id" style="display: none;" value="${students.getId()}" aria-describedby="name">
          </div>
          <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Name</label>
            <input type="text" name="name" class="form-control" id=""  value="${students.getName()}" aria-describedby="name">
          </div>
          <div class="mb-3">
            <label for="" class="form-label">Date Of Birth</label>
            <input type="date" name="date" class="form-control" value="${students.getDateOfBirth()}" id="date" aria-describedby="password">
          </div>
          <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Email address</label>
            <input type="email" name="email" class="form-control" value="${students.getEmail()}" id="exampleInputEmail1" aria-describedby="emailHelp">
          </div>
          <div class="mb-3">
            <label for="" class="form-label">Address</label>
            <input type="text" name="address" value="${students.getAddress()}" class="form-control" id="address">
          </div>
          <div class="mb-3">
            <label for="" class="form-label">Phone</label>
            <input type="text" name="phone" value="${students.getPhoneNumber()}" class="form-control" id="phone">
          </div>
          <div class="mb-3">
            <label for="" class="form-label">Classroom</label>
            <select name="class"  id="class">
              <option <c:if test="${students.getClassroomId() == '1'}">selected</c:if> value="1">C0823H1</option>
              <option <c:if test="${students.getClassroomId() == '2'}">selected</c:if> value="2">C0723H1</option>
              <option <c:if test="${students.getClassroomId() == '3'}">selected</c:if> value="3">C0623H1</option>
            </select>
          </div>
          <button type="submit" class="btn btn-primary">Submit</button>
          <a href="/student" type="button" class="btn btn-danger">Cancel</a>
        </form>
      </div>
    </div>
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
</body>
</html>