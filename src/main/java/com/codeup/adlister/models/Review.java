package com.codeup.adlister.models;

public class Review {

    private long game_id;
    private long user_id;
    private String title;
    private String review;


    public Review(long user_id, long game_id, String title, String review) {
        this.user_id = user_id;
        this.game_id = game_id;
        this.title = title;
        this.review = review;
    }
    public Review(){

    }
    public long getId() {
        return user_id;
    }
    public long getGame_id() {
        return game_id;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getTitle() {
        return title;
    }

    public String getReview() {
        return review;
    }

}
