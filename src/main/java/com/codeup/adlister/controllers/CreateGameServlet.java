package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Game;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/games/create")
public class CreateGameServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/games/create.jsp")
            .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String console = request.getParameter("console");
        String genre = request.getParameter("genre");
        String releaseDate = request.getParameter("release_date");
        User user = (User)request.getSession().getAttribute("user");

        String gameExists = "<span style=\"color:red\">* already exists<span>";
        String noStuff = "<span style=\"color:red\">* please fill <span>";

        boolean inputHasErrors = title.isEmpty() || description.isEmpty() || releaseDate.isEmpty();

        if(inputHasErrors){
            response.sendRedirect("/games/create");
            return;
        }

        boolean gameTitleExists = true;
        System.out.println(title);
        Game gameTitleTest = DaoFactory.getGamesDao().findByTitle(title);

        if(gameTitleTest == null){
            gameTitleExists = false;
        }

        //create and save a new game
        if(!gameTitleExists){
            Game game = new Game(user.getId(), title, description, console, genre, releaseDate);
            DaoFactory.getGamesDao().insert(game);
            response.sendRedirect("/games");
        } else if(gameTitleExists){
            request.setAttribute("titleExists", gameExists);
            request.getRequestDispatcher("/WEB-INF/games/create.jsp").forward(request, response);
        }


    }
}
