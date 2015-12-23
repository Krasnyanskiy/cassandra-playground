
USE demo;

CREATE TABLE addresses (
  id      text,
  address text,
  city    text,
  state   text,
  country text,
  PRIMARY KEY (id, address, city)
 );

INSERT INTO demo.addresses ("id", "address", "city", "state", "country") VALUES ('829aa84a-4bba-411f-a4fb-38167a987cda', '548 Market St', 'San Francisco', 'CA', 'USA');