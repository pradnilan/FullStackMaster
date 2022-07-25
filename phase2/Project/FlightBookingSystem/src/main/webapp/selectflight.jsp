<%--
  Created by IntelliJ IDEA.
  User: pradn
  Date: 2/7/2022
  Time: 11:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.List"
    import="org.prad.dto.FlightSearchResult"%>
<%@ page import="jakarta.servlet.http.Cookie" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="org.prad.dto.FlightSearchParam" %>
<%@include file="template.jsp"%>
<html>
<head>
    <title>Available Flights</title>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 75%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>

<%!
    String msg;
    List<FlightSearchResult> results;
    FlightSearchParam searchParams;
    Cookie[] cookies;
    Map<String,String> cookieMap=new HashMap<>();
%>

<%
    msg=(String)session.getAttribute("msg");
    String test=(String)session.getAttribute("test");
    results=(List<FlightSearchResult>) session.getAttribute("searchresults");
    searchParams=(FlightSearchParam) session.getAttribute("searchparam");

    cookies=request.getCookies();

    if(cookies !=null){
        for (Cookie cookie:cookies) {
            cookieMap.put(cookie.getName(),cookie.getValue());
        }
    }
%>

<h3>Hello <%=cookieMap.get("user")%>, please select your flight.</h3>

<%
    if(searchParams!=null){
%>
<b>Departure Date:</b> <%=searchParams.getDate()%></br>
</br>
<b>Departure Airport:</b> <%=searchParams.getDepartureCode()%></br>
</br>
<b>Arrival Airport:</b> <%=searchParams.getArrivalCode()%></br>
</br>
<b>Number of Passengers:</b> <%=searchParams.getNoSeats()%></br>
</br>
<%
    }
%></br>

<form action="passengerdetail.jsp" method="post">

    <table>
    <tr>
        <th style="width: 15px"></th>
        <th style="width: 75px">Flight No</th>
        <th style="width: 75px">Airline</th>
        <th style="width: 75px">Flight</th>
        <th style="width: 250px">Departure Airport</th>
        <th style="width: 100px">Departure Time</th>
        <th style="width: 250px">Arrival Airport</th>
        <th style="width: 100px">Arrival Time</th>
        <th style="width: 100px">Price (USD)</th>
    </tr>

    <%
        if(results!=null){
        for (FlightSearchResult result:results) {
    %>
   <%-- <input type="radio" id=<%=result.getFlightNo()%> name="selectedflight" value=<%=result.getFlightNo()%>
    <label for=<%=result.getFlightNo()%>><%=result.getFlightNo()%></label><br>
    Airline:<%=result.getAirline()%></br>
    Flight: <%=result.getManufacture()%> <%=result.getModel()%></br>
    Departure:<%=result.getDepartureTime()%></br>
    Arrival:<%=result.getArrivalTime()%></br>--%>

    <tr>
        <td>
            <input type="radio" id="id" name="selectedlegins" value=<%=result.getLegInstanceId()%>>
            </td>
        <td><%=result.getFlightNo()%></td>
        <td><%=result.getAirline()%></td>
        <td><%=result.getManufacture()%> <%=result.getModel()%></td>
        <td><%=result.getDeparture().getName()%> (<%=result.getDeparture().getCode()%>)</td>
        <td><%=result.getDepartureDate()%> <%=result.getDepartureTime()%></td>
        <td><%=result.getArrival().getName()%> (<%=result.getArrival().getCode()%>)</td>
        <td><%=result.getDepartureDate()%> <%=result.getArrivalTime()%></td>
        <td><%=result.getPrice()%></td>
    </tr>

    <%
        }
        }
    %>
    </table> </br>
    <%=msg%> </br>
    </br>
    <input type="submit" value="Book Flight">


</form>

</body>
</html>
