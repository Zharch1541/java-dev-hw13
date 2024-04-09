CREATE TABLE client (
    id IDENTITY PRIMARY KEY,
    name VARCHAR NOT NULL,
    CONSTRAINT name_length_check
    CHECK (LENGTH(name) BETWEEN 3 AND 200)
);

CREATE TABLE planet (
    id VARCHAR NOT NULL PRIMARY KEY,
    CONSTRAINT id_format CHECK (id = UPPER(id)),
    name VARCHAR NOT NULL,
    CONSTRAINT name_length
    CHECK (LENGTH(name) BETWEEN 1 AND 500)
);

CREATE TABLE ticket (
    ID IDENTITY PRIMARY KEY,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP AT TIME ZONE 'UTC',
    client_id BIGINT NOT NULL,
    CONSTRAINT client_id_fk
    FOREIGN KEY (client_id) REFERENCES client(id),
    from_planet_id VARCHAR NOT NULL,
    CONSTRAINT from_planet_id_fk
    FOREIGN KEY (from_planet_id) REFERENCES planet(id),
    to_planet_id VARCHAR NOT NULL,
    CONSTRAINT to_planet_id_fk
    FOREIGN KEY (to_planet_id) REFERENCES planet(id)
);