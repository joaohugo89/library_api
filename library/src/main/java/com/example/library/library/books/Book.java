package com.example.library.library.books;

import java.util.List;
import java.util.Set;

import com.example.library.library.books.request.BookRequestDTO;
import com.example.library.library.genres.GroupGenre;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "books")
@Entity(name = "books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_book")
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_book;
    private String title;
    private String autor;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<GroupGenre> groupGenres;

    @OneToMany(mappedBy = "book" , fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Chapter> chapters;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Page> pages;

    public Book(BookRequestDTO data){
        this.title = data.title();
        this.autor = data.autor();
    }

}