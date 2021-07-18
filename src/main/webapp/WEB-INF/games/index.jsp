<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
    <style>
        .cardDisplay {
            height: 400px;
            margin: 10px;
        }
    </style>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h2>Game selection:</h2>
    <form action="/genre" method="post">
        <div class="form-group">
            <label for="dropdownMenuButton2">Search by genre</label>
            <select class="btn btn-secondary dropdown-toggle" id="dropdownMenuButton2" name="genreSearch" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" onchange="this.form.submit()">
                <option value="all-genres" >All genres</option>
                <option value="action">Action</option>
                <option value="adventure">Adventure</option>
                <option value="battle-royale">Battle Royale</option>
                <option value="fighting">Fighting</option>
                <option value="mmo">MMO</option>
                <option value="racing">Racing</option>
                <option value="role-play">Role-play</option>
                <option value="sandbox">Sandbox</option>
                <option value="sports">Sports</option>
                <option value="strategy">Strategy</option>
                <option value="other">Other</option>
            </select>
        </div>
    </form>
    <hr style="margin: 0px;">
      <form action="/games" method="post">
              <div class="row">
             <c:forEach var="game" items="${games}">
                 <div class="cardDisplay col-md-5">
                    <h2>${game.title}</h2>
                    <p>${game.description}</p>
                    <p>${game.console}</p>
                    <p>${game.genre}</p>
                    <p>${game.releaseDate}</p>
                    <button name="selectedGame" type="submit" value="${game.id}" class="btn btn-block btn-primary">Reviews</button>
                 </div>
             </c:forEach>
              </div>
        </form>
    </div>
</body>
</html>
