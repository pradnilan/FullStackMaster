package com.simplilearn.controllers;

import com.simplilearn.model.User;
import com.simplilearn.service.UserServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName=request.getParameter("userName");
        String password=request.getParameter("password");

        User user=new User(userName,password);
        boolean isUserValid=new UserServiceImpl().validateUser(user);

        if(isUserValid){
            HttpSession session=request.getSession();
            session.setAttribute("userName",userName);
            RequestDispatcher dispatcher=request.getRequestDispatcher("home.jsp");
            dispatcher.forward(request,response);
        }else{
            response.sendRedirect("index.jsp");
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
