<%@ page import="beans.User" %><%--
  Created by IntelliJ IDEA.
  User: pradn
  Date: 18/6/2022
  Time: 1:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<jsp:include page="data.jsp" ></jsp:include>
<h4>This is a demo page</h4>

<%
    User user=new User();
    user.setUserName("prad");
    user.setPassword("123");
    out.println("User Name:"+user.getUserName());
    out.println("Password:"+user.getPassword());
%>
    </br>
    <jsp:useBean class="beans.User" id="user1"></jsp:useBean>
    <jsp:setProperty name="user1" property="userName" value="nil"></jsp:setProperty>
    <jsp:setProperty name="user1" property="password" value="123"></jsp:setProperty>
    User name is: <jsp:getProperty name="user1" property="userName"/> </br>
    password is: <jsp:getProperty name="user1" property="password"/> </br>

</body>
</html>
