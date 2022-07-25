<%@ page import="org.prad.entity.Airport" %>
<%@ page import="jakarta.servlet.http.Cookie" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@include file="template.jsp"%>
<%--
  Created by IntelliJ IDEA.
  User: pradn
  Date: 3/7/2022
  Time: 3:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Booking</title>
</head>
<body>

<%!
    String msg;
    Cookie[] cookies;
    Map<String,String> cookieMap=new HashMap<>();

%>

<%
    msg=(String)session.getAttribute("msg");

    cookies=request.getCookies();

    if(cookies !=null){
        for (Cookie cookie:cookies) {
            cookieMap.put(cookie.getName(),cookie.getValue());
        }
    }
%>

<h4>Hello <%=cookieMap.get("user")%>, select your itinerary</h4>


</body>
</html>
