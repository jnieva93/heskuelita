<%@ page import="com.capgemini.heskuelita.core.beans.User" contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="US-ASCII">
    <title>Login Page</title>
</head>
<body>

<%User us = (User)session.getAttribute ("user");%>
Welcome : <%=us.getUserName() + ". Tu email es: " + us.getEmail() + " y tu contrasena es: " + us.getPassword()%>
</body>
</html>