package org.prad.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.prad.dto.FlightSearchParam;
import org.prad.dto.FlightSearchResult;
import org.prad.service.FlightSearchServiceImpl;
import org.prad.service.FlightSearchService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "FlightSearchServlet", value = "/FlightSearchServlet")
public class FlightSearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie noSeatCk;

        String date=request.getParameter("date");
        String departure = request.getParameter("departure");
        String arrival = request.getParameter("arrival");
        String passengers = request.getParameter("passengers");

        boolean isInputValid=date!="" & departure!=null & arrival!=null & passengers!="";

        if(isInputValid) {

            if (!departure.equals(arrival)) {

                LocalDate departureDate = LocalDate.parse(date);
                int seats = Integer.parseInt(passengers);

                FlightSearchParam flightSearchParam = new FlightSearchParam(departureDate, departure, arrival, seats);

                FlightSearchService flightSearch = new FlightSearchServiceImpl();
                List<FlightSearchResult> searchResults = flightSearch.searchFlights(flightSearchParam);
                System.out.println(searchResults);

                HttpSession session = request.getSession();
                session.setAttribute("searchresults", searchResults);
                session.setAttribute("searchparam",flightSearchParam);
                noSeatCk= new Cookie("seats",passengers);
                response.addCookie(noSeatCk);

                String msg;
                if(searchResults==null) msg="Sorry, no direct flights on selected date/between two airports";
                else msg=searchResults.size()+" flights on selected date";
                session.setAttribute("msg",msg);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("selectflight.jsp");
                requestDispatcher.forward(request, response);
            } else  errorMsg(request,response);
        }

        else errorMsg(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected  void errorMsg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("msg", "Invalid selection, please try again!");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("searchflights.jsp");
        requestDispatcher.forward(request, response);
    }
}
