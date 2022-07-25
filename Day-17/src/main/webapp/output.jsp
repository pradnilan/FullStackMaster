<%@ page import="java.util.Date" extends="java.lang.Thread" %><%--
  Created by IntelliJ IDEA.
  User: pradn
  Date: 5/6/2022
  Time: 10:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%
        String name=request.getParameter("uname");
        out.println("Hello "+name);
        session.setAttribute("user",name);
        String userName=application.getInitParameter("username");
        out.println("Context param value is "+userName);
        Date date=new Date();

        start();
    %></br>

    <%= "Today is:"+date%>

</body>
</html>
