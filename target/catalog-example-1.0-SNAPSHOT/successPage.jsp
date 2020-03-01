<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: owlet
  Date: 01.03.2020
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success!</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<header>
    <div>
        <h1><a href="${pageContext.request.contextPath}/">Catalog</a> > Success!</h1>
    </div>

    <c:if test="${authorized == true}">
        <div class="journey">
            <h3><a href="${pageContext.request.contextPath}/journey">Journey</a></h3>
        </div>
        <div class="logout">
            <h3><a href="${pageContext.request.contextPath}/logout">Logout</a></h3>
        </div>
    </c:if>
</header>
<c:choose>
<c:when test="${authorized == true}">
        <h3>You are authorized now!</h3>
</c:when>
<c:otherwise>
    <h3>You are successfully registered now!</h3>
</c:otherwise>
</c:choose>


</body>
</html>
