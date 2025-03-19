package com.example.library.library.genres;

import com.example.library.library.mangas.Manga;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Table(name = "group_genres_manga")
@Entity(name = "group_genres_manga")
@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class GroupGenreManga {
    @EmbeddedId
    private GroupGenreMangaId id;

    @ManyToOne
    @MapsId("id_manga")  // Maps the idBook field in the composite key
    @JoinColumn(name = "id_manga", nullable = false)
    private Manga manga;

    @ManyToOne
    @MapsId("id_genre")  // Maps the idGenre field in the composite key
    @JoinColumn(name = "id_genre", nullable = false)
    private Genre genre;

    public GroupGenreManga() {}

    public GroupGenreManga(Manga manga, Genre genre) {
        this.id = new GroupGenreMangaId(manga.getId_manga(), genre.getId_genre());
        this.manga = manga;
        this.genre = genre;
    }
}
