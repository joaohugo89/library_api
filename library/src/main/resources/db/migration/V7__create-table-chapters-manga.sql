CREATE TABLE chapters_manga (
    id_chapter_manga SERIAL PRIMARY KEY NOT NULL,
    id_manga INTEGER NOT NULL,
    title TEXT NOT NULL,
    chapter_number INTEGER NOT NULL,
    FOREIGN KEY (id_manga) REFERENCES mangas(id_manga)
);

ALTER TABLE page_mangas
RENAME TO pages_manga;