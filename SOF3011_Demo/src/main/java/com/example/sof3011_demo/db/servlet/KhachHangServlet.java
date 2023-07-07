package com.example.sof3011_demo.db.servlet;

import com.example.sof3011_demo.db.entity.KhachHang;
import com.example.sof3011_demo.db.repository.KhachHangRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "KhachHangServlet", value = {
        "/khach-hang/hien-thi",
        "/khach-hang/add",
        "/khach-hang/detail",
        "/khach-hang/update",
        "/khach-hang/delete"
})
public class KhachHangServlet extends HttpServlet {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private KhachHangRepository khachHangRepository = new KhachHangRepository();
    private UUID ViTriUpdate = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI();
        if (uri.contains("/hien-thi")) {
            List<KhachHang> listkhachHang = khachHangRepository.getAll();
            request.setAttribute("listKhachHang", listkhachHang);
            request.getRequestDispatcher("/view/khach-hang/hien-thi.jsp").forward(request, response);
        } else if (uri.contains("/detail")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            KhachHang khachHang = khachHangRepository.getById(id);

            request.setAttribute("khachHang", khachHang);
            System.out.println(khachHang.getNgaySinh());
            String ngaySinh = dateFormat.format(khachHang.getNgaySinh());
            request.setAttribute("ngaySinh", ngaySinh);
            request.getRequestDispatcher("/view/khach-hang/Detail.jsp").forward(request, response);
            ViTriUpdate = id;

        } else if (uri.contains("/delete")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            KhachHang khachHang = khachHangRepository.getById(id);
            khachHangRepository.delete(khachHang);
            response.sendRedirect("/khach-hang/hien-thi");

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {


        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String tenDem = request.getParameter("tenDem");
            String sdt = request.getParameter("sdt");
            String diaChi = request.getParameter("diaChi");
            String thanhPho = request.getParameter("thanhPho");
            String quocGia = request.getParameter("quocGia");
            String matKhau = request.getParameter("matKhau");
            String ho = request.getParameter("ho");
            Date ngaySinh;
            try {
                ngaySinh = dateFormat.parse(request.getParameter("ngaySinh"));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            KhachHang khachHang = new KhachHang();
            khachHang.setMa(ma);
            khachHang.setTen(ten);
            khachHang.setHo(ho);
            khachHang.setTenDem(tenDem);
            khachHang.setNgaySinh(ngaySinh);
            khachHang.setSdt(sdt);
            khachHang.setDiaChi(diaChi);
            khachHang.setThanhPho(thanhPho);
            khachHang.setQuocGia(quocGia);
            khachHang.setMatKhau(matKhau);
            khachHangRepository.add(khachHang);
            response.sendRedirect("/khach-hang/hien-thi");
        } else if (uri.contains("/update")) {

            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String tenDem = request.getParameter("tenDem");
            String sdt = request.getParameter("sdt");
            String diaChi = request.getParameter("diaChi");
            String thanhPho = request.getParameter("thanhPho");
            String quocGia = request.getParameter("quocGia");
            String matKhau = request.getParameter("matKhau");
            String ho = request.getParameter("ho");
            Date ngaySinh;
            try {
                ngaySinh = dateFormat.parse(request.getParameter("ngaySinh"));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            KhachHang khachHang = new KhachHang();
            khachHang.setId(ViTriUpdate);
            khachHang.setMa(ma);
            khachHang.setTen(ten);
            khachHang.setHo(ho);
            khachHang.setTenDem(tenDem);
            khachHang.setNgaySinh(ngaySinh);
            khachHang.setSdt(sdt);
            khachHang.setDiaChi(diaChi);
            khachHang.setThanhPho(thanhPho);
            khachHang.setQuocGia(quocGia);
            khachHang.setMatKhau(matKhau);
            khachHangRepository.update(khachHang);
            response.sendRedirect("/khach-hang/hien-thi");

        }
    }
}


