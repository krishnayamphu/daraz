package com.aptech.controllers.admin;

import com.aptech.dao.AdminDao;
import com.aptech.models.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/users")
public class AdminUserController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Admin> users= AdminDao.getAllUsers();
        request.setAttribute("users",users);
        request.getRequestDispatcher("/admin/users.jsp").forward(request,response);
    }
}
