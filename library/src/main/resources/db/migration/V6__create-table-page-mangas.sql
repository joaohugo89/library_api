CREATE TABLE page_mangas (
    id_manga BIGINT NOT NULL,
    page_number INT NOT NULL,
    image BYTEA NOT NULL,
    PRIMARY KEY (id_manga, page_number),
    FOREIGN KEY (id_manga) REFERENCES mangas(id_manga)
);

ALTER TABLE chapters_book RENAME COLUMN id_chapter TO id_chapter_book;