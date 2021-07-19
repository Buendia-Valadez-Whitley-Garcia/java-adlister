<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">
    <h1>Create a new Game</h1>
    <form action="/games/create" method="post">
        <div class="form-group">
            <label for="title">Title ${titleExists} ${titleEmpty}</label>
            <input id="title" name="title" class="form-control" type="text" value="${titleAttempt}">
        </div>
        <div class="form-group">
            <label for="description">Description ${descriptionEmpty}</label>
            <textarea id="description" name="description" class="form-control">${descriptionAttempt}</textarea>
        </div>
        <div class="form-group">
            <label for="dropdownMenuButton">Console</label>
            <select class="btn btn-secondary dropdown-toggle" id="dropdownMenuButton" name="console" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <option value="all-consoles">All consoles</option>
                <option value="playstation">Playstation</option>
                <option value="xbox">XBox</option>
                <option value="nintendo">Nintendo</option>
                <option value="wii">Wii</option>
                <option value="other">Other</option>
            </select>
        </div>
        <div class="form-group">
            <label for="dropdownMenuButton2">Genre</label>
            <select class="btn btn-secondary dropdown-toggle" id="dropdownMenuButton2" name="genre" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
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
        <div class="form-group">
            <label for="release-date" placeholder="year">Release date ${releaseEmpty}</label>
            <input id="release-date" name="release_date" class="form-control" type="text" value="${releaseAttempt}">
        </div>
        <input type="submit" class="btn btn-block btn-primary">
    </form>
</div>
</body>
</html>