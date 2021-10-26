package com.aptech.controllers.auth;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/signout")
public class SignOutController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();

        //remove global CurrentUser attribute
        this.getServletConfig().getServletContext().removeAttribute("CurrentUser");
        response.sendRedirect(getServletContext().getContextPath());
    }
}
