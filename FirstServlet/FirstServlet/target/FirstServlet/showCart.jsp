<%@ page import="somePackage.Cart" %><%--
  Created by IntelliJ IDEA.
  User: Марина
  Date: 07.04.2024
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show somePackage.Cart</title>
</head>
<body>
    <%@page import="somePackage.Cart" %>
    <% Cart cart = (Cart) session.getAttribute("cart"); %>

    <p>Название: <%=cart.getName()%></p>
    <p>Колличество: <%=cart.getQuantity()%></p>
</body>
</html>
