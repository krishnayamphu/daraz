package com.aptech.controllers;

import com.aptech.dao.CartDao;
import com.aptech.dao.ProductDao;
import com.aptech.models.Cart;
import com.aptech.models.CartItem;
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
import java.util.List;

@WebServlet("/cart")
public class CartController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw=response.getWriter();
        User user=(User)getServletContext().getAttribute("CurrentUser");
        int uid=user.getId();
        int pid=Integer.parseInt(request.getParameter("pid"));
        int qty=Integer.parseInt(request.getParameter("qty"));
        Product product=ProductDao.getProductById(pid);
        double price=product.getSalesPrice();
        double total=price*qty;
        Cart cart=new Cart(pid,uid,qty,total);
        if(CartDao.addCartItem(cart)){
            //set global CartCount var
            this.getServletConfig().getServletContext().setAttribute("cartCount", CartDao.getTotalCartItem(uid));
            response.sendRedirect("/daraz/cart");
        }else{
            System.out.println("something error");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user=(User)getServletContext().getAttribute("CurrentUser");
        int uid=user.getId();
        List<CartItem> cartItems=CartDao.getAllCartItems(uid);
        double subTotal=CartDao.getSubTotal(uid);
        request.setAttribute("pageTitle","All Cart Items");
        request.setAttribute("cartItems",cartItems);
        request.setAttribute("subTotal",subTotal);
        request.getRequestDispatcher("cart.jsp").forward(request,response);
    }
}
