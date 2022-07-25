package org.prad.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.prad.entity.Airport;
import org.prad.entity.User;
import org.prad.entity.UserAccount;
import org.prad.service.AirportService;
import org.prad.service.AirportServiceImpl;
import org.prad.service.UserService;
import org.prad.service.UserServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ValidateUserServlet", value = "/ValidateUserServlet")
public class ValidateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService;
        UserAccount user;
        List<Airport> airports;
        AirportService airportService;
        Cookie userCk;

        String userName=request.getParameter("user");
        String password=request.getParameter("pwd");

        if(userName!="" & password!="") {

            user = new UserAccount(userName, password);
            userService = new UserServiceImpl();

            boolean isUserValid = userService.validateUser(user);
            String userType = userService.userType(user);


            airports = new AirportServiceImpl().searchAllAirport();
            System.out.println(airports);

            if (isUserValid) {

                if (userType.equals("customer")) {
                    HttpSession session = request.getSession();
                    session.setAttribute("type", userType);
                    session.setAttribute("airports", airports);
                    userCk= new Cookie("user",userName);
                    response.addCookie(userCk);

                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("searchflights.jsp");
                    requestDispatcher.forward(request, response);
                }
            } else errorMsg(request,response);
        }
        else errorMsg(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void errorMsg(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String msg = "Invalid user name or password, Please Try again !";
        HttpSession session = request.getSession();
        session.setAttribute("msg", msg);
        session.setAttribute("validation", "invalid");
        response.sendRedirect("index.jsp");
    }


}
