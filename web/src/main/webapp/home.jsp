<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 3/8/2019
  Time: 10:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.capgemini.heskuelita.core.beans.User" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <h1>Home</h1>
    <br>
    Hello:
    <%
        User us = (User) session.getAttribute("user");
        us.getUsername();
    %>
</body>
</html>
