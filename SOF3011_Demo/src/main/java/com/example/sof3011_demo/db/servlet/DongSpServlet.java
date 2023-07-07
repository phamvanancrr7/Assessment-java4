package com.example.sof3011_demo.db.servlet;



import com.example.sof3011_demo.db.entity.DongSp;

import com.example.sof3011_demo.db.repository.DongSpRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "DongSpServlet", value = {
        "/dong-sp/hien-thi",
        "/dong-sp/add",
        "/dong-sp/detail",
        "/dong-sp/update",
        "/dong-sp/delete"

})
public class DongSpServlet extends HttpServlet {
    private DongSpRepository dongSpRepository = new DongSpRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/hien-thi")) {
            List<DongSp> listdsp = dongSpRepository.getAll();
            request.setAttribute("listdongsp", listdsp);
            request.getRequestDispatcher("/view/dong-sp/hien-thi.jsp").forward(request, response);
        } else if (uri.contains("/detail")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            DongSp dongSp = dongSpRepository.getByID(id);
            request.setAttribute("dongSp", dongSp);
            request.getRequestDispatcher("/view/dong-sp/detail.jsp").forward(request, response);
        } else if (uri.contains("/delete")) {

            UUID id = UUID.fromString(request.getParameter("id"));
            DongSp dongSp = dongSpRepository.getByID(id);
            System.out.println(dongSpRepository.delete(dongSp));
            response.sendRedirect("/dong-sp/hien-thi");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");

            DongSp dongSp = new DongSp();
            dongSp.setMa(ma);
            dongSp.setTen(ten);

            dongSpRepository.add(dongSp);
            response.sendRedirect("/dong-sp/hien-thi");
        } else if (uri.contains("/update")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");

            DongSp dongSp = new DongSp();
            dongSp.setId(UUID.fromString(request.getParameter("id")));
            dongSp.setMa(ma);
            dongSp.setTen(ten);

            dongSpRepository.update(dongSp);
            response.sendRedirect("/dong-sp/hien-thi");
        }
    }


}

