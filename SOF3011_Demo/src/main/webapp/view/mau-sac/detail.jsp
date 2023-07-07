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
<form action="/mau-sac/update?id=${mauSac.id}" method="post" class="container">

    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Mã</label>
        <div class="col-sm-10">
            <input value="${mauSac.ma}" class="form-control" type="text" name="ma"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Tên</label>
        <div class="col-sm-10">
            <input value="${mauSac.ten}" class="form-control" type="text" name="ten"><br>
        </div>
    </div>
    <button type="submit">Sửa</button>
</form>
</body>
</html>
