package com.aptech.controllers.admin.category;

import com.aptech.dao.CategoryDao;
import com.aptech.models.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/category")
public class CategoryController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories= CategoryDao.getAllCategories();
        request.setAttribute("pageTitle","All Categories");
        request.setAttribute("categories",categories);
        request.getRequestDispatcher("category/index.jsp").forward(request,response);
    }
}