package com.example.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.library.mangas.Manga;

public interface MangaRepository extends JpaRepository<Manga, Long>{
    
}
