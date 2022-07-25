<%@ page import="jakarta.servlet.http.Cookie" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="org.prad.dto.FlightSearchResult" %>
<%@include file="template.jsp"%><%--
  Created by IntelliJ IDEA.
  User: pradn
  Date: 2/7/2022
  Time: 11:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Payment</title>
    <style>input {
        //display: ;
        //float: left;
        alignment: left;
    }
    label{
        //display: inline-block;
        //float: left;
        //clear: left;
        //width: 250px;
        //text-align: right;
    }</style>
</head>
<body>
<%!
    String msg;
    Cookie[] cookies;
    Map<String,String> cookieMap=new HashMap<>();
    FlightSearchResult result;

%>

<%
    msg=(String)session.getAttribute("msg");
    result=(FlightSearchResult)session.getAttribute("result");

    cookies=request.getCookies();

    if(cookies !=null){
        for (Cookie cookie:cookies) {
            cookieMap.put(cookie.getName(),cookie.getValue());
        }
    }
%>
<h3>Hello <%=cookieMap.get("user")%>, proceed to payment to reserve your seats</h3>

<%
    if(result!=null){
%>

<b>Flight:</b><%=result.getAirline()%> <%=result.getModel()%></br>
</br>
<b>Departure:</b> <%=result.getDeparture().getName()%>
        (<%=result.getDeparture().getCode()%>) <%=result.getDepartureDate()%> <%=result.getDepartureTime()%></br>
</br>
<b>Arrival:</b> <%=result.getArrival().getName()%>
        (<%=result.getArrival().getCode()%>) <%=result.getDepartureDate()%> <%=result.getArrivalTime()%></br>
</br>
<b>Price:</b> USD <%=result.getPrice()%></br>
</br>
<b>Passengers:</b><%=cookieMap.get("seats")%></br>
</br>
<b>Total Price:</b> USD <%=result.getTotal()%></br>
</br>
    <%
    }
%></br>

<HR>
<h3>Payment</h3>

    <form action="confirmation.jsp" method="post">
        <input type="radio" value="Mastercard" name="card">Master Card
        <input type="radio" value="Visa" name="card">Visa</br>
        </br>
        <label>Card Holder's Name:</label></label><input type="text" name="name" minlength="1" maxlength="40"></br>
        </br>
        <label>Email:</label><input type="email" name="email"></br>
        </br>
        <label>Card Number:</label><input type="text" name="cardnumber" minlength="16" maxlength="16"></br>
        </br>
        <label>Card Expiry:</label><input type="text" placeholder="month" size="6" minlength="2" maxlength="2">/<input type="text" placeholder="year" size="12" minlength="4" maxlength="4"></br>
        </br>
    <input type="submit" value="Make Payment">
</form>





</body>
</html>
