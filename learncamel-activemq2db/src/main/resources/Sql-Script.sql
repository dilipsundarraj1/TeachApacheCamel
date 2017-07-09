
CREATE TABLE messages
(
    id text ,
    message text,
    create_date timestamp without time zone DEFAULT now()
)