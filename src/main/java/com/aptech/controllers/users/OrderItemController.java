package com.aptech.controllers.users;

import com.aptech.dao.CartDao;
import com.aptech.dao.OrderDao;
import com.aptech.dao.OrderItemDao;
import com.aptech.dao.ProductDao;
import com.aptech.models.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/orderItem")
public class OrderItemController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int oid =Integer.parseInt(request.getParameter("oid"));
        String name=request.getParameter("name");
        String mobile=request.getParameter("mobile");
        String email=request.getParameter("email");
        String address=request.getParameter("address");

        Order order=new Order();
        order.setId(oid);
        order.setName(name);
        order.setEmail(email);
        order.setMobile(mobile);
        order.setAddress(address);
        if(OrderDao.updateOrderItem(order)){
            response.sendRedirect("payment?oid="+oid);
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
        request.getRequestDispatcher("/user/order-item.jsp").forward(request, response);
    }
}
