package com.example;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ValidateUser", value = "/validateuser")
public class ValidateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName=request.getParameter("uname");
        String pwd=request.getParameter("pwd");

        if (userName.equals("pradeep") && pwd.equals("admin123")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("ValidUserServlet");
            dispatcher.forward(request,response);
        }
        else {
            response.sendRedirect("InvalidUserServlet");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
