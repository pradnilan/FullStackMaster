package com.simplilearn.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ControllerServlet", value = "/ControllerServlet")
public class ControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestFor=request.getParameter("task");
        System.out.println(requestFor+"get");

        if (requestFor.equals("Login")) {
            RequestDispatcher requestDispatcher= request.getRequestDispatcher("/LoginServlet");
            requestDispatcher.forward(request,response);

        } else if (requestFor.equals("Signup")){
            response.sendRedirect("/SignupServlet");
        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);


    }
}
