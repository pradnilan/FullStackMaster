package com.simplilearn;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TestConfig", value = "/TestConfig",initParams = {@WebInitParam(
        name = "username", value = "user"),
        @WebInitParam(name="password",value="user123")})
public class TestConfig extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter= response.getWriter();

        ServletConfig config=getServletConfig();
        String userName=config.getInitParameter("username");
        String password=config.getInitParameter("password");
        printWriter.println(userName+"&"+password);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }
}
