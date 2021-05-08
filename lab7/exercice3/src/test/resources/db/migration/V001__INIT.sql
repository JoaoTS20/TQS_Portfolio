CREATE SEQUENCE hibernate_sequence START 1;
CREATE TABLE cars (
            car_id BIGSERIAL primary key ,
            model varchar(255) not null,
            maker varchar(255) not null
);