package com.aptech.controllers;

import com.aptech.dao.ProductDao;
import com.aptech.models.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/single")
public class SingleProductController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pid=Integer.parseInt(request.getParameter("pid"));
        Product product= ProductDao.getProductById(pid);
        request.setAttribute("pageTitle",product.getName());
        request.setAttribute("product",product);
        request.getRequestDispatcher("single.jsp").forward(request,response);
    }
}
