package com.aptech.controllers;

import com.aptech.dao.CartDao;
import com.aptech.dao.ProductDao;
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

@WebServlet("/single")
public class SingleProductController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pid=Integer.parseInt(request.getParameter("pid"));
        boolean isSET=false;
        HttpSession session=request.getSession(false);
        String user=(String)session.getAttribute("user");
        Product product= ProductDao.getProductById(pid);
//        PrintWriter pw=response.getWriter();

        if(user!=null){
            User currentUser=(User)this.getServletContext().getAttribute("CurrentUser");
            int uid=currentUser.getId();
             isSET= CartDao.cartItemCheck(uid,pid);
        }
        request.setAttribute("pageTitle",product.getName());
        request.setAttribute("product",product);
        request.setAttribute("isSET",isSET);
        request.getRequestDispatcher("single.jsp").forward(request,response);
    }


}
