package com.example.library.library.books.request;

public record PageRequestDTO(Long id_book, Long id_chapter, Integer page_number, String content) {
    
}
