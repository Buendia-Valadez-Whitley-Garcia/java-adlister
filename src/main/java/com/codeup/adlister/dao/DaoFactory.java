package com.codeup.adlister.dao;

public class DaoFactory {
    private static Games gamesDao;
    private static Reviews reviewsDao;
    private static Users usersDao;
    private static Config config = new Config();

    public static Games getGamesDao(){
        if(gamesDao == null){
            gamesDao = new MySQLGamesDao(config);
        }
        return gamesDao;
    }

    public static Users getUsersDao() {
        if (usersDao == null) {
            usersDao = new MySQLUsersDao(config);
        }
        return usersDao;
    }
    public static Reviews getReviewsDao(){
        if(reviewsDao == null){
            reviewsDao = new MySQLReviewsDao(config);
        }
        return reviewsDao;
    }
}
