package com.example.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.library.genres.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long>{

}