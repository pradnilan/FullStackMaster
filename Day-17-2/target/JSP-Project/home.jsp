<%--
  Created by IntelliJ IDEA.
  User: pradn
  Date: 18/6/2022
  Time: 5:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    String userName= (String) session.getAttribute("userName");
%>

    Hello<%= userName%>, plase select from below options:

    <form action="EmployeeServlet" method="post">
        <input type="submit" value="Add Employee" name="emp"></br>
        <input type="submit" value="Delete Employee" name="emp"></br>
        <input type="submit" value="Get All Employee" name="emp"></br>
    </form>

</body>
</html>
