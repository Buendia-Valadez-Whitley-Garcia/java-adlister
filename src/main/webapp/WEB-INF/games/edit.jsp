<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%= "some title" %>
    </title>
</head>
<body>
<form action="/reviews/edit" method="post">
    <div class="form-group">
        <label for="title">Title</label>
        <textarea id="title" name="updateTitle" class="form-control" style="width: 450px; height: 50px; margin: 10px;">${title}</textarea>
        <label for="review">Review</label>
        <textarea id="review" name="updateReview"  class="form-control" style="width: 650px; height: 150px; margin: 10px;">${review}</textarea>
    </div>
    <input type="submit" class="btn btn-block btn-primary">
</form>

</body>
</html>