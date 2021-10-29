package com.aptech.controllers.admin.category;

import com.aptech.dao.CategoryDao;
import com.aptech.models.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/category-add")
public class CategoryAddController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        String desc=request.getParameter("desc");

        Category category=new Category(name,desc);
        if(CategoryDao.addCategory(category)!=-1){
            String msg = " <div class='alert alert-success'>Category Added !</div>";
            request.getSession().setAttribute("success", msg);
            response.sendRedirect("category");
        }else{
            String msg = " <div class='alert alert-warning'>Error while adding new category</div>";
            request.getSession().setAttribute("err", msg);
            request.getRequestDispatcher("category/add.jsp").include(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("pageTitle","Add Category");
        request.getRequestDispatcher("category/add.jsp").forward(request,response);
    }
}
