DROP TABLE IF EXISTS bank_account;

CREATE TABLE bank_account
(
    id         SERIAL PRIMARY KEY,
    person_id  SERIAL    NOT NULL,
    created_on timestamp NOT NULL
);