<%--
  Created by IntelliJ IDEA.
  User: Juwon
  Date: 2022-09-19
  Time: 오후 7:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Model.UsersDTO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL Core Test</title>
</head>
<body>

    <%
        // Set user via DTO.
        UsersDTO user = new UsersDTO();
        user.setUserName("John");
        user.setUserAddress("Boston");
        user.setUserAge(35);
        // Set Request attribute.
        request.setAttribute("userRequest", user);
    %>

    <!-- c:set -->
    <c:set var="justName1" value="James"/>
    <c:set var="justName2" value="Jimmy"/>
    <c:set var="userName" value="<%=user.getUserName()%>" scope="request"/>
    <c:set var="age" value="<%=user.getUserAge()%>" scope="request"/>
    <c:set target="${userRequest}" property="name" value="Steve"/>
    <c:set target="<%=user%>" property="name" value="before"
    <!-- output inform -->
    <h3></h3>
</body>
</html>
