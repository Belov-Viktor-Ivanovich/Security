<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<%@page import="somePackage.Cart" %>
<% Cart cart = (Cart) session.getAttribute("cart"); %>
<p>Название: <%=cart.getName() %></p>
<p>Колличество: <%=cart.getQuantity() %></p>
</body>
</html>
