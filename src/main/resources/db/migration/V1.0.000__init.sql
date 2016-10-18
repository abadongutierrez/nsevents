CREATE TABLE app_user
(
  app_user_id serial NOT NULL,
  first_name text NOT NULL,
  last_name text NOT NULL,
  email text NOT NULL,
  password text NOT NULL,
  inserted_at timestamp without time zone DEFAULT now(),
  updated_at timestamp without time zone DEFAULT now(),
  CONSTRAINT app_user_pkey PRIMARY KEY (app_user_id)
);

CREATE TABLE venue
(
  venue_id serial NOT NULL,
  name text NOT NULL,
  address_1 text NOT NULL,
  address_2 text,
  city text NOT NULL,
  postal_code text NOT NULL,
  country text NOT NULL,
  inserted_at timestamp without time zone DEFAULT now(),
  updated_at timestamp without time zone DEFAULT now(),
  CONSTRAINT venue_pkey PRIMARY KEY (venue_id)
);

CREATE TABLE event
(
  event_id serial NOT NULL,
  name text NOT NULL,
  description text,
  begin_at timestamp NOT NULL,
  end_at timestamp NOT NULL,
  capacity int NOT NULL,
  logo text,
  venue_id integer NOT NULL
    REFERENCES venue (venue_id)
      ON UPDATE CASCADE
      ON DELETE CASCADE,
  inserted_at timestamp without time zone DEFAULT now(),
  updated_at timestamp without time zone DEFAULT now(),
  CONSTRAINT event_pkey PRIMARY KEY (event_id)
);