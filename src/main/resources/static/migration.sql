CREATE DATABASE outfitter_db;

USE outfitter_db;

DROP TABLE IF EXISTS users;
CREATE TABLE users (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(150) NOT NULL,
    outfitter VARCHAR(3) NOT NULL,
    PRIMARY KEY (id)
);