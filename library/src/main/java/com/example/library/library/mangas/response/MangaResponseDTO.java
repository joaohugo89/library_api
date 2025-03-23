package com.example.library.library.mangas.response;

import java.util.Set;
import java.util.stream.Collectors;

import com.example.library.library.mangas.Manga;

public record MangaResponseDTO(Long id_manga, String title, String autor, Set<String> genres) {
    public MangaResponseDTO (Manga manga){
        this(manga.getId_manga(), 
            manga.getTitle(), 
            manga.getAutor(),
            manga.getGroupGenresMangas().stream()
                                .map(groupGenre -> groupGenre
                                .getGenre()
                                .getName()).collect(Collectors.toSet()));
    }
}
