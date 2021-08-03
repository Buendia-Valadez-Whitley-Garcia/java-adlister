package com.outfitterexpert.outfitterexpert.models;

public class User {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String outfitter;

    public User(){}

    public User(String firstName, String lastName, String email, String outfitter) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.outfitter = outfitter;
    }

    public User(long id, String firstName, String lastName, String email, String outfitter) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.outfitter = outfitter;
    }
}
