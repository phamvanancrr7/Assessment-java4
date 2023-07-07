package com.example.sof3011_demo.db.servlet;

import com.example.sof3011_demo.db.entity.ChucVu;
import com.example.sof3011_demo.db.entity.CuaHang;

import com.example.sof3011_demo.db.repository.CuaHangRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "CuaHangServlet", value = {
        "/cua-hang/hien-thi",
        "/cua-hang/add",
        "/cua-hang/detail",
        "/cua-hang/update",
        "/cua-hang/delete"
})
public class CuaHangServlet extends HttpServlet {
    private CuaHangRepository cuaHangRepository = new CuaHangRepository();
    private UUID vitriUpdate = null;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/hien-thi")) {
            List<CuaHang> listch = CuaHangRepository.getAll();
            request.setAttribute("listcuahang", listch);
            request.getRequestDispatcher("/view/cua-hang/hien-thi.jsp").forward(request, response);
        } else if (uri.contains("/detail")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            CuaHang cuaHang = cuaHangRepository.getByID(id);
            request.setAttribute("cuaHang", cuaHang);
            request.getRequestDispatcher("/view/cua-hang/detail.jsp").forward(request, response);
        } else if (uri.contains("/delete")) {

            UUID id = UUID.fromString(request.getParameter("id"));
            CuaHang cuaHang = cuaHangRepository.getByID(id);
            System.out.println(cuaHangRepository.delete(cuaHang));

            response.sendRedirect("/cua-hang/hien-thi");

        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String diaChi=request.getParameter("diaChi");
            String thanhPho=request.getParameter("thanhPho");
            String quocGia=request.getParameter("quocGia");
            CuaHang cuaHang = new CuaHang();
            cuaHang.setMa(ma);
            cuaHang.setTen(ten);
            cuaHang.setDiaChi(diaChi);
            cuaHang.setThanhPho(thanhPho);
            cuaHang.setQuocGia(quocGia);
            cuaHangRepository.add(cuaHang);
            response.sendRedirect("/cua-hang/hien-thi");
        } else if (uri.contains("/update")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String diaChi=request.getParameter("diaChi");
            String thanhPho=request.getParameter("thanhPho");
            String quocGia=request.getParameter("quocGia");
            CuaHang cuaHang = new CuaHang();
            cuaHang.setId(UUID.fromString(request.getParameter("id")));
            cuaHang.setMa(ma);
            cuaHang.setTen(ten);
            cuaHang.setDiaChi(diaChi);
            cuaHang.setThanhPho(thanhPho);
            cuaHang.setQuocGia(quocGia);
            cuaHangRepository.update(cuaHang);
            response.sendRedirect("/cua-hang/hien-thi");
        }
    }

}
