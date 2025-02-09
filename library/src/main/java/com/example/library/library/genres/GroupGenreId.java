package com.example.library.library.genres;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class GroupGenreId implements Serializable {
    
    private Long id_book;
    private Long id_genre;

    public GroupGenreId() {}

    public GroupGenreId(Long id_book, Long id_genre) {
        this.id_book = id_book;
        this.id_genre = id_genre;
    }

}