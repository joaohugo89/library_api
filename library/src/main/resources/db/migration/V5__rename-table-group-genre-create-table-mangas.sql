ALTER TABLE group_genres
RENAME TO group_genres_book;

ALTER TABLE pages
RENAME TO pages_book;

ALTER TABLE chapters
RENAME TO chapters_book;

CREATE TABLE mangas (
    id_manga SERIAL PRIMARY KEY UNIQUE NOT NULL,
    title TEXT NOT NULL,
    autor TEXT NOT NULL 
);

CREATE TABLE group_genres_manga (  -- Renamed to follow SQL conventions
    id_manga INTEGER NOT NULL,
    id_genre INTEGER NOT NULL,
    PRIMARY KEY (id_manga, id_genre),  -- Composite primary key instead of an unnecessary ID
    FOREIGN KEY (id_manga) REFERENCES mangas(id_manga),
    FOREIGN KEY (id_genre) REFERENCES genres(id_genre)
);
