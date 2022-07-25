<%@ page import="jakarta.servlet.http.Cookie" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: pradn
  Date: 3/7/2022
  Time: 11:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="template.jsp"%>
<html>
<head>
    <title>Passenger Detail</title>
</head>
<body>
<%!
    String msg;
    Cookie[] cookies;
    Map<String,String> cookieMap=new HashMap<>();
    String selectedlegins;

%>

<%
    msg=(String)session.getAttribute("msg");
    selectedlegins= (request.getParameter("selectedlegins"));
    session.setAttribute("selectedlegins",Integer.parseInt(selectedlegins));
    cookies=request.getCookies();

    if(cookies !=null){
        for (Cookie cookie:cookies) {
            cookieMap.put(cookie.getName(),cookie.getValue());
        }
    }
%>


<h4>Hello <%=cookieMap.get("user")%>, please enter passenger's detail</h4>

<form action="PassengerServlet" method="post">

    <%
        int i=0;
        String salutation="salutation";
        String firstname="firstname";
        String lastname="lastname";
        String passport="passport";


        while(i<Integer.parseInt(cookieMap.get("seats"))){
        salutation="salutation"+i;
        firstname="firstname"+i;
        lastname="lastname"+i;
        passport="passport"+i;



    %>
    </br>
    <b>Passenger <%=i+1%></b></br>
    <HR>

    <select name=<%=salutation%> id=<%=salutation%>>
        <Option selected disabled hidden> select</Option>
        <option value="Mr.">Mr.</option>
        <option value="Mrs.">Mrs.</option>
        <option value="Ms.">Ms.</option>
        <option value="Dr.">Dr.</option>
        <option value="Miss.">Miss.</option>
    </select>

    First Name: <input type="text" name=<%=firstname%>>
    Last Name: <input type="text" name=<%=lastname%>>
    Passport: <input type="text" name=<%=passport%>>
    </br>

    <%
            i++;
        }
    %>
    </br>
    <input type="submit" value="submit">


</form>

</body>
</html>
