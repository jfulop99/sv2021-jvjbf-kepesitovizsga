CREATE TABLE recorder
(
    id          bigint auto_increment,
    name        varchar(255) not null ,
    birth_date  date not null ,
    primary key (id)
);