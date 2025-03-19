package com.example.library.library.genres;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class GroupGenreMangaId implements Serializable {
    
    private Long id_manga;
    private Long id_genre;

    public GroupGenreMangaId() {}

    public GroupGenreMangaId(Long id_manga, Long id_genre) {
        this.id_manga = id_manga;
        this.id_genre = id_genre;
    }

}
