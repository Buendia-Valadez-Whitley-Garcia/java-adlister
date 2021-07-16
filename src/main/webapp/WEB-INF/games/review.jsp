<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Please Log In" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="games">
        <h1>Game Review</h1>
        <h2>${sessionScope.game.title}</h2>
        <p>"Description: "${sessionScope.game.description}</p>
        <p>"Console: "${sessionScope.game.console}</p>
        <p>"Genre: "${sessionScope.game.genre}</p>
        <p>"Release Year: "${sessionScope.game.releaseDate}</p>

        <c:forEach var="reviews" items="${reviews}">
            <h2>${reviews.title}</h2>
            <p>${reviews.review}</p>
        </c:forEach>
    </div>

    <form action="/games/review" method="post">
        <div class="form-group">
            <label for="review">Leave Review</label>
            <textarea id="review" name="review" class="form-control"></textarea>
        </div>
        <input type="submit" class="btn btn-block btn-primary">
    </form>
</body>
</html>
