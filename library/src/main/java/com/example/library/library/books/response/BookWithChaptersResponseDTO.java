package com.example.library.library.books.response;

import java.util.List;

import com.example.library.library.books.Book;

public record BookWithChaptersResponseDTO(Long id_book, String title, String autor, List<ChapterResponseDTO> chapters) {
    public BookWithChaptersResponseDTO(Book book) {
        this(book.getId_book(), book.getTitle(), book.getAutor(), book.getChapters().stream().map(ChapterResponseDTO::new).toList());
    }
}