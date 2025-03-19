package com.example.library.library.books.response;

import com.example.library.library.books.ChapterBook;

public record ChapterResponseDTO(Long id_chapter, String title, Long bookId, Integer chapterNumber) {
    public ChapterResponseDTO(ChapterBook chapter) {
        this(chapter.getId_chapter(), chapter.getTitle(), chapter.getBook().getId_book(), chapter.getChapter_number());
    }
} 
