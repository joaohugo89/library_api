package com.example.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.library.mangas.PageManga;
import com.example.library.library.mangas.PageMangaId;

public interface PageMangaRepository extends JpaRepository<PageManga, PageMangaId> {
}