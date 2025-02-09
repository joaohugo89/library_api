package com.example.library.library.genres;

import com.example.library.library.books.Book;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Table(name = "group_genres")
@Entity(name = "group_genres")
@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class GroupGenre {
    
    @EmbeddedId
    private GroupGenreId id;

    @ManyToOne
    @MapsId("id_book")  // Maps the idBook field in the composite key
    @JoinColumn(name = "id_book", nullable = false)
    private Book book;

    @ManyToOne
    @MapsId("id_genre")  // Maps the idGenre field in the composite key
    @JoinColumn(name = "id_genre", nullable = false)
    private Genre genre;

    public GroupGenre() {}

    public GroupGenre(Book book, Genre genre) {
        this.id = new GroupGenreId(book.getId_book(), genre.getId_genre());
        this.book = book;
        this.genre = genre;
    }
}