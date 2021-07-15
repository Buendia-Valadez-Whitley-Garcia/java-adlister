package com.codeup.adlister.dao;

import com.codeup.adlister.models.Game;
import com.codeup.adlister.models.Review;

import java.util.List;

public interface Reviews {
    List<Review> all(Game game);
//    Long findReviews(Reviews reviews);
}
