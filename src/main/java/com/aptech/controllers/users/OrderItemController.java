package com.aptech.controllers.users;

import com.aptech.dao.CartDao;
import com.aptech.dao.OrderDao;
import com.aptech.dao.OrderItemDao;
import com.aptech.dao.ProductDao;
import com.aptech.models.Order;
import com.aptech.models.OrderItem;
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

@WebServlet("/orderItem")
public class OrderItemController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int orderId=Integer.parseInt(request.getParameter("id"));
        Order order=OrderDao.getOrderItemById(orderId);


        request.setAttribute("pageTitle","All Ordered Items");
        request.setAttribute("order",order);
        request.getRequestDispatcher("/user/order-item.jsp").forward(request, response);
    }
}
