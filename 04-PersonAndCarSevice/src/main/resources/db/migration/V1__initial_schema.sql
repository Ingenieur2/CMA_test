create table "persons"
(
    id          bigserial   not null primary key,
    name        varchar(50) not null,
    birthdate   date        not null
);
insert into "persons" (id, name, birthdate)
values (1, 'Ivan', '2014-04-04');

insert into "persons" (id, name, birthdate)
values (2, 'Igor', '01-03-1984');

create table "cars"
(
    id          bigserial   not null primary key,
    model       varchar(50) not null,
    horsepower  serial      not null,
    owner_id    bigserial   not null
);

insert into "cars" (id, model, horsepower, owner_id)
values (1, 'BMW-X5', 250,  1);

insert into "cars" (id, model, horsepower, owner_id)
values (2, 'KIA-K5', 150,  2);
