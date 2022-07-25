<!--
  Created by IntelliJ IDEA.
  User: pradn
  Date: 5/6/2022
  Time: 10:35 PM
  To change this template use File | Settings | File Templates.
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
    <head><title>Title</title></head>
    <body>
    <%@include file="data.jsp"%>
    <h1>Welcome to Login page!</h1>

    <form action="output.jsp" method="post">
        User Name:<input type="text" name="uname"><br>
        Password:<input type="text" name="pwd"><br>
        <input type="submit" value="Login">
    </form>


    </form>

    </body>
    </html>
