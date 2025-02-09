CREATE TABLE group_genres (  -- Renamed to follow SQL conventions
    id_book INTEGER NOT NULL,
    id_genre INTEGER NOT NULL,
    PRIMARY KEY (id_book, id_genre),  -- Composite primary key instead of an unnecessary ID
    FOREIGN KEY (id_book) REFERENCES books(id_book),
    FOREIGN KEY (id_genre) REFERENCES genres(id_genre)
);