package com.aptech.controllers.users;

import com.aptech.dao.CartDao;
import com.aptech.dao.OrderDao;
import com.aptech.dao.OrderItemDao;
import com.aptech.models.Order;
import com.aptech.models.OrderItem;
import com.aptech.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/order")
public class OrderController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user=(User)this.getServletContext().getAttribute("CurrentUser");
        String name=user.getFirstname()+" "+user.getLastname();
        double total=Double.parseDouble(request.getParameter("total"));
        String[] pid=request.getParameterValues("pid");
        String[] price=request.getParameterValues("price");
        String[] qty=request.getParameterValues("qty");
        PrintWriter pw=response.getWriter();

        Order order=new Order();
        order.setUserId(user.getId());
        order.setName(name);
        order.setEmail(user.getEmail());
        order.setMobile(user.getContact());
        order.setAddress(user.getAddress());
        order.setOrderStatusId(1);
        order.setTotalAmount(total);
        int id=OrderDao.addOrderItem(order);
        if(id!=-1){
            int length=pid.length;
            boolean status=false;
            for(int i=0; i<length; i++){
                OrderItem item=new OrderItem(id,Integer.parseInt(pid[i]),Double.parseDouble(price[i]),Integer.parseInt(qty[i]));
                if(OrderItemDao.addOrderItem(item)) {
                    status=true;
                }
            }
            if(status){
                System.out.println("ordered items added successfully.");
            }else{
                System.out.println("error while adding order items.");
            }
            CartDao.delCartItemByUserId(user.getId());
            this.getServletConfig().getServletContext().setAttribute("cartCount", CartDao.getTotalCartItem(user.getId()));
            response.sendRedirect("order");
        }else {
            String msg = "<div class='alert alert-danger'>Error while ordering product</div>";
            request.getSession().setAttribute("err", msg);
            response.sendRedirect("order");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user=(User)this.getServletContext().getAttribute("CurrentUser");
        List<Order> orders=OrderDao.getAllOrderItems(user.getId());
        request.setAttribute("pageTitle","All Ordered Items");
        request.setAttribute("orders",orders);
        request.getRequestDispatcher("/user/order.jsp").forward(request, response);
    }
}
