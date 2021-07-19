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


//             sticky for empty fields work, except for description because it is not an input field,
//             it is a textarea.

                boolean titleEmpty = title.isEmpty();
                boolean descriptionEmpty = description.isEmpty();
                boolean releaseEmpty = releaseDate.isEmpty();

                String empty = "<span style=\"color:red\">*Empty field, please fill.<span>";
                if(titleEmpty){
                        request.setAttribute("titleEmpty", empty);
                        request.setAttribute("descriptionAttempt", description);
                        request.setAttribute("releaseAttempt", releaseDate);
                     request.getRequestDispatcher("/WEB-INF/games/create.jsp").forward(request, response);
                    }else if (descriptionEmpty){
                        request.setAttribute("titleAttempt", title);
                        request.setAttribute("descriptionEmpty", empty);
                        request.setAttribute("releaseAttempt", releaseDate);
                     request.getRequestDispatcher("/WEB-INF/games/create.jsp").forward(request, response);
                    } else if(releaseEmpty){
                     request.setAttribute("releaseEmpty", empty);
                     request.setAttribute("titleAttempt", title);
                     request.setAttribute("descriptionAttempt", description);
                     request.getRequestDispatcher("/WEB-INF/games/create.jsp").forward(request, response);
                 }





        String gameExists = "<span style=\"color:red\">* already exists<span>";

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
