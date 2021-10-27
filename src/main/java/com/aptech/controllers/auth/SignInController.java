package com.aptech.controllers.auth;

import com.aptech.dao.CartDao;
import com.aptech.dao.UserDao;
import com.aptech.models.User;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/signin")
public class SignInController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password = request.getParameter("password");
        String username = request.getParameter("username");
        User user = new User();
        user.setPassword(DigestUtils.sha256Hex(password));
        user.setUsername(username);
        if (UserDao.auth(user)) {
            HttpSession session = request.getSession();
            session.setAttribute("user", username);
            User CurrentUser = UserDao.getUserByUsername(username);
            //set global CurrentUser object
            this.getServletConfig().getServletContext().setAttribute("CurrentUser", CurrentUser);

            //set global CartCount var
            this.getServletConfig().getServletContext().setAttribute("cartCount", CartDao.getTotalCartItem(CurrentUser.getId()
            ));

            response.sendRedirect("/daraz/home");
        } else {
            String msg = "Invalid username or password.";
            request.setAttribute("err", msg);
            request.getRequestDispatcher("/auth/signin.jsp").include(request, response);
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/auth/signin.jsp").forward(request, response);
    }
}
