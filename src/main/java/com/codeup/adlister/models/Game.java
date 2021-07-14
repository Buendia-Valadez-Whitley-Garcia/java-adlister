package com.codeup.adlister.models;

public class Game {
    private long id;
    private long user_id;
    private String title;
    private String description;
    private String console;
    private String genre;
    private int releaseDate;

    public Game(long id, long user_id, String title, String description, String console, String genre, int releaseDate) {
        this.id = id;
        this.user_id = user_id;
        this.title = title;
        this.description = description;
        this.console = console;
        this.genre = genre;
        this.releaseDate = releaseDate;
    }

    public Game(long user_id, String title, String description, String console, String genre, int releaseDate) {
        this.user_id = user_id;
        this.title = title;
        this.description = description;
        this.console = console;
        this.genre = genre;
        this.releaseDate = releaseDate;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public long getUser_id() {
        return user_id;
    }
    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getConsole() {
        return console;
    }
    public void setConsole(String console) {
        this.console = console;
    }

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }
}
