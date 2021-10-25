package com.aptech.controllers;

import com.aptech.dao.ProductDao;
import com.aptech.models.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/single")
public class SingleProductController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        HttpSession session=request.getSession();
        String user=(String)session.getAttribute("user");

        Product product= ProductDao.getProductById(id);
        request.setAttribute("product",product);
        request.setAttribute("user",user);
        request.getRequestDispatcher("single-product.jsp").forward(request,response);
    }
}
