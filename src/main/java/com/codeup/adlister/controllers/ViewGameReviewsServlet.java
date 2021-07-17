package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Game;
import com.codeup.adlister.models.Review;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@WebServlet(name = "controllers.ViewGameReviewServlet", urlPatterns ="/game/reviews")
public class ViewGameReviewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("game") == null){
            resp.sendRedirect("/games");
            return;
        }

        Game game = (Game) req.getSession().getAttribute("game");
        List<Review> results = DaoFactory.getReviewsDao().gameReviews(game.getId());
        req.setAttribute("reviews", results);
        req.getRequestDispatcher("/WEB-INF/games/review.jsp").forward(req, resp);

        //we need to make sure that a user cant post a review unless they are logged in.
        //format the page so it looks nice
        //check if the user that's logged into the session has a review on that game and display a delete or edit button for that post
        //      if true (or handle this in the profile)

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = (User) req.getSession().getAttribute("user");
        Game game = (Game) req.getSession().getAttribute("game");
        String newTitle = req.getParameter("newTitle");
        String newReview = req.getParameter("newReview");
        Review review = new Review (
            user.getId(),
            game.getId(),
            newTitle,
            newReview
        );
        DaoFactory.getReviewsDao().insert(review);
        resp.sendRedirect("/game/reviews");
    }
}
