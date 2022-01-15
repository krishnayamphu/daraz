package com.aptech.controllers.admin.discount;


import com.aptech.dao.DiscountDao;
import com.aptech.models.Discount;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/coupons")
public class AdminDiscountController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        if (DiscountDao.delDiscount(id)) {
            String msg = "<div class='alert alert-success'>Coupon deleted successfully</div>";
            request.getSession().setAttribute("success", msg);
            response.sendRedirect(request.getHeader("referer"));
        } else {
            String msg = "<div class='alert alert-danger'>Error while deleting coupon</div>";
            request.getSession().setAttribute("err", msg);
            response.sendRedirect(request.getHeader("referer"));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Discount> coupons = DiscountDao.getAllDiscounts();
        request.setAttribute("coupons", coupons);
        request.getRequestDispatcher("discount/index.jsp").forward(request, response);
    }
}
