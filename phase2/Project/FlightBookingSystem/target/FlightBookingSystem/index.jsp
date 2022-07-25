<%--
  Created by IntelliJ IDEA.
  User: pradn
  Date: 2/7/2022
  Time: 1:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="template.jsp"%>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
</br>
</br>
<form action="ValidateUserServlet" method="post">

    user name:<input type="text" name="user"></br>
    </br>
    Password:<input type="password" name="pwd"></br>
    </br>
    <input type="submit" value="Login"></br>
    </br>
    <a href="google.com">Signup</a>
</form>

<%!
    String msg;
    String validation;

%>

<%
    validation=(String) session.getAttribute("validation");
    msg=(String)session.getAttribute("msg");

%>

<%=msg%>

</body>
</html>
