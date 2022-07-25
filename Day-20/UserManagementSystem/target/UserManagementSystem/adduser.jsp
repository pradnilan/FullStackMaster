<%--
  Created by IntelliJ IDEA.
  User: pradn
  Date: 19/6/2022
  Time: 11:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add User</title>
</head>
<body>

    <form action="AddUserServlet" method="post">
        First Name: <input type="text" name="fname"></br>
        Last Name: <input type="text" name="lname"></br>
        User Name: <input type="text" name="uname"></br>
        Password: <input type="password" name="pwd"></br>
        <input type="submit" value="Add User">
    </form>

</body>
</html>
