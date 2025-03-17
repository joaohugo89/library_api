package com.example.library.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.library.library.books.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
    @Query("SELECT b FROM books b LEFT JOIN FETCH b.chapters")
    List<Book> findAllWithChapters();
}
