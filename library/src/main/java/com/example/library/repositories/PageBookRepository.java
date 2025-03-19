package com.example.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.library.books.PageBook;
import com.example.library.library.books.PageBookId;

public interface PageBookRepository extends JpaRepository<PageBook, PageBookId>{
}
