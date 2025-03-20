package com.example.library.library.books.response;

import com.example.library.library.books.ChapterBook;

public record ChapterBookResponseDTO(Long id_chapter, String title, Long bookId, Integer chapterNumber) {
    public ChapterBookResponseDTO(ChapterBook chapter) {
        this(chapter.getId_chapter_book(), chapter.getTitle(), chapter.getBook().getId_book(), chapter.getChapter_number());
    }
} 
