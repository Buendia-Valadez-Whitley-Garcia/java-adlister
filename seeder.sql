
INSERT INTO users (username, email, password)
VALUES ('admin', 'admin@email.com', 'password'),
       ('austin', 'austin@email.com', 'password'),
       ('karen', 'karen@email.com', 'password'),
       ('savanna', 'savanna@email.com', 'password'),
       ('irvin', 'irvin@email.com', 'password')

INSERT INTO games (user_id, title, description, console, genre, release_date)
VALUES
(2, 'Apex Legends', 'Apex Legends is a free-to-play battle royale-hero shooter game developed by Respawn Entertainment and published by Electronic Arts. It was released for Microsoft Windows, PlayStation 4, and Xbox One in February 2019, and for Nintendo Switch in March 2021. A mobile version of the game specially designed for touchscreens titled Apex Legends Mobile has also been announced which is scheduled to be fully released by 2022 on Android and iOS. The game supports cross-platform play.', 'all', 'FPS', 2019);