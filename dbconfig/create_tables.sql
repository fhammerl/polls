CREATE TABLE poll
(
    id CHAR(16) NOT NULL,
    latest_change timestamp without time zone,
    initiated timestamp without time zone NOT NULL,
    hidden boolean NOT NULL,
    preferences_type text NOT NULL,
    state text NOT NULL,
    title text NOT NULL,
    created_by_user_id integer, -- dummy value, would obviously be a foreign key
    PRIMARY KEY (id)
);

CREATE TABLE participant
(
    id SERIAL,
    name text NOT NULL,
    email text NOT NULL,
    poll_id character(16) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_participant_poll FOREIGN KEY (poll_id)
        REFERENCES public.poll (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)
