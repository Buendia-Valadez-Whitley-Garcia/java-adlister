<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Here Are all the games!</h1>
    <form action="/reviews" method="post">
    <c:forEach var="game" items="${games}">
        <div class="col-md-6">
            <h2>${game.title}</h2>
            <p>${game.description}</p>
            <p>${game.console}</p>
            <p>${game.genre}</p>
            <p>${game.release_date}</p>
        </div>
        <input name="${game.id}" type="submit" value="Reviews" class="btn btn-block btn-primary">
    </c:forEach>
    </form>
</div>

</body>
</html>
