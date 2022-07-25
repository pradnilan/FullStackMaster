<html>
<body>
<h2>Welcome to User Management System</h2>

<%
    String msg= (String) request.getAttribute("msg");
    if(msg != null) out.print(msg);
%>

<a href="adduser.jsp">Add User</a></body></br>
<a href="updateuser.jsp">Update User</a></body></br>
<a href="deleteuser.jsp">Delete User</a></body></br>
<a href="serachuser.jsp">Search User</a></body></br>
<a href="getalluser.jsp">Get All User</a></body></br>
</body>

</body>
</html>
