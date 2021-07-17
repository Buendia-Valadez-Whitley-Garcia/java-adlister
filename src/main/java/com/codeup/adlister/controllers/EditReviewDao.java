package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Review;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/reviews/edit")
public class EditReviewDao extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get info then pass it to the form
        if(req.getSession().getAttribute("review") == null){
            resp.sendRedirect("/profile");
        }
        //set the review in the session equal to the
        Review review = (Review)req.getSession().getAttribute("review");

        req.setAttribute("title", review.getTitle());
        req.setAttribute("review", review.getReview());
        req.getRequestDispatcher("/WEB-INF/games/edit.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //handle information coming from the jsp and pass it to the edit review method in the Dao
        //reset the session "review" attribute to be null
        User user = (User)req.getSession().getAttribute("user");
        String title = req.getParameter("updateTitle");
        String review = req.getParameter("updateReview");

        DaoFactory.getReviewsDao().editReview(title, review, user);
        req.getSession().setAttribute("review", null);
        resp.sendRedirect("/profile");

    }
}
