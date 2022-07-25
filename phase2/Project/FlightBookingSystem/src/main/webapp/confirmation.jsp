<%@ page import="jakarta.servlet.http.Cookie" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="org.prad.entity.Passenger" %>
<%@ page import="org.prad.dto.FlightSearchResult" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: pradn
  Date: 2/7/2022
  Time: 11:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="template.jsp"%>
<html>
<head>
    <title>Confirmation</title>
</head>
<body>
<%!
    Cookie[] cookies;
    Map<String,String> cookieMap=new HashMap<>();
    List<Passenger> passengers;
    FlightSearchResult result;

%>

<%
    passengers=(List<Passenger>)session.getAttribute("passengers");
    result=(FlightSearchResult)session.getAttribute("result");
    cookies=request.getCookies();

    if(cookies !=null){
        for (Cookie cookie:cookies) {
            cookieMap.put(cookie.getName(),cookie.getValue());
        }
    }
%>
<h4>Hello <%=cookieMap.get("user")%>, your booking is confirmed!</h4>

<form action="LogoutServlet" method="post">
<%
    int i=0;
    for (Passenger p:passengers) {
%>
    Passenger<%=i+1%>
    <HR>
    <b>Passenger Name:</b><%=p.getSalutation()%> <%=p.getFirstName()%> <%=p.getLastName()%></br>
    </br>
    <b>Passport:</b><%=p.getPassportNo()%></br>
    </br>
    <b>Flight:</b><%=result.getAirline()%> <%=result.getModel()%></br>
    </br>
    <b>Departure:</b> <%=result.getDeparture().getName()%>
    (<%=result.getDeparture().getCode()%>) <%=result.getDepartureDate()%> <%=result.getDepartureTime()%></br>
    </br>
    <b>Arrival:</b> <%=result.getArrival().getName()%>
    (<%=result.getArrival().getCode()%>) <%=result.getDepartureDate()%> <%=result.getArrivalTime()%></br>
    </br>
<%
        i++;
    }
%>
    <b>Please login to <%=result.getAirline()%>.com to check-in and reserve seats.</b></br>
    <br>
    <input type="submit" value="Exit">
</form>
</body>
</html>
