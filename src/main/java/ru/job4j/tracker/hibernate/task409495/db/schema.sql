create table if not exists engine(
    id serial primary key,
    name varchar
);

create table if not exists driver(
    id serial primary key,
    name varchar
);

create table if not exists carX(
    id serial primary key,
    name varchar,
    engine_id int not null unique references engine(id)
);

create table if not exists history_owner(
    id serial primary key,
    driver_id int not null references driver(id),
    carX_id int not null references carX(id)
);