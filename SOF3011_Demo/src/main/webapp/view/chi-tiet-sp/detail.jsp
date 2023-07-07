<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 29/3/2023
  Time: 7:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/chi-tiet-sp/update?id=${chiTietSp.id}" method="post" class="container">

    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Năm Bảo Hành</label>
        <div class="col-sm-10">
            <input value="${chiTietSp.namBh}" class="form-control" type="text" name="namBH"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Mô Tả</label>
        <div class="col-sm-10">
            <input value="${chiTietSp.moTa}" class="form-control" type="text" name="moTa"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Số Lượng Tồn</label>
        <div class="col-sm-10">
            <input value="${chiTietSp.soLuongTon}" class="form-control" type="text" name="soLuongTon"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Giá Nhập</label>
        <div class="col-sm-10">
            <input value="${chiTietSp.giaNhap}" class="form-control" type="text" name="giaNhap"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Giá Bán</label>
        <div class="col-sm-10">
            <input value="${chiTietSp.giaBan}" class="form-control" type="text" name="giaBan"><br>
        </div>
    </div>
    <button type="submit">Sửa</button>
</form>


</body>
</html>
