package com.example.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.library.books.ChapterBook;

public interface ChapterBookRepository extends JpaRepository<ChapterBook, Long>{

}
