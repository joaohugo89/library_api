package com.example.library.library.mangas;

import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.io.Serializable;

@Embeddable
@Getter
public class PageMangaId implements Serializable {
    private Long id_chapter_manga;
    private Long id_manga;
    private Integer page_number;

    public PageMangaId() {}

    public PageMangaId(Long id_chapter_manga, Long id_manga, Integer page_number){
        this.id_chapter_manga = id_chapter_manga;
        this.id_manga = id_manga;
        this.page_number = page_number;
    }
}