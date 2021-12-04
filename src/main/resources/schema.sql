CREATE TABLE IF NOT EXISTS users
(
    id         identity primary key,
    first_name varchar(64)        not null,
    last_name  varchar(64)        not null,
    password   varchar(64)        not null,
    email      varchar(64) unique not null,
    created_at timestamp          not null,
    role       varchar(64) default 'trader',
    check (role in ('trader', 'admin'))
);
CREATE TABLE IF NOT EXISTS games
(
    id   identity primary key,
    name varchar(64) not null
);
CREATE TABLE IF NOT EXISTS trader_posts
(
    id           identity primary key,
    id_trader_fk bigint not null,
    id_game_fk   bigint not null,
    foreign key (id_trader_fk) references users (id),
    foreign key (id_game_fk) references games (id)
);
CREATE TABLE IF NOT EXISTS reviews
(
    id          identity primary key,
    message     clob        not null,
    rating      integer     not null,
    reviewer    varchar(64) not null,
    id_post_fk  varchar(64) not null,
    created_at  timestamp   not null,
    modified_at timestamp   not null,
    approved    boolean     not null default false,
    foreign key (id_post_fk) references trader_posts (id)
);