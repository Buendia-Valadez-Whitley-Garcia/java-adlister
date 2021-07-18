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
    public List<Review> gameReviews(Long game) {
        String sql = "SELECT * FROM reviews WHERE game_id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, game);
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

    @Override
    public Review findByID(Long id){
        String query = "SELECT * FROM reviews WHERE id = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return stringToReview(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a review with that id", e);
        }
    }

    public Review stringToReview(ResultSet rs) throws SQLException{
        return new Review(
                rs.getLong("user_id"),
                rs.getLong("game_id"),
                rs.getString("title"),
                rs.getString("review")
        );

    }

    @Override
    public void editReview(String title, String review, Long id){
        try{
            String insertGameQuery = "UPDATE reviews SET title = ?, review = ? WHERE id = ?;";
            PreparedStatement stmt = connection.prepareStatement(insertGameQuery, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, title);
            stmt.setString(2, review);
            stmt.setLong(3, id);

            stmt.executeUpdate();

        }catch (SQLException e){
            throw new RuntimeException("Error inserting review into database", e);
        }
    }


//    ============ Insert new review into the database ==============
    @Override
    public Long insert(Review review) {
        try{
            String insertGameQuery = "INSERT INTO reviews(user_id, game_id, title, review) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertGameQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, review.getUser_id());
            stmt.setLong(2, review.getGame_id());
            stmt.setString(3, review.getTitle());
            stmt.setString(4, review.getReview());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        }catch (SQLException e){
            throw new RuntimeException("Error inserting review into database", e);
        }
    }


//    ======================= Select all reviews by user ID ==================
    @Override
    public List<Review> all(Long user) {
        String sql = "SELECT * FROM reviews WHERE user_id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, user);
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
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getLong("game_id"),
                rs.getString("title"),
                rs.getString("review")
        );

    }

}
