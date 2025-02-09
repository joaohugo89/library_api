package com.example.library.library.books.response;

import com.example.library.library.books.Book;

public record BookResponseDTO(Long id_book, String title, String autor) {
    public BookResponseDTO (Book book){
        this(book.getId_book() ,book.getTitle(), book.getAutor());
    }
}
