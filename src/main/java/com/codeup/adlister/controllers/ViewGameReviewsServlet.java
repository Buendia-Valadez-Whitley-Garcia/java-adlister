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

@WebServlet("/game/reviews")
public class ViewGameReviewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("game") == null){
            resp.sendRedirect("/games");
            return;
        }
        req.getRequestDispatcher("/WEB-INF/games/review.jsp").forward(req, resp);

        //we need to make sure that a user cant post a review unless they are logged in.
        //Refactor the review page to host reviews based on game ID
        //format the page so it looks nice
        //check if the user that's logged into the session has a review on that game and display a delete or edit button for that post
        //      if true (or handle this in the profile)

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //this will handle all review posts made from the game page
        //get user from session
    }
}
