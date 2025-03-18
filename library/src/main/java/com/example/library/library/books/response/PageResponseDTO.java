package com.example.library.library.books.response;

public record PageResponseDTO(Long id_book, Long id_chapter, Integer page_number, String content) {
    public PageResponseDTO(Long id_book, Long id_chapter, Integer page_number, String content) {
        this.id_book = id_book;
        this.id_chapter = id_chapter;
        this.page_number = page_number;
        this.content = content;
    }
}
