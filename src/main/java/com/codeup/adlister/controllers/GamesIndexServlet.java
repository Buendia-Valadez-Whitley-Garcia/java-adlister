package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Game;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/games")
public class GamesIndexServlet extends HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("games", DaoFactory.getGamesDao().all());
        req.getRequestDispatcher("/WEB-INF/games/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String stringGameID = req.getParameter("selectedGame");
        Long gameID = Long.parseLong(stringGameID);

        Game game = DaoFactory.getGamesDao().findByID(gameID);

        req.getSession().setAttribute("game", game);
        resp.sendRedirect("/game/reviews");
    }
}