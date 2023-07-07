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
<form action="/chi-tiet-sp/add" method="post" class="container">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Năm Bảo Hành</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="namBH"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Mô Tả</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="moTa"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Số Lượng Tồn</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="soLuongTon"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Giá Nhập</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="giaNhap"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Giá Bán</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="giaBan"><br>
        </div>
    </div>
    <button type="submit">Them</button>
</form>
<table class="table container">
    <thead>
    <tr>
        <td>NamBh</td>
        <td>Mo Ta</td>
        <td>So Luong Ton</td>
        <td>Gia Nhap</td>
        <td>Gia Ban</td>
        <td>Action</td>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listchitietsp}" var="l">
        <tr>
            <td>${l.namBh}</td>
            <td>${l.moTa}</td>
            <td>${l.soLuongTon}</td>
            <td>${l.giaNhap}</td>
            <td>${l.giaBan}</td>


            <td>
                <a href="/chi-tiet-sp/detail?id=${l.id}">DETAIL</a>
                <a href="/chi-tiet-sp/delete?id=${l.id}">DELETE</a>
            </td>

        </tr>

    </c:forEach>

    </tbody>
</table>
</body>
</html>
