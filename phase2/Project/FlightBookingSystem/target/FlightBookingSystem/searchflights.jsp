<%--
  Created by IntelliJ IDEA.
  User: pradn
  Date: 2/7/2022
  Time: 2:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="org.prad.entity.Airport"
         import="java.util.List" %>
<%@ page import="jakarta.servlet.http.Cookie" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@include file="template.jsp"%>


<html>
<head>
    <title>Search Flights</title>
</head>
<body>

<%!
    String msg;
    List<Airport> airports;
    Cookie[] cookies;
    Map<String,String> cookieMap=new HashMap<>();

%>

<%
    msg=(String)session.getAttribute("msg");
    airports=(List<Airport>) session.getAttribute("airports");

    cookies=request.getCookies();

    if(cookies !=null){
        for (Cookie cookie:cookies) {
            cookieMap.put(cookie.getName(),cookie.getValue());
        }
    }
%>

<h4>Hello <%=cookieMap.get("user")%>, select your itinerary.</h4>

<form action="FlightSearchServlet" method="post">

    <label>Departure Date:</label>
    <input type="date" id="date" name="date">

    <label>Departure:</label>
    <select name="departure" id="departure">
    <%
        if(airports!=null){
        for (Airport airport:airports) {
    %>
        <Option selected disabled hidden> Select Departure Airport</Option>
        <option value="<%=airport.getCode()%>"><%=airport.getName()%> (<%=airport.getCode()%>)</option>
    <%
        }
    %>
    </select>

    <label>Arrival:</label>

    <select name="arrival" id="arrival">
        <%
            for (Airport airport:airports) {
        %>
        <Option selected disabled hidden> Select Arrival Airport</Option>
        <option value="<%=airport.getCode()%>"><%=airport.getName()%> (<%=airport.getCode()%>)</option>
        <%
            }
            }
        %>
    </select>

    <label>Passengers:</label>
    <select name="passengers" id="passengers">
        <%
            int i=1;
            while (i<6) {
        %>
        <option value="<%=i%>"><%=i%></option>
        <%
             i++;
            }
        %>
    </select>
    <input type="submit" value="Search">

    </br>
    </br>
    <%=msg%>
</form>

</body>
</html>
