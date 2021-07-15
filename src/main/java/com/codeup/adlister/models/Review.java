package com.codeup.adlister.models;

public class Review {
    private long game_id;
    private String title;
    private String review;


    public Review(long game_id, String title, String review) {
        this.game_id = game_id;
        this.title = title;
        this.review = review;
    }


    public long getId() {
        return game_id;
    }

    public void setGame_id(long game_id) {
        this.game_id = game_id;
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
