package com.example.library.library.genres;

import com.example.library.library.books.Book;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Table(name = "group_genres_book")
@Entity(name = "group_genres_book")
@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class GroupGenreBook {
    
    @EmbeddedId
    private GroupGenreBookId id;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("id_book")  // Maps the idBook field in the composite key
    @JoinColumn(name = "id_book", nullable = false)
    private Book book;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("id_genre")  // Maps the idGenre field in the composite key
    @JoinColumn(name = "id_genre", nullable = false)
    private Genre genre;

    public GroupGenreBook() {}

    public GroupGenreBook(Book book, Genre genre) {
        this.id = new GroupGenreBookId(book.getId_book(), genre.getId_genre());
        this.book = book;
        this.genre = genre;
    }
}