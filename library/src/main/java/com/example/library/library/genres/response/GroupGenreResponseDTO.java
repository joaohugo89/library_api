package com.example.library.library.genres.response;

import com.example.library.library.genres.GroupGenre;

public record GroupGenreResponseDTO(String bookTitle, String genreName, Long id_book, Long id_genre) {
    public GroupGenreResponseDTO(GroupGenre groupGenre) {
        this(groupGenre.getBook().getTitle(), groupGenre.getGenre().getName(), groupGenre.getId().getId_book(), groupGenre.getId().getId_genre());
    }
    
}