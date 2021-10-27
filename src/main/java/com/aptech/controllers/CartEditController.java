package com.aptech.controllers;

import com.aptech.dao.CartDao;
import com.aptech.dao.ProductDao;
import com.aptech.models.Cart;
import com.aptech.models.Product;
import com.aptech.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/cart-edit")
public class CartEditController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user=(User)getServletContext().getAttribute("CurrentUser");
        int uid=user.getId();
        int pid=Integer.parseInt(request.getParameter("pid"));
        int qty=Integer.parseInt(request.getParameter("qty"));
        double price=Double.parseDouble(request.getParameter("price"));
        double total=qty*price;

        Cart cart=new Cart();
        cart.setProductId(pid);
        cart.setUserId(uid);
        cart.setQty(qty);
        cart.setTotal(total);
        if(CartDao.updateCartItem(cart)){
            //set global CartCount var
            this.getServletConfig().getServletContext().setAttribute("cartCount", CartDao.getTotalCartItem(uid));
            response.sendRedirect("/daraz/cart");
        }else{
            String msg = "Error while updating item.";
            request.setAttribute("err", msg);
            response.sendRedirect("/daraz/cart");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user=(User)getServletContext().getAttribute("CurrentUser");
        int uid=user.getId();
        int pid=Integer.parseInt(request.getParameter("pid"));
        Product product= ProductDao.getProductById(pid);
        Cart cart=CartDao.getCartById(uid,pid);

        request.setAttribute("pageTitle",product.getName());
        request.setAttribute("product",product);
        request.setAttribute("cart",cart);
        request.getRequestDispatcher("cart-edit.jsp").forward(request,response);
    }
}
