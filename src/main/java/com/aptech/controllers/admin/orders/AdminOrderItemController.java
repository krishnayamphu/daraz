package com.aptech.controllers.admin.orders;

import com.aptech.dao.OrderDao;
import com.aptech.dao.OrderItemDao;
import com.aptech.models.Order;
import com.aptech.models.OrderItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/orderItem")
public class AdminOrderItemController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int orderId =Integer.parseInt(request.getParameter("oid"));
        String name=request.getParameter("name");
        String mobile=request.getParameter("mobile");
        String email=request.getParameter("email");
        String address=request.getParameter("address");

        Order order=new Order();
        order.setId(orderId);
        order.setName(name);
        order.setEmail(email);
        order.setMobile(mobile);
        order.setAddress(address);
        if(OrderDao.updateOrderItem(order)){
            response.sendRedirect("payment?oid="+orderId);
        }else {
            String msg = "<div class='alert alert-danger'>Error while ordering product</div>";
            request.getSession().setAttribute("err", msg);
            response.sendRedirect(request.getHeader("referer"));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int orderId=Integer.parseInt(request.getParameter("id"));
        Order order=OrderDao.getOrderItemById(orderId);
        List<OrderItem> orderItems=OrderItemDao.getAllOrderItemsByOrderId(orderId);

        request.setAttribute("pageTitle","All Ordered Items");
        request.setAttribute("order",order);
        request.setAttribute("orderItems",orderItems);
        request.getRequestDispatcher("/admin/orders/order-item.jsp").forward(request, response);
    }
}
