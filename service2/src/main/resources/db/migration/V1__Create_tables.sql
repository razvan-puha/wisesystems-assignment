DROP TABLE IF EXISTS person;

CREATE TABLE person
(
    id           SERIAL PRIMARY KEY,
    person_name  varchar(255) NOT NULL,
    personal_code varchar(13)  NOT NULL,
    contact_email varchar(255) NOT NULL
);