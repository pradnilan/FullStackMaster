<%@ page import="com.simplilearn.model.Employee" %>
<%@ page import="java.util.Set" %><%--
  Created by IntelliJ IDEA.
  User: pradn
  Date: 18/6/2022
  Time: 8:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Employee</title>
</head>
<body>

    <%
     Set<Employee> allEmps= (Set<Employee>) session.getAttribute("allEmps");
    %>
        <table style="border: 2px #abd3ff">
            <tr>
                <th>Emp Id</th>
                <th>Emp Name</th>
                <th>Designation</th>
            </tr>

    <%
        for(Employee employee:allEmps){
    %>
        <tr>
            <td><%= employee.getEmpId()%></td>
            <td><%= employee.getEmpName()%></td>
            <td><%= employee.getDesignation()%></td>
        </tr>
    <%
     }
    %>
        </table>

</body>
</html>
