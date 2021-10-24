package com.aptech.controllers.admin.users;

import com.aptech.dao.AdminDao;
import com.aptech.models.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/admin/edit/*")
public class AdminEditController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo(); // '/{value}/test'
        String[] pathParts = pathInfo.split("/");
        String part1 = pathParts[1]; // {value}

        int id = Integer.parseInt(part1);
        Admin admin = AdminDao.getUserById(id);
        request.setAttribute("admin", admin);
        request.getRequestDispatcher("/admin/show.jsp").forward(request, response);
    }
}