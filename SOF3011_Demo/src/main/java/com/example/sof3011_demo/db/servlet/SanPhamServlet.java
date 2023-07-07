package com.example.sof3011_demo.db.servlet;


import com.example.sof3011_demo.db.entity.DongSp;
import com.example.sof3011_demo.db.entity.KhachHang;
import com.example.sof3011_demo.db.entity.SanPham;

import com.example.sof3011_demo.db.repository.SanPhamRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "SanPhamServlet", value = {
        "/san-pham/hien-thi",
        "/san-pham/add",
        "/san-pham/detail",
        "/san-pham/update",
        "/san-pham/delete"
})
public class SanPhamServlet extends HttpServlet {
    private SanPhamRepository sanPhamRepository = new SanPhamRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/hien-thi")) {
            List<SanPham> listsp = sanPhamRepository.getAll();
            request.setAttribute("listsanpham", listsp);
            request.getRequestDispatcher("/view/SanPham/hien-thi.jsp").forward(request, response);
        } else if (uri.contains("/detail")) {
            UUID id = UUID.fromString(request.getParameter("id"));
         SanPham sanPham = sanPhamRepository.getByID(id);
            request.setAttribute("sanPham", sanPham);

            request.getRequestDispatcher("/view/SanPham/detail.jsp").forward(request, response);


        } else if (uri.contains("/delete")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            SanPham sanPham = sanPhamRepository.getByID(id);
            sanPhamRepository.delete(sanPham);
            response.sendRedirect("/san-pham/hien-thi");

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");

           SanPham sanPham = new SanPham();
           sanPham.setMa(ma);
            sanPham.setTen(ten);

            sanPhamRepository.add(sanPham);
            response.sendRedirect("/san-pham/hien-thi");
        } else if (uri.contains("/update")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");

          SanPham sanPham = new SanPham();
            sanPham.setId(UUID.fromString(request.getParameter("id")));
            sanPham.setMa(ma);
            sanPham.setTen(ten);

           sanPhamRepository.update(sanPham);
            response.sendRedirect("/san-pham/hien-thi");
        }
    }
}
