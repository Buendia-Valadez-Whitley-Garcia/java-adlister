<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <h2>${sessionScope.games.title}</h2>
        <p>"Description: "${sessionScope.games.description}</p>
        <p>"Console: "${sessionScope.games.console}</p>
        <p>"Genre: "${sessionScope.games.genre}</p>
        <p>"Release Year: "${sessionScope.games.release_date}</p>

    <c:forEach var="review" items="${reviews}">
<%--        <p>"User: ${}</p>--%>
        <p>"Title: ${review.title}</p>
        <p>"Review: ${review.review}</p>
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
