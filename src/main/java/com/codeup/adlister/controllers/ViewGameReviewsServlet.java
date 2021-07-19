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
