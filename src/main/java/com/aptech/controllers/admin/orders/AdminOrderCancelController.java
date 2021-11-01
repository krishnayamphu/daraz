package com.aptech.controllers.admin.orders;

import com.aptech.dao.OrderDao;
import com.aptech.models.Order;
import com.aptech.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/order-cancel")
public class AdminOrderCancelController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int oid=Integer.parseInt(request.getParameter("oid"));
        Order order=new Order();
        order.setId(oid);
        order.setOrderStatusId(6); //cancellation in progress
        if(OrderDao.updateOrderStatusId(order)){
            response.sendRedirect("order");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Order> orders=OrderDao.getCancelRequestOrders();
        request.setAttribute("pageTitle","All Items");
        request.setAttribute("orders",orders);
        request.getRequestDispatcher("/admin/order-cancel.jsp").forward(request, response);
    }
   }
