package com.simplilearn.hibernate.controllers;

import com.simplilearn.hibernate.entity.User;
import com.simplilearn.hibernate.service.UserService;
import com.simplilearn.hibernate.service.UserServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AddUserServlet", value = "/AddUserServlet")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName=request.getParameter("fname");
        String lastName=request.getParameter("lname");
        String userName=request.getParameter("uname");
        String password=request.getParameter("pwd");

        User user=new User(firstName,lastName,userName,password);
        UserService service=new UserServiceImpl();
        int userId=service.addUser(user);
        System.out.println(userId);

        String msg;

        if(userId != 1000){
            msg="User added successfully";
            request.setAttribute("msg",msg);
            RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request,response);
        }else msg="Error in user add";


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }
}
