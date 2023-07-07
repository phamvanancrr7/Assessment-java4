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
<form action="/nhan-vien/add" method="post" class="container">
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
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Tên Đệm</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="tenDem"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Họ</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="ho"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Giới tính</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="gioiTinh"><br>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Ngày Sinh</label>
        <div class="col-sm-10">
            <input class="form-control" type="date" name="ngaySinh"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Địa Chỉ</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="diaChi"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">SĐT</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="sdt"><br>
        </div>
    </div>


    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Mật Khẩu</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="matKhau"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Trạng Thái</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="trangThai"><br>
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
        <td>Ten Dem</td>
        <td>Ho</td>
        <td>Gioi Tinh</td>
        <td>Ngay Sinh</td>
        <td>Dia Chi</td>
        <td>Sdt</td>
        <td>Mat Khau</td>
        <td>Trang Thai</td>
        <td>Action</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listnhanvien}" var="l">
        <tr>
            <td>${l.id}</td>
            <td>${l.ma}</td>
            <td>${l.ten}</td>
            <td>${l.tenDem}</td>
            <td>${l.ho}</td>
            <td>${l.gioiTinh}</td>
            <td>${l.ngaySinh}</td>
            <td>${l.diaChi}</td>
            <td>${l.sdt}</td>


            <td>${l.matKhau}</td>
            <td>${l.trangThai}</td>
            <td>
                <a href="/nhan-vien/detail?id=${l.id}"> Detail</a>
                <a href="/nhan-vien/delete?id=${l.id}">DELETE</a>
            </td>

        </tr>

    </c:forEach>

    </tbody>
</table>
</body>
</html>
