package com.example.sof3011_demo.db.servlet;

import com.example.sof3011_demo.db.entity.ChiTietSp;


import com.example.sof3011_demo.db.repository.ChiTietSpRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "ChiTietSpServlet", value = {
        "/chi-tiet-sp/hien-thi",
        "/chi-tiet-sp/add",
        "/chi-tiet-sp/detail",
        "/chi-tiet-sp/update",
        "/chi-tiet-sp/delete"})
public class ChiTietSpServlet extends HttpServlet {
    private ChiTietSpRepository chiTietSpRepository = new ChiTietSpRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/hien-thi")) {
            List<ChiTietSp> listctsp = chiTietSpRepository.getAll();
            request.setAttribute("listchitietsp", listctsp);
            request.getRequestDispatcher("/view/chi-tiet-sp/hien-thi.jsp").forward(request, response);
        } else if (uri.contains("/detail")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            ChiTietSp chiTietSp = chiTietSpRepository.getByID(id);
            request.setAttribute("chiTietSp", chiTietSp);
            request.getRequestDispatcher("/view/chi-tiet-sp/detail.jsp").forward(request, response);

        } else if (uri.contains("/delete")) {

            UUID id = UUID.fromString(request.getParameter("id"));
            ChiTietSp chiTietSp = chiTietSpRepository.getByID(id);
            System.out.println(chiTietSpRepository.delete(chiTietSp));

            response.sendRedirect("/chi-tiet-sp/hien-thi");

        }

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            String namBh = request.getParameter("namBH");
            String moTa = request.getParameter("moTa");
            String soLuongTon=request.getParameter("soLuongTon");
            String giaNhap=request.getParameter("giaNhap");
            String giaBan=request.getParameter("giaBan");

            ChiTietSp chiTietSp= new ChiTietSp();
            chiTietSp.setNamBh(Integer.parseInt(namBh));
            chiTietSp.setMoTa(moTa);
            chiTietSp.setSoLuongTon(Integer.parseInt(soLuongTon));
            chiTietSp.setGiaNhap(Double.parseDouble(giaNhap));
            chiTietSp.setGiaBan(Double.parseDouble(giaBan));
            chiTietSpRepository.add(chiTietSp);
            response.sendRedirect("/chi-tiet-sp/hien-thi");
        } else if (uri.contains("/update")) {
            String namBh = request.getParameter("namBH");
            String moTa = request.getParameter("moTa");
            String soLuongTon=request.getParameter("soLuongTon");
            String giaNhap=request.getParameter("giaNhap");
            String giaBan=request.getParameter("giaBan");
           ChiTietSp chiTietSp = new ChiTietSp();
            chiTietSp.setId(UUID.fromString(request.getParameter("id")));
            chiTietSp.setNamBh(Integer.parseInt(namBh));
            chiTietSp.setMoTa(moTa);
            chiTietSp.setSoLuongTon(Integer.parseInt(soLuongTon));
            chiTietSp.setGiaNhap(Double.parseDouble(giaNhap));
            chiTietSp.setGiaBan(Double.parseDouble(giaBan));
            chiTietSpRepository.update(chiTietSp);
            response.sendRedirect("/chi-tiet-sp/hien-thi");
        }
    }
}
