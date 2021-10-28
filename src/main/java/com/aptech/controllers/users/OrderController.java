package com.aptech.controllers.users;

import com.aptech.dao.OrderDao;
import com.aptech.dao.UserDao;
import com.aptech.models.Order;
import com.aptech.models.User;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/order")
public class OrderController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user=(User)this.getServletContext().getAttribute("CurrentUser");
        int uid=user.getId();
        String name=request.getParameter("name");
        double total=Double.parseDouble(request.getParameter("total"));
        Order order=new Order();
        order.setUserId(uid);
        order.setName(name);
        order.setTotalAmount(total);
        if(OrderDao.addOrderItem(order)){

            response.sendRedirect("order");

        }else {
            String msg = "<div class='alert alert-danger'>Error while ordering product</div>";
            request.getSession().setAttribute("err", msg);
            response.sendRedirect("order");
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/user/order.jsp").forward(request, response);
    }
}
