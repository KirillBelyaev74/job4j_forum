create table if not exists posts
(
    id          serial primary key,
    name        varchar(50) not null,
    description text,
    created     timestamp without time zone not null default now()
);

CREATE TABLE if not exists authority
(
    id        serial primary key,
    authority VARCHAR(50) NOT NULL unique
);

CREATE TABLE if not exists users
(
    id           serial primary key,
    username     VARCHAR(50)  NOT NULL unique,
    password     VARCHAR(100) NOT NULL,
    enabled      boolean default true,
    authority_id int          not null references authority (id)
);