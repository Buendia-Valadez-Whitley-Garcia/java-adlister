package com.codeup.adlister.dao;
import com.codeup.adlister.models.Game;
import com.mysql.jdbc.Driver;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLGamesDao implements Games{
    private Connection connection = null;

    public MySQLGamesDao(Config config){
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
    @Override
    public List<Game> all() {
        PreparedStatement stmt = null;
        try{
            stmt = connection.prepareStatement("SELECT * FROM games;");
            ResultSet rs = stmt.executeQuery();
            return createGameListFromRs(rs);
        }catch(SQLException e){
            throw new RuntimeException("Error generating games.");
        }
    }

    public List<Game> createGameListFromRs(ResultSet rs) throws SQLException {
        List<Game> games = new ArrayList<>();
        while(rs.next()){
            //we need to add the games to our list but they are plain text right now so we will create a function that turns them into actual game objects
            games.add(stringToGame(rs));
        }
        return games;
    }

    public Game stringToGame(ResultSet rs) throws SQLException{
        return new Game(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getString("console"),
                rs.getString("genre"),
                rs.getInt("release_date")
        );
    }

    @Override
    public Game findByID(Long id){
        String query = "SELECT * FROM games WHERE id = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return extractGame(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a game with that id", e);
        }
    }

    @Override
    public Long insert(Game game) {
        try{
            String insertGameQuery = "INSERT INTO games(user_id, title, description, console, genre, release_date) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertGameQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, game.getUser_id());
            stmt.setString(2, game.getTitle());
            stmt.setString(3, game.getDescription());
            stmt.setString(4, game.getConsole());
            stmt.setString(5, game.getGenre());
            stmt.setLong(6, game.getReleaseDate());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        }catch (SQLException e){
            throw new RuntimeException("Error inserting game into database");
        }
    }

    private Game extractGame(ResultSet rs) throws SQLException {
        return new Game(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getString("console"),
                rs.getString("genre"),
                rs.getLong("release_date")
        );
    }

    private List<Game> createGamesFromResults(ResultSet rs) throws SQLException {
        List<Game> games = new ArrayList<>();
        while (rs.next()) {
            games.add(extractGame(rs));
        }
        return games;
    }

    @Override
    public List<Game> searchByTitle(String query) {
        String sql = "SELECT * FROM games WHERE title LIKE ?;";
        String searchTermWithWildcards = "%" + query + "%";
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, searchTermWithWildcards);
            ResultSet rs = stmt.executeQuery();
            return createGamesFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("OOPS! Error retrieving all games...", e);
        }
    }


//    =======================SELECT by genre===================

    @Override
    public List<Game> findByGenre(String game) {
        String sql = "SELECT * FROM games WHERE genre = ?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, game);
            ResultSet rs = stmt.executeQuery();
            return createGenreList(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error generating list", e);
        }
    }

        public List<Game> createGenreList(ResultSet rs) throws SQLException {
            List<Game> game = new ArrayList<>();
            while(rs.next()){
                game.add(stringToGenre(rs));
            }
            return game;
        }

    public Game stringToGenre(ResultSet rs) throws SQLException{
        return new Game(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getString("console"),
                rs.getString("genre"),
                rs.getLong("release_date")
        );

    }










}
