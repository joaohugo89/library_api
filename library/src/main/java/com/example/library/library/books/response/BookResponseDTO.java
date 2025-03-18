package com.example.library.library.books.response;

import java.util.Set;
import java.util.stream.Collectors;

import com.example.library.library.books.Book;
import com.example.library.library.genres.GroupGenre;

public record BookResponseDTO(Long id_book, String title, String autor, Set<String> genres) {
    public BookResponseDTO (Book book){
        this(book.getId_book(), 
            book.getTitle(), 
            book.getAutor(), 
            book.getGroupGenres().stream()
                                .map(groupGenre -> groupGenre
                                .getGenre()
                                .getName()).collect(Collectors.toSet()));
    }
}
