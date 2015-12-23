
CREATE KEYSPACE demo
WITH REPLICATION = {'class': 'SimpleStrategy', 'replication_factor': 3};


CREATE TABLE addresses (
  id      text,
  address text,
  city    text,
  state   text,
  country text,
  PRIMARY KEY (id, address, city)
 );


CREATE TABLE users (
  id        text,
  firstname text,
  lastname  text,
  age       int,
  email     text,
  PRIMARY KEY (id, firstname, lastname, age, email)
);

-- Cassandra 2.1.x
-- BEGIN BATCH
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
-- APPLY BATCH;


-- Addresses in JSON (for Cassandra 3.x only)

INSERT INTO demo.addresses JSON '{
  "id":      "829aa84a-4bba-411f-a4fb-38167a987cda",
  "address": "548 Market St",
  "city":    "San Francisco",
  "state":   "CA",
  "country": "USA" }';

INSERT INTO demo.addresses JSON '{
  "id": "bc87d5a0-a5ab-49b5-b1b5-345c62b16b4a",
  "address": "1234 Broadway St",
  "city": "San Francisco",
  "state": "CA",
  "country": "USA" }';

INSERT INTO demo.addresses JSON '{
  "id":      "a36b2128-7549-45c9-85f8-118fcc6eed49",
  "address": "4450 17th St",
  "city":    "San Francisco",
  "state":   "CA",
  "country": "USA" }';

INSERT INTO demo.addresses JSON '{
  "id":      "675d5b4f-30c5-43b6-acaf-1e4cb272be29",
  "address": "101 Hyde St",
  "city":    "San Francisco",
  "state":   "CA",
  "country": "USA" }';

INSERT INTO demo.users JSON '{
  "id":        "5f5ebb6c-191e-4c5f-bf08-5c0d4c9b03a4",
  "firstname": "Mark",
  "lastname":  "Livshiz",
  "age":       21,
  "email":     "mark.livshiz@home.il" }';

INSERT INTO demo.users JSON '{
  "id":        "acdafb27-682c-4d1c-9eb5-6fd08ec404fd",
  "firstname": "Arri",
  "lastname":  "Finkelson",
  "age":       27,
  "email":     "afinkelson@gmail.com" }';

INSERT INTO demo.users JSON '{
  "id":        "4fdf1662-accd-4ddf-a277-77545d2f9c0c",
  "firstname": "Golda",
  "lastname":  "Katz",
  "age":       18,
  "email":     "golda.katz@gmail.il" }';