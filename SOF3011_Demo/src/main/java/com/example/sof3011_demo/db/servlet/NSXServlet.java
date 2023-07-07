package com.example.sof3011_demo.db.servlet;

import com.example.sof3011_demo.db.entity.DongSp;
import com.example.sof3011_demo.db.entity.KhachHang;
import com.example.sof3011_demo.db.entity.NSX;

import com.example.sof3011_demo.db.repository.NSXRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "NSXServlet", value = {
        "/NSX/hien-thi",
        "/NSX/add",
        "/NSX/detail",
        "/NSX/update",
        "/NSX/delete"
})
public class NSXServlet extends HttpServlet {
    private NSXRepository nsxRepository = new NSXRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/hien-thi")) {
            List<NSX> listnsx = nsxRepository.getAll();
            request.setAttribute("listnsx", listnsx);
            request.getRequestDispatcher("/view/NSX/hien-thi.jsp").forward(request, response);
        } else if (uri.contains("/detail")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            NSX nsx = nsxRepository.getByID(id);

            request.setAttribute("NSX", nsx);


            request.getRequestDispatcher("/view/NSX/detail.jsp").forward(request, response);


        } else if (uri.contains("/delete")) {
            UUID id = UUID.fromString(request.getParameter("id"));
           NSX nsx = nsxRepository.getByID(id);
            nsxRepository.delete(nsx);
            response.sendRedirect("/NSX/hien-thi");

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");

           NSX nsx = new NSX();
            nsx.setMa(ma);
            nsx.setTen(ten);

           nsxRepository.add(nsx);
            response.sendRedirect("/NSX/hien-thi");
        } else if (uri.contains("/update")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");


            NSX nsx = new NSX();
            nsx.setMa(ma);
            nsx.setTen(ten);
            nsx.setId(UUID.fromString(request.getParameter("id")));


           nsxRepository.update(nsx);
            response.sendRedirect("/NSX/hien-thi");
        }
    }
}
