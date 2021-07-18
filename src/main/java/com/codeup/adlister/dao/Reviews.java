package com.codeup.adlister.dao;

import com.codeup.adlister.models.Game;
import com.codeup.adlister.models.Review;
import com.codeup.adlister.models.User;

import java.util.List;

public interface Reviews {
    List<Review> gameReviews(Long game);
    Long insert(Review review);
    List<Review> all(Long user);
    void editReview(String title, String review, Long id);
    Review findByID(Long id);
}
