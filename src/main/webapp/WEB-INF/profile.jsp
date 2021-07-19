<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
        <h1>Welcome, ${sessionScope.user.username}!</h1>
        <h2>User Tools:</h2>
        <hr style="margin: 0px;"><br>
        <div class="well well-sm" style="width: 530px; margin: auto;">
            <i class="far fa-envelope"></i> View Messages •
            <i class="fad fa-user-friends"></i> View Games •
            <i class="fal fa-chalkboard-teacher"></i> Message Board •
            <i class="far fa-file-export"></i> Approve Posts
        </div>
        <br>
        <h2>Welcome to your Gamelister Hub!</h2><br>
        Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut
        labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris
        nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit
        esse cillum dolore eu fugiat nulla pariatur.
        Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut
        labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris
        nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit
        esse cillum dolore eu fugiat nulla pariatur.
        <h2>Here are your reviews:</h2>
        <hr style="margin: 0px;">
        <div class="card" style="padding: 30px; margin: 0px; width: 85vw">
            <form action="/profile" method="post">
            <c:forEach var="reviews" items="${reviews}">
                <div class="card">
                    <h5 class="card-header">${reviews.title}</h5>
                    <div class="card-body">
                        <p class="card-text">${reviews.review}</p>
                        <button name="edit" value="${reviews.id}" type="submit" class="btn btn-info" >Edit</button>
                        <button name="delete" value="${reviews.id}" type="submit" class="btn btn-danger" >Delete</button>
                    </div>
                </div>
            </c:forEach>
            </form>
        </div>
    </div>
</body>
</html>
