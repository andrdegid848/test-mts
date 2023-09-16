--liquibase formatted sql

--changeset agusev:1
CREATE TABLE IF NOT EXISTS tariffs (
    id SERIAL PRIMARY KEY,
    title VARCHAR(64) NOT NULL UNIQUE,
    description VARCHAR(256),
    price INT NOT NULL
);