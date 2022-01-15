package com.aptech.controllers.admin.discount;


import com.aptech.dao.DiscountDao;
import com.aptech.dao.ProductDao;
import com.aptech.models.Discount;
import com.aptech.models.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/discount-edit")
public class AdminDiscountEditController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        String code=request.getParameter("code");
        String desc=request.getParameter("desc");
        String discount_type=request.getParameter("discount_type");
        double discount_percentage=Double.parseDouble(request.getParameter("discount_percentage"));
        double min_spend=Double.parseDouble(request.getParameter("min_spend"));
        String expired_date=request.getParameter("expired_date");

        Discount discount=new Discount();
        discount.setId(id);
        discount.setCode(code);
        discount.setDescription(desc);
        discount.setCouponType(discount_type);
        discount.setDiscountPercentage(discount_percentage);
        discount.setMinSpendAmount(min_spend);
        discount.setExpiredAt(expired_date);
        discount.setActive(1);

        if(DiscountDao.updateDiscount(discount)){
            String msg = "<div class='alert alert-success'>Coupon updated successfully</div>";
            request.getSession().setAttribute("err", msg);
            response.sendRedirect(request.getHeader("referer"));
        }else{
            String msg = "<div class='alert alert-danger'>Error while updating coupon</div>";
            request.getSession().setAttribute("err", msg);
            response.sendRedirect(request.getHeader("referer"));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        Discount coupon= DiscountDao.getDiscountById(id);
        request.setAttribute("coupon",coupon);
        request.getRequestDispatcher("discount/show.jsp").forward(request,response);
    }
}
