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
import java.sql.ResultSet;
import java.util.List;

@WebServlet(name = "controllers.ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        User user = (User) request.getSession().getAttribute("user");
        List<Review> results = DaoFactory.getReviewsDao().all(user.getId());
        request.setAttribute("reviews", results);
        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("edit") != null){
            String stringReviewID = req.getParameter("edit");
            Long reviewID = Long.parseLong(stringReviewID);

            Review review = DaoFactory.getReviewsDao().findByID(reviewID);

            req.getSession().setAttribute("reviewID", reviewID);
            req.getSession().setAttribute("review", review);
            resp.sendRedirect("/reviews/edit");
        }else if( req.getParameter("delete") != null){
            String stringReviewID = req.getParameter("delete");
            Long reviewID = Long.parseLong(stringReviewID);

            DaoFactory.getReviewsDao().deleteReview(reviewID);
            resp.sendRedirect("/profile");
        }


    }
}
