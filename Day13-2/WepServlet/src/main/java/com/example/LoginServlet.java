package com.example;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "loginservice", value = "/loginservice")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID=1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName=request.getParameter("uname");
        String pwd=request.getParameter("pwd");

        PrintWriter writer= response.getWriter();

        if (userName.equals("pradeep") && pwd.equals("admin123")) writer.println("Valid User");
        else writer.println("Invalid USer");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
