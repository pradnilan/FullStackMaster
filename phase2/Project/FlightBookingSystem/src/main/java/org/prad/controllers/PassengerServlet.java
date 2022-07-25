package org.prad.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.prad.dto.FlightSearchParam;
import org.prad.dto.FlightSearchResult;
import org.prad.entity.Passenger;
import org.prad.service.FlightSearchService;
import org.prad.service.FlightSearchServiceImpl;
import org.prad.service.PassengerService;
import org.prad.service.PassengerServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "PassengerServlet", value = "/PassengerServlet")
public class PassengerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String,String> cookieMap=new HashMap<>();
        Cookie[] cookies=request.getCookies();
        HttpSession session=request.getSession();
        List<Passenger> passengerList=new ArrayList<Passenger>();
        PassengerService passengerService=new PassengerServiceImpl();

        if(cookies !=null) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie.getValue());
            }
        }

        int passengers= Integer.parseInt(cookieMap.get("seats"));
        int i=0;
        String salutation="salutation";
        String firstname="firstname";
        String lastname="lastname";
        String passport="passport";
        Passenger passenger;

        while(i<passengers){
            passenger=new Passenger(request.getParameter(salutation+i),
                    request.getParameter(firstname+i),
                    request.getParameter(lastname+i),request.getParameter(passport+i));

            passengerList.add(passenger);
            i++;
        }

        passengerService.addPassengers(passengerList);
        session.setAttribute("passengers",passengerList);

        int selectedLegIns= (int) session.getAttribute("selectedlegins");
        Cookie cookieLegIns=new Cookie("legins",String.valueOf(selectedLegIns));
        response.addCookie(cookieLegIns);



        if (selectedLegIns!=0) {

            FlightSearchResult flightSearchResult = new FlightSearchServiceImpl().
                    searchFlightById(new FlightSearchParam(selectedLegIns,Integer.parseInt(cookieMap.get("seats"))));

            session = request.getSession();
            session.setAttribute("result", flightSearchResult);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("invoice.jsp");
            requestDispatcher.forward(request, response);
        } else errorMsg(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected  void errorMsg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("msg", "Please enter passenger detail");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("PassengerServlet");
        requestDispatcher.forward(request, response);
    }
}
