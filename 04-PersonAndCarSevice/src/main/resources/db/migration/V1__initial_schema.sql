create table "persons"
(
    id          bigserial   not null primary key,
    name        varchar(50) not null,
    birthdate   date        not null
);

create table "cars"
(
    id          bigserial   not null primary key,
    model       varchar(50) not null,
    horsepower  serial      not null,
    owner_id    bigserial   not null
);
