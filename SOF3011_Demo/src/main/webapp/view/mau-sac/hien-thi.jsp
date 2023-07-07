<%--
  Created by IntelliJ IDEA.
  User: nguyenvv
  Date: 11/03/2023
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
          crossorigin="anonymous">
</head>
<body>
<form action="/mau-sac/add" method="post" class="container">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Mã</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="ma"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Tên</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="ten"><br>
        </div>
    </div>
    <button type="submit">Them</button>
</form>
<table class="table container">
    <thead>
    <tr>
        <td>id</td>
        <td>Ma</td>
        <td>Ten</td>
        <td>Action</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listmausac}" var="l">
        <tr>
            <td>${l.id}</td>
            <td>${l.ma}</td>
            <td>${l.ten}</td>

            <td>
                <button>  <a href="/mau-sac/detail?id=${l.id}">Detail</a></button>
                <button>  <a href="/mau-sac/delete?id=${l.id}">Delete</a></button>
            </td>

        </tr>

    </c:forEach>

    </tbody>
</table>
</body>
</html>
