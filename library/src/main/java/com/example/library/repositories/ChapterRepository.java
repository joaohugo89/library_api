package com.example.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.library.books.Chapter;

public interface ChapterRepository extends JpaRepository<Chapter, Long>{

}
