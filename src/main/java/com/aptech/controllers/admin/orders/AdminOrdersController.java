package com.aptech.controllers.admin.orders;



import com.aptech.dao.CartDao;
import com.aptech.dao.OrderDao;
import com.aptech.dao.ProductDao;
import com.aptech.models.Order;
import com.aptech.models.Product;
import com.aptech.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/orders")
public class AdminOrdersController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Order> orders= OrderDao.getPaidOrders();
        request.setAttribute("orders",orders);
        request.getRequestDispatcher("orders/index.jsp").forward(request,response);
    }
}
