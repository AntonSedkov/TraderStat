DELETE
FROM users;
INSERT INTO users (id, first_name, last_name, password, email, created_at, role)
VALUES (1, 'Admin', 'Admin', '{noop}pass', 'admin@uni.tr', '27-11-21 12:00:01', 'admin'),
       (2, 'John', 'Doe', '{noop}pass', 'john@test.ml', '28-11-21 13:10:02', 'trader'),
       (3, 'Jane', 'Doe', '{noop}pass', 'jane@test.ml', '29-11-21 14:20:03', 'trader'),
       (4, 'Ivan', 'Ivanov', '{noop}pass', 'ivan@test.ml', '26-11-21 15:30:40', 'trader'),
       (5, 'Juanita', 'Pozuela', '{noop}pass', 'jp@test.ml', '25-11-21 01:40:05', 'trader');

DELETE
FROM games;
INSERT INTO games (id, name)
VALUES (1, 'FIFA'),
       (2, 'DOTA'),
       (3, 'CS:GO'),
       (4, 'Team Fortress');

DELETE
FROM trader_posts;
INSERT INTO trader_posts (id, id_trader_fk, id_game_fk)
VALUES (1, 2, 1),
       (2, 2, 2),
       (3, 3, 3),
       (4, 3, 4),
       (5, 4, 3),
       (6, 4, 2),
       (7, 5, 1),
       (8, 6, 4);

DELETE
FROM reviews;
INSERT INTO reviews (id, message, rating, reviewer, id_post_fk, created_at, approved)
VALUES (1, 'Really good seller', 10, 'Author_1', 1, '27-12-21 12:00:01', true),
       (2, 'Awful service', 1, 'Couch potato', 5, '28-12-21 13:10:02', true),
       (3, 'You can do better', 4, 'Couch potato', 8, '07-12-21 13:10:02', false),
       (4, 'Good choice', 8, 'Couch potato', 3, '05-12-21 13:10:02', true),
       (5, 'Awful service', 5, 'Raccoon', 3, '09-01-21 13:10:02', true),
       (6, 'Awful service', 7, 'Raccoon', 3, '03-07-21 13:10:02', true);


