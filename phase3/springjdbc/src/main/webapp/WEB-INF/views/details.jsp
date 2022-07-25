<%--
  Created by IntelliJ IDEA.
  User: pradn
  Date: 21/7/2022
  Time: 8:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>EProducts</title>
</head>
<body>
<h1>Product Detail</h1>

<table>
    <thead>
    <tr>
        <th>ID</th> <th>Name</th> <th>Price</th> <th>Date</th>
    </tr>
    </thead>
        <tbody>
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.dateAdded}</td>
        </tr>
        </tbody>
</table>
<a href="edit?id=${product.id}">Edit Product</a>


</body>
</html>
