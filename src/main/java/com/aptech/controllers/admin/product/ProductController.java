package com.aptech.controllers.admin.product;



import com.aptech.dao.ProductDao;
import com.aptech.models.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/products")
public class ProductController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products= ProductDao.getAllProducts();
        request.setAttribute("products",products);

        request.getRequestDispatcher("product/index.jsp").forward(request,response);
    }
}
