package com.codeup.adlister.dao;

import com.codeup.adlister.models.Game;
import com.codeup.adlister.models.Review;
import com.mysql.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLReviewsDao implements Reviews{
    private Connection connection = null;

    public MySQLReviewsDao(Config config){
        try{
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        }catch(SQLException e){
            throw new RuntimeException("Error connecting to database (games_constructor)");
        }
    }


    //all is going to return the entire list of ads so we can display them on the page
    //We will need to create a SQL command that will access the games table and show us the contents
    //prepared statements can throw SQL exceptions so we will need to handle this
    public List<Review> all(Game game) {
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("SELECT * FROM reviews");

            ResultSet rs = stmt.executeQuery();
            return createReviewListFromRs(rs);
        } catch(SQLException e){
            throw new RuntimeException("Error generating reviews.");
        }
    }

    public List<Review> createReviewListFromRs(ResultSet rs) throws SQLException {
        List<Review> reviews = new ArrayList<>();
        while(rs.next()){
            reviews.add(stringToReview(rs));
        }
        return reviews;
    }

    public Review stringToReview(ResultSet rs) throws SQLException{
        return new Review(
                rs.getLong("game_id"),
                rs.getString("title"),
                rs.getString("review")
        );

    }

}
