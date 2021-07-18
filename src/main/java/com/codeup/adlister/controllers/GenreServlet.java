package com.codeup.adlister.controllers;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Game;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/genre")
public class GenreServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String genreSearch = req.getParameter("genreSearch");
        List<Game> results = DaoFactory.getGamesDao().findByGenre(genreSearch);
        req.setAttribute("games", results);
        req.getRequestDispatcher("/WEB-INF/games/index.jsp").forward(req, resp);
    }
}