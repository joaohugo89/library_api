package com.example.library.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.library.library.mangas.Manga;
import com.example.library.library.genres.Genre;
import com.example.library.library.genres.GroupGenreManga;
import com.example.library.library.genres.GroupGenreMangaId;


public interface GroupGenreMangaRepository extends JpaRepository<GroupGenreManga, GroupGenreMangaId>{
    @Query("SELECT g.manga FROM group_genres_manga g WHERE g.genre.id = :genreId")
    List<Manga> findMangasByGenre(@Param("genreId") Long genreId);

    @Query("SELECT g.genre FROM group_genres_manga g WHERE g.manga.id = :mangaId")
    List<Genre> findGenresByMangas(@Param("mangaId") Long mangaId);
}
