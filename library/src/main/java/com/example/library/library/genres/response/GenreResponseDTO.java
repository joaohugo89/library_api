package com.example.library.library.genres.response;

import com.example.library.library.genres.Genre;

public record GenreResponseDTO(Long id_genre, String title) {
    public GenreResponseDTO (Genre genre){
        this(genre.getId_genre() ,genre.getName());
    }
}
