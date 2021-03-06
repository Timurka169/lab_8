<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Catalog Example</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <header>
        <div>
            <h1>Catalog</h1>
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
    <main>
        <ul>
            <li>
                <c:choose>
                    <c:when test="${authorized == true}">
                        <form method="post">
                            <ul>
                                <li>
                                    <label>
                                        <strong>Name</strong>
                                        <br>
                                        <input type="text" name="name">
                                    </label>
                                </li>
                                <li>
                                    <label>
                                        <strong>Price</strong>
                                        <br>
                                        <input type="number" name="price">
                                    </label>
                                </li>
                                <li>
                                    <label>
                                        <strong>Category</strong>
                                        <br>
                                        <select name="category">
                                            <c:forEach items="${categories}" var="category">
                                                <option value="${category.id}">${category.name}</option>
                                            </c:forEach>
                                        </select>
                                    </label>
                                </li>
                                <li>
                                    <input type="submit" value="Add offering">
                                </li>
                            </ul>
                        </form>
                    </c:when>
                    <c:otherwise>
                        <h4><a href="${pageContext.request.contextPath}/login">Login</a> to add your offering</h4>
                    </c:otherwise>
                </c:choose>
            </li>
            <c:forEach items="${offerings}" var="offering">
                <li>
                    <div class="text">
                    <h2><a href="${pageContext.request.contextPath}/offering?id=${offering.id}">${offering.name}</a></h2>
                    for <strong>${offering.price}</strong> points
                    </div>
                    <c:choose>
                            <c:when test="${authorized == true}">
                                <c:choose>
                                <c:when test="${offering.like == true}">
                                   <div class="picture">
                                       <img src="owl.jpg" width="60" height="60"/>
                                   </div>
                                </c:when>
                                <c:otherwise>
                                    <h4><a href="${pageContext.request.contextPath}/like?id=${offering.id}">Like!</a></h4>
                                </c:otherwise>
                                </c:choose>
                            </c:when>
                            <c:otherwise>
                                <h5><a href="${pageContext.request.contextPath}/login">Login</a> to add your like</h5>
                            </c:otherwise>

                    </c:choose>

                </li>
            </c:forEach>
        </ul>
    </main>
</body>
</html>
