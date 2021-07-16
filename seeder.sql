USE gamelister_db;

INSERT INTO users (username, email, password)
VALUES ('admin', 'admin@email.com', 'password'),
       ('austin', 'austin@email.com', 'password'),
       ('karen', 'karen@email.com', 'password'),
       ('savanna', 'savanna@email.com', 'password'),
       ('irvin', 'irvin@email.com', 'password');

INSERT INTO games (user_id, title, description, console, genre, release_date)
VALUES
(2, 'Apex Legends', 'Apex Legends is a free-to-play battle royale-hero shooter game developed by Respawn Entertainment and published by Electronic Arts. It was released for Microsoft Windows, PlayStation 4, and Xbox One in February 2019, and for Nintendo Switch in March 2021. A mobile version of the game specially designed for touchscreens titled Apex Legends Mobile has also been announced which is scheduled to be fully released by 2022 on Android and iOS. The game supports cross-platform play.', 'all-consoles', 'FPS', 2019),
(3, 'Breath of the Wild', 'Breath of the Wild is an action-adventure game set in an open world where players are tasked with exploring the kingdom of Hyrule while controlling Link. ... Link can procure items from the environment, including weapons, food, and other resources. Unlike previous Zelda games, weapons and shields degrade through use.', 'nintendo', 'adventure', 2017),
(5, 'FIFA', 'FIFA 21 is an association football simulation video game published by Electronic Arts as part of the FIFA series. It is the 28th installment in the FIFA series.', 'all-consoles', 'sports', 2020),
(4, 'Doom Eternal', 'Doom Eternal is a first-person shooter game developed by id Software and published by Bethesda Softworks. ... Set some time after the events of the 2016 game, the story follows the Doomguy once again, on a mission to end Hell''s consumption of Earth and foil the alien Maykr''s plans to exterminate humanity.', 'all-consoles', 'action', 2020);

INSERT INTO reviews (user_id, game_id, title, review)
VALUES (17, 2, 'Breath of the Wild: An evocative and exhilarating open-world adventure game.', 'The Legend of Zelda: Breath of the Wild is a masterclass in open-world design and a watershed game that reinvents a 30-year-old franchise. It presents a wonderful sandbox full of mystery, dangling dozens upon dozens of tantalizing things in front of you that just beg to be explored. I’ve had so many adventures in Breath of the Wild, and each one has a unique story behind what led me to them, making them stories on top of stories. And even after I’ve spent more than 50 hours searching the far reaches of Hyrule, I still manage to come across things I haven’t seen before. I’ll easily spend 50 to 100 more trying to track down its fascinating moments.');

