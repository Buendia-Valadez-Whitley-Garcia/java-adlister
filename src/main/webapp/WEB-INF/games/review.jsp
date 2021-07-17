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
<div class="container">
    <div class="games">
        <h2>Game Overview</h2>
        <h2>${sessionScope.game.title}</h2>
        <p>"Description: "${sessionScope.game.description}</p>
        <p>"Console: "${sessionScope.game.console}</p>
        <p>"Genre: "${sessionScope.game.genre}</p>
        <p>"Release Year: "${sessionScope.game.releaseDate}</p>

        <h3>Reviews submitted by our users</h3>
        <hr style="margin: 0px;">
        <div class="card" style="padding: 30px;">
            <c:forEach var="reviews" items="${reviews}">
                <h4>${reviews.title}</h4>
                <p>${reviews.review}</p>
                <hr style="margin: auto; width: 800px">
            </c:forEach>
        </div>
    </div>


    <h3>Want to submit a review?</h3>
    <hr style="margin: 0px;">
    <form action="/game/reviews" method="post">
        <div class="form-group">
            <textarea id="title" name="newTitle" class="form-control" style="width: 450px; height: 50px; margin: 10px;" placeholder="Enter title here"></textarea>
            <textarea id="review" name="newReview" class="form-control" style="width: 650px; height: 150px; margin: 10px;" placeholder="Please enter your review"></textarea>
        </div>
        <input type="submit" class="btn btn-block btn-primary">
    </form>
</div>
</body>
</html>
