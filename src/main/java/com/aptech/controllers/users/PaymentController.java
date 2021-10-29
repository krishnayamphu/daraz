package com.aptech.controllers.users;

import com.aptech.dao.CartDao;
import com.aptech.dao.OrderDao;
import com.aptech.models.CartItem;
import com.aptech.models.Order;
import com.aptech.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/payment")
public class PaymentController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user=(User)this.getServletContext().getAttribute("CurrentUser");
        int uid=user.getId();
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String mobile=request.getParameter("mobile");
        String address=request.getParameter("address");
        double total=Double.parseDouble(request.getParameter("total"));

        Order order=new Order();
        order.setUserId(uid);
        order.setName(name);
        order.setEmail(email);
        order.setMobile(mobile);
        order.setAddress(address);
        order.setOrderStatusId(1);
        order.setTotalAmount(total);
        int id=OrderDao.addOrderItem(order);
        if(id!=-1){
            PrintWriter pw =response.getWriter();
//            pw.println(id);
            response.sendRedirect("order");
        }else {
            String msg = "<div class='alert alert-danger'>Error while ordering product</div>";
            request.getSession().setAttribute("err", msg);
            response.sendRedirect("order");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int oid=Integer.parseInt(request.getParameter("oid"));
        Order orderItem=OrderDao.getOrderItemById(oid);
        request.setAttribute("pageTitle","Payment Method");
        request.setAttribute("orderItem",orderItem);
        request.getRequestDispatcher("/user/payment.jsp").forward(request, response);
    }
}
