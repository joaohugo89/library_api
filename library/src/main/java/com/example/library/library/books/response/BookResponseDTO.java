package com.example.library.library.books.response;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Map;

import com.example.library.library.books.Book;

public record BookResponseDTO(Long id_book, String title, String autor, Set<String> genres, Map<String, List<String>> chapters) {
    public BookResponseDTO (Book book){
        this(book.getId_book(), 
            book.getTitle(), 
            book.getAutor(), 
            book.getGroupGenres().stream()
                                .map(groupGenre -> groupGenre
                                .getGenre()
                                .getName()).collect(Collectors.toSet()),
            book.getChapters().stream()
                                .collect(Collectors.toMap(chapter -> chapter.getTitle(),
                                                        chapter -> chapter.getPages().stream()
                                                                                    .map(page -> page.getContent())
                                                                                    .collect(Collectors.toList())))
            );
    }
}
