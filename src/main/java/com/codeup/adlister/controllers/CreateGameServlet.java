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


        String noStuff = "<span style=\"color:red\">* please fill <span>";



        if (title == null) {
            request.setAttribute("empty", noStuff);
            request.setAttribute("passBackDescription", description);
            request.setAttribute("passBackDate", releaseDate);
            request.getRequestDispatcher("WEB-INF/create.jsp").forward(request, response);
            return;
        }

        //create values that will determine if a user can create a game
        boolean titleExists = true;


        //test to see if those games already exist
        Game titleTest = (Game)DaoFactory.getGamesDao().searchByTitle(title);

        if(titleTest == null){
            titleExists = false;

        }

        String gameExists = "<span style=\"color:red\">* already exists<span>";

        //create and save a new game
        if(!titleExists){
            Game game = new Game(user.getId(), title, description, console, genre, releaseDate);
            DaoFactory.getGamesDao().insert(game);
            response.sendRedirect("/games");
            } else if (titleExists){
            request.setAttribute("titleExists", gameExists);
            request.getRequestDispatcher("WEB-INF/create.jsp");
        }

//        User user = (User) request.getSession().getAttribute("user");
//        Game game = new Game(
//            user.getId(),
//            request.getParameter("title"),
//            request.getParameter("description"),
//            request.getParameter("console"),
//            request.getParameter("genre"),
//            request.getParameter("release_date")
//        );
//        DaoFactory.getGamesDao().insert(game);
//        response.sendRedirect("/games");
    }
}
