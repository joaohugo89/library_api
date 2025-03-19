package com.example.library.library.genres.response;

import com.example.library.library.genres.GroupGenreManga;

public record GroupGenreMangaResponseDTO(String mangaTitle, String genreName, Long id_manga, Long id_genre) {
    public GroupGenreMangaResponseDTO(GroupGenreManga groupGenre) {
        this(groupGenre.getManga().getTitle(), groupGenre.getGenre().getName(), groupGenre.getId().getId_manga(), groupGenre.getId().getId_genre());
    }
    
}