package com.codeup.adlister.dao;

import com.codeup.adlister.models.Game;
import com.codeup.adlister.models.Review;
import com.codeup.adlister.models.User;

import java.util.List;

public interface Reviews {
    List<Review> all(Game game);
    Long insert(Review review);
    List<Review> all(User user);
}
