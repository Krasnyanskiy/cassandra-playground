
CREATE KEYSPACE demo WITH REPLICATION = {'class': 'SimpleStrategy', 'replication_factor': 3};

CREATE TABLE demo.addresses (
  id      text,
  address text,
  city    text,
  state   text,
  country text,
  PRIMARY KEY (id, address, city)
 );


CREATE TABLE demo.users (
  id        text,
  firstname text,
  lastname  text,
  age       int,
  email     text,
  PRIMARY KEY (id, firstname, lastname, age, email)
);


-- Cassandra 2.1.x
BEGIN BATCH
INSERT INTO demo.users (
  "id",
  "firstname",
  "lastname",
  "age",
  "email"
) VALUES ('5f5ebb6c-191e-4c5f-bf08-5c0d4c9b03a4', 'Mark', 'Livshiz', 21, 'mark.livshiz@home.il');
INSERT INTO demo.users (
  "id",
  "firstname",
  "lastname",
  "age",
  "email"
) VALUES ('acdafb27-682c-4d1c-9eb5-6fd08ec404fd', 'Arri', 'Finkelson', 27, 'afinkelson@gmail.com');
INSERT INTO demo.users (
  "id",
  "firstname",
  "lastname",
  "age",
  "email"
) VALUES ('4fdf1662-accd-4ddf-a277-77545d2f9c0c', 'Golda', 'Katz', 18, 'golda.katz@gmail.il');
APPLY BATCH;