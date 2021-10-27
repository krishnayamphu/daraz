package com.aptech.controllers.admin.category;

import com.aptech.dao.CategoryDao;
import com.aptech.models.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/category-edit")
public class CategoryEditController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String desc = request.getParameter("desc");

        Category category = new Category(id,name,desc);

        if (CategoryDao.updateCategory(category)) {
            String msg = " <div class='alert alert-success'>Category Updaated !</div>";
            request.getSession().setAttribute("success", msg);
            response.sendRedirect(request.getHeader("referer"));
        } else {
            String msg = "<div class='alert alert-danger'>Error while updating category</div>";
            request.getSession().setAttribute("err", msg);
            response.sendRedirect(request.getHeader("referer"));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Category category = CategoryDao.getCategoryById(id);
        request.setAttribute("pageTitle", "Category Details");
        request.setAttribute("category", category);
        request.getRequestDispatcher("category/show.jsp").forward(request, response);
    }
}