<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad" />
    </jsp:include>
</head>
<body>
<div class="container">
    <h1>Create a new Game</h1>
    <form action="/games/create" method="post">
        <div class="form-group">
            <label for="title">Title</label>
            <input id="title" name="title" class="form-control" type="text">
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea id="description" name="description" class="form-control" type="text"></textarea>
        </div>
        <div class="form-group">
            <select class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <option class="other">All consoles</option>
                <option class="playstation">Playstation</option>
                <option class="xbox">XBox</option>
                <option class="nintendo">Nintendo</option>
                <option class="wii">Wii</option>
                <option class="other">Other</option>
            </select>
        </div>
        <div class="form-group">
            <select class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <option value="all" >All genres</option>
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
            <label for="release-date" placeholder="year">Release date</label>
            <input id="release-date" name="release-date" class="form-control" type="text">
        </div>
        <input type="submit" class="btn btn-block btn-primary">
    </form>
</div>
</body>
</html>