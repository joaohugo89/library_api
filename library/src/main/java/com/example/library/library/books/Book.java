package com.example.library.library.books;

import com.example.library.library.books.request.BookRequestDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "books")
@Entity(name = "books")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_book")
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_book;
    private String title;
    private String autor;

    public Book(BookRequestDTO data){
        this.title = data.title();
        this.autor = data.autor();
    }

}