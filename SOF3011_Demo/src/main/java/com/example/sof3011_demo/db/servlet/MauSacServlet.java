package com.example.sof3011_demo.db.servlet;

import com.example.sof3011_demo.db.entity.DongSp;
import com.example.sof3011_demo.db.entity.KhachHang;
import com.example.sof3011_demo.db.entity.MauSac;

import com.example.sof3011_demo.db.repository.MauSacRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "MauSacServlet", value = {
        "/mau-sac/hien-thi",
        "/mau-sac/add",
        "/mau-sac/detail",
        "/mau-sac/update",
        "/mau-sac/delete"
})
public class MauSacServlet extends HttpServlet {
    private MauSacRepository mauSacRepository = new MauSacRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/hien-thi")) {
            List<MauSac> listms = mauSacRepository.getAll();
            request.setAttribute("listmausac", listms);
            request.getRequestDispatcher("/view/mau-sac/hien-thi.jsp").forward(request, response);
        } else if (uri.contains("/detail")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            MauSac mauSac = mauSacRepository.getByID(id);

            request.setAttribute("mauSac", mauSac);


            request.getRequestDispatcher("/view/mau-sac/detail.jsp").forward(request, response);


        } else if (uri.contains("/delete")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            MauSac mauSac = mauSacRepository.getByID(id);
            mauSacRepository.delete(mauSac);
            response.sendRedirect("/mau-sac/hien-thi");

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");

            MauSac mauSac = new MauSac();
            mauSac.setMa(ma);
            mauSac.setTen(ten);

            mauSacRepository.add(mauSac);
            response.sendRedirect("/mau-sac/hien-thi");
        } else if (uri.contains("/update")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");

            MauSac mauSac = new MauSac();
            mauSac.setId(UUID.fromString(request.getParameter("id")));
            mauSac.setMa(ma);
            mauSac.setTen(ten);

            mauSacRepository.update(mauSac);
            response.sendRedirect("/mau-sac/hien-thi");
        }
    }

}
