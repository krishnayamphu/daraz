package com.aptech.controllers;

import com.aptech.dao.ProductDao;
import com.aptech.dao.UserDao;
import com.aptech.models.Product;
import com.aptech.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = {"/home"})
public class HomeController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw=response.getWriter();
        List<Product> products= ProductDao.getAllProducts();
        request.setAttribute("products",products);
        request.getRequestDispatcher("home.jsp").forward(request,response);
    }
}
