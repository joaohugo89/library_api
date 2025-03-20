package com.example.library.library.books.response;

import java.util.List;

import com.example.library.library.books.Book;

public record BookWithChaptersResponseDTO(Long id_book, String title, String autor, List<ChapterBookResponseDTO> chapters) {
    public BookWithChaptersResponseDTO(Book book) {
        this(book.getId_book(), book.getTitle(), book.getAutor(), book.getChapters().stream().map(ChapterBookResponseDTO::new).toList());
    }
}