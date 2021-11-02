package com.aptech.controllers.users;

import com.aptech.dao.OrderDao;
import com.aptech.models.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/order-cancel")
public class OrderCancelController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int oid=Integer.parseInt(request.getParameter("oid"));
        Order order=new Order();
        order.setId(oid);
        order.setOrderStatusId(5); //cancellation in progress
        if(OrderDao.updateOrderStatusId(order)){
            response.sendRedirect("order");
        }
    }

}
