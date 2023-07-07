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
<form action="/nhan-vien/update?id=${nhanVien.id}" method="post" class="container">

    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Mã</label>
        <div class="col-sm-10">
            <input value="${nhanVien.ma}" class="form-control" type="text" name="ma"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Tên</label>
        <div class="col-sm-10">
            <input value="${nhanVien.ten}" class="form-control" type="text" name="ten"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Tên Đệm</label>
        <div class="col-sm-10">
            <input value="${nhanVien.tenDem}" class="form-control" type="text" name="tenDem"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Họ</label>
        <div class="col-sm-10">
            <input value="${nhanVien.ho}" class="form-control" type="text" name="ho"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Ngày Sinh</label>
        <div class="col-sm-10">
            <input value="${ngaySinh}" class="form-control" type="date" name="ngaySinh"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Địa CHỉ</label>
        <div class="col-sm-10">
            <input value="${nhanVien.diaChi}" class="form-control" type="text" name="diaChi"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">SĐT</label>
        <div class="col-sm-10">
            <input value="${nhanVien.sdt}" class="form-control" type="text" name="sdt"><br>
        </div>
    </div> <div class="form-group row">
        <label class="col-sm-2 col-form-label">Mật Khẩu</label>
        <div class="col-sm-10">
            <input value="${nhanVien.matKhau}" class="form-control" type="text" name="matKhau"><br>
        </div>
    </div> <div class="form-group row">
        <label class="col-sm-2 col-form-label">Trạng Thái</label>
        <div class="col-sm-10">
            <input value="${nhanVien.trangThai}" class="form-control" type="text" name="trangThai"><br>
        </div>
    </div>



    <button type="submit">Sửa</button>


</form>
</body>
</html>
