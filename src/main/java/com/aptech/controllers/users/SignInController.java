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

@WebServlet("/signin")
public class SignInController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password = request.getParameter("password");
        String username = request.getParameter("username");
        User user=new User();
        user.setPassword(password);
        user.setUsername(username);
        if(UserDao.auth(user)){
            HttpSession session=request.getSession();
            session.setAttribute("user",username);
        }else{
            String msg = "<div class='alert alert-danger'> password do not match</div>";
            request.setAttribute("err", msg);
            request.getRequestDispatcher("/user/signup.jsp").include(request, response);
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/user/signin.jsp").forward(request, response);
    }
}
