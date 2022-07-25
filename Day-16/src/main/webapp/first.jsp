<%--
  Created by IntelliJ IDEA.
  User: pradn
  Date: 5/6/2022
  Time: 12:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%!
        int i;
        String s;
        void sayHello(){
            System.out.println("Hello From JSP");
        }
    %>
    <%
        i=100;
        s="Hello";
        sayHello();
    %>

    <%="i is:" +i %></br>
    <%="s is:" +s %>

</body>
</html>
