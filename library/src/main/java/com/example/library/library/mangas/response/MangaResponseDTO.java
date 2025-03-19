package com.example.library.library.mangas.response;

import com.example.library.library.mangas.Manga;

public record MangaResponseDTO(Long id_manga, String title, String autor) {
    public MangaResponseDTO (Manga manga){
        this(manga.getId_manga(), 
            manga.getTitle(), 
            manga.getAutor());
    }
}
