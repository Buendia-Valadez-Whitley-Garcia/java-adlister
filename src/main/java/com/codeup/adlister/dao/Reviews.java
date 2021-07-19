package com.codeup.adlister.dao;
import com.codeup.adlister.models.Review;
import java.util.List;

public interface Reviews {
    List<Review> gameReviews(Long game);
    Long insert(Review review);
    List<Review> all(Long user);
    void deleteReview(Long id);
    void editReview(String title, String review, Long id);
    Review findByID(Long id);
}
