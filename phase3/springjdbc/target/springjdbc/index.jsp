<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Hello World!</h2>
<a href="/getdata">Get All Products</a>

<form action="details" method="post">
    Enter Product Id:   <input type="text" name="id">
                        <input type="submit" value="search">
</form>

</body>
</html>
