package com.codeup.adlister.dao;

import com.codeup.adlister.models.Game;
import com.codeup.adlister.models.Review;
import com.codeup.adlister.models.User;
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

//    ============= View all reviews by Game ID =============
    public List<Review> all(Game game) {
        String sql = "SELECT * FROM reviews WHERE game_id = VALUES(?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, game.getId());
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
                rs.getLong("user_id"),
                rs.getLong("game_id"),
                rs.getString("title"),
                rs.getString("review")
        );

    }


//    ============ Insert new review into the database ==============
    @Override
    public Long insert(Review review) {
        try{
            String insertGameQuery = "INSERT INTO reviews(user_id, title, review) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertGameQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, review.getId());
            stmt.setString(2, review.getTitle());
            stmt.setString(3, review.getReview());
            stmt.executeUpdate();

            ResultSet rs = stmt.getResultSet();
            rs.next();
            return rs.getLong(1);
        }catch (SQLException e){
            throw new RuntimeException("Error inserting review into database");
        }
    }


//    ======================= Select all reviews by user ID ==================
    @Override
    public List<Review> all(User user) {
        String sql = "SELECT * FROM reviews WHERE user_id = VALUES(?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, user.getId());
            ResultSet rs = stmt.executeQuery();
            return createReviewListFromUsers(rs);
        } catch(SQLException e){
            throw new RuntimeException("Error generating user's reviews.");
        }
    }
    public List<Review> createReviewListFromUsers(ResultSet rs) throws SQLException {
        List<Review> userReviews = new ArrayList<>();
        while(rs.next()){
            userReviews.add(userStringToReview(rs));
        }
        return userReviews;
    }

    public Review userStringToReview(ResultSet rs) throws SQLException{
        return new Review(
                rs.getLong("user_id"),
                rs.getLong("game_id"),
                rs.getString("title"),
                rs.getString("review")
        );

    }

}
