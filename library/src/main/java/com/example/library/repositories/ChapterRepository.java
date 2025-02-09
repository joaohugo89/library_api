package com.example.library.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.library.books.Chapter;

public interface ChapterRepository extends JpaRepository<Chapter, Long>{
}
