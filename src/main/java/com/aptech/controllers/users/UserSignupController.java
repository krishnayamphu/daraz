package com.aptech.controllers.users;

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

@WebServlet("/signup")
public class UserSignupController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pass = request.getParameter("password");
        String cpass = request.getParameter("cpassword");
        if (pass.equals(cpass)) {
            User user=new User();
            user.setFirstname(request.getParameter("fname"));
            user.setLastname(request.getParameter("lname"));
            user.setGender(request.getParameter("gender"));
            user.setUsername(request.getParameter("username"));
            user.setEmail(request.getParameter("email"));
            user.setContact(request.getParameter("contact"));
            user.setPassword(DigestUtils.sha256Hex(pass));
            user.setAddress(request.getParameter("address"));
            user.setActive(1);
            if(UserDao.addUser(user)){
                HttpSession session = request.getSession();
                session.setAttribute("user", user.getUsername());
                User CurrentUser=UserDao.getUserByUsername(user.getUsername());
                this.getServletConfig().getServletContext().setAttribute("CurrentUser", CurrentUser);
                response.sendRedirect("user/profile");
                System.out.println("data inserted");
            }else {
                String msg = "<div class='alert alert-danger'>Error while adding new user</div>";
                request.setAttribute("errUser", msg);
                request.getRequestDispatcher("/user/signup.jsp").include(request, response);
            }
        } else {
            String msg = "<div class='alert alert-danger'> password do not match</div>";
            request.setAttribute("err", msg);
            request.getRequestDispatcher("/user/signup.jsp").include(request, response);
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/user/signup.jsp").forward(request, response);
    }
}
