package com.example.library.library.books.request;

import java.util.List;

import com.example.library.library.books.Book;
import com.example.library.library.books.Chapter;
import com.example.library.library.books.response.ChapterResponseDTO;

public record BookWithChapterDTO(Long id_book, String title, String autor, List<ChapterResponseDTO> chapters) {
    public BookWithChapterDTO(Book book, List<Chapter> chapters) {
        this(book.getId_book(), book.getTitle(), book.getAutor(), chapters.stream().map(ChapterResponseDTO::new).toList());
    }
}