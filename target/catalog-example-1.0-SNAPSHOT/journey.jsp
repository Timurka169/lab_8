<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Journey List</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<header>
    <div>
        <h1><a href="${pageContext.request.contextPath}/">Catalog</a> > Journey List</h1>
    </div>
    <c:if test="${authorized == true}">
        <div class="logout">
            <h3><a href="${pageContext.request.contextPath}/logout">Logout</a></h3>
        </div>
    </c:if>
</header>
<main>
    <ul>
        <li>
            <c:choose>
                <c:when test="${authorized == true}">
                    <form method="post">
                        <ul>
                            <li>
                                <input type="submit" value="Clean all paths">
                            </li>
                        </ul>
                    </form>
                </c:when>
                <c:otherwise>
                    <h4><a href="${pageContext.request.contextPath}/login">Login</a> to see your history</h4>
                </c:otherwise>
            </c:choose>
        </li>
        <c:choose>
            <c:when test="${authorized == true}">
                <c:forEach items="${paths}" var="path">
                    <li>
                        <h2><a href="${path}">${path}</a></h2>
                    </li>
                </c:forEach>
            </c:when>
            <c:otherwise>
            </c:otherwise>
        </c:choose>

    </ul>
</main>
</body>
</html>

