package com.codeup.adlister.models;

public class Game {
    private long id;
    private long user_id;
    private String title;
    private String description;
    private String console;
    private String genre;
    private long releaseDate;

    public Game(long id, long user_id, String title, String description, String console, String genre, long releaseDate) {
        this.id = id;
        this.user_id = user_id;
        this.title = title;
        this.description = description;
        this.console = console;
        this.genre = genre;
        this.releaseDate = releaseDate;
    }

    public Game(long user_id, String title, String description, String console, String genre, long releaseDate) {
        this.user_id = user_id;
        this.title = title;
        this.description = description;
        this.console = console;
        this.genre = genre;
        this.releaseDate = releaseDate;
    }

    //constructor with a string release date
    public Game(long user_id, String title, String description, String console, String genre, String release_date) {
        this.user_id = user_id;
        this.title = title;
        this.description = description;
        this.console = console;
        this.genre = genre;
        this.releaseDate = Long.parseLong(release_date);
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

    public long getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }
}
