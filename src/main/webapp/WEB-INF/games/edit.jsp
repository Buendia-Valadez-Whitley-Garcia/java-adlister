<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Edit your reviews" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
        <form action="/reviews/edit" method="post">
            <div class="form-group">
                <label for="title">Edit Title</label>
                <textarea id="title" name="updateTitle" class="form-control" style="width: 450px; height: 30px; margin: 10px;">${title}</textarea>
                <label for="review">Edit Review</label>
                <textarea id="review" name="updateReview"  class="form-control" style="width: 650px; height: 250px; margin: 10px;">${review}</textarea>
            </div>
            <input type="submit" class="btn btn-block btn-primary" style="width: 200px">
        </form>
    </div>
</body>
</html>