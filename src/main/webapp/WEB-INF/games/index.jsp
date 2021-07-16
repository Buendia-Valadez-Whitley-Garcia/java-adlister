<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
    <style>
        .cardDisplay {
            height: 350px;
            margin: 10px;


        }
    </style>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1 class="text-align-center">Here Are all the games!</h1>
  
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
