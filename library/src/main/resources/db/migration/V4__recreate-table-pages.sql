-- Drop the existing `pages` table
DROP TABLE IF EXISTS pages;

-- Create the new `pages` table
CREATE TABLE pages (
    page_number INTEGER NOT NULL,
    content TEXT NOT NULL,
    id_chapter INTEGER NOT NULL,
    id_book INTEGER NOT NULL,
    PRIMARY KEY (id_chapter, id_book, page_number), -- Composite primary key
    FOREIGN KEY (id_chapter) REFERENCES chapters(id_chapter) ON DELETE CASCADE,
    FOREIGN KEY (id_book) REFERENCES books(id_book) ON DELETE CASCADE
);