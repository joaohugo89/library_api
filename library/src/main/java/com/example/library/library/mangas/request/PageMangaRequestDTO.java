package com.example.library.library.mangas.request;

public record PageMangaRequestDTO(Long id_manga, Long id_chapter_manga, Integer page_number, byte[] image) {
    
}
