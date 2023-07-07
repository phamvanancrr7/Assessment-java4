package com.example.sof3011_demo.db.servlet;

import com.example.sof3011_demo.db.entity.ChucVu;

import com.example.sof3011_demo.db.repository.ChucVuRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "ChucVuServlet", value = {
        "/chuc-vu/hien-thi",
        "/chuc-vu/add",
        "/chuc-vu/detail",
        "/chuc-vu/update",
        "/chuc-vu/delete"

})
public class ChucVuServlet extends HttpServlet {
    private ChucVuRepository chucVuRepository = new ChucVuRepository();
    private UUID vitriUpdate = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/hien-thi")) {
            List<ChucVu> listcv = chucVuRepository.getAll();
            request.setAttribute("listchucvu", listcv);
            request.getRequestDispatcher("/view/chuc-vu/hien-thi.jsp").forward(request, response);
        } else if (uri.contains("/detail")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            ChucVu chucVu = chucVuRepository.getByid(id);
            request.setAttribute("chucVu", chucVu);
            request.getRequestDispatcher("/view/chuc-vu/detail.jsp").forward(request, response);

        } else if (uri.contains("/delete")) {

            UUID id = UUID.fromString(request.getParameter("id"));
            ChucVu chucVu = chucVuRepository.getByid(id);
            System.out.println(chucVuRepository.delete(chucVu));

            response.sendRedirect("/chuc-vu/hien-thi");

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            ChucVu chucVu = new ChucVu();
            chucVu.setMa(ma);
            chucVu.setTen(ten);
            chucVuRepository.add(chucVu);
            response.sendRedirect("/chuc-vu/hien-thi");
        } else if (uri.contains("/update")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            ChucVu chucVu = new ChucVu();
            chucVu.setId(UUID.fromString(request.getParameter("id")));
            chucVu.setMa(ma);
            chucVu.setTen(ten);
            chucVuRepository.update(chucVu);
            response.sendRedirect("/chuc-vu/hien-thi");
        }
    }
}
