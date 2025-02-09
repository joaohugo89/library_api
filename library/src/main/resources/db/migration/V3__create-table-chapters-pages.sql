CREATE TABLE chapters (
    id_chapter SERIAL PRIMARY KEY NOT NULL,
    id_book INTEGER NOT NULL,
    title TEXT NOT NULL,
    chapter_number INTEGER NOT NULL,
    FOREIGN KEY (id_book) REFERENCES books(id_book)
);

CREATE TABLE pages (
    id_page SERIAL PRIMARY KEY NOT NULL,
    id_chapter INTEGER NOT NULL,
    page_number INTEGER NOT NULL,
    content TEXT NOT NULL,
    FOREIGN KEY (id_chapter) REFERENCES chapters(id_chapter)
);

ALTER TABLE pages ADD COLUMN id_book INTEGER NOT NULL REFERENCES books(id_book);
