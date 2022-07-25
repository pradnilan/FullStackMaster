package com.simplilearn;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloServlet", value = "/HelloServlet",initParams = {@WebInitParam(
        name = "username", value = "admin"),
        @WebInitParam(name="password",value="admin123")})
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter= response.getWriter();
        printWriter.println("Hello From Maven Project");

        String userNameFromUser=request.getParameter("user");
        String pwdNameFromUser=request.getParameter("pwd");

        //ServletConfig
        ServletConfig config=getServletConfig();
        String userName=config.getInitParameter("username");
        String password=config.getInitParameter("password");
        printWriter.println(userName+"&"+password);

        if(userNameFromUser.equals(userName) && pwdNameFromUser.equals(password)) printWriter.println("You are allowed to access");
        else printWriter.println("You are not allowed to access");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }
}
