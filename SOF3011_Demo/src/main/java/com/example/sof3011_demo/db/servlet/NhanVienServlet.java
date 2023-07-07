package com.example.sof3011_demo.db.servlet;

import com.example.sof3011_demo.db.entity.KhachHang;
import com.example.sof3011_demo.db.entity.NhanVien;
import com.example.sof3011_demo.db.repository.NhanVienRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "NhanVienServlet", value = {
        "/nhan-vien/hien-thi",
        "/nhan-vien/add",
        "/nhan-vien/detail",
        "/nhan-vien/update",
        "/nhan-vien/delete"
})
public class NhanVienServlet extends HttpServlet {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private NhanVienRepository nhanVienRepository = new NhanVienRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/hien-thi")) {
            List<NhanVien> listNhanVien = nhanVienRepository.getAll();
            request.setAttribute("listnhanvien", listNhanVien);
            request.getRequestDispatcher("/view/Nhan-vien/hien-thi.jsp").forward(request, response);
        } else if (uri.contains("/detail")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            NhanVien nhanVien = nhanVienRepository.getByID(id);

            request.setAttribute("nhanVien", nhanVien);
            System.out.println(nhanVien.getNgaySinh());
            String ngaySinh = dateFormat.format(nhanVien.getNgaySinh());
            request.setAttribute("ngaySinh", ngaySinh);
            request.getRequestDispatcher("/view/Nhan-vien/detail.jsp").forward(request, response);


        } else if (uri.contains("/delete")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            NhanVien nhanVien = nhanVienRepository.getByID(id);
            nhanVienRepository.delete(nhanVien);
            response.sendRedirect("/nhan-vien/hien-thi");

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String tenDem = request.getParameter("tenDem");
            String ho = request.getParameter("ho");
            String gioiTinh = request.getParameter("gioiTinh");

            Date ngaySinh;
            try {
                ngaySinh = dateFormat.parse(request.getParameter("ngaySinh"));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            String diaChi = request.getParameter("diaChi");
            String sdt = request.getParameter("sdt");
            String matKhau = request.getParameter("matKhau");
            String trangThai = request.getParameter("trangThai");

            NhanVien nhanVien = new NhanVien();
            nhanVien.setMa(ma);
            nhanVien.setTen(ten);

            nhanVien.setTenDem(tenDem);
            nhanVien.setHo(ho);
            nhanVien.setGioiTinh(gioiTinh);

            nhanVien.setNgaySinh(ngaySinh);
            nhanVien.setDiaChi(diaChi);
            nhanVien.setSdt(sdt);
            nhanVien.setMatKhau(matKhau);
            nhanVien.setTrangThai(Integer.parseInt(trangThai));
            nhanVienRepository.add(nhanVien);
            response.sendRedirect("/nhan-vien/hien-thi");
        } else if (uri.contains("/update")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String tenDem = request.getParameter("tenDem");
            String ho = request.getParameter("ho");
            String gioiTinh = request.getParameter("gioiTinh");

            Date ngaySinh;
            try {
                ngaySinh = dateFormat.parse(request.getParameter("ngaySinh"));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            String diaChi = request.getParameter("diaChi");
            String sdt = request.getParameter("sdt");
            String matKhau = request.getParameter("matKhau");
            String trangThai = request.getParameter("trangThai");

            NhanVien nhanVien = new NhanVien();
            nhanVien.setId(UUID.fromString(request.getParameter("id")));
            nhanVien.setMa(ma);
            nhanVien.setTen(ten);

            nhanVien.setTenDem(tenDem);
            nhanVien.setHo(ho);
            nhanVien.setGioiTinh(gioiTinh);

            nhanVien.setNgaySinh(ngaySinh);
            nhanVien.setDiaChi(diaChi);
            nhanVien.setSdt(sdt);
            nhanVien.setMatKhau(matKhau);

            nhanVien.setTrangThai(Integer.parseInt(trangThai));
            nhanVienRepository.update(nhanVien);
            response.sendRedirect("/nhan-vien/hien-thi");


        }
    }
}
