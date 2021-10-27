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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/cart-del")
public class CartDelController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user=(User)getServletContext().getAttribute("CurrentUser");
        int uid=user.getId();
        int pid=Integer.parseInt(request.getParameter("pid"));
        Cart cart=new Cart();
        cart.setProductId(pid);
        cart.setUserId(uid);
        if(CartDao.delCartItem(cart)){
            //set global CartCount var
            this.getServletConfig().getServletContext().setAttribute("cartCount", CartDao.getTotalCartItem(uid));
            String msg = "Item deleted successfully.";
            request.setAttribute("msg", msg);
            response.sendRedirect("/daraz/cart");
        }else{
            String msg = "Error while deleting item.";
            request.setAttribute("err", msg);
            response.sendRedirect("/daraz/cart");
        }
    }
}
