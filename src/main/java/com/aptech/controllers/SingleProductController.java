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
//        int id=Integer.parseInt(request.getParameter("id"));
        Product product= ProductDao.getProductById(5);
        request.setAttribute("product",product);
        request.getRequestDispatcher("single.jsp").forward(request,response);
    }
}
