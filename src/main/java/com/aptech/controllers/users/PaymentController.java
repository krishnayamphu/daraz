package com.aptech.controllers.users;

import com.aptech.dao.CartDao;
import com.aptech.dao.InvoiceDao;
import com.aptech.dao.OrderDao;
import com.aptech.models.CartItem;
import com.aptech.models.Invoice;
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
       int pmtId=Integer.parseInt(request.getParameter("pmt"));
        int oid=Integer.parseInt(request.getParameter("oid"));
       if(pmtId==1){
           Invoice invoice=new Invoice(oid,1);
           if(InvoiceDao.addInvoice(invoice)){
               String msg = " <div class='alert alert-success'>Category Updaated !</div>";
               request.getSession().setAttribute("success", msg);
                response.sendRedirect("order");
           }else {
               String msg = "<div class='alert alert-danger'>Error while updating category</div>";
               request.getSession().setAttribute("err", msg);
               response.sendRedirect(request.getHeader("referer"));
           }
       }else{
           //error
       }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int oid=Integer.parseInt(request.getParameter("oid"));
        Order orderItem=OrderDao.getOrderItemById(oid);
        request.setAttribute("pageTitle","Payment Method");
        request.setAttribute("orderItem",orderItem);
        request.setAttribute("oid",oid);
        request.getRequestDispatcher("/user/payment.jsp").forward(request, response);
    }
}
