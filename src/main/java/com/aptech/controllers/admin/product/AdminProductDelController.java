package com.aptech.controllers.admin.product;

import com.aptech.dao.ProductDao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/product-del")
public class AdminProductDelController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pid=Integer.parseInt(request.getParameter("id"));
        if(ProductDao.delProduct(pid)){
            response.sendRedirect("products");
        }else{
            String msg = "<div class='alert alert-danger'>Error while deleting product</div>";
            request.setAttribute("err", msg);
            response.sendRedirect("admin/product-edit?id="+pid);
        }
    }
}
