INSERT INTO client
(NAME)
VALUES
    ('Gregor'),
    ('Max'),
    ('Genry'),
    ('John'),
    ('Charity'),
    ('Ann'),
    ('Kolya'),
    ('Oleh'),
    ('Andreas'),
    ('Antonio'),
    ('Olha');

    INSERT INTO planet
    (ID, NAME)
    VALUES
        ('MARS1', 'Mars'),
        ('VEN', 'Venera'),
        ('JUP', 'Jupiter'),
        ('SAT', 'Saturn'),
        ('PLU', 'Pluton');

        INSERT INTO ticket
            (CLIENT_ID, FROM_PLANET_ID, TO_PLANET_ID)
            VALUES
                (1, 'MARS1', 'PLU'),
                (2, 'VEN', 'PLU'),
                (3, 'JUP', 'SAT'),
                (4, 'SAT', 'PLU'),
                (5, 'VEN', 'JUP'),
                (6, 'MARS1', 'SAT'),
                (7, 'VEN', 'MARS1'),
                (8, 'JUP', 'VEN'),
                (9, 'SAT', 'JUP'),
                (10, 'PLU', 'SAT'),
                (11, 'SAT', 'PLU');
